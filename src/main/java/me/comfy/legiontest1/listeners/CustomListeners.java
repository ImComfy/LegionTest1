package me.comfy.legiontest1.listeners;

import me.comfy.legiontest1.events.SpawnerBreakEvent;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Creature;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

public class CustomListeners implements Listener {

    @EventHandler
    public void onSpawnerBreak(SpawnerBreakEvent e){

        CreatureSpawner cs = (CreatureSpawner) e.getSpawner().getState();
        ItemStack spawnerToGive = new ItemStack(Material.SPAWNER);
        BlockStateMeta meta = (BlockStateMeta) spawnerToGive.getItemMeta();
        CreatureSpawner css = (CreatureSpawner) meta.getBlockState();

        css.setSpawnedType(cs.getSpawnedType());
        meta.setBlockState(css);
        spawnerToGive.setItemMeta(meta);

        e.getBreaker().getInventory().addItem(spawnerToGive);

    }

}
