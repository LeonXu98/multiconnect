package net.earthcomputer.multiconnect.protocols.v1_12_2;

import net.earthcomputer.multiconnect.protocols.AbstractProtocol;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FlowerPotBlockEntity extends BlockEntity {
    public FlowerPotBlockEntity() {
        super(BlockEntities_1_12_2.FLOWER_POT);
    }

    @Override
    public void fromTag(CompoundTag tag) {
        super.fromTag(tag);
        Item flowerPotItem;
        if (tag.contains("Item", 8))
            flowerPotItem = Registry.ITEM.get(new Identifier(tag.getString("Item")));
        else
            flowerPotItem = Registry.ITEM.get(tag.getInt("Item"));
        int meta = tag.getInt("Data");
        setFlowerPotItemStack(Items_1_12_2.oldItemStackToNew(new ItemStack(flowerPotItem), meta));
    }

    public void setFlowerPotItemStack(ItemStack stack) {
        Block block;
        if (!(stack.getItem() instanceof BlockItem)) {
            block = Blocks_1_12_2.FLOWER_POT;
        } else {
            block = ((BlockItem) stack.getItem()).getBlock();
            block = AbstractProtocol.getFlowerPotBlock(block);
            if (block == null)
                block = Blocks_1_12_2.FLOWER_POT;
        }
        assert world != null;
        world.setBlockState(pos, block.getDefaultState());
    }
}
