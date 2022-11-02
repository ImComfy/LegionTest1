package me.comfy.legiontest1.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class HologramCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){
            ArmorStand hologram = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
            hologram.setVisible(false);
            hologram.setGravity(false);
            hologram.setCustomNameVisible(true);
            hologram.setCustomName(ChatColor.RED + "Hologram");
            //second line
            ArmorStand hologram2 = (ArmorStand) p.getWorld().spawnEntity(p.getLocation().add(0,-0.25,0), EntityType.ARMOR_STAND);
            hologram2.setVisible(false);
            hologram2.setGravity(false);
            hologram2.setCustomNameVisible(true);
            hologram2.setCustomName(ChatColor.AQUA + "Line 2");
        }

        return true;
    }
}
