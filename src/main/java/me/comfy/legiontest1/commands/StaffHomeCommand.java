package me.comfy.legiontest1.commands;

import me.comfy.legiontest1.LegionTest1;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffHomeCommand implements CommandExecutor {

    LegionTest1 plugin;

    public StaffHomeCommand(LegionTest1 plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p){
            if (plugin.getConfig().getBoolean("staffhome-enable")) {
                if (p.hasPermission("legiontest.staffhome")) {
                    if (args.length == 0) {
                        p.sendMessage("/staffhome set");
                        p.sendMessage("/staffhome return");
                        p.sendMessage("/staffhome <player>");
                        p.sendMessage("hi socks");
                    } else if (args.length == 1 && args[0].equalsIgnoreCase("set")) {
                        Location location = p.getLocation();
                        plugin.getConfig().createSection("savedlocations." + p.getName());
                        plugin.getConfig().set("savedlocations" + p.getName() + ".x", location.getX());
                        plugin.getConfig().set("savedlocations" + p.getName() + ".y", location.getY());
                        plugin.getConfig().set("savedlocations" + p.getName() + ".z", location.getZ());
                        plugin.saveConfig();
                        p.sendMessage(ChatColor.GREEN + "Successfully set a temporary home at " + ChatColor.GRAY + Math.round(plugin.getConfig().getDouble("savedlocations." + p.getName() + ".x")) + "/" + Math.round(plugin.getConfig().getDouble("savedlocations." + p.getName() + ".y")) + "/" + Math.round(plugin.getConfig().getDouble("savedlocations." + p.getName() + ".z")));
                        p.sendMessage(ChatColor.GREEN + "You may come back to it using /staffhome return.");
                    }else if (args.length == 1 && args[0].equalsIgnoreCase("return")) {
                        if (plugin.getConfig().isConfigurationSection("savedlocations." + p.getName())){
                            Location returnLocation = new Location(p.getWorld(), plugin.getConfig().getDouble("savedlocations." + p.getName() + ".x"), plugin.getConfig().getDouble("savedlocations." + p.getName() + ".y"), plugin.getConfig().getDouble("savedlocations." + p.getName() + ".z"));
                            p.teleport(returnLocation);
                            p.sendMessage(ChatColor.GREEN + "Returned to staff home.");
                            plugin.getConfig().set("savedlocations." + p.getName(), null);
                            plugin.saveConfig();
                        }else {
                            p.sendMessage(ChatColor.DARK_RED + "You never set a staff home!");
                        }
                    }
                }else {
                    p.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                }
            }
        }

        return true;
    }
}
