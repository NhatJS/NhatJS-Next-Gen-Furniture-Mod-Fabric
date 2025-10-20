package net.nhatjs.nextgen_furniture.entity.client;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
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
    protected void readCustomData(ReadView view) {

    }

    @Override
    protected void writeCustomData(WriteView view) {

    }

    @Override
    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
        if(!this.getEntityWorld().isClient()) {
            this.kill(((ServerWorld) this.getEntityWorld()));
        }
    }

    @Override
    public void tick() {
        super.tick();
        if(!this.getEntityWorld().isClient())
        {
            BlockPos pos = this.getBlockPos();
            if(this.getPassengerList().isEmpty() || this.getEntityWorld().isAir(pos))
            {
                this.discard();
                this.getEntityWorld().updateComparators(pos, this.getEntityWorld().getBlockState(pos).getBlock());
            }
        }
    }

    @Override
    public void remove(RemovalReason reason) {
        if (!this.getEntityWorld().isClient()) {
            if (this.hasPassengers()) this.getPassengerList().forEach(p -> p.stopRiding());
            this.removeAllPassengers();
        }
        super.remove(reason);
    }
}