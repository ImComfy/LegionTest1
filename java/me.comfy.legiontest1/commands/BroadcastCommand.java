package me.comfy.legiontest1.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import static org.bukkit.Bukkit.getLogger;

public class BroadcastCommand implements CommandExecutor {

    /* /ebroadcast bob is really cool
       ["bob", "is", "really", "cool"]
       args[0] - "bob"
       args[1] - "is"
       etc*/
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p) {

            if (args.length == 0) {
                p.sendMessage("Usage: /ebroadcast <message>");
            } else if (args.length == 1) {
                String word = args[0];

                if(p.hasPermission("legiontest.broadcast")){
                    Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + ChatColor.BOLD + "!" + ChatColor.RESET + ChatColor.DARK_GRAY + "] " + ChatColor.AQUA + "BROADCAST: " + ChatColor.RESET + word);
                }else{
                    p.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                }

            } else {
                StringBuilder builder = new StringBuilder();

                for (int i = 0; i < args.length; i++) {
                    builder.append(args[i]);
                    builder.append(" ");
                }

                String finalMessage = builder.toString();
                finalMessage = finalMessage.stripTrailing();

                if(p.hasPermission("legiontest.broadcast")) {
                    Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + ChatColor.BOLD + "!" + ChatColor.RESET + ChatColor.DARK_GRAY + "] " + ChatColor.AQUA + "BROADCAST: " + ChatColor.RESET + finalMessage);
                }else{
                    p.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
                }
            }

        } else if (sender instanceof ConsoleCommandSender) {

            if (args.length == 0) {
                getLogger().info("Usage: /ebroadcast <message>");
            } else if(args.length == 1){
                String word = args[0];

                Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + ChatColor.BOLD + "!" + ChatColor.RESET + ChatColor.DARK_GRAY + "] " + ChatColor.AQUA + "Console: " + ChatColor.RESET + word);
            }else{
                StringBuilder builder = new StringBuilder();

                for (int i = 0; i < args.length; i++) {
                    builder.append(args[i]);
                    builder.append(" ");
                }

                String finalMessage = builder.toString();
                finalMessage = finalMessage.stripTrailing();

                Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + ChatColor.BOLD + "!" + ChatColor.RESET + ChatColor.DARK_GRAY + "] " + ChatColor.AQUA + "Console: " + ChatColor.RESET + finalMessage);

            }

            return true;
        }
        return true;
    }
}
