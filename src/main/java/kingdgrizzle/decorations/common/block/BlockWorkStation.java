package kingdgrizzle.decorations.common.block;

import kingdgrizzle.decorations.common.lib.LibBlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockWorkStation extends BlockMod {

	public BlockWorkStation() {
		super(Material.WOOD, LibBlockNames.WORK_BENCH);
		setHardness(2.5F);
		setSoundType(SoundType.WOOD);
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return true;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return true;
	}
}
