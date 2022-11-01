package me.comfy.legiontest1.commands;

import me.comfy.legiontest1.LegionTest1;
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

public class ASGUICommand implements CommandExecutor {

    LegionTest1 plugin;

    public ASGUICommand(LegionTest1 plugin){
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){
        plugin.openMainMenu(p);
        }
        return true;
    }
}
