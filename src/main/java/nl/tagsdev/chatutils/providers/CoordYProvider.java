package nl.tagsdev.chatutils.providers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import nl.tagsdev.chatutils.ITextProvider;

public class CoordYProvider implements ITextProvider {

	@Override
	public String getText(String input) {
		EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
		return String.format("%d", (int)player.posY);
	}

	@Override
	public String getName() {
		return "coordy";
	}
	
}
