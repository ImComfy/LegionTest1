package me.comfy.legiontest1.commands;

import me.comfy.legiontest1.LegionTest1;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getLogger;

public class ReloadCommand implements CommandExecutor {

    LegionTest1 plugin;

    public ReloadCommand(LegionTest1 plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p){
            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                plugin.reloadConfig();
                p.sendMessage(ChatColor.GREEN + "Successfully reloaded LegionTest1.");
            }
        }else if (sender instanceof ConsoleCommandSender console){
            if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
                plugin.reloadConfig();
                getLogger().info("Successfully reloaded LegionTest1");
            }
        }

        return true;
    }

}
