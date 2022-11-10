package me.comfy.legiontest1.listeners;

import me.comfy.legiontest1.events.GameEndEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class GameListener implements Listener {

    @EventHandler
    public void onGameEnd(GameEndEvent e){
        Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "Game has ended!");
        Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Winner: " + e.getWinner().getName());
        Bukkit.getServer().broadcastMessage(ChatColor.RED + "Loser: " + e.getLoser().getName());
    }

}
