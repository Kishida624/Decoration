package kingdgrizzle.decorations.api.state;

import kingdgrizzle.decorations.api.state.enums.JarColors;
import net.minecraft.block.properties.PropertyEnum;

public class DecorationStateProps {
	
	public static final PropertyEnum<JarColors> JAR_VARIANTS = PropertyEnum.create("color", JarColors.class);
	
	private DecorationStateProps() {
	}
	
}
