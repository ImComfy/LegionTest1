package me.comfy.legiontest1.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){
            if(p.hasPermission("legiontest1.feed")) {
                p.setFoodLevel(20);
                p.sendMessage(ChatColor.YELLOW + "Food set to max");
            }else{
                p.sendMessage(ChatColor.RED + "You do not have permission to use that command!");
            }
        }

        return true;
    }
}
