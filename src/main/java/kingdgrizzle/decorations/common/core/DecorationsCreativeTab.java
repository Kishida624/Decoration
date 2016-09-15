package kingdgrizzle.decorations.common.core;

import kingdgrizzle.decorations.common.lib.LibMisc;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class DecorationsCreativeTab extends CreativeTabs {

	public static final DecorationsCreativeTab INSTANCE = new DecorationsCreativeTab();
	
	public DecorationsCreativeTab() {
		super(LibMisc.MOD_ID);
	}

	@Override
	public Item getTabIconItem() {
		return Items.APPLE;
	}

}
