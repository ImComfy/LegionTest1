package me.comfy.legiontest1.tasks;

import me.comfy.legiontest1.LegionTest1;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getLogger;

public class KeepDayTask extends BukkitRunnable {

    LegionTest1 plugin;

    public KeepDayTask(LegionTest1 plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        String world = plugin.getConfig().getString("world-name");
        if (Bukkit.getServer().getWorld(world) != null){
            Bukkit.getServer().getWorld(world).setTime(0L);
        }else{
            getLogger().warning("[LegionTest1] Specified world name in config.yml doesn't exist!");
            getLogger().warning("[LegionTest1] Please check line 27 of config.yml \"world-name\" and make sure it's the same as the world file's name");
        }
    }
}
