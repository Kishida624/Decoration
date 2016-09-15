package kingdgrizzle.decorations.common.block;

import kingdgrizzle.decorations.common.lib.LibBlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockStonePath extends BlockMod {
	
	protected static final AxisAlignedBB STONE_PATH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.1D, 1.0D);	
	
	public BlockStonePath() {
		super(Material.CARPET, LibBlockNames.STONE_PATH);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
}
