package me.comfy.legiontest1;

import me.comfy.legiontest1.commands.*;
import me.comfy.legiontest1.listeners.*;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class LegionTest1 extends JavaPlugin {

    private static LegionTest1 plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic

        plugin = this;

        getServer().getPluginManager().registerEvents(new LegionTest1Listener(), this);
        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(), this);
        getServer().getPluginManager().registerEvents(new BannedPlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new SpawnListeners(this), this);
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
        getServer().getPluginManager().registerEvents(new TPBowListener(this), this);

        getCommand("holyshitlegionsmp").setExecutor(new LegionTest1Listener());
        getCommand("etime").setExecutor(new TimeCommand());
        getCommand("god").setExecutor(new GodCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("saturation").setExecutor(new SaturationCommand());
        getCommand("ebroadcast").setExecutor(new BroadcastCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("menu").setExecutor(new MenuCommand());
        getCommand("rules").setExecutor(new RulesCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("tpbow").setExecutor(new GiveBowCommand(plugin));

        //config.yml
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getLogger().info("Plugin enabled.");


    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(command.getName().equals("maxHealth")){
            if(sender instanceof Player){
                Player p = (Player) sender;
                String Maxhealth = getConfig().getString("Max health");
                p.sendMessage(ChatColor.DARK_PURPLE + "The maximum amount of HEALTH you can get is " + ChatColor.RED + Maxhealth);
            }else if(sender instanceof ConsoleCommandSender){
                String Maxhealth = getConfig().getString("Max health");
                getLogger().info("The maximum amount of HEALTH you can get is " + Maxhealth);

            }
        }else if(command.getName().equals("setHealth")){
            getConfig().set("Max health", "20");
        }
        return true;
    }



    @Override
    public void onDisable() {
        // Plugin shutdown logic

        getLogger().info("[LegionCore] Plugin shutting down.");

    }

    public static LegionTest1 getPlugin() {
        return plugin;
    }
}
