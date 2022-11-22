package me.comfy.legiontest1.commands;

import me.comfy.legiontest1.LegionTest1;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getLogger;

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
                        p.sendMessage("/staffhome reload");
                        p.sendMessage("hi socks");
                    } else if (args.length == 1 && args[0].equalsIgnoreCase("set")) {
                        if (plugin.getConfig().isConfigurationSection("savedlocations." + p.getName())){
                            p.sendMessage(ChatColor.GREEN + "Overriding new home at " + ChatColor.GRAY + Math.round(plugin.getConfig().getDouble("savedlocations." + p.getName() + ".x")) + "/" + Math.round(plugin.getConfig().getDouble("savedlocations." + p.getName() + ".y")) + "/" + Math.round(plugin.getConfig().getDouble("savedlocations." + p.getName() + ".z")));
                            saveLocation(p);
                        }else {
                            saveLocation(p);
                        }
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
                    }else if (args.length == 1){
                        if (p.hasPermission("legiontest.staffhomeother")) {
                            Player target = Bukkit.getPlayer(args[0]);
                            if (target == null) {
                                p.sendMessage(ChatColor.RED + "That player is not online.");
                            } else {
                                if (plugin.getConfig().isConfigurationSection("savedlocations." + target.getName())) {
                                    Location returnLocation = new Location(target.getWorld(), plugin.getConfig().getDouble("savedlocations." + target.getName() + ".x"), plugin.getConfig().getDouble("savedlocations." + target.getName() + ".y"), plugin.getConfig().getDouble("savedlocations." + target.getName() + ".z"));
                                    p.teleport(returnLocation);
                                    p.sendMessage(ChatColor.GREEN + "Successfully teleported to the staff home of " + target.getDisplayName() + " at " + ChatColor.GRAY + Math.round(plugin.getConfig().getDouble("savedlocations." + target.getName() + ".x")) + "/" + Math.round(plugin.getConfig().getDouble("savedlocations." + target.getName() + ".y")) + "/" + Math.round(plugin.getConfig().getDouble("savedlocations." + target.getName() + ".z")));
                                } else {
                                    p.sendMessage(ChatColor.DARK_RED + "That player does not have a set staff home.");
                                }
                            }
                        }else {
                            p.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                        }
                    }
                }else {
                    p.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                }
            }
        }else if (sender instanceof ConsoleCommandSender console){
            getLogger().info("Only players may use this command.");
        }

        return true;
    }

public void saveLocation(Player p){
    Location location = p.getLocation();
    plugin.getConfig().createSection("savedlocations." + p.getName());
    plugin.getConfig().set("savedlocations" + p.getName() + ".x", location.getX());
    plugin.getConfig().set("savedlocations" + p.getName() + ".y", location.getY());
    plugin.getConfig().set("savedlocations" + p.getName() + ".z", location.getZ());
    plugin.saveConfig();
    p.sendMessage(ChatColor.GREEN + "Successfully set a temporary home at " + ChatColor.GRAY + Math.round(plugin.getConfig().getDouble("savedlocations." + p.getName() + ".x")) + "/" + Math.round(plugin.getConfig().getDouble("savedlocations." + p.getName() + ".y")) + "/" + Math.round(plugin.getConfig().getDouble("savedlocations." + p.getName() + ".z")));
    p.sendMessage(ChatColor.GREEN + "You may come back to it using /staffhome return.");
}

}
