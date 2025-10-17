package net.nhatjs.nextgen_furniture.system;

import com.google.gson.*;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class NextGenRecipeManager implements SimpleSynchronousResourceReloadListener {
    private static final List<NextGenRecipe> RECIPES = new ObjectArrayList<>();
    private static final Gson GSON = new GsonBuilder().setLenient().create();
    private static final Identifier FOLDER = Identifier.of("nextgen_furniture","nextgen_crafting");

    public static void init() {
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new NextGenRecipeManager());
    }

    @Override public Identifier getFabricId() { return Identifier.of("nextgen_furniture","nextgen_recipe_loader"); }

    @Override
    public void reload(ResourceManager manager) {
        RECIPES.clear();
        // Nạp mọi file trong data/*/nextgen_furniture/nextgen_crafting/*.json
        Map<Identifier, Resource> map = manager.findResources(FOLDER.getPath(), id -> id.getPath().endsWith(".json"));
        map.forEach((id, res) -> {
            try (var in = res.getInputStream();
                 var reader = new InputStreamReader(in, StandardCharsets.UTF_8)) {
                JsonObject root = GSON.fromJson(reader, JsonObject.class);

                // optional: "type": "nextgen_furniture:nextgen_shaped"
                if (root.has("type")) {
                    String t = root.get("type").getAsString();
                    if (!"nextgen_furniture:nextgen_shaped".equals(t)) return; // bỏ qua loại khác
                }

                int w = root.get("width").getAsInt();
                int h = root.get("height").getAsInt();
                var arr = root.getAsJsonArray("pattern");
                String[] patt = new String[h];
                for (int i=0;i<h;i++) patt[i] = arr.get(i).getAsString();

                // key: { "A": "minecraft:iron_ingot", ... }
                var keyObj = root.getAsJsonObject("key");
                var keyIds = new java.util.HashMap<Character, Identifier>();
                for (var e : keyObj.entrySet()) {
                    char ch = e.getKey().charAt(0);
                    keyIds.put(ch, Identifier.of(e.getValue().getAsString()));
                }

                var resultObj = root.getAsJsonObject("result");
                Identifier resultId = Identifier.of(resultObj.get("item").getAsString());
                int count = resultObj.has("count") ? resultObj.get("count").getAsInt() : 1;

                RECIPES.add(new NextGenRecipe(w, h, patt, keyIds, resultId, count));
            } catch (Exception ex) {
                // log nhẹ, không nổ
                System.err.println("[NextGen] Failed to load " + id + " : " + ex.getMessage());
            }
        });
        System.out.println("[NextGen] Loaded " + RECIPES.size() + " next-gen recipes.");
    }

    /** Trả về kết quả nếu khớp; null nếu không khớp */
    public static ItemStack match(CraftingInventory grid, World world) {
        for (NextGenRecipe r : RECIPES) {
            if (matches(r, grid)) return r.result.copy();
        }
        return null;
    }

    private static boolean matches(NextGenRecipe r, CraftingInventory grid) {
        // thử mọi offset trong 3x3
        for (int offY = 0; offY <= 3 - r.height; offY++) {
            for (int offX = 0; offX <= 3 - r.width; offX++) {
                if (matchAt(r, grid, offX, offY)) return true;
            }
        }
        return false;
    }

    private static boolean matchAt(NextGenRecipe r, CraftingInventory g, int ox, int oy) {
        for (int y=0;y<3;y++) {
            for (int x=0;x<3;x++) {
                var stack = g.getStack(x + y*3);
                ItemStack s = stack == null ? ItemStack.EMPTY : stack;
                char keyCh = ' ';
                // lấy ký tự pattern nếu trong vùng r.width x r.height
                if (x >= ox && y >= oy && x < ox + r.width && y < oy + r.height) {
                    keyCh = r.pattern[y - oy].charAt(x - ox);
                }
                if (keyCh == ' ') {
                    if (!s.isEmpty()) return false; // pattern trống mà slot có đồ
                } else {
                    var need = r.key.get(keyCh);
                    if (need == null || s.isEmpty() || s.getItem() != need) return false;
                }
            }
        }
        return true;
    }
}
