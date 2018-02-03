package me.neo_0815.utilitys.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.neo_0815.utilitys.Utilitys;
import me.neo_0815.utilitys.utility.FileUtility;

public class CMDsaveInv implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if(cmd.getName().equalsIgnoreCase("saveinv")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(!p.hasPermission("utilitys.inv.save")) {
					p.sendMessage(Utilitys.noperm);
					return true;
				}else {
					if(args.length != 0) {
						return false;
					}else {
						FileUtility.saveInv(p);
						FileUtility.saveArmor(p);

						p.sendMessage(Utilitys.pr + "Dein Inventar wurde erfolgreich gesichert.");
					}
				}
			}
		}
		return true;
	}
}
