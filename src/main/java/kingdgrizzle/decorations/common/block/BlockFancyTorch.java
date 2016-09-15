package kingdgrizzle.decorations.common.block;

import java.util.List;
import java.util.Random;


import kingdgrizzle.decorations.api.bounding.DecorationBoundingBoxes;
import kingdgrizzle.decorations.api.collision.DecorationCollisionBoxes;
import kingdgrizzle.decorations.common.Decorations;
import kingdgrizzle.decorations.common.item.block.ItemBlockMod;
import kingdgrizzle.decorations.common.lib.LibBlockNames;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFancyTorch extends BlockMod {
	
	// 1 / 16 = 0.0625
	
	public BlockFancyTorch() {
		super(Material.CIRCUITS, LibBlockNames.FANCY_TORCH);
		setLightLevel(1F);
		setTickRandomly(true);
		setSoundType(SoundType.WOOD);
	}
	
	@Override
	protected IBlockState pickDefaultState() {
		// TODO Auto-generated method stub
		return super.pickDefaultState();
	}

	@Override
	protected boolean registerInCreative() {
		return true;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return DecorationBoundingBoxes.FANCY_TORCH_BB;
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entityIn) {
		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, DecorationCollisionBoxes.FANCY_TORCH_CB);
	}
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState worldIn, World pos, BlockPos state, Random rand) {
        double d0 = (double)state.getX() + 0.5D;
        double d1 = (double)state.getY() + 0.45D;
        double d2 = (double)state.getZ() + 0.5D;
		pos.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
		pos.spawnParticle(EnumParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
	}
}
