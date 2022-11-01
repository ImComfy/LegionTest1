package me.comfy.legiontest1;

import me.comfy.legiontest1.commands.*;
import me.comfy.legiontest1.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public final class LegionTest1 extends JavaPlugin {

    public HashMap<Player, ArmorStand> armorstands = new HashMap<>();

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
        getServer().getPluginManager().registerEvents(new MoveEvent(plugin), this);
        getServer().getPluginManager().registerEvents(new GuiListener(), this);
        getServer().getPluginManager().registerEvents(new MenuHandler(this), this);

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
        getCommand("armorstand").setExecutor(new ArmorStandCommand());
        getCommand("gui").setExecutor(new GuiCommand());
        getCommand("asgui").setExecutor(new ASGUICommand(this));

        //config.yml
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getLogger().info("Plugin enabled.");
    }

    public void openMainMenu(Player p) {

        Inventory main_menu = Bukkit.createInventory(p, 9, ChatColor.BLUE + "Armor Stand GUI");

        //Options for main menu
        ItemStack create = new ItemStack(Material.ARMOR_STAND);
        ItemMeta createMeta = create.getItemMeta();
        createMeta.setDisplayName(ChatColor.GREEN + "Create");
        ArrayList<String> createlore = new ArrayList<>();
        createlore.add(ChatColor.DARK_PURPLE + "Create a new armor stand");
        createMeta.setLore(createlore);
        create.setItemMeta(createMeta);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close Menu");
        close.setItemMeta(closeMeta);

        main_menu.setItem(0, create);
        main_menu.setItem(8, close);
        p.openInventory(main_menu);
    }

    public void openCreateMenu(Player p){
        Inventory create_menu = Bukkit.createInventory(p, 9, ChatColor.GREEN + "Create an armorstand");

        ItemStack arms = new ItemStack(Material.ARMOR_STAND);
        ItemStack glow = new ItemStack(Material.GLOW_INK_SAC);
        ItemStack armor = new ItemStack(Material.NETHERITE_HELMET);
        ItemStack base = new ItemStack(Material.STONE_SLAB);
        ItemStack complete = new ItemStack(Material.GREEN_WOOL);
        ItemStack cancel = new ItemStack(Material.BARRIER);

        ItemMeta armsMeta = arms.getItemMeta();
        armsMeta.setDisplayName(ChatColor.YELLOW + "Arms");
        ItemMeta glowMeta = glow.getItemMeta();
        glowMeta.setDisplayName("Glow");
        ItemMeta armorMeta = armor.getItemMeta();
        arms.setItemMeta(armsMeta);
        glow.setItemMeta(glowMeta);
        armor.setItemMeta(armorMeta);

        create_menu.setItem(0, arms);
        create_menu.setItem(1, glow);
        create_menu.setItem(2, armor);
        create_menu.setItem(3, base);
        create_menu.setItem(7, complete);
        create_menu.setItem(8, cancel);

        p.openInventory(create_menu);
    }

    public void openConfirmMenu(Player p, Material option){
        Inventory confirmMenu = Bukkit.createInventory(p, 36, ChatColor.GREEN + "Are you sure?");

        ItemStack option_item = new ItemStack(option);
        ItemMeta option_meta = option_item.getItemMeta();

        if(option == Material.ARMOR_STAND){
            option_meta.setDisplayName(ChatColor.YELLOW + "Give arms?");
            option_item.setItemMeta(option_meta);
        }else if(option == Material.GLOW_INK_SAC){
            option_meta.setDisplayName(ChatColor.YELLOW + "Add glow?");
            option_item.setItemMeta(option_meta);
        } else if (option == Material.STONE_SLAB) {
            option_meta.setDisplayName(ChatColor.YELLOW + "Add base?");
            option_item.setItemMeta(option_meta);
        }
        ItemStack yes = new ItemStack(Material.GREEN_CONCRETE);
        ItemStack no = new ItemStack(Material.RED_CONCRETE);
        ItemMeta yesMeta = yes.getItemMeta();
        yesMeta.setDisplayName(ChatColor.GREEN + "Confirm");
        ItemMeta noMeta = no.getItemMeta();
        noMeta.setDisplayName(ChatColor.RED + "Cancel");
        yes.setItemMeta(yesMeta);
        no.setItemMeta(noMeta);

        confirmMenu.setItem(13, option_item);
        confirmMenu.setItem(21, yes);
        confirmMenu.setItem(23, no);

        p.openInventory(confirmMenu);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("maxHealth")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                String Maxhealth = getConfig().getString("Max health");
                p.sendMessage(ChatColor.DARK_PURPLE + "The maximum amount of HEALTH you can get is " + ChatColor.RED + Maxhealth);
            } else if (sender instanceof ConsoleCommandSender) {
                String Maxhealth = getConfig().getString("Max health");
                getLogger().info("The maximum amount of HEALTH you can get is " + Maxhealth);

            }
        } else if (command.getName().equals("setHealth")) {
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