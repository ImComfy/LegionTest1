package me.comfy.legiontest1.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static org.bukkit.Bukkit.getLogger;

public class FlyCommand implements CommandExecutor {

    private ArrayList<Player> list_of_flying_players = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){
            if(args.length == 0){
                flyMethod(p);
            }else if(args.length == 1){
                Player target = Bukkit.getPlayer(args[0]);
                if(target == null){
                    p.sendMessage(ChatColor.RED + "That player is not online!");
                }else{
                    flyMethod(target);
                    if (list_of_flying_players.contains(target)) {
                        p.sendMessage(ChatColor.GREEN + "Enabled flight for " + target.getDisplayName());
                    } else if (!list_of_flying_players.contains(target)) {
                        p.sendMessage(ChatColor.RED + "Disabled flight for " + target.getDisplayName());
                    }
                }
            }
        }else if(sender instanceof ConsoleCommandSender){
            getLogger().info("FYI, servers can't fly.");
        }return true;
        }

    private void flyMethod(Player p){
        if(p.hasPermission("legiontest.fly")){
            if(list_of_flying_players.contains(p)){
                list_of_flying_players.remove(p);
                p.setAllowFlight(false);
                p.sendMessage(ChatColor.RED + "Flight disabled.");
            }else if(!list_of_flying_players.contains(p)){
                list_of_flying_players.add(p);
                p.setAllowFlight(true);
                p.sendMessage(ChatColor.GREEN + "Flight enabled.");
            }
        }
    }
}
