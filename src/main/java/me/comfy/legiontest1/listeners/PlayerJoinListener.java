package me.comfy.legiontest1.listeners;

import me.comfy.legiontest1.LegionTest1;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinListener implements Listener {

    LegionTest1 plugin;

    public PlayerJoinListener(LegionTest1 plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if (plugin.getConfig().getBoolean("motd")){
            for (int i = 0; i < plugin.getConfig().getList("motd-messages").size(); i++){
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getList("motd-messages").get(i).toString()));
            }
        }

        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);

        e.setJoinMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "!" + ChatColor.DARK_GRAY + "] " + ChatColor.AQUA + p.getDisplayName() + ChatColor.GOLD + " has joined the game.");
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.setQuitMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "!" + ChatColor.DARK_GRAY + "] " + ChatColor.AQUA + p.getDisplayName() + ChatColor.GOLD + " has left the game.");
    }

}
