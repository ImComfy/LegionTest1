package me.comfy.legiontest1.listeners;

import me.comfy.legiontest1.LegionTest1;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherListener implements Listener {

    LegionTest1 plugin;

    public WeatherListener(LegionTest1 plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent e){
        if (plugin.getConfig().getBoolean("perfect-day")) {
            e.setCancelled(true);
        }
    }

}
