package me.comfy.legiontest1.listeners;

import me.comfy.legiontest1.LegionTest1;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class FallDamageListener implements Listener {

    LegionTest1 plugin;

    public FallDamageListener(LegionTest1 plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onFallDamage(EntityDamageEvent e){
        if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL) && plugin.getConfig().getBoolean("disable-fall-damage")){
            if (plugin.jumpingPlayers.contains(e.getEntity())){
                e.setCancelled(true);
                plugin.jumpingPlayers.remove(e.getEntity());
            }
        }
    }

}
