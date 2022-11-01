package me.comfy.legiontest1.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class RulesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player)sender;

        Inventory inventory = Bukkit.createInventory(p, 9, ChatColor.RED + "Server rules");
        ItemStack rule = new ItemStack(Material.PAPER, 1);
        ItemMeta ruleMeta = rule.getItemMeta();
        ruleMeta.setDisplayName(ChatColor.RED + "No hacking");
        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Hacking is not tolerated");
        lore.add(ChatColor.GRAY + "on the server.");
        ruleMeta.setLore(lore);

        inventory.setItem(4, rule);

        p.openInventory(inventory);

        return true;
    }
}
