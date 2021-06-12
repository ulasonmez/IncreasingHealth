package me.blume.increasinghealth;

import java.util.HashSet;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	private HashSet<UUID> speedRunner = new HashSet<UUID>();
	@Override
	public void onEnable() {
	}
	@Override
	public void onDisable() {
	}
	public HashSet<UUID> getRunner(){
		return speedRunner;
	}
	public void addRunner(Player player) {
		speedRunner.add(player.getUniqueId());
	}
	public void removeRunner(Player player) {
		speedRunner.remove(player.getUniqueId());
	}
	public void clearRunner() {
		speedRunner.clear();
	}
}
