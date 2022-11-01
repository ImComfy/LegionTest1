package me.comfy.legiontest1.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GuiCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){

            Inventory gui = Bukkit.createInventory(p, 9, ChatColor.RED + "GUI among us");

            ItemStack suicide = new ItemStack(Material.TNT);
            ItemStack feed = new ItemStack(Material.BREAD);
            ItemStack sword = new ItemStack(Material.IRON_SWORD);

            ItemMeta suicideMeta = suicide.getItemMeta();
            suicideMeta.setDisplayName(ChatColor.RED + "Suicide");
            ArrayList<String> suicidelore = new ArrayList<>();
            suicidelore.add(ChatColor.GRAY + "Clicking will kill you.");
            suicideMeta.setLore(suicidelore);
            suicideMeta.addEnchant(Enchantment.BINDING_CURSE, 1, false);
            suicide.setItemMeta(suicideMeta);

            ItemMeta feedMeta = feed.getItemMeta();
            feedMeta.setDisplayName(ChatColor.YELLOW + "Saturation");
            ArrayList<String> feedlore = new ArrayList<>();
            feedlore.add(ChatColor.GRAY + "Maximizes your saturation.");
            feedMeta.setLore(feedlore);
            feedMeta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
            feed.setItemMeta(feedMeta);

            ItemMeta swordMeta = sword.getItemMeta();
            swordMeta.setDisplayName(ChatColor.GOLD + "idk what to call this");
            ArrayList<String> swordlore = new ArrayList<>();
            swordlore.add(ChatColor.GRAY + "i rly dont know what to put here");
            swordMeta.setLore(swordlore);
            swordMeta.addEnchant(Enchantment.FIRE_ASPECT, 10, true);
            sword.setItemMeta(swordMeta);






            ItemStack[] menu_items = {suicide, feed, sword};
            gui.setContents(menu_items);
            p.openInventory(gui);

        }

        return true;
    }
}
