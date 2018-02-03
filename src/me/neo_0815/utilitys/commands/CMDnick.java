package me.neo_0815.utilitys.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.neo_0815.utilitys.Utilitys;
import me.neo_0815.utilitys.utility.FileUtility;

public class CMDnick implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if(cmd.getName().equalsIgnoreCase("nick")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;

				if(!p.hasPermission("utilitys.nick")) {
					p.sendMessage(Utilitys.noperm);
					return true;
				}else {
					if(args.length < 1 && args.length > 2) {
						return false;
					}else if(args.length == 1) {
						if(p.getName().contains(args[0]) || args[0].equalsIgnoreCase("reset")) {
							String reset = p.getName();

							p.setCustomName(reset);
							p.setDisplayName(reset);
							p.setPlayerListName(reset);

							FileUtility.deleteNickname(p);

							p.sendMessage(Utilitys.pr + "Dein Name wurde auf §r" + reset + "§8 zurückgesetzt.");
						}else {
							String name = args[0].replaceAll("&", "§") + "§r";

							p.setCustomName(name);
							p.setDisplayName(name);
							p.setPlayerListName(name);

							FileUtility.saveNickname(p, name);

							p.sendMessage(Utilitys.pr + "Dein Name lautet nun §r" + name + "§8.");
						}

						return true;
					}else if(args.length == 2) {
						String name = args[0];
						String nName = args[1];

						Player target = Bukkit.getPlayer(name);

						if(target != null) {
							String rName = target.getName();
							if(args[1] != rName) {
								target.setCustomName(nName);
								target.setDisplayName(nName);
								target.setPlayerListName(nName);

								FileUtility.saveNickname(target, nName);

								target.sendMessage(Utilitys.pr + "Dein Name lautet nun §r" + nName + "§8.");
								p.sendMessage(Utilitys.pr + "Der Name von §6" + rName + "§8 lautet nun §r" + nName + "§8.");
							}else {
								target.setCustomName(rName);
								target.setDisplayName(rName);
								target.setPlayerListName(rName);

								FileUtility.deleteNickname(target);

								target.sendMessage(Utilitys.pr + "Dein Name wurde auf §r" + rName + "§8 zurückgesetzt.");
								p.sendMessage(Utilitys.pr + "Der Name von §6" + rName + "§8 wurde azurückgesetzt.");
							}
						}else {
							p.sendMessage(Utilitys.pr + "Der Spieler ist nicht online.");
						}
					}
				}
			}
		}
		return true;
	}
}
