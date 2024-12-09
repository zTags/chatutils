package nl.tagsdev.chatutils.providers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import nl.tagsdev.chatutils.ITextProvider;

public class CoordsProvider implements ITextProvider {

	@Override
	public String getText(String input) {
		EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
		return String.format("%d %d %d", (int)player.posX, (int)player.posY, (int)player.posZ);
	}
	
	@Override
	public String getName() {
		return "coords";
	}
}
