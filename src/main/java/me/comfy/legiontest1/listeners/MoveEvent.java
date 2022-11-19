package me.comfy.legiontest1.listeners;

import me.comfy.legiontest1.LegionTest1;
import org.bukkit.Location;
import org.bukkit.Material;
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
        Player p = e.getPlayer();

        if(plugin.getConfig().getBoolean("turle-spam")) {

            Entity entity = p.getWorld().spawnEntity(p.getLocation(), EntityType.TURTLE);
            entity.setGravity(false);
            entity.setCustomName("Wawoawos");
            entity.setCustomNameVisible(true);
            /* we could also do:
            Entity entity = Bukkit.getWorld("world").spawnEntity(new Location(Bukkit.getWorld("world"), x:218, y:80, z:154), EntityType.SKELETON);
             */
        }

        if (plugin.getConfig().getBoolean("block-boost")){
            Location blockUnder = p.getLocation();
            blockUnder.setY(blockUnder.getY() - 1);

            if (p.getLocation().getBlock().getType().equals(Material.valueOf(plugin.getConfig().getString("top-block"))) && blockUnder.getBlock().getType().equals(Material.valueOf(plugin.getConfig().getString("bottom-block")))){
                p.setVelocity(p.getLocation().getDirection().multiply(plugin.getConfig().getInt("velocity-multiplier")).setY(plugin.getConfig().getInt("y-velocity")));
                plugin.jumpingPlayers.add(p);
            }
        }

    }

}
