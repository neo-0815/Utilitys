package me.neo_0815.utilitys.utility;

import org.bukkit.Material;

public class BlockUtility {

	private static Material[] stairs = { Material.ACACIA_STAIRS, Material.BIRCH_WOOD_STAIRS, Material.BRICK_STAIRS, Material.COBBLESTONE_STAIRS, Material.DARK_OAK_STAIRS, Material.JUNGLE_WOOD_STAIRS, Material.NETHER_BRICK_STAIRS, Material.PURPUR_STAIRS, Material.QUARTZ_STAIRS, Material.RED_SANDSTONE_STAIRS, Material.SANDSTONE_STAIRS, Material.SMOOTH_STAIRS, Material.SPRUCE_WOOD_STAIRS, Material.WOOD_STAIRS };

	public static boolean isSeat(Material block) {
		for(int i = 0; i < stairs.length; i++) {
			if(block == stairs[i]) {
				return true;
			}
		}
		return false;
	}
}
