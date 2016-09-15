package kingdgrizzle.decorations.common.item.block;

import javax.annotation.Nonnull;

import kingdgrizzle.decorations.client.lib.LibResources;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockWithMetadataAndName extends ItemBlock {

	public ItemBlockWithMetadataAndName(Block par2Block) {
        super(par2Block);
        setHasSubtypes(true);
    }

    @Nonnull
    @Override
    public String getUnlocalizedNameInefficiently(@Nonnull ItemStack par1ItemStack) {
        return super.getUnlocalizedNameInefficiently(par1ItemStack).replaceAll("tile.", "tile." + LibResources.PREFIX_MOD);
    }

    @Nonnull
    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack) {
        return super.getUnlocalizedName(par1ItemStack) + par1ItemStack.getItemDamage();
    }

    @Override
    public int getMetadata(int damage)
    {
        return damage;
    }
}
