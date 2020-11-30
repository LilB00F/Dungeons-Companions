package net.mcreator.dungeonsandcompanions.procedures;

import net.minecraft.item.ItemStack;

import net.mcreator.dungeonsandcompanions.DungeonsAndCompanionsModElements;

import java.util.Random;
import java.util.Map;

@DungeonsAndCompanionsModElements.ModElement.Tag
public class IronSpearRangedItemUsedProcedure extends DungeonsAndCompanionsModElements.ModElement {
	public IronSpearRangedItemUsedProcedure(DungeonsAndCompanionsModElements instance) {
		super(instance, 154);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure IronSpearRangedItemUsed!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		{
			ItemStack _ist = (itemstack);
			if (_ist.attemptDamageItem((int) 5, new Random(), null)) {
				_ist.shrink(1);
				_ist.setDamage(0);
			}
		}
	}
}
