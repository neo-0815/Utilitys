package me.neo_0815.utilitys.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.neo_0815.utilitys.Utilitys;
import me.neo_0815.utilitys.utility.InventoryUtility;

public class CMDinvsee implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if(cmd.getName().equalsIgnoreCase("invsee")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;

				if(!p.hasPermission("utilitys.inv.see")) {
					p.sendMessage(Utilitys.noperm);
					return true;
				}else {
					if(args.length != 1) return false;
					else {
						Player target = Bukkit.getPlayer(args[0]);
						if(target != null) {
							Inventory inv = Bukkit.createInventory(p, 6 * 9, "§6" + target.getDisplayName() + "§8's Inventar");

							ItemStack[] contents = target.getInventory().getContents();
							for(int i = 0; i < 9; i++)
								inv.setItem(i, contents[i]);

							InventoryUtility.setupInventorySeperator(inv, 9);
							InventoryUtility.setupInventorySeperator(inv, 10);
							InventoryUtility.setupInventorySeperator(inv, 11);
							InventoryUtility.setupInventorySeperator(inv, 12);
							InventoryUtility.setupInventorySeperator(inv, 13);
							InventoryUtility.setupInventorySeperator(inv, 14);
							InventoryUtility.setupInventorySeperator(inv, 15);
							InventoryUtility.setupInventorySeperator(inv, 16);
							InventoryUtility.setupInventorySeperator(inv, 17);

							for(int i = 0; i < 27; i++)
								inv.setItem(i + 18, contents[i + 9]);

							InventoryUtility.setupInventorySeperator(inv, 45);

							ItemStack[] armor = target.getInventory().getArmorContents();
							for(int i = 0; i < 4; i++)
								inv.setItem(i + 46, armor[i]);

							InventoryUtility.setupInventorySeperator(inv, 50);

							inv.setItem(51, target.getInventory().getItemInOffHand());

							InventoryUtility.setupInventorySeperator(inv, 52);
							InventoryUtility.setupInventorySeperator(inv, 53);

							p.openInventory(inv);
						}else p.sendMessage(Utilitys.pr + "Der Spieler §6" + args[0] + "§8 ist nicht online!!");

					}
				}
			}
		}
		return true;
	}
}
