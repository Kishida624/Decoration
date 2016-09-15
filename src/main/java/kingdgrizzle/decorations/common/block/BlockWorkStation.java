package kingdgrizzle.decorations.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockWorkStation extends Block {

	public BlockWorkStation() {
		super(Material.WOOD);
		setHardness(2.5F);
		setSoundType(SoundType.WOOD);
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return true;
	}
}
