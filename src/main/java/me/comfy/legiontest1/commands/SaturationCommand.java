package me.comfy.legiontest1.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class SaturationCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){

            if (args.length == 0) {
                p.setSaturation(20);
                p.sendMessage(ChatColor.GOLD + "Saturation set to max.");
            }else if (args.length == 1 && args[0] == "set" || args.length == 2 && args[0] == "set"){
                p.sendMessage("/saturation set (name) 20");
            }else if (args.length == 3 && args[0] == "set"){
                try {
                    Player target = Bukkit.getPlayer(args[1]);
                    int sAmount = Integer.parseInt(args[2]);
                    target.setSaturation(sAmount);
                } catch (NullPointerException n){
                    p.sendMessage(ChatColor.RED + "That player is not online.");
                }
            }

        }

        return true;
    }
}
