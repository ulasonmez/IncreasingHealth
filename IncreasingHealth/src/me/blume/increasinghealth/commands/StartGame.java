package me.blume.increasinghealth.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.blume.increasinghealth.Main;
import net.md_5.bungee.api.ChatColor;

public class StartGame implements CommandExecutor{

	private Main plugin;
	public StartGame(Main plugin) {
		this.plugin=plugin;
	}
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(plugin.getRunner().size()==0) {
			if(label.equals("increasehealthstart")) {
				if(args.length==0) {
					Player player = (Player) sender;
					if(plugin.getRunner().contains(player.getUniqueId())) {
						player.sendMessage("You have already been selected");
						return false;
					}
					plugin.addRunner(player);
					player.sendMessage("You are added.");
					for(Player p : Bukkit.getOnlinePlayers()) {
						if(!plugin.getRunner().contains(p.getUniqueId())) {
							p.setMaxHealth(2);
						}
					}
					return false;
				}
				else if(args.length==1) {
					Player player = Bukkit.getPlayerExact(args[0]);
					if(player==null) {
						sender.sendMessage(ChatColor.RED+"Could not find a player");
						return false;
					}
					if(plugin.getRunner().contains(player.getUniqueId())) {
						sender.sendMessage(args[0]+" is already added");
						return false;
					}
					plugin.addRunner(player);
					sender.sendMessage(args[0]+" added");
					player.sendMessage("You are added");
					for(Player p : Bukkit.getOnlinePlayers()) {
						if(!plugin.getRunner().contains(p.getUniqueId())) {
							p.setMaxHealth(2);
						}
					}
				}
				else {
					sender.sendMessage("You did not use the command properly");
				}
			}
		}

		return false;
	}
}
