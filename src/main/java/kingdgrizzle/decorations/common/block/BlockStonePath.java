package kingdgrizzle.decorations.common.block;

import kingdgrizzle.decorations.common.lib.LibBlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockStonePath extends BlockMod {
	
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
