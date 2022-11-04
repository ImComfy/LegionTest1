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

        //Check inventory
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Player List")){
            //Make sure they clicked a player head
            if(e.getCurrentItem().getType() == Material.PLAYER_HEAD){

                Player whoToBan = LegionTest1.getPlugin().getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));

                PunishMenuUtils.openConfirmBanMenu(p, whoToBan);

            }

        }else if(e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Are you sure?")){

            switch(e.getCurrentItem().getType()){
                case BARRIER:
                    PunishMenuUtils.openBanMenu(p);
                    break;
                case NETHERITE_AXE:
                    //Get username
                    String name = e.getClickedInventory().getItem(4).getItemMeta().getDisplayName();
                    p.getServer().getBanList(BanList.Type.IP).addBan(ChatColor.stripColor(name), "L", null, "legion");
                    p.kickPlayer(ChatColor.RED + "L bozo");
            }

                for(Player player : Bukkit.getOnlinePlayers()){
                    if(player.hasPermission("legiontest.banalerts")){
                        String name = ChatColor.stripColor(e.getClickedInventory().getItem(4).getItemMeta().getDisplayName());
                        player.sendMessage(ChatColor.RED + name + "has been banned.");
                    }
                }


        }

        //stop players from moving items
        e.setCancelled(true);
    }

}
