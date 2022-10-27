package me.comfy.legiontest1.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SaturationCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){

            p.setSaturation(20);
            p.sendMessage(ChatColor.GOLD + "Saturation set to max.");

        }

        return true;
    }
}
