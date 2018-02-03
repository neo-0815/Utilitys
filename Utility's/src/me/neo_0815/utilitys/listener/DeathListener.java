package me.neo_0815.utilitys.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.neo_0815.utilitys.Utilitys;
import me.neo_0815.utilitys.utility.FileUtility;

public class DeathListener implements Listener {

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();

		FileUtility.saveDeathPoint(p);
		if(p.hasPermission("utilitys.back")) p.sendMessage(Utilitys.pr + "Du kannst mit /back zu deinem Todespunkt zurückteleportieren.");
	}
}
