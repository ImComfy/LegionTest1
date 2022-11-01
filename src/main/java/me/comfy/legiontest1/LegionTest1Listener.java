package me.comfy.legiontest1;

import static org.bukkit.Bukkit.getLogger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class LegionTest1Listener implements Listener, CommandExecutor {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();
        e.setJoinMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "!" + ChatColor.DARK_GRAY + "] " + ChatColor.AQUA + player.getDisplayName() + ChatColor.GOLD + " has joined the game.");
    }


    @EventHandler
    public void onLeave(PlayerQuitEvent e){

        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "!" + ChatColor.DARK_GRAY + "] " + ChatColor.AQUA + player.getDisplayName() + ChatColor.GOLD + " has left the game.");
    }



    public boolean onCommand(CommandSender sender, Command holyshitlegionsmp, String label, String[] args) {
        if(sender instanceof ConsoleCommandSender) {
            ConsoleCommandSender c = (ConsoleCommandSender) sender;
            getLogger().info("omg command works welcome to legion console");
        }else if(sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage("&comg command works welcome to legion world");
        }
        return true;
    }




}


