package me.neo_0815.utilitys.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.neo_0815.utilitys.Utilitys;
import me.neo_0815.utilitys.utility.FileUtility;

public class CMDback implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if(cmd.getName().equalsIgnoreCase("back")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(!p.hasPermission("utilitys.back")) {
					p.sendMessage(Utilitys.noperm);
					return true;
				}else {
					if(args.length != 0) {
						return false;
					}else {
						Location loc;
						loc = FileUtility.loadDeathPoint(p);

						if(loc == null) {
							p.sendMessage(Utilitys.pr + "Du bist noch nicht gestorben!!");
						}else {
							p.teleport(loc);
						}
					}
				}
			}
		}
		return true;
	}
}
