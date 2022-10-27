package me.comfy.legiontest1.commands;

import me.comfy.legiontest1.LegionTest1;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getLogger;

public class SpawnCommand implements CommandExecutor {

    private final LegionTest1 plugin;
    public SpawnCommand(LegionTest1 plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String args3[] = new String[3];

        if(sender instanceof Player p){
            Location location = plugin.getConfig().getLocation("spawn");

            if(args.length == 0) {

                if (location != null) {
                    p.teleport(location);
                    p.sendMessage(ChatColor.YELLOW + "You have been teleported to spawn.");
                } else {
                    p.sendMessage(ChatColor.RED + "There is no set spawn. Use /setspawn first.");
                }
            }else{

                String playerName = args[0];

                Player target = Bukkit.getServer().getPlayerExact(playerName);
                if(p.hasPermission("legiontest.spawnothers")) {

                    if (target == null) {

                        p.sendMessage(ChatColor.RED + "That player is not online.");
                    } else {
                        if (location != null) {
                            target.teleport(location);
                            p.sendMessage(ChatColor.GREEN + "Teleported " + target.getDisplayName() + " to spawn location.");
                        }
                    }
                }else{
                    p.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                }
            }
        }

        return true;
    }
}
