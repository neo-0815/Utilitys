package me.neo_0815.utilitys.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.neo_0815.utilitys.Utilitys;
import me.neo_0815.utilitys.utility.InventoryUtility;

public class CMDpets implements CommandExecutor {

	private Inventory inv = Bukkit.createInventory(null, 5 * 9, "§aPets");

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if(cmd.getName().equalsIgnoreCase("pets")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;

				if(!p.hasPermission("utilitys.pets")) {
					p.sendMessage(Utilitys.noperm);
					return true;
				}else {
					if(args.length != 0) {
						return false;
					}else {
						InventoryUtility.setupInventorySeperator(inv, 0);
						InventoryUtility.setupInventorySeperator(inv, 1);
						InventoryUtility.setupInventorySeperator(inv, 2);
						InventoryUtility.setupInventorySeperator(inv, 3);
						InventoryUtility.setupInventorySeperator(inv, 4);
						InventoryUtility.setupInventorySeperator(inv, 5);
						InventoryUtility.setupInventorySeperator(inv, 6);
						InventoryUtility.setupInventorySeperator(inv, 7);
						InventoryUtility.setupInventorySeperator(inv, 8);
						InventoryUtility.setupInventorySeperator(inv, 9);
						InventoryUtility.setupSpawnEgg(inv, EntityType.SHEEP, "§fSchaf", 10);
						InventoryUtility.setupSpawnEgg(inv, EntityType.CHICKEN, "§4Huhn", 11);
						InventoryUtility.setupSpawnEgg(inv, EntityType.COW, "§6Kuh", 12);
						InventoryUtility.setupSpawnEgg(inv, EntityType.BAT, "§7Fledermaus", 13);
						InventoryUtility.setupSpawnEgg(inv, EntityType.VILLAGER, "§5Dorfbewohner", 14);
						InventoryUtility.setupSpawnEgg(inv, EntityType.SPIDER, "§8Spinne", 15);
						InventoryUtility.setupSpawnEgg(inv, EntityType.OCELOT, "§eOzelot", 16);
						InventoryUtility.setupInventorySeperator(inv, 17);
						InventoryUtility.setupInventorySeperator(inv, 18);

						p.openInventory(inv);
					}
				}
			}
		}
		return true;
	}
}
