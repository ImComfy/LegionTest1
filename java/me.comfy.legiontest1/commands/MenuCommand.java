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
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;

        Inventory inventory = Bukkit.createInventory(p, 9, ChatColor.RED + "Potato something");

        ItemStack item = new ItemStack(Material.BEEF, 16);
        inventory.addItem(item);

        ItemStack flower = new ItemStack(Material.POPPY, 32);
        ItemMeta flowerMeta = flower.getItemMeta();
        flowerMeta.setDisplayName(ChatColor.RED + "omg flower real");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "holy shit realest flower ever");
        lore.add(ChatColor.GRAY + "wowo");
        flowerMeta.setLore(lore);

        flowerMeta.addEnchant(Enchantment.LOYALTY, 10, true);

        flower.setItemMeta(flowerMeta);

        inventory.setItem(0, item);
        inventory.setItem(1, flower);

        p.openInventory(inventory);

        return true;
    }
}
