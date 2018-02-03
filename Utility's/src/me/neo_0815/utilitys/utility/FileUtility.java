package me.neo_0815.utilitys.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class FileUtility {

	public static void saveInv(Player p) {
		ArrayList<ItemStack> list = new ArrayList<>();
		String name = p.getName();
		File file = new File("plugins//Utility's//Inventory//" + name + "//inv.yml");

		try {
			file.createNewFile();
		}catch(IOException e) {
			System.out.println("[Utility's] Pfad nicht gefunden!");
		}

		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		ItemStack[] contents = p.getInventory().getContents();

		for(int i = 0; i < contents.length; i++) {
			ItemStack item = contents[i];

			list.add(item);

		}
		cfg.set("Inventory", list);
		try {
			cfg.save(file);
		}catch(IOException e) {
			System.out.println("[Utility's] Pfad nicht gefunden!");
		}
	}

	public static void saveArmor(Player p) {
		ArrayList<ItemStack> list = new ArrayList<>();
		String name = p.getName();
		File file = new File("plugins//Utility's//Inventory//" + name + "//armor.yml");

		try {
			file.createNewFile();
		}catch(IOException e) {
			System.out.println("[Utility's] Pfad nicht gefunden!");
		}

		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		ItemStack[] contents = p.getInventory().getArmorContents();

		for(int i = 0; i < contents.length; i++) {
			ItemStack item = contents[i];

			list.add(item);

		}
		cfg.set("Armor", list);
		try {
			cfg.save(file);
		}catch(IOException e) {
			System.out.println("[Utility's] Pfad nicht gefunden!");
		}
	}

	public static void loadInv(Player p) {
		String name = p.getName();
		File file = new File("plugins//Utility's//Inventory//" + name + "//inv.yml");

		if(file.exists()) {
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			p.getInventory().clear();
			ItemStack[] contents = p.getInventory().getContents();
			List<?> list = cfg.getList("Inventory");

			for(int i = 0; i < list.size(); i++) {
				contents[i] = (ItemStack) list.get(i);
			}
			p.getInventory().setContents(contents);
		}
	}

	public static void loadArmor(Player p) {
		String name = p.getName();
		File file = new File("plugins//Utility's//Inventory//" + name + "//armor.yml");

		if(file.exists()) {
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

			ItemStack[] contents = p.getInventory().getArmorContents();
			List<?> list = cfg.getList("Armor");

			for(int i = 0; i < list.size(); i++) {
				contents[i] = (ItemStack) list.get(i);
			}
			p.getInventory().setArmorContents(contents);
		}
	}

	public static void saveDeathPoint(Player p) {
		String name = p.getName();
		File file = new File("plugins//Utility's//DeathPoint//" + name + ".yml");

		try {
			file.createNewFile();
		}catch(IOException e) {
			System.out.println("[Utility's] Pfad nicht gefunden!");
		}

		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set("DeathPoint", p.getLocation());
		try {
			cfg.save(file);
		}catch(IOException e) {
			System.out.println("[Utility's] Pfad nicht gefunden!");
		}
	}

	public static Location loadDeathPoint(Player p) {
		String name = p.getName();
		File file = new File("plugins//Utility's//DeathPoint//" + name + ".yml");
		Location loc = null;

		if(file.exists()) {
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

			loc = (Location) cfg.get("DeathPoint");
		}
		return loc;
	}

	public static void saveWarp(Player p, String name) {
		File file = new File("plugins//Utility's//Warp//" + name + ".yml");

		try {
			file.createNewFile();
		}catch(IOException e) {
			System.out.println("[Utility's] Pfad nicht gefunden!");
		}

		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set("Warp", p.getLocation());
		try {
			cfg.save(file);
		}catch(IOException e) {
			System.out.println("[Utility's] Pfad nicht gefunden!");
		}
	}

	public static Location loadWarp(String name) {
		File file = new File("plugins//Utility's//Warp//" + name + ".yml");
		Location loc = null;

		if(file.exists()) {
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

			loc = (Location) cfg.get("Warp");
		}
		return loc;
	}

	public static void deleteWarp(String name) {
		File file = new File("plugins//Utility's//Warp//" + name + ".yml");

		if(!file.exists()) {
			return;
		}else {
			file.delete();
		}
	}

	public static boolean searchWarp(String name) {
		File file = new File("plugins//Utility's//Warp//" + name + ".yml");

		if(file.exists()) {
			return true;
		}else {
			return false;
		}
	}

	public static void saveHome(Player p, String name) {
		String pName = p.getName();
		File file = new File("plugins//Utility's//Home//" + pName + "//" + name + ".yml");

		try {
			file.createNewFile();
		}catch(IOException e) {
			System.out.println("[Utility's] Pfad nicht gefunden!");
		}

		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set("Home", p.getLocation());
		try {
			cfg.save(file);
		}catch(IOException e) {
			System.out.println("[Utility's] Pfad nicht gefunden!");
		}
	}

	public static Location loadHome(Player p, String name) {
		String pName = p.getName();
		File file = new File("plugins//Utility's//Home//" + pName + "//" + name + ".yml");
		Location loc = null;

		if(file.exists()) {
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

			loc = (Location) cfg.get("Home");
		}
		return loc;
	}

	public static void deleteHome(Player p, String name) {
		String pName = p.getName();
		File file = new File("plugins//Utility's//Home//" + pName + "//" + name + ".yml");

		if(!file.exists()) {
			return;
		}else {
			file.delete();
		}
	}

	public static boolean searchHome(Player p, String name) {
		String pName = p.getName();
		File file = new File("plugins//Utility's//Home//" + pName + "//" + name + ".yml");

		if(file.exists()) {
			return true;
		}else {
			return false;
		}
	}

	public static void saveMoney(Player p, double amount) {
		String name = p.getName();
		File file = new File("plugins//Utility's//Player//" + name + ".yml");

		try {
			file.createNewFile();
		}catch(IOException e) {
			System.out.println("[Utility's] Pfad nicht gefunden!");
		}

		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set("Money", amount);
		try {
			cfg.save(file);
		}catch(IOException e) {
			System.out.println("[Utility's] Pfad nicht gefunden!");
		}
	}

	public static double loadMoney(Player p) {
		String name = p.getName();
		File file = new File("plugins//Utility's//Player//" + name + ".yml");
		double amount = -1;

		if(file.exists()) {
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

			amount = (double) cfg.get("Money");
		}
		return amount;
	}

	public static boolean searchMoney(Player p) {
		String name = p.getName();
		File file = new File("plugins//Utility's//Player//" + name + ".yml");

		if(file.exists()) {
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

			if(cfg.get("Money") != null) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}

	public static void saveTPA(Player p, Player requester) {
		String name = p.getName();
		File file = new File("plugins//Utility's//TPA//" + name + ".yml");

		try {
			file.createNewFile();
		}catch(IOException e) {
			System.out.println("[Utility's] Pfad nicht gefunden!");
		}

		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set("Requester", requester);
		try {
			cfg.save(file);
		}catch(IOException e) {
			System.out.println("[Utility's] Pfad nicht gefunden!");
		}
	}

	public static Player loadTPA(Player p) {
		String name = p.getName();
		File file = new File("plugins//Utility's//TPA//" + name + ".yml");
		Player requester = null;

		if(file.exists()) {
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

			requester = (Player) cfg.get("Requester");
		}
		return requester;
	}

	public static boolean searchTPA(Player p) {
		String name = p.getName();
		File file = new File("plugins//Utility's//TPA//" + name + ".yml");

		if(file.exists()) {
			return true;
		}
		return false;
	}

	public static void deleteTPA(Player p) {
		String name = p.getName();
		File file = new File("plugins//Utility's//TPA//" + name + ".yml");

		if(!file.exists()) {
			return;
		}else {
			file.delete();
		}
	}

	public static void saveNickname(Player p, String nickname) {
		String name = p.getName();
		File file = new File("plugins//Utility's//Player//" + name + ".yml");

		try {
			file.createNewFile();
		}catch(IOException e) {
			System.out.println("[Utility's] Pfad nicht gefunden!");
		}

		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set("Nickname", nickname);
		try {
			cfg.save(file);
		}catch(IOException e) {
			System.out.println("[Utility's] Pfad nicht gefunden!");
		}
	}

	public static void deleteNickname(Player p) {
		String name = p.getName();
		File file = new File("plugins//Utility's//Player//" + name + ".yml");

		if(!file.exists()) {
			return;
		}else {
			YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
			cfg.set("Nickname", "");
			try {
				cfg.save(file);
			}catch(IOException e) {
				System.out.println("[Utility's] Pfad nicht gefunden!");
			}
		}
	}
}
