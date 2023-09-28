package net.kaupenjoe.tutorialmod.item.custom;

import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class BimalBoltItem extends RangedWeaponItem {



    public BimalBoltItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack itemStack = user.getStackInHand(hand);
//        EnderPearlEntity enderPearlEntity = new EnderPearlEntity(world, user);
////        enderPearlEntity.setItem(itemStack);
//        enderPearlEntity.setOnFire(true);
//        enderPearlEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
//
//        world.spawnEntity(enderPearlEntity);
        if (user.getInventory().contains(ModItems.BOLT.getDefaultStack())){

            StaffBoltEntity boltEntity = new StaffBoltEntity(world, user);
            boltEntity.setItem(ModItems.BOLT.getDefaultStack());
//        staffEntity.se;
            boltEntity.setGlowing(true);
            boltEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 2.5F, 1.0F);
            world.spawnEntity(boltEntity);

            int boltSlot = user.getInventory().getSlotWithStack(ModItems.BOLT.getDefaultStack());
            user.getInventory().getStack(boltSlot).decrement(1);


        };


        return TypedActionResult.success(itemStack, world.isClient());

    }


    @Override
    public Predicate<ItemStack> getProjectiles() {
        return null;
    }

    @Override
    public int getRange() {
        return 30;
    }
}
