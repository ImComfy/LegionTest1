package me.comfy.legiontest1.commands;

import me.comfy.legiontest1.utility.TeleportUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class RTPCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p){

            if(args.length == 0) {
                p.teleport(TeleportUtils.generateLocation(p));

                int x = p.getLocation().getBlockX();
                int y = p.getLocation().getBlockY();
                int z = p.getLocation().getBlockZ();

                p.sendMessage(ChatColor.GREEN + "Teleported to " + ChatColor.BOLD + x + " / " + y + " / " + z);
            }else if (args.length == 1){

                if (p.hasPermission("legiontest.rtpothers")){
                    Player target = Bukkit.getPlayer(args[0]);
                    target.teleport(TeleportUtils.generateLocation(target));

                    int x = target.getLocation().getBlockX();
                    int y = target.getLocation().getBlockY();
                    int z = target.getLocation().getBlockZ();

                    target.sendMessage(ChatColor.GREEN + "Teleported by " + p.getDisplayName() + " to " + ChatColor.BOLD + x + " / " + y + " / " + z);

                    p.sendMessage(ChatColor.GREEN + "Teleported " + target.getDisplayName() + " to " + ChatColor.BOLD + x + " / " + y + " / " + z);
                }

            }

        }

        return true;
    }
}
