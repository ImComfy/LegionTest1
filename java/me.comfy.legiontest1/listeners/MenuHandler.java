package me.comfy.legiontest1.listeners;

import me.comfy.legiontest1.LegionTest1;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.HashMap;

public class MenuHandler implements Listener {

    LegionTest1 plugin;

    public MenuHandler(LegionTest1 plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        //Menu list
        final String MAIN_MENU = ChatColor.BLUE + "Armor Stand GUI";
        final String CREATE_MENU = ChatColor.GREEN + "Create an armorstand";
        final String CONFIRM_MENU = ChatColor.GREEN + "Are you sure?";

        if (e.getView().getTitle().equalsIgnoreCase(MAIN_MENU)) {
            switch (e.getCurrentItem().getType()) {
                case ARMOR_STAND:
                    p.closeInventory();
                    //Open the creator menu
                    plugin.openCreateMenu(p);
                    break;
                case BARRIER:
                    p.closeInventory();
                    break;
            }
            e.setCancelled(true);
        } else if (e.getView().getTitle().equalsIgnoreCase(CREATE_MENU)) {

            if (!plugin.armorstands.containsKey(p)) {
                ArmorStand stand = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                stand.setVisible(false);
                plugin.armorstands.put(p, stand);
            }

            switch (e.getCurrentItem().getType()) {
                case ARMOR_STAND:
                    plugin.openConfirmMenu(p, Material.ARMOR_STAND);
                    break;
                case GLOW_INK_SAC:
                    plugin.openConfirmMenu(p, Material.GLOW_INK_SAC);
                    break;
                case NETHERITE_HELMET:
                    //Armor select menu
                    break;
                case STONE_SLAB:
                    plugin.openConfirmMenu(p, Material.STONE_SLAB);
                    break;
                case GREEN_WOOL:
                    p.closeInventory();
                    if (plugin.armorstands.containsKey(p)) {
                        ArmorStand stand = plugin.armorstands.get(p);
                        stand.setVisible(true);
                        plugin.armorstands.remove(p);
                    }
                    break;
                case BARRIER:
                    if (plugin.armorstands.containsKey(p)) {
                        ArmorStand stand = plugin.armorstands.get(p);
                        stand.remove();
                        plugin.armorstands.remove(p);
                    }
                    p.closeInventory();
                    break;
            }

            e.setCancelled(true);
        } else if (e.getView().getTitle().equalsIgnoreCase(CONFIRM_MENU)) {
            if (e.getClickedInventory().contains(Material.ARMOR_STAND)) {
                switch (e.getCurrentItem().getType()) {
                    case GREEN_CONCRETE:
                        plugin.openCreateMenu(p);
                        if (plugin.armorstands.containsKey(p)) {
                            ArmorStand stand = plugin.armorstands.get(p);
                            stand.setArms(true);
                        }
                        break;
                    case RED_CONCRETE:
                        plugin.openCreateMenu(p);
                        if (plugin.armorstands.containsKey(p)) {
                            ArmorStand stand = plugin.armorstands.get(p);
                            stand.setArms(false);
                        }
                        break;
                }
            } else if (e.getClickedInventory().contains(Material.GLOW_INK_SAC)) {
                switch (e.getCurrentItem().getType()) {
                    case GREEN_CONCRETE:
                        plugin.openCreateMenu(p);
                        if (plugin.armorstands.containsKey(p)) {
                            ArmorStand stand = plugin.armorstands.get(p);
                            stand.setGlowing(true);
                        }
                        break;
                    case RED_CONCRETE:
                        plugin.openCreateMenu(p);
                        if (plugin.armorstands.containsKey(p)) {
                            ArmorStand stand = plugin.armorstands.get(p);
                            stand.setGlowing(false);
                        }
                        break;
                }

            } else if (e.getClickedInventory().contains(Material.STONE_SLAB)) {
                switch (e.getCurrentItem().getType()) {
                    case GREEN_CONCRETE:
                        plugin.openCreateMenu(p);
                        if (plugin.armorstands.containsKey(p)) {
                            ArmorStand stand = plugin.armorstands.get(p);
                            stand.setBasePlate(true);
                        }
                        break;
                    case RED_CONCRETE:
                        plugin.openCreateMenu(p);
                        if (plugin.armorstands.containsKey(p)) {
                            ArmorStand stand = plugin.armorstands.get(p);
                            stand.setBasePlate(false);
                        }
                        break;
                }

                e.setCancelled(true);
            }
        }
    }

}
