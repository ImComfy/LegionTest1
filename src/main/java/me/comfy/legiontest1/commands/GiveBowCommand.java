package me.comfy.legiontest1.commands;

import me.comfy.legiontest1.LegionTest1;
import me.comfy.legiontest1.utility.BowUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveBowCommand implements CommandExecutor {

    private final LegionTest1 plugin;
    private final BowUtils bowUtils;

    public GiveBowCommand(LegionTest1 plugin) {
        this.plugin = plugin;
        this.bowUtils = new BowUtils(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){

            if(p.hasPermission("legiontest.tpbow")){

                if(args.length == 0){

                    ItemStack bow = bowUtils.createTeleportBow();
                    p.getInventory().addItem(bow);
                    p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
                    p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + ">:)");

                }else{
                    Player target = Bukkit.getPlayerExact(args[0]);

                    if(target == null){
                        p.sendMessage(ChatColor.RED + "That player is not online.");

                        return true;
                    }

                    ItemStack bow = bowUtils.createTeleportBow();
                    target.getInventory().addItem(bow);
                    target.getInventory().addItem(new ItemStack(Material.ARROW, 1));
                    target.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + ">:)");

                }

            }else{
                p.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            }

        }

        return true;
    }
}
