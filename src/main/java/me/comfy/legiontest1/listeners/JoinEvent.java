package me.comfy.legiontest1.listeners;

import me.comfy.legiontest1.LegionTest1;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    LegionTest1 plugin;

    public JoinEvent(LegionTest1 plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        for (int i = 0; i < plugin.vanishedlist.size(); i++){
            p.hidePlayer(plugin, plugin.vanishedlist.get(i));
        }
    }

}
