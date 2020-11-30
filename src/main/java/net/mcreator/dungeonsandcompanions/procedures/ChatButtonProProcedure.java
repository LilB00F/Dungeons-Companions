package net.mcreator.dungeonsandcompanions.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.dungeonsandcompanions.DungeonsAndCompanionsModElements;

import java.util.Map;

@DungeonsAndCompanionsModElements.ModElement.Tag
public class ChatButtonProProcedure extends DungeonsAndCompanionsModElements.ModElement {
	public ChatButtonProProcedure(DungeonsAndCompanionsModElements instance) {
		super(instance, 7);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ChatButtonPro!");
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
							"When I was young my babushka told me that russians were super stong and could take anything. But then the week after that she fell down the stairs and died, so I guess shes a liar."));
			}
		} else if ((Math.random() < 0.5)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent(
							"Have you ever thought of having a bird as a pet? I want one but Im worried I'll get drunk and sit on it or something."));
			}
		} else if ((Math.random() < 0.75)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Glory to our party and to the motherland!"));
			}
		}
	}
}
