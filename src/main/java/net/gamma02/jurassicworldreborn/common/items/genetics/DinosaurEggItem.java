package net.gamma02.jurassicworldreborn.common.items.genetics;

import net.gamma02.jurassicworldreborn.common.entities.Dinosaurs.Dinosaur;
import net.gamma02.jurassicworldreborn.common.util.LangUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraftforge.registries.ForgeRegistries;

public class DinosaurEggItem extends DNAContainerItem {
    public DinosaurEggItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public Component getName(ItemStack pStack) {
        return Component.literal(Component.translatable(ForgeRegistries.ITEMS.getKey(this).getPath() + ".name").getString().replace("{dino}", LangUtil.getDinoName(this.getDinosaur(pStack)).getString()));
    }

    public Dinosaur getDinosaur(ItemStack stack) {
        Dinosaur dinosaur = Dinosaur.getDinosaurByName(stack.getTag() != null ? stack.getTag().getString("DinosaurName") : null);

        if (dinosaur == null) {
            dinosaur = Dinosaur.EMPTY;
        }

        return dinosaur;
    }

    //legacy, use with care
    @Override
    public int getContainerId(ItemStack stack) {
        return Dinosaur.DINOS.indexOf(this.getDinosaur(stack));
    }

//    @Override
//    @OnlyIn(Dist.CLIENT)
//    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subtypes) {
//        List<Dinosaur> dinosaurs = new LinkedList<>(EntityHandler.getDinosaurs().values());
//        Collections.sort(dinosaurs);
//        if(this.isInCreativeTab(tab)) {
//            for (Dinosaur dinosaur : dinosaurs) {
//                if (dinosaur.shouldRegister()) {
//                    if(!dinosaur.isMammal()) {
//                        if(!dinosaur.isMarineCreature()) {
//                            subtypes.add(new ItemStack(this, 1, EntityHandler.getDinosaurId(dinosaur)));
//                        }}}
//            }
//        }
//    }




    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        //        pos = pos.offset(side);
//
//        if (side == EnumFacing.EAST || side == EnumFacing.WEST)
//        {
//            hitX = 1.0F - hitX;
//        }
//        else if (side == EnumFacing.NORTH || side == EnumFacing.SOUTH)
//        {
//            hitZ = 1.0F - hitZ;
//        }
//
//        if (player.canPlayerEdit(pos, side, stack) && !world.isRemote)
//        {
//            DinosaurEggEntity egg = new DinosaurEggEntity(world, getDinosaur(stack), getDNAQuality(player, stack), getGeneticCode(player, stack).toString());
//            egg.setPosition(pos.getX() + hitX, pos.getY(), pos.getZ() + hitZ);
//            egg.rotationYaw = player.rotationYaw;
//            world.spawnEntity(egg);
//
//            if (!player.capabilities.isCreativeMode)
//            {
//                stack.stackSize--;
//            }
//
//            return EnumActionResult.SUCCESS;
//        }
        return InteractionResult.PASS;
    }
}