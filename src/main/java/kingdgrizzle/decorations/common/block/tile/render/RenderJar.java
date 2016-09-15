package kingdgrizzle.decorations.common.block.tile.render;

import kingdgrizzle.decorations.common.block.tile.TileEntityJar;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class RenderJar extends TileEntitySpecialRenderer<TileEntityJar> {
	
	private static final EntityItem ITEM = new EntityItem(Minecraft.getMinecraft().theWorld, 0, 0, 0, new ItemStack(Items.COOKIE));
	
	@Override
	public void renderTileEntityAt(TileEntityJar te, double x, double y, double z, float partialTicks, int destroyStage) {

		super.renderTileEntityAt(te, x, y, z, partialTicks, destroyStage);
		
		ITEM.hoverStart = 0.0F;
		
		GlStateManager.pushMatrix(); {
			
			GlStateManager.translate(x, y, z);
			GlStateManager.rotate(90F, 1, 0, 0);
			GlStateManager.translate(0.5, 0.025, -0.125);
			for(int i = 0; i < te.cookieCount; i++) {
				Minecraft.getMinecraft().getRenderManager().doRenderEntity(ITEM, 0, 0, 0, 0F, 0F, false);
				GlStateManager.translate(0, 0, -0.0625);
			}			
		}
		
		GlStateManager.popMatrix(); {
			
		}
		
		
	}

}
