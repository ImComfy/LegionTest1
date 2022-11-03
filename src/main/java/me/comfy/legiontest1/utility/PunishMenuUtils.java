package me.comfy.legiontest1.utility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class PunishMenuUtils {

    public static void openBanMenu(Player p){
        ArrayList<Player> list = new ArrayList<>(p.getServer().getOnlinePlayers());

        Inventory punishgui = Bukkit.createInventory(p, 45, ChatColor.BLUE + "Player List");

        for(int i = 0; i < list.size(); i++){

            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
            ItemMeta meta = playerHead.getItemMeta();

            meta.setDisplayName(list.get(i).getDisplayName());
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GOLD + "Player Health: " + ChatColor.RED + list.get(i).getHealth());
            playerHead.setItemMeta(meta);

            punishgui.addItem(playerHead);
        }
        p.openInventory(punishgui);
    }

    public static void openConfirmBanMenu(Player p, Player whoToBan){
        Inventory confirmBanMenu = Bukkit.createInventory(p, 9, ChatColor.RED + "Are you sure?");

        //Confirm option
        ItemStack ban = new ItemStack(Material.NETHERITE_AXE, 1);
        ItemMeta banMeta = ban.getItemMeta();
        banMeta.setDisplayName(ChatColor.GREEN + "Confirm");
        ban.setItemMeta(banMeta);
        confirmBanMenu.setItem(3, ban);

        //Player to ban
        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
        ItemMeta playerMeta = playerHead.getItemMeta();
        banMeta.setDisplayName(whoToBan.getDisplayName());
        playerHead.setItemMeta(playerMeta);
        confirmBanMenu.setItem(4, playerHead);

        //Cancel option
        ItemStack cancel = new ItemStack(Material.BARRIER, 1);
        ItemMeta cancelMeta = cancel.getItemMeta();
        cancelMeta.setDisplayName(ChatColor.RED + "Cancel");
        cancel.setItemMeta(cancelMeta);
        confirmBanMenu.setItem(5, cancel);

        p.openInventory(confirmBanMenu);
    }

}
