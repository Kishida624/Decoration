package kingdgrizzle.decorations.client.core.proxy;

import kingdgrizzle.decorations.client.core.handler.ModelHandler;
import kingdgrizzle.decorations.common.block.tile.TileEntityJar;
import kingdgrizzle.decorations.common.block.tile.render.RenderJar;
import kingdgrizzle.decorations.common.core.proxy.CommonProxy;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	 @Override
	 public void preInit(FMLPreInitializationEvent event) {
		 super.preInit(event);
		 ModelHandler.registerModels();
	 }
	 
	 @Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJar.class, new RenderJar());
	}

}
