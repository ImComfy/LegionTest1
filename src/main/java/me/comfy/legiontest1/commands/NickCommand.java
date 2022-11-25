package me.comfy.legiontest1.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getLogger;

public class NickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p){
            if (p.isOp() || p.hasPermission("legiontest.nick")){
                if (args.length == 0 || args.length == 1){
                    p.sendMessage("/nick set (player) (nick)");
                    p.sendMessage("/nick (player)");
                }else if (args.length == 2){
                    if (args[0].equalsIgnoreCase("set")){
                        try {
                            Player target = Bukkit.getPlayer(args[0]);
                            String nickname = args[1];
                            target.setDisplayName(nickname);
                            target.setPlayerListName(nickname);
                            p.sendMessage(ChatColor.GREEN + "Successfully nicked " + target.getName() + " to " + nickname);
                            target.sendMessage(ChatColor.GREEN + "Nickname has been set to " + "\"" + nickname + "\"" + " by " + p.getDisplayName());
                        }catch (NullPointerException n){
                            p.sendMessage(ChatColor.RED + "That player is not online.");
                        }
                    }
                }

                if (command.getName().equalsIgnoreCase("unnick")){
                    if (args.length == 0){
                        String name = p.getName();
                        p.setDisplayName(name);
                        p.setPlayerListName(name);
                    }else if (args.length == 1){
                        try {
                            Player target = Bukkit.getPlayer(args[0]);
                            String name = target.getName();
                            target.setDisplayName(name);
                            target.setPlayerListName(name);
                            p.sendMessage(ChatColor.GREEN + "Successfully removed nick from " + target.getName());
                            target.sendMessage(ChatColor.GREEN + "Nickname removed by " + p.getDisplayName());
                        }catch (NullPointerException n){
                            p.sendMessage(ChatColor.RED + "That player is not online.");
                        }
                    }
                }
            }
        }else if (sender instanceof ConsoleCommandSender console){
            if (args.length == 0 || args.length == 1){
                getLogger().info("/nick set (player) (nick)");
            }else if (args.length == 2){
                if (args[0].equalsIgnoreCase("set")){
                    try {
                        Player target = Bukkit.getPlayer(args[1]);
                        String nickname = args[2];
                        target.setDisplayName(nickname);
                        target.setPlayerListName(nickname);
                        getLogger().info("\"Successfully nicked \" + target.getName() + \" to \" + nickname");
                        target.sendMessage(ChatColor.GREEN + "Nickname has been set to " + "\"" + nickname + "\"" + " by " + ChatColor.AQUA + "@System");
                    }catch (NullPointerException n){
                        getLogger().info("That player is not online.");
                    }
                }
            }
        }

        return true;
    }
}
