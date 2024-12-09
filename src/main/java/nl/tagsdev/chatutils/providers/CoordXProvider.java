package nl.tagsdev.chatutils.providers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import nl.tagsdev.chatutils.ITextProvider;

public class CoordXProvider implements ITextProvider {

	@Override
	public String getText(String input) {
		EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
		return String.format("%d", (int)player.posX);
	}

	@Override
	public String getName() {
		return "coordx";
	}
}
