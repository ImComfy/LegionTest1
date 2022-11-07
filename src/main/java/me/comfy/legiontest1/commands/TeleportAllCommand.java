package me.comfy.legiontest1.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportAllCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p) {

            if (p.hasPermission("legiontest.tpall")) {
                if (Bukkit.getServer().getOnlinePlayers().size() >= 1) {
                    int numOfPlayers = 0;
                    if (args.length == 0) {
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            players.teleport(p.getLocation());
                            numOfPlayers++;
                        }
                        p.sendMessage("Teleported " + numOfPlayers + " players to you.");
                    } else if (args.length == 1) {
                        Player target = Bukkit.getPlayer(args[0]);
                        try {
                            for (Player players : Bukkit.getOnlinePlayers()) {
                                players.teleport(target.getLocation());
                                numOfPlayers++;
                            }
                            p.sendMessage("Teleported " + numOfPlayers + " to " + target);
                        } catch (NullPointerException e) {
                            p.sendMessage(ChatColor.RED + "That player is not online.");
                        }
                    }

                }
            }
        }
        return true;
    }
}
