package me.neo_0815.utilitys.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import me.neo_0815.utilitys.Utilitys;

public class CMDhat implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if(cmd.getName().equalsIgnoreCase("hat")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;

				if(!p.hasPermission("utilitys.hat")) {
					p.sendMessage(Utilitys.noperm);
					return true;
				}else {
					PlayerInventory inv = p.getInventory();

					ItemStack helmet = inv.getHelmet();
					ItemStack hand = inv.getItemInMainHand();

					inv.setItemInMainHand(helmet);
					inv.setHelmet(hand);

					p.sendMessage(Utilitys.pr + "Das Item wurde auf deinen Kopf gesetzt.");
				}
			}
		}
		return true;
	}
}
