package me.neo_0815.utilitys.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.neo_0815.utilitys.Utilitys;
import me.neo_0815.utilitys.utility.FileUtility;

public class CMDmoney implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
		if(cmd.getName().equalsIgnoreCase("money")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;

				if(args.length == 0) {
					if(!p.hasPermission("utilitys.money.info")) {
						p.sendMessage(Utilitys.noperm);
						return true;
					}else {
						if(FileUtility.searchMoney(p)) {
							p.sendMessage(Utilitys.pr + "Du hast §6" + FileUtility.loadMoney(p) + " €§8.");
							return true;
						}else {
							FileUtility.saveMoney(p, 0);
							p.sendMessage(Utilitys.pr + "Du hast §6" + FileUtility.loadMoney(p) + " €§8.");
						}
					}
				}else if(args.length == 2) {
					if(args[0].equalsIgnoreCase("set")) {
						if(!p.hasPermission("utilitys.money.set")) {
							p.sendMessage(Utilitys.noperm);
							return true;
						}else {
							String in = args[1];
							double amount = Double.parseDouble(in);

							FileUtility.saveMoney(p, amount);

							p.sendMessage(Utilitys.pr + "Dein Geld wurde auf §6" + amount + " € §8gesetzt.");
						}
						return true;
					}else if(args[0].equalsIgnoreCase("add")) {
						if(!p.hasPermission("utilitys.money.add")) {
							p.sendMessage(Utilitys.noperm);
							return true;
						}else {
							String in = args[1];
							double add = Double.parseDouble(in);
							double amount = FileUtility.loadMoney(p);

							amount = amount + add;
							FileUtility.saveMoney(p, amount);

							p.sendMessage(Utilitys.pr + "Dein Geld wurde um §6" + add + " € §8erhöht.");
						}
					}else if(args[0].equalsIgnoreCase("remove")) {
						if(!p.hasPermission("utilitys.money.remove")) {
							p.sendMessage(Utilitys.noperm);
							return true;
						}else {
							String in = args[1];
							double remove = Double.parseDouble(in);
							double amount = FileUtility.loadMoney(p);

							amount = amount - remove;
							FileUtility.saveMoney(p, amount);

							p.sendMessage(Utilitys.pr + "Dein Geld wurde um §6" + remove + " € §8verringert.");
						}
					}
				}else if(args.length == 1) {
					if(args[0].equalsIgnoreCase("reset")) {
						if(!p.hasPermission("utilitys.money.reset")) {
							p.sendMessage(Utilitys.noperm);
							return true;
						}else {
							if(FileUtility.searchMoney(p)) {
								FileUtility.saveMoney(p, 0);
								p.sendMessage(Utilitys.pr + "Dein Geld wurde erfolgreich zurückgesetzt.");
							}else {
								p.sendMessage(Utilitys.pr + "Du hast kein Geld!!");
							}
						}
					}
				}
			}
		}
		return true;
	}
}
