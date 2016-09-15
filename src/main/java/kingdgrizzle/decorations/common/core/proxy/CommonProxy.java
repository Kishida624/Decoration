package kingdgrizzle.decorations.common.core.proxy;

import kingdgrizzle.decorations.common.Decorations;
import kingdgrizzle.decorations.common.block.ModBlocks;
import kingdgrizzle.decorations.common.block.tile.TileEntityJar;
import kingdgrizzle.decorations.common.lib.LibMisc;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent event) {
		
		ModBlocks.init();
		//Debug Text
		Decorations.LOG.info("The following blocks have been registered: " + "\n" + ModBlocks.ALL_BLOCKS);

	}
	
	public void init(FMLInitializationEvent event) {
		
		ModBlocks.initTileEntity();
		
	}

	public void postInit(FMLPostInitializationEvent event) {

	}
	
}
