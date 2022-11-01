package me.comfy.legiontest1.commands;

import me.comfy.legiontest1.LegionTest1;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getLogger;

public class SetSpawnCommand implements CommandExecutor {

    private final LegionTest1 plugin;

    public SetSpawnCommand(LegionTest1 plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){

            Location location = p.getLocation();

            if(p.hasPermission("legiontest.setspawn")) {

                plugin.getConfig().set("spawn", location);

                plugin.saveConfig();

                p.sendMessage(ChatColor.YELLOW + "Spawn location set");
            }
        }else{
            getLogger().info("You need to be a player in order to use this command.");
        }

        return true;
    }
}
