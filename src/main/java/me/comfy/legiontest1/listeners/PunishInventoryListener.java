package me.comfy.legiontest1.listeners;

import me.comfy.legiontest1.LegionTest1;
import me.comfy.legiontest1.utility.PunishMenuUtils;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PunishInventoryListener implements Listener {

    LegionTest1 plugin;

    public PunishInventoryListener(LegionTest1 plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Player List")){

            if(e.getCurrentItem().getType() == Material.PLAYER_HEAD){

                Player whoToBan = p.getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));

                PunishMenuUtils.openConfirmBanMenu(p, whoToBan);

            }

            e.setCancelled(true);
        }else if(e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Are you sure?")){

            if(e.getCurrentItem().getType() == Material.BARRIER){
                PunishMenuUtils.openBanMenu(p);
            }else if(e.getCurrentItem().getType() == Material.NETHERITE_AXE){
                String name = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                p.getServer().getBanList(BanList.Type.NAME).addBan(name, "L", null, null);
                for(Player player : Bukkit.getOnlinePlayers()){
                    if(player.hasPermission("legiontest.banalerts")){
                        player.sendMessage(ChatColor.RED + name + "has been banned.");
                    }
                }
            }

        }

    }

}
