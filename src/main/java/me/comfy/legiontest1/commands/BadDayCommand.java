package me.comfy.legiontest1.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BadDayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p){
            p.sendMessage(ChatColor.GOLD + "Hello, I hope you have a " + ChatColor.ITALIC + "wonderful" + ChatColor.GOLD + " day.");
        }

        return true;
    }
}
