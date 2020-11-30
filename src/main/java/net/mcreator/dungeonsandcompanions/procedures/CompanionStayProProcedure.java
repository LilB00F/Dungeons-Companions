package net.mcreator.dungeonsandcompanions.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.AnimalTameEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.Entity;

import net.mcreator.dungeonsandcompanions.DungeonsAndCompanionsModElements;

import java.util.Map;
import java.util.HashMap;

@DungeonsAndCompanionsModElements.ModElement.Tag
public class CompanionStayProProcedure extends DungeonsAndCompanionsModElements.ModElement {
	public CompanionStayProProcedure(DungeonsAndCompanionsModElements instance) {
		super(instance, 6);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure CompanionStayPro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putString("Sitting", "1");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
		if (((entity instanceof TameableEntity) ? ((TameableEntity) entity).getOwner() : null) instanceof PlayerEntity
				&& !((entity instanceof TameableEntity) ? ((TameableEntity) entity).getOwner() : null).world.isRemote) {
			((PlayerEntity) ((entity instanceof TameableEntity) ? ((TameableEntity) entity).getOwner() : null))
					.sendStatusMessage(new StringTextComponent("So be it, I will rest here until you return comrade."), (true));
		}
	}

	@SubscribeEvent
	public void onEntityTamed(AnimalTameEvent event) {
		Entity entity = event.getAnimal();
		Entity sourceentity = event.getTamer();
		double i = entity.getPosX();
		double j = entity.getPosY();
		double k = entity.getPosZ();
		World world = entity.world;
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("sourceentity", sourceentity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
