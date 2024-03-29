package net.gamma02.jurassicworldreborn.common.items.Food;

import net.gamma02.jurassicworldreborn.common.entities.Dinosaurs.Dinosaur;
import net.gamma02.jurassicworldreborn.common.util.LangUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class DinosaurMeatItem extends Item {
    boolean cooked;
    Dinosaur dino;
    public DinosaurMeatItem(Properties properties, boolean cooked, Dinosaur dino) {
        super(properties);
        this.cooked = cooked;
        this.dino = dino;
    }

    @Override
    public @NotNull Component getName(@NotNull ItemStack stack) {

        String key = Component.translatable("item.jurassicworldreborn.dinosaur_meat").getString();

        if(cooked){
            key = Component.translatable("item.jurassicworldreborn.dinosaur_steak").getString();
        }

        return LangUtil.replaceWithDinoName(dino, key);
    }


    //    @Override
//    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
//        if (!world.isRemote) {
//            this.getDinosaur(stack).applyMeatEffect(player, false);
//        }
//    }
//

    public Dinosaur getDinosaur() {
        return this.dino;
    }

//    @Override
//    @SideOnly(Side.CLIENT)
//    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subtypes) {
//        List<Dinosaur> dinosaurs = new LinkedList<>(EntityHandler.getDinosaurs().values());
//
//        Collections.sort(dinosaurs);
//        if (this.isInCreativeTab(tab))
//            for (Dinosaur dinosaur : dinosaurs) {
//                if (dinosaur.shouldRegister()) {
//                    subtypes.add(new ItemStack(this, 1, EntityHandler.getDinosaurId(dinosaur)));
//                }
//            }
//    }
}
