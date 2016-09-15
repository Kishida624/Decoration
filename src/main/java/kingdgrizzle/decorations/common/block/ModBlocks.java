package kingdgrizzle.decorations.common.block;

import java.util.HashSet;
import java.util.Set;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import kingdgrizzle.decorations.common.block.tile.TileEntityJar;
import kingdgrizzle.decorations.common.block.tile.render.RenderJar;
import kingdgrizzle.decorations.common.lib.LibMisc;
import net.minecraft.block.Block;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static final Set<Block> ALL_BLOCKS = new HashSet<>();
	public static Block fancyTorch;
	public static Block missing_no;
	public static Block jar;
	
	public static void init() {
		
		fancyTorch = new BlockFancyTorch();
		jar = new BlockJar();
		missing_no = new BlockMissingTexture();
	}
	
	public static void initTileEntity() {
		
		GameRegistry.registerTileEntity(TileEntityJar.class, LibMisc.MOD_ID + "TileEntityJar");
	}
}
