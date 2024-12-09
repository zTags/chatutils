package nl.tagsdev.chatutils;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

@Mod(modid = Chatutils.MODID, version = Chatutils.VERSION)
public class Chatutils
{
    public static final String MODID = "chatutils";
    public static final String VERSION = "1.0";
    
    public static KeyBinding openAugChat;
    public static KeyBinding triggerAutocomplete;

    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(this);
    	openAugChat = new KeyBinding("key.openaugchat", Keyboard.KEY_SEMICOLON, "key.categories.multiplayer");
    	triggerAutocomplete = new KeyBinding("key.triggerautocomplete", Keyboard.KEY_TAB, "key.categories.multiplayer");
    	ClientRegistry.registerKeyBinding(openAugChat);
    	ClientRegistry.registerKeyBinding(triggerAutocomplete);
    }
    
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {	
    	if (openAugChat.isPressed()) {
    		Minecraft minecraft = Minecraft.getMinecraft();
    		minecraft.displayGuiScreen(new AugChatGui());
    	}
    }
}
