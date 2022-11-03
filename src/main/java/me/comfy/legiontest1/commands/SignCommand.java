package me.comfy.legiontest1.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SignCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){

            //sign 2 hello socks
            if(args.length != 2){
                p.sendMessage("Usage: /sign 2 text");
            }else if(args.length == 2){
                p.getWorld().getBlockAt(p.getLocation()).setType(Material.SPRUCE_SIGN);
                Sign sign = (Sign) p.getWorld().getBlockAt(p.getLocation()).getState();

                int line = Integer.parseInt(args[0]) - 1;
                String word = args[1];

                sign.setLine(line, word);
                sign.update();
            }

        }

        return true;
    }
}
