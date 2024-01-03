package net.gamma02.jurassicworldreborn.common.network;

import net.gamma02.jurassicworldreborn.common.blocks.ModBlocks;
import net.gamma02.jurassicworldreborn.common.blocks.entities.DNABlocks.DNACombinatorHybridizer.DNACombinatorHybridizerBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class SwitchHybridizerCombinatorMode {

    public boolean mode;

    public BlockPos pos;

    public ResourceKey<Level> dimension;

    public SwitchHybridizerCombinatorMode(boolean newMode, BlockPos blockPosition, ResourceKey<Level> dim){
        this.mode = newMode;
        this.pos = blockPosition;
        this.dimension = dim;
    }

    public void write(FriendlyByteBuf buf){
        buf.writeBoolean(this.mode);
        buf.writeBlockPos(this.pos);
        buf.writeResourceKey(this.dimension);
    }

    public static SwitchHybridizerCombinatorMode read(FriendlyByteBuf buf){
        var mode = buf.readBoolean();
        var pos = buf.readBlockPos();
        var dim = buf.readResourceKey(Registry.DIMENSION_REGISTRY);
        return new SwitchHybridizerCombinatorMode(mode, pos, dim);
    }

    public static void handle(SwitchHybridizerCombinatorMode packet, Supplier<NetworkEvent.Context> ctx){
        ServerLevel dimension = ctx.get().getSender().server.getLevel(packet.dimension);
        if(dimension != null && dimension.getBlockState(packet.pos).is(ModBlocks.DNA_COMBINER.get())){
            dimension.setBlock(packet.pos, dimension.getBlockState(packet.pos).setValue(DNACombinatorHybridizerBlock.MODE, packet.mode), 3);

//            dimension.updateNeighborsAt(packet.pos, ModBlocks.DNA_COMBINER.get());
        }
    }

}
