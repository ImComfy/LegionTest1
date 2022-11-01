package me.comfy.legiontest1.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class BannedPlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        player.getDisplayName();
        if(player.isBanned()) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (p.hasPermission("legiontest.banjoins")) {
                    p.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.RED + ChatColor.BOLD + "!" + ChatColor.RESET + ChatColor.DARK_GRAY + "] " + ChatColor.RED + player.getDisplayName() + " has tried joining the server.");
                }

            }
        }
    }

}
