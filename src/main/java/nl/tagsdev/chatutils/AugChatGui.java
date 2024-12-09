package nl.tagsdev.chatutils;

import java.io.IOException;
import java.util.HashMap;

import org.lwjgl.input.Mouse;

import net.minecraft.client.gui.GuiChat;
import net.minecraft.util.IChatComponent;
import nl.tagsdev.chatutils.providers.*;

// TODO: remove semicolon when sending message
// TODO: quit Augchat when beginning ; removed
// TODO: normal chatgui mixin -> open augchat when ; first character
// TODO: replace ITextProvider with UnaryOperator<String>

// TODO: math evaluator

public class AugChatGui extends GuiChat {
	private HashMap<String, ITextProvider> commands;
	
	public AugChatGui() {
		super(";");
		commands = new HashMap<String, ITextProvider>();
		RegisterTextProvider(new CoordsProvider());
		RegisterTextProvider(new CoordXProvider());
		RegisterTextProvider(new CoordYProvider());
		RegisterTextProvider(new CoordZProvider());
		RegisterTextProvider(new CoordsXZProvider());
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		if (keyCode == Chatutils.triggerAutocomplete.getKeyCode()) {
			onTriggerAutocomplete();
		}
		super.keyTyped(typedChar, keyCode);
	}
	
	private void onTriggerAutocomplete() {
		String text = inputField.getText();
		for (String key : commands.keySet()) {
			if (text.endsWith(key)) {
				String replacement = commands.get(key).getText(text);
				text = text.replace(key, replacement);
				inputField.setText(text);
			}
		}
	}
	
	public void drawScreen(int mx, int my, float partialTicks) {
        drawRect(2, this.height - 14, this.width - 2, this.height - 2, Integer.MIN_VALUE);
        
		drawRect(2, this.height - 14, this.width - 2, this.height - 13,  0xFF50FF38); // TOP
		drawRect(2, this.height - 14, 3, this.height - 2,  0xFF76CC6A); // LEFT
		drawRect(2, this.height - 3, this.width - 2, this.height - 2,  0xFF50FF38); // BOTTOM
        drawRect(this.width - 3, this.height - 14, this.width - 2, this.height - 2, 0xFF50FF38); // RIGHT
		
        this.inputField.drawTextBox();
        IChatComponent ichatcomponent = this.mc.ingameGUI.getChatGUI().getChatComponent(Mouse.getX(), Mouse.getY());

        if (ichatcomponent != null && ichatcomponent.getChatStyle().getChatHoverEvent() != null)
        {
            this.handleComponentHover(ichatcomponent, mx, my);
        }

        super.drawScreen(mx, my, partialTicks);
	}
	
	private void RegisterTextProvider(ITextProvider provider) {
		commands.put(provider.getName(), provider);
	}
}
