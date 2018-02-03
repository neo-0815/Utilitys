package me.neo_0815.utilitys.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class InvseeListener implements Listener {

	@EventHandler
	public void onItemMove(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		Inventory inv = e.getClickedInventory();

		if(inv.getTitle().contains("§8's Inventar")) {
			if(!p.hasPermission("utilitys.inv.edit")) e.setCancelled(true);
			else {

				ItemStack item = e.getCurrentItem();

				if(item.getType() != Material.AIR) if(item.getItemMeta().getDisplayName().equals("§0~~~~~")) e.setCancelled(true);

				ItemStack[] stacks = inv.getContents();

				Player target = Bukkit.getPlayer(inv.getTitle().replaceAll("§8's Inventar", ""));

				if(target != null) {
					PlayerInventory pInv = target.getInventory();
					ItemStack[] contents = new ItemStack[41];
					ItemStack[] armor = new ItemStack[4];
					ItemStack offHand;

					for(int i = 0; i < 9; i++)
						contents[i] = stacks[i];

					for(int i = 0; i < 27; i++)
						contents[i + 9] = stacks[i + 18];

					for(int i = 0; i < 4; i++)
						armor[i] = stacks[i + 46];

					offHand = stacks[51];

					pInv.setContents(contents);
					pInv.setArmorContents(armor);
					pInv.setItemInOffHand(offHand);
				}
			}
		}
	}
}
