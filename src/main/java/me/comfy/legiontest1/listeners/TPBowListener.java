package me.comfy.legiontest1.listeners;

import me.comfy.legiontest1.LegionTest1;
import me.comfy.legiontest1.utility.BowUtils;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class TPBowListener implements Listener {

    private final LegionTest1 plugin;
    private final BowUtils bowUtils;

    public TPBowListener(LegionTest1 plugin) {
        this.plugin = plugin;
        this.bowUtils = new BowUtils(plugin);
    }

    @EventHandler
    public void onArrowLand(ProjectileHitEvent e) {


        //check to see if it was shot by a tp bow
        if (e.getEntity().getShooter() instanceof Player p) {

            ItemStack itemInMainHand = p.getInventory().getItemInMainHand();

            if (itemInMainHand.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("bow-name")))) {

                Location location = e.getEntity().getLocation();

                p.teleport(location);
                e.getEntity().remove();
                p.playSound(p, Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
            }

        }

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        if(plugin.getConfig().getBoolean("give-bow-on-join")){

            Player p = e.getPlayer();
            p.getInventory().addItem(bowUtils.createTeleportBow());
            p.getInventory().addItem(new ItemStack(Material.ARROW, 1));

        }

    }

}
