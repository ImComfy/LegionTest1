package me.comfy.legiontest1.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import static org.bukkit.Bukkit.getLogger;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){

            //for some reason this doesn't work vv
            if(p.isFlying()){
                p.setFlying(false);
                p.sendMessage(ChatColor.RED + "Flying disabled.");
            }else{
                p.setFlying(true);
                p.sendMessage(ChatColor.GREEN + "Flying enabled.");
            }

        }else if(sender instanceof ConsoleCommandSender){
            getLogger().info("Servers can't fly");
        }

        return true;
    }
}
