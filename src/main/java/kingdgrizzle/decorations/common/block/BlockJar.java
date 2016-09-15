package kingdgrizzle.decorations.common.block;

import java.util.List;

import javax.annotation.Nonnull;

import kingdgrizzle.decorations.api.state.enums.JarColors;
import org.lwjgl.input.Keyboard;

import com.mojang.realmsclient.gui.ChatFormatting;

import kingdgrizzle.decorations.api.bounding.DecorationBoundingBoxes;
import kingdgrizzle.decorations.api.collision.DecorationCollisionBoxes;
import kingdgrizzle.decorations.api.state.DecorationStateProps;
import kingdgrizzle.decorations.client.core.handler.ModelHandler;
import kingdgrizzle.decorations.common.block.tile.TileEntityJar;
import kingdgrizzle.decorations.common.item.block.ItemBlockJar;
import kingdgrizzle.decorations.common.lib.LibBlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockJar extends BlockMod implements ITileEntityProvider {
	
	// 1 / 16 = 0.0625

	public BlockJar() {
		super(Material.GLASS, LibBlockNames.JAR);
		setHardness(0.5F);
		setSoundType(SoundType.GLASS);
	}
	
	//Beginning of Metadata information!
	
	@Override
	protected IBlockState pickDefaultState() {
		return blockState.getBaseState().withProperty(DecorationStateProps.JAR_VARIANTS, JarColors.WHITE);
	}
	
	@Override
	public void registerItemForm() {
		GameRegistry.register(new ItemBlockJar(this), getRegistryName());
	}
	
	@Nonnull
	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, DecorationStateProps.JAR_VARIANTS);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(DecorationStateProps.JAR_VARIANTS).ordinal();
	}

	@Nonnull
	@Override
	public IBlockState getStateFromMeta(int meta) {
		if (meta >= JarColors.values().length) {
			meta = 0;
		}
		return getDefaultState().withProperty(DecorationStateProps.JAR_VARIANTS, JarColors.values()[meta]);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(@Nonnull Item item, CreativeTabs par2, List<ItemStack> par3) {
		for(int i = 0; i < JarColors.values().length; i++)
			par3.add(new ItemStack(item, 1, i));
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels() {
		ModelHandler.registerBlockToState(this, JarColors.values().length);
	} 
	//End of MetaData, just re-use it!

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return DecorationBoundingBoxes.JAR_BB;
	}
	
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entityIn) {
		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, DecorationCollisionBoxes.JAR_CB);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityJar();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote) {
			TileEntity tileEntity = worldIn.getTileEntity(pos);
			if(tileEntity instanceof TileEntityJar) {
				TileEntityJar jar = (TileEntityJar) tileEntity;
				if(heldItem != null) {
					if(heldItem.getItem() == Items.COOKIE) {
						if(jar.addCookie()) {
							heldItem.stackSize--;
							return true;
						}
					}					
				}
				jar.removeCookie();
			}
		}
		return true;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
		final String KEY = "LShift";
		final String KEY2 = "LCtrl";
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			tooltip.add("Hold your cookies!");
		} else if(Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)) {
			tooltip.add("It took me ages to figure out how to make metadata for this Jars, in order to not make a lot of the same blocks with the same code, but with different colors!" + "\n" + "It also took me ages to get Comparator Signals to work, but thats another story!");
		} else {
			tooltip.add(ChatFormatting.BOLD + "" + ChatFormatting.WHITE + "Press " + KEY + " for the tooltip or " + KEY2 + " for some random facts!");
		}
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn) {
		super.neighborChanged(state, worldIn, pos, blockIn);
		TileEntity tileentity = worldIn.getTileEntity(pos);

        if (tileentity instanceof TileEntityJar)
        {
            tileentity.updateContainingBlockInfo();
        }
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		TileEntity tileEntity = worldIn.getTileEntity(pos);		
		if(tileEntity instanceof TileEntityJar) {
			TileEntityJar jar = (TileEntityJar) tileEntity;
			jar.breakJar();
		}
		super.breakBlock(worldIn, pos, state);		
	}
	
	@Override
	public boolean canProvidePower(IBlockState state) {
		return true;
	}
	
	@Override
	public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		
		if(!blockState.canProvidePower()) {
			return 0;
		} else {
			int i = 0;
			TileEntity te = blockAccess.getTileEntity(pos);
			
			if(te instanceof TileEntityJar) {
				i = ((TileEntityJar)te).cookieCount;
			}
			
			return MathHelper.clamp_int(i, 0, 8);
		}
	}
	
	@Override
	public int getStrongPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return blockState.getWeakPower(blockAccess, pos, side);
	}
	
	@Override
	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}
	
	@Override
	public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
		TileEntity te = worldIn.getTileEntity(pos);
		if(te instanceof TileEntityJar) {
			return ((TileEntityJar)te).cookieCount;
		} else {
			return 0;
		}
	}
}
