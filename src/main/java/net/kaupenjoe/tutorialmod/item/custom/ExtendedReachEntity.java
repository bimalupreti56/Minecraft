import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class ExtendedReachEntity extends PersistentProjectileEntity {
    public ExtendedReachEntity(EntityType<? extends ExtendedReachEntity> entityType, World world) {
        super(entityType, world);
    }

//    public ExtendedReachEntity(LivingEntity owner, World world) {
//        super(entityType, owner, world);
//    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        // Handle what happens when the extended reach entity hits an entity
        // For example, deal damage here
        super.onEntityHit(entityHitResult);
    }

    @Override
    protected ItemStack asItemStack() {
        return null;
    }
}
