package kingdgrizzle.decorations.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import kingdgrizzle.decorations.common.block.ModBlocks;
import kingdgrizzle.decorations.common.core.proxy.CommonProxy;
import kingdgrizzle.decorations.common.lib.LibMisc;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.Arrays;

@Mod(modid = LibMisc.MOD_ID, name = LibMisc.MOD_NAME, version = LibMisc.VERSION, acceptedMinecraftVersions = LibMisc.MC_VERSION)
public class Decorations {
	
	@Instance(LibMisc.MOD_ID)
	public static Decorations instance;
	
	@SidedProxy(clientSide = LibMisc.PROXY_CLIENT, serverSide = LibMisc.PROXY_COMMON)
	public static CommonProxy proxy;
	
	public static final Logger LOG = LogManager.getLogger("KingDGrizzle - Decorations");
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        //Debugging Text:
        LOG.info(ModBlocks.ALL_BLOCKS);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
