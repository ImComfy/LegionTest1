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
        //Get a list of players on the server
        ArrayList<Player> list = new ArrayList<Player>(p.getServer().getOnlinePlayers());

        //Create and open the punish gui
        Inventory punishgui = Bukkit.createInventory(p, 45, ChatColor.BLUE + "Player List");
        //For every player, add their name to the gui
        for(int i = 0; i < list.size(); i++){

            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
            ItemMeta meta = playerHead.getItemMeta();
            //Set info for the item
            meta.setDisplayName(list.get(i).getDisplayName());
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.GOLD + "Player Health: " + ChatColor.RED + list.get(i).getHealth());
            meta.setLore(lore);
            playerHead.setItemMeta(meta);
            //Add the head to the gui
            punishgui.addItem(playerHead);
        }
        p.openInventory(punishgui);
    }

    public static void openConfirmBanMenu(Player player, Player whoToBan){
        Inventory confirmBanMenu = Bukkit.createInventory(player, 9, ChatColor.RED + "Are you sure?");

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

        player.openInventory(confirmBanMenu);
    }

}
