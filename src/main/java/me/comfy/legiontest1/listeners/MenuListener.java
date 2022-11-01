package me.comfy.legiontest1.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

import static org.bukkit.Bukkit.getLogger;

public class MenuListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Potato something")){

            if(e.getCurrentItem() == null){
                return;
            }

            if(e.getCurrentItem().getType() == Material.POPPY){
                e.getWhoClicked().sendMessage(ChatColor.DARK_RED + "Why'd you click that flower?");
            }else if(e.getCurrentItem().getType() == Material.BEEF){
                e.getWhoClicked().sendMessage(ChatColor.RED + "Why'd you touch that meat?");
            }

            //stops players from moving items
            e.setCancelled(true);

        }else if(e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Server rules")){

            if(e.getCurrentItem() == null){
                return;
            }

            //stops players from moving items
            e.setCancelled(true);

        }



    }

}
