package me.neo_0815.utilitys;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.neo_0815.utilitys.commands.CMDback;
import me.neo_0815.utilitys.commands.CMDhat;
import me.neo_0815.utilitys.commands.CMDhome;
import me.neo_0815.utilitys.commands.CMDinvsee;
import me.neo_0815.utilitys.commands.CMDloadInv;
import me.neo_0815.utilitys.commands.CMDmoney;
import me.neo_0815.utilitys.commands.CMDnick;
import me.neo_0815.utilitys.commands.CMDpets;
import me.neo_0815.utilitys.commands.CMDsaveInv;
import me.neo_0815.utilitys.commands.CMDtpa;
import me.neo_0815.utilitys.commands.CMDtpaccept;
import me.neo_0815.utilitys.commands.CMDtpall;
import me.neo_0815.utilitys.commands.CMDwarp;
import me.neo_0815.utilitys.listener.DeathListener;
import me.neo_0815.utilitys.listener.InvseeListener;
import me.neo_0815.utilitys.listener.SeatListener;

public class Utilitys extends JavaPlugin {
	public static String pr = "§8[§aUtility's§8] ";
	public static String noperm = pr + "§cDazu hast du keine Berechtigung!";

	@Override
	public void onEnable() {
		fileCheck();

		registerCMDs();
		registerListeners();
	}

	private void registerCMDs() {
		registerCmd("saveinv", new CMDsaveInv());
		registerCmd("loadinv", new CMDloadInv());
		registerCmd("invsee", new CMDinvsee());
		registerCmd("back", new CMDback());
		registerCmd("warp", new CMDwarp());
		registerCmd("home", new CMDhome());
		registerCmd("money", new CMDmoney());
		registerCmd("tpa", new CMDtpa());
		registerCmd("tpaccept", new CMDtpaccept());
		registerCmd("tpall", new CMDtpall());
		registerCmd("hat", new CMDhat());
		registerCmd("nick", new CMDnick());
		registerCmd("pets", new CMDpets());
	}

	private void registerListeners() {
		registerListener(new DeathListener());
		registerListener(new SeatListener());
		registerListener(new InvseeListener());
	}

	private void registerCmd(String name, CommandExecutor executor) {
		getCommand(name).setExecutor(executor);
	}

	private void registerListener(Listener listener) {
		Bukkit.getPluginManager().registerEvents(listener, this);
	}

	private void fileCheck() {
		File path = new File("plugins//Utility's");
		if(!path.exists()) path.mkdir();
	}
}
