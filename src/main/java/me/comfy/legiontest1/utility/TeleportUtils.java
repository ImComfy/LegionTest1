package me.comfy.legiontest1.utility;

import me.comfy.legiontest1.LegionTest1;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.util.HashSet;
import java.util.Random;

public class TeleportUtils {

    static LegionTest1 plugin;

    public TeleportUtils(LegionTest1 plugin) {
        this.plugin = plugin;
    }

    public static HashSet<Material> bad_blocks = new HashSet<>();

    static{
        bad_blocks.add(Material.LAVA);
        bad_blocks.add(Material.FIRE);
        bad_blocks.add(Material.WATER);
    }

    public static Location generateLocation(Player p){
        Random random = new Random();

        int x = 0;
        int y = 0;
        int z = 0;

        if (plugin.getConfig().getBoolean("world-border")){
             x = random.nextInt(plugin.getConfig().getInt("border"));
             y = 150;
             z = random.nextInt(plugin.getConfig().getInt("border"));
        }else if (!plugin.getConfig().getBoolean("world-border")){
            x = random.nextInt(25000);
            y = 150;
            z = random.nextInt(25000);
        }

        Location randomLocation = new Location(p.getWorld(), x, y, z);

        y = randomLocation.getWorld().getHighestBlockYAt(randomLocation);
        randomLocation.setY(y);

        while(!isLocationSafe(randomLocation)){
            randomLocation = generateLocation(p);
        }
        return randomLocation;

    }

    public static boolean isLocationSafe(Location location){

        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();

        Block block = location.getWorld().getBlockAt(x, y, z);
        Block below = location.getWorld().getBlockAt(x, y - 1, z);
        Block above = location.getWorld().getBlockAt(x, y + 1, y);

        return !(bad_blocks.contains(below.getType()) || (block.getType().isSolid() || above.getType().isSolid()));

    }

}
