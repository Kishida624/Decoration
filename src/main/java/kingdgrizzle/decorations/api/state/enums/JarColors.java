package kingdgrizzle.decorations.api.state.enums;

import java.util.Locale;

import net.minecraft.util.IStringSerializable;

public enum JarColors implements IStringSerializable {
	CLEAR,
	WHITE;
	
	@Override
	public String getName() {
		return name().toLowerCase(Locale.ROOT);
	}

}
