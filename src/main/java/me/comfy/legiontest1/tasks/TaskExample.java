package me.comfy.legiontest1.tasks;

import me.comfy.legiontest1.LegionTest1;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getLogger;

public class TaskExample extends BukkitRunnable {

    LegionTest1 plugin;

    public TaskExample(LegionTest1 plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        getLogger().info(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("scheduled-message")));
    }
}
