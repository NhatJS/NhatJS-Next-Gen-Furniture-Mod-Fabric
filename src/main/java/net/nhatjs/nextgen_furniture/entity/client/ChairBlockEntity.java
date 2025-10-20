package net.nhatjs.nextgen_furniture.entity.client;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
    protected void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {

    }

    @Override
    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
        if(!this.getWorld().isClient()) {
            this.kill(((ServerWorld) this.getWorld()));
        }
    }

    @Override
    public void tick()
    {
        super.tick();
        if(!this.getWorld().isClient)
        {
            BlockPos pos = this.getBlockPos();
            if(this.getPassengerList().isEmpty() || this.getWorld().isAir(pos))
            {
                this.discard();
                this.getWorld().updateComparators(pos, this.getWorld().getBlockState(pos).getBlock());
            }
        }
    }

    @Override
    public void remove(RemovalReason reason) {
        if (!this.getWorld().isClient) {
            if (this.hasPassengers()) this.getPassengerList().forEach(p -> p.stopRiding());
            this.removeAllPassengers();
        }
        super.remove(reason);
    }
}
