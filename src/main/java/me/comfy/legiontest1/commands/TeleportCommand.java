package me.comfy.legiontest1.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p){

            if (args.length == 0){
                p.sendMessage(ChatColor.GRAY + "Usage: /tp (player)");
            }else if (args.length == 1){
                if (p.hasPermission("legiontest.tp")) {
                    Player target = Bukkit.getPlayer(args[0]);
                    try {
                        p.teleport(target.getLocation());
                        p.sendMessage("Teleported to " + target);
                    } catch (NullPointerException e) {
                        p.sendMessage(ChatColor.RED + "That player is not online!");
                    }
                }else{
                    p.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                }
            }else if (args.length == 2){
                if (p.hasPermission("legiontest.tpothers")) {
                    //Player to teleport
                    Player playerToSend = Bukkit.getPlayer(args[0]);
                    Player target = Bukkit.getPlayer(args[1]);
                    try {
                        playerToSend.teleport(target.getLocation());
                        p.sendMessage("Teleported " + playerToSend + " to " + target);
                    } catch (NullPointerException e) {
                        p.sendMessage(ChatColor.RED + "That player is not online!");
                    }
                }
            }

        }

        return true;
    }
}
