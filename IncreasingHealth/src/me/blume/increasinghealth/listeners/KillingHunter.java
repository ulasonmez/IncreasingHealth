package me.blume.increasinghealth.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import me.blume.increasinghealth.Main;

public class KillingHunter implements Listener{
	
	private Main plugin;
	public KillingHunter(Main plugin) {
		this.plugin=plugin;
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onHunterDeath(EntityDeathEvent event) {
		if(event.getEntity() instanceof Player) {
			Player dead = (Player) event.getEntity();
			Player killer = event.getEntity().getKiller();
			if(plugin.getRunner().contains(killer.getUniqueId()) && !plugin.getRunner().contains(dead.getUniqueId())) {
				dead.setMaxHealth(dead.getMaxHealth()+2);
				return;
			}
		}
	}

}
