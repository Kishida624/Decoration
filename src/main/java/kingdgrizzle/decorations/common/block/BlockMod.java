package kingdgrizzle.decorations.common.block;

import kingdgrizzle.decorations.client.core.handler.ModelHandler;
import kingdgrizzle.decorations.client.render.IModelRegister;
import kingdgrizzle.decorations.common.Decorations;
import kingdgrizzle.decorations.common.core.DecorationsCreativeTab;
import kingdgrizzle.decorations.common.item.block.ItemBlockMod;
import kingdgrizzle.decorations.common.lib.LibMisc;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMod extends Block implements IModelRegister {
	
	public BlockMod(Material par2material, String name) {
        super(par2material);
        ModBlocks.ALL_BLOCKS.add(this);
        setUnlocalizedName(name);
        setDefaultState(pickDefaultState()); // This MUST happen before registering the block
        setRegistryName(new ResourceLocation(LibMisc.MOD_ID, name));
        GameRegistry.register(this);
        registerItemForm();
        if(registerInCreative())
            setCreativeTab(DecorationsCreativeTab.INSTANCE);
    }
	
	protected IBlockState pickDefaultState() {
		return blockState.getBaseState();
	}

    protected boolean registerInCreative() {
        return true;
    }

    public void registerItemForm() {
        GameRegistry.register(new ItemBlockMod(this), getRegistryName());
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerModels() {
        if(Item.getItemFromBlock(this) != null)
            ModelHandler.registerBlockToState(this, 0, getDefaultState());
    }
}
