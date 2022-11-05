package me.comfy.legiontest1.commands;

import me.comfy.legiontest1.LegionTest1;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class VanishCommand implements CommandExecutor {

    LegionTest1 plugin;

    public VanishCommand(LegionTest1 plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p){

            if (plugin.vanishedlist.contains(p)){
                for (Player people : Bukkit.getOnlinePlayers()){
                    people.showPlayer(plugin, p);
                }
                plugin.vanishedlist.remove(p);
                p.sendMessage(ChatColor.GREEN + "You are now visible to all players.");
            }else if (!plugin.vanishedlist.contains(p)){
                for (Player people : Bukkit.getOnlinePlayers()){
                    people.hidePlayer(plugin, p);
                }
                plugin.vanishedlist.add(p);
                p.sendMessage(ChatColor.GREEN + "You are now invisible to all players.");
            }

        }

        return true;
    }
}
