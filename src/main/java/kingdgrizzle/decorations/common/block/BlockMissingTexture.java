package kingdgrizzle.decorations.common.block;

import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import kingdgrizzle.decorations.common.lib.LibBlockNames;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class BlockMissingTexture extends BlockMod {

    public BlockMissingTexture() {
        super(Material.WOOD, LibBlockNames.MISSING_NO);
        setHardness(2.5F);
        setSoundType(SoundType.WOOD);
    }

    @Override
    protected IBlockState pickDefaultState() {
        return super.pickDefaultState();
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {

    	if(advanced == true) {
    		tooltip.add("Yo dawg");
    	} else if(advanced == false) {
            tooltip.add("This is for people who like the " + ChatFormatting.LIGHT_PURPLE +  "missing texture!");
        }
    }
}
