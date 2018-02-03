package me.neo_0815.utilitys.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.neo_0815.utilitys.Utilitys;
import me.neo_0815.utilitys.utility.FileUtility;

public class CMDtpa implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if(cmd.getName().equalsIgnoreCase("tpa")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;

				if(!p.hasPermission("utilitys.tpa")) {
					p.sendMessage(Utilitys.noperm);
					return true;
				}else {
					if(args.length != 1) {
						return false;
					}else {
						Player target = Bukkit.getPlayer(args[0]);

						if(target != null) {
							FileUtility.saveTPA(target, p);

							target.sendMessage(Utilitys.pr + "§6" + p.getDisplayName() + "§8 möchte sich zu dir teleportieren.");
							target.sendMessage(Utilitys.pr + "Nehme diese mit §e/tpaccept §8an.");

							p.sendMessage(Utilitys.pr + "Teleportationsanfrage erfolgreich an §6" + args[0] + "§8 verschickt.");
							return true;
						}
					}
				}
			}
		}
		return true;
	}
}
