package me.neo_0815.utilitys.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.neo_0815.utilitys.Utilitys;
import me.neo_0815.utilitys.utility.FileUtility;

public class CMDtpaccept implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if(cmd.getName().equalsIgnoreCase("tpaccept")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;

				if(!p.hasPermission("utilitys.tpaccept")) {
					p.sendMessage(Utilitys.noperm);
					return true;
				}else {
					if(args.length != 0) {
						return false;
					}else {
						Player requester = FileUtility.loadTPA(p);

						if(requester != null) {
							requester.sendMessage(Utilitys.pr + "Du wirst nun zu §6" + p.getDisplayName() + "§8 teleportiert.");
							p.sendMessage(Utilitys.pr + "§6" + requester.getDisplayName() + "§8 wird nun zu dir teleportiert.");

							requester.teleport(p);

							FileUtility.deleteTPA(p);
							return true;
						}else {
							p.sendMessage(Utilitys.pr + "Der Spieler ist nicht online");
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
