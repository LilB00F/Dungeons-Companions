package net.mcreator.dungeonsandcompanions.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.Entity;

import net.mcreator.dungeonsandcompanions.DungeonsAndCompanionsModElements;

import java.util.Map;

@DungeonsAndCompanionsModElements.ModElement.Tag
public class CompanionRalfThisEntityKillsAnotherOneProcedure extends DungeonsAndCompanionsModElements.ModElement {
	public CompanionRalfThisEntityKillsAnotherOneProcedure(DungeonsAndCompanionsModElements instance) {
		super(instance, 16);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure CompanionRalfThisEntityKillsAnotherOne!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof TameableEntity) ? ((TameableEntity) entity).getOwner() : null) instanceof PlayerEntity)
			((PlayerEntity) ((entity instanceof TameableEntity) ? ((TameableEntity) entity).getOwner() : null)).giveExperiencePoints((int) 8);
	}
}
