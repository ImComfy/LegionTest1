package me.comfy.legiontest1.listeners;

import me.comfy.legiontest1.LegionTest1;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListeners implements Listener {

    private final LegionTest1 plugin;

    public SpawnListeners(LegionTest1 plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player player = e.getPlayer();

        if(!player.getPlayer().hasPlayedBefore()) {

            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null) {
                player.teleport(location);

            }
        }

        }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){

        //when a player dies, respawn them at the /spawn location if set
        Location location = plugin.getConfig().getLocation("spawn");
        if(location != null) {

            e.setRespawnLocation(location);

        }
    }

}