package me.comfy.legiontest1.listeners;

import me.comfy.legiontest1.LegionTest1;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;
import static org.bukkit.Bukkit.getLogger;

public class DeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent pde){

        new BukkitRunnable(){
            @Override
            public void run() {
                getLogger().info("I want waffle fries.");
            }
        }.runTaskLater(LegionTest1.getPlugin(), 20L);

    }

}
