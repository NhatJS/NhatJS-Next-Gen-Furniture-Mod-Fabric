package net.nhatjs.nextgen_furniture.entity.client;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.world.World;
import net.nhatjs.nextgen_furniture.block.ChairBlock;

public class ChairBlockEntity extends Entity {
    public ChairBlockEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {

    }

    @Override
    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        return false;
    }

    @Override
    protected void readCustomData(ReadView view) {

    }

    @Override
    protected void writeCustomData(WriteView view) {

    }

    @Override
    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
        if(!this.getWorld().isClient()) {
            this.kill(((ServerWorld) this.getWorld()));
        }
    }

    @Override
    public void tick() {
        super.tick();

        // Nếu block không còn → dismount & tự huỷ (bảo hiểm)
        if (!this.getWorld().isClient) {
            BlockState below = this.getWorld().getBlockState(this.getBlockPos());
            if (!(below.getBlock() instanceof ChairBlock)) {
                if (this.hasPassengers()) this.getPassengerList().forEach(p -> p.stopRiding());
                this.discard();
            }
        }
    }

    @Override
    public void remove(RemovalReason reason) {
        if (!this.getWorld().isClient) {
            // huỷ cưỡi ở server → đồng bộ về client
            if (this.hasPassengers()) this.getPassengerList().forEach(p -> p.stopRiding());
            this.removeAllPassengers(); // thừa kế Mojang mappings vẫn ok
        }
        super.remove(reason);
    }
}