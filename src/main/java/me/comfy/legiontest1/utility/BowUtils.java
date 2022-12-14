package me.comfy.legiontest1.utility;


import me.comfy.legiontest1.LegionTest1;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

//create and provide teleport bows
public class BowUtils {

    private final LegionTest1 plugin;

    public BowUtils(LegionTest1 plugin) {
        this.plugin = plugin;
    }

    public ItemStack createTeleportBow(){

        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("bow-name")));
        List<String> lore = new ArrayList<>();
        lore.add(plugin.getConfig().getString(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("bow-description"))));
        bowMeta.setLore(lore);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, false);
        bow.setItemMeta(bowMeta);

        return bow;
    }

}
