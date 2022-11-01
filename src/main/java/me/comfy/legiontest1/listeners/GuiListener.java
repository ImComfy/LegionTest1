package me.comfy.legiontest1.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GuiListener implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "GUI among us")){

            switch(e.getCurrentItem().getType()){
                case TNT:
                    p.closeInventory();
                    p.setHealth(0.0);
                    p.sendMessage(ChatColor.RED + "You killed yourself!");
                    break;
                case BREAD:
                    p.closeInventory();
                    p.setSaturation(20);
                    p.sendMessage(ChatColor.YELLOW + "Maximized your saturation.");
                case IRON_SWORD:
                    p.closeInventory();
                    p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000, 1));
                    p.sendMessage(ChatColor.GOLD + "Received strength.");
            }

        }

        e.setCancelled(true);
    }

}
