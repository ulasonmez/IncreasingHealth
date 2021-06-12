package me.blume.increasinghealth.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.blume.increasinghealth.Main;

public class StopGame implements CommandExecutor{
	
	private Main plugin;
	public StopGame(Main plugin) {
		this.plugin=plugin;
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(label.equals("increasehealthstop")) {
			plugin.clearRunner();
			for(Player p : Bukkit.getOnlinePlayers()) {
				p.setMaxHealth(20);
			}
		}
		return false;
	}
}
