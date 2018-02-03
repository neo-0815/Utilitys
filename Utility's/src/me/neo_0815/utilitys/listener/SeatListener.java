package me.neo_0815.utilitys.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.spigotmc.event.entity.EntityDismountEvent;

import me.neo_0815.utilitys.Utilitys;
import me.neo_0815.utilitys.utility.BlockUtility;

public class SeatListener implements Listener {

	@EventHandler
	public void onRightClickSeat(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(!p.hasPermission("utilitys.seat")) {
				p.sendMessage(Utilitys.noperm);
				e.setCancelled(true);
			}else {
				Block block = e.getClickedBlock();
				Material type = block.getType();
				Location loc = block.getLocation();

				if(BlockUtility.isSeat(type)) {
					Arrow arrow = p.getWorld().spawn(new Location(loc.getWorld(), loc.getX() + 0.5, loc.getY(), loc.getZ() + 0.5, loc.getYaw(), loc.getPitch()), Arrow.class);
					arrow.setCustomName("Seat");
					arrow.setPassenger(p);
				}
			}
		}
	}

	@SuppressWarnings("unused")
	@EventHandler
	public void onSeatDismount(EntityDismountEvent e) {
		Entity entity = e.getEntity();
		Entity entity2 = e.getDismounted();

		if(entity instanceof Player && entity2 instanceof Arrow) {
			Player p = (Player) entity;
			Arrow arrow = (Arrow) entity2;
			if(arrow.getCustomName() == "Seat") {
				arrow.remove();
			}
		}
	}
}
