package net.mcreator.dungeonsandcompanions.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.dungeonsandcompanions.DungeonsAndCompanionsModElements;

import java.util.Map;

@DungeonsAndCompanionsModElements.ModElement.Tag
public class ChattemplateProcedure extends DungeonsAndCompanionsModElements.ModElement {
	public ChattemplateProcedure(DungeonsAndCompanionsModElements instance) {
		super(instance, 33);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Chattemplate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
		if ((Math.random() < 0.25)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent(
							"I was camping and I found this flower that was budding, and it smelt amazing so I had the idea of burning it indoors. After about 15 minutes, I kid you not, I felt so good I thought I was an enderman!"));
			}
		} else if ((Math.random() < 0.5)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList()
							.sendMessage(new StringTextComponent("Strike them where it hurts! Except the groin, only cowards strike there."));
			}
		} else if ((Math.random() < 0.75)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("I wonder if snails think they're as fast as a horse."));
			}
		}
	}
}
