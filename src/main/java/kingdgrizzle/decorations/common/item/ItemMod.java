package kingdgrizzle.decorations.common.item;

import javax.annotation.Nonnull;

import kingdgrizzle.decorations.client.lib.LibResources;
import kingdgrizzle.decorations.client.render.IModelRegister;
import kingdgrizzle.decorations.common.core.DecorationsCreativeTab;
import kingdgrizzle.decorations.common.lib.LibMisc;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ItemMod extends Item implements IModelRegister {

	public ItemMod(String name) {
		setCreativeTab(DecorationsCreativeTab.INSTANCE);
		setUnlocalizedName(name);
		if(shouldRegister())
			GameRegistry.register(this, new ResourceLocation(LibMisc.MOD_ID, name));
	}
	
	protected boolean shouldRegister() {
        return true;
    }

    @Nonnull
    @Override
    public String getUnlocalizedNameInefficiently(@Nonnull ItemStack par1ItemStack) {
        return super.getUnlocalizedNameInefficiently(par1ItemStack).replaceAll("item\\.", "item." + LibResources.PREFIX_MOD);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
