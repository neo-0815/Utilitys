package me.neo_0815.utilitys.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.neo_0815.utilitys.Utilitys;
import me.neo_0815.utilitys.utility.FileUtility;

public class CMDwarp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if(cmd.getName().equalsIgnoreCase("warp")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(args.length < 1) {
					return false;
				}else {
					if(args.length == 0) {
						return false;
					}else if(args.length == 2) {
						if(args[0].equalsIgnoreCase("set")) {
							if(!p.hasPermission("utilitys.warp.set")) {
								p.sendMessage(Utilitys.noperm);
								return true;
							}else {
								String name = args[1];

								if(FileUtility.searchWarp(name)) {
									p.sendMessage(Utilitys.pr + "Den Warppunkt §6" + name + "§8 gibt es bereits.");
								}else {
									FileUtility.saveWarp(p, name);
									p.sendMessage(Utilitys.pr + "Der Warppunkt §6" + name + "§8 wurde erfolgreich erstellt.");
								}
							}
							return true;
						}else if(args[0].equalsIgnoreCase("delete") || args[0].equalsIgnoreCase("del")) {
							if(!p.hasPermission("utilitys.warp.delete")) {
								p.sendMessage(Utilitys.noperm);
								return true;
							}else {
								String name = args[1];

								if(FileUtility.searchWarp(name)) {
									FileUtility.deleteWarp(name);
									p.sendMessage(Utilitys.pr + "Der Warppunkt §6" + name + "§8 wurde erfolgreich eliminiert.");
									return true;
								}else {
									p.sendMessage(Utilitys.pr + "Den Warppunkt §6" + name + "§8 gibt es nicht.");
								}
							}
							return true;
						}
					}else if(args.length == 1) {
						if(!p.hasPermission("utilitys.warp.warp")) {
							p.sendMessage(Utilitys.noperm);
							return true;
						}else {
							String name = args[0];

							if(FileUtility.searchWarp(name)) {
								p.sendMessage(Utilitys.pr + "Du wirst zum Warppunkt §6" + name + "§8 teleportiert.");
								p.teleport(FileUtility.loadWarp(name));
								return true;
							}else {
								p.sendMessage(Utilitys.pr + "Der Warppunkt §6" + name + "§8 existiert nicht.");
							}
						}
						return true;
					}
				}
			}
		}
		return true;
	}
}
