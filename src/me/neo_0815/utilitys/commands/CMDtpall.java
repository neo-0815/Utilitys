package me.neo_0815.utilitys.commands;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.neo_0815.utilitys.Utilitys;

public class CMDtpall implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if(cmd.getName().equalsIgnoreCase("tpall")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;

				if(!p.hasPermission("utilitys.tpall")) {
					p.sendMessage(Utilitys.noperm);
					return true;
				}else {
					if(args.length != 0) {
						return false;
					}else {
						Collection<? extends Player> targets = Bukkit.getOnlinePlayers();
						for(Player target : targets) {
							target.teleport(p);
						}
					}
				}
			}
		}
		return true;
	}
}
