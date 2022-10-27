package me.comfy.legiontest1.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getLogger;

public class TimeCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command etime, String label, String[] args) {
        if(sender instanceof ConsoleCommandSender) {
            ConsoleCommandSender c = (ConsoleCommandSender) sender;
            getLogger().info("check the time on your computer idiot.");
        }else if(sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage(ChatColor.GOLD + "check the time on your computer " + ChatColor.BOLD + ChatColor.UNDERLINE + "idiot.");
        }
        return true;
    }


}
