package me.comfy.legiontest1.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignEvent implements Listener {

    @EventHandler
    public void onSignEvent(SignChangeEvent e){
        e.getBlock().setType(Material.NETHERITE_BLOCK);

    }

}
