package net.kaupenjoe.tutorialmod.item.custom;

import net.kaupenjoe.tutorialmod.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class BimalStaffItem extends RangedWeaponItem {
    public BimalStaffItem(Settings settings) {
        super(settings);
    }


//    @Override
//    public ActionResult useOnBlock(ItemUsageContext context) {
//
//    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack itemStack = user.getStackInHand(hand);

//        EnderPearlEntity enderPearlEntity = new EnderPearlEntity(world, user);
////        enderPearlEntity.setItem(itemStack);
//        enderPearlEntity.setOnFire(true);
//        enderPearlEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
//
//        world.spawnEntity(enderPearlEntity);

        if (user.getInventory().contains(ModItems.STAFF_EXPLOSIVE.getDefaultStack())){

            StaffFireBallEntity staffEntity = new StaffFireBallEntity(world, user);
            staffEntity.setItem(ModItems.STAFF_EXPLOSIVE.getDefaultStack());
//        staffEntity.se;
            staffEntity.setOnFireFor(10);
            staffEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 2F, 1.0F);
            world.spawnEntity(staffEntity);

            int slot = user.getInventory().getSlotWithStack(ModItems.STAFF_EXPLOSIVE.getDefaultStack());
            user.getInventory().getStack(slot).decrement(1);


        };



        return TypedActionResult.success(itemStack, world.isClient());

    }


    @Override
    public Predicate<ItemStack> getProjectiles() {
        return null;
    }

    @Override
    public int getRange() {
        return 20;
    }
}
