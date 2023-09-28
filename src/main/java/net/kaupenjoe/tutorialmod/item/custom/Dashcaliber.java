package net.kaupenjoe.tutorialmod.item.custom;

import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.function.Predicate;

public class Dashcaliber extends SwordItem {
    public Dashcaliber(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
//        this.attackRange = 4.0F;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack itemStack = user.getStackInHand(hand);

        DashcaliberEntity caliberEntity = new DashcaliberEntity(world, user);
        caliberEntity.setItem(ModItems.ADASH_SPARK.getDefaultStack());
        caliberEntity.setGlowing(true);
        caliberEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 2.2F, 1.0F);
        world.spawnEntity(caliberEntity);
//        lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(blockPos.up()));
//        lightningEntity.setPos(this.getBlockX(),this.getBlockY(),this.getBlockZ());
//            Entity entity = projectile.getOwner();
//            lightningEntity.setChanneler(entity instanceof ServerPlayerEntity ? (ServerPlayerEntity)entity : null);

        return TypedActionResult.success(itemStack, world.isClient());

    }
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return true; }
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,600));
        target.setGlowing(true);
        return true;
    }

    public void setRange(boolean change_range){

    }

}
