package me.comfy.legiontest1.listeners;

import me.comfy.legiontest1.LegionTest1;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {
    
    private final LegionTest1 plugin;

    public MoveEvent(LegionTest1 plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        
        if(plugin.getConfig().getBoolean("turle-spam")) {

            Player p = e.getPlayer();

            Entity entity = p.getWorld().spawnEntity(p.getLocation(), EntityType.TURTLE);
            entity.setGravity(false);
            entity.setCustomName("Wawoawos");
            entity.setCustomNameVisible(true);
            /* we could also do:
            Entity entity = Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), x:218, y:80, z:154), EntityType.SKELETON);
             */
        }

    }

}
