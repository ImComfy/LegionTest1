package me.comfy.legiontest1.commands;

import me.comfy.legiontest1.utility.PunishMenuUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PunishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){

            PunishMenuUtils.openBanMenu(p);

        }

        return true;
    }
}
