package nl.tagsdev.chatutils.providers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import nl.tagsdev.chatutils.ITextProvider;

public class CoordZProvider implements ITextProvider {

	@Override
	public String getText(String input) {
		EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
		return String.format("%d", (int)player.posZ);
	}

	@Override
	public String getName() {
		return "coordz";
	}
	
}
