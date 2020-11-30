package net.mcreator.dungeonsandcompanions.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.server.MinecraftServer;

import net.mcreator.dungeonsandcompanions.DungeonsAndCompanionsModElements;

import java.util.Map;

@DungeonsAndCompanionsModElements.ModElement.Tag
public class CompanionMale1OnInitialEntitySpawnProcedure extends DungeonsAndCompanionsModElements.ModElement {
	public CompanionMale1OnInitialEntitySpawnProcedure(DungeonsAndCompanionsModElements instance) {
		super(instance, 3);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		{
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList()
						.sendMessage(new StringTextComponent("Good day comrade! I will be your new companion and fight alongside you."));
		}
	}
}
