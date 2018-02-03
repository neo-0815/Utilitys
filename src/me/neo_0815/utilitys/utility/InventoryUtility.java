package me.neo_0815.utilitys.utility;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.SpawnEgg;

public class InventoryUtility {

	public static void setupItemStack(Inventory inv, Material material, int damage, String name, int place) {
		ItemStack item = new ItemStack(material, 1, (short) damage);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);

		inv.setItem(place, item);
	}

	public static void setupSpawnEgg(Inventory inv, EntityType type, String name, int place) {
		ItemStack item = new SpawnEgg(type).toItemStack(1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);
		item.setItemMeta(meta);

		inv.setItem(place, item);
	}

	public static void setupInventorySeperator(Inventory inv, int place) {
		ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) DyeColor.BLACK.ordinal());
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§0~~~~~");
		item.setItemMeta(meta);

		inv.setItem(place, item);
	}
}
