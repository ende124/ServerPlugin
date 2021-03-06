package me.ende124.testplugin.commands;

import me.ende124.testplugin.ServerPlugin;
import me.ende124.testplugin.config.MyConfig;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class WarpsCommand extends ServerPluginCommand {
	public WarpsCommand(ServerPlugin instance) {
		super(instance);
	}

	MyConfig warps = ServerPlugin.warps;
	
	@Override
	public boolean onPlayerCommand(Player p, Command cmd, String label, String[] args) {

		//Header
		p.sendMessage(ChatColor.BLUE + "--------------" + ChatColor.GOLD + " Warps " + ChatColor.BLUE + "--------------");
		p.sendMessage("- " + ChatColor.AQUA + ChatColor.BOLD + "Name" + ChatColor.RESET + " - " + ChatColor.DARK_AQUA + ChatColor.BOLD + "Description");
		
		//Warp listing
		for (String s : warps.getConfigurationSection("warps").getKeys(false))
			p.sendMessage("- " + ChatColor.AQUA + s + ChatColor.RESET + " - " + ChatColor.DARK_AQUA + warps.getString("warps." + s + ".description"));
		
		return true;
	}
}
