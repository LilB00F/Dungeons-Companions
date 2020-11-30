package net.mcreator.dungeonsandcompanions.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.dungeonsandcompanions.DungeonsAndCompanionsModElements;

import java.util.Map;

@DungeonsAndCompanionsModElements.ModElement.Tag
public class StaffFireballLivingEntityIsHitWithItemProcedure extends DungeonsAndCompanionsModElements.ModElement {
	public StaffFireballLivingEntityIsHitWithItemProcedure(DungeonsAndCompanionsModElements instance) {
		super(instance, 170);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure StaffFireballLivingEntityIsHitWithItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 10);
	}
}
