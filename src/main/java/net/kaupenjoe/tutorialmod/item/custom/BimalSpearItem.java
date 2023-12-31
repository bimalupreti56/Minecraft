package net.kaupenjoe.tutorialmod.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.item.Vanishable;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BimalSpearItem extends Item {
    public static final int field_30926 = 10;
    public static final float ATTACK_DAMAGE = 10F;
    public static final float field_30928 = 2.5F;
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public BimalSpearItem(Item.Settings settings) {
        super(settings);
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", 8.0, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", -2.9000000953674316, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.SPEAR;
    }

    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

//    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
//        if (user instanceof PlayerEntity playerEntity) {
//            int i = this.getMaxUseTime(stack) - remainingUseTicks;
//            if (i >= 10) {
//                int j = EnchantmentHelper.getRiptide(stack);
//                if (j <= 0 || playerEntity.isTouchingWaterOrRain()) {
//                    if (!world.isClient) {
//                        stack.damage(1, playerEntity, (p) -> {
//                            p.sendToolBreakStatus(user.getActiveHand());
//                        });
//                        if (j == 0) {
//                            TridentEntity tridentEntity = new TridentEntity(world, playerEntity, stack);
//                            tridentEntity.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0F, 2.5F + (float) j * 0.5F, 1.0F);
//
//                            if (playerEntity.getAbilities().creativeMode) {
//                                tridentEntity.pickupType = PersistentProjectileEntity.PickupPermission.CREATIVE_ONLY;
//                            }
//
//                            world.spawnEntity(tridentEntity);
//                            world.playSoundFromEntity((PlayerEntity) null, tridentEntity, SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);
//                            if (!playerEntity.getAbilities().creativeMode) {
//                                playerEntity.getInventory().removeOne(stack);
//                            }
//                        }
//                    }
//
//                    playerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
//                    if (j > 0) {
//                        float f = playerEntity.getYaw();
//                        float g = playerEntity.getPitch();
//                        float h = -MathHelper.sin(f * 0.017453292F) * MathHelper.cos(g * 0.017453292F);
//                        float k = -MathHelper.sin(g * 0.017453292F);
//                        float l = MathHelper.cos(f * 0.017453292F) * MathHelper.cos(g * 0.017453292F);
//                        float m = MathHelper.sqrt(h * h + k * k + l * l);
//                        float n = 3.0F * ((1.0F + (float) j) / 4.0F);
//                        h *= n / m;
//                        k *= n / m;
//                        l *= n / m;
//                        playerEntity.addVelocity((double) h, (double) k, (double) l);
//                        playerEntity.useRiptide(20);
//                        if (playerEntity.isOnGround()) {
//                            float o = 1.1999999F;
//                            playerEntity.move(MovementType.SELF, new Vec3d(0.0, 1.1999999284744263, 0.0));
//                        }
//
//                        SoundEvent soundEvent;
//                        if (j >= 3) {
//                            soundEvent = SoundEvents.ITEM_TRIDENT_RIPTIDE_3;
//                        } else if (j == 2) {
//                            soundEvent = SoundEvents.ITEM_TRIDENT_RIPTIDE_2;
//                        } else {
//                            soundEvent = SoundEvents.ITEM_TRIDENT_RIPTIDE_1;
//                        }
//
//                        world.playSoundFromEntity((PlayerEntity) null, playerEntity, soundEvent, SoundCategory.PLAYERS, 1.0F, 1.0F);
//                    }
//
//                }
//            }
//        }
//    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        ItemStack stack = playerEntity.getStackInHand(hand);
        if (!world.isClient) {
            stack.damage(1, playerEntity, (p) -> {
                p.sendToolBreakStatus(playerEntity.getActiveHand());
            });

                TridentEntity2 tridentEntity = new TridentEntity2(world, playerEntity, stack);
                tridentEntity.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getYaw(), 0.0F, 2.5F + (float) 0 * 0.5F, 1.0F);

                    tridentEntity.pickupType = PersistentProjectileEntity.PickupPermission.DISALLOWED;

                world.spawnEntity(tridentEntity);
                world.playSoundFromEntity((PlayerEntity) null, tridentEntity, SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F);
//                if (!playerEntity.getAbilities().creativeMode) {
//                    playerEntity.getInventory().removeOne(stack);
//                }
            playerEntity.getItemCooldownManager().set(this, 15);
        }
        return TypedActionResult.success(stack,world.isClient());

    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, (e) -> {
            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if ((double) state.getHardness(world, pos) != 0.0) {
            stack.damage(2, miner, (e) -> {
                e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
            });
        }

        return true;
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
    }

    public int getEnchantability() {
        return 1;
    }



}
