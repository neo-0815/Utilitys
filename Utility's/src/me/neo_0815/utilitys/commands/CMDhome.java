package me.neo_0815.utilitys.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.neo_0815.utilitys.Utilitys;
import me.neo_0815.utilitys.utility.FileUtility;

public class CMDhome implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if(cmd.getName().equalsIgnoreCase("home")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;

				if(args.length == 0) {
					if(!p.hasPermission("utilitys.home.warp")) {
						p.sendMessage(Utilitys.noperm);
						return true;
					}else {
						if(FileUtility.searchHome(p, "home")) {
							p.sendMessage(Utilitys.pr + "Du wirst zum Home teleportiert.");
							p.teleport(FileUtility.loadHome(p, "home"));
							return true;
						}else {
							return false;
						}
					}
				}else if(args.length == 2) {
					if(args[0].equalsIgnoreCase("set")) {
						if(!p.hasPermission("utilitys.home.set")) {
							p.sendMessage(Utilitys.noperm);
							return true;
						}else {
							String name = args[1];

							if(FileUtility.searchHome(p, name)) {
								p.sendMessage(Utilitys.pr + "Das Home §6" + name + "§8 gibt es bereits.");
							}else {
								FileUtility.saveHome(p, name);
								p.sendMessage(Utilitys.pr + "Das Home §6" + name + "§8 wurde erfolgreich erstellt.");
							}
						}
						return true;
					}else if(args[0].equalsIgnoreCase("delete") || args[0].equalsIgnoreCase("del")) {
						if(!p.hasPermission("utilitys.home.delete")) {
							p.sendMessage(Utilitys.noperm);
							return true;
						}else {
							String name = args[1];

							if(FileUtility.searchHome(p, name)) {
								FileUtility.deleteHome(p, name);
								p.sendMessage(Utilitys.pr + "Das Home §6" + name + "§8 wurde erfolgreich eliminiert.");
								return true;
							}else {
								p.sendMessage(Utilitys.pr + "Das Home §6" + name + "§8 gibt es nicht.");
							}
						}
						return true;
					}
				}else if(args.length == 1) {
					if(!p.hasPermission("utilitys.home.warp")) {
						p.sendMessage(Utilitys.noperm);
						return true;
					}else {
						String name = args[0];

						if(FileUtility.searchHome(p, name)) {
							p.sendMessage(Utilitys.pr + "Du wirst zum Home §6" + name + "§8 teleportiert.");
							p.teleport(FileUtility.loadHome(p, name));
							return true;
						}else {
							p.sendMessage(Utilitys.pr + "Das Home §6" + name + "§8 existiert nicht.");
						}
					}
					return true;
				}
			}
		}
		return true;
	}
}
