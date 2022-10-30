package me.comfy.legiontest1.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

public class ArmorStandCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){

            if(args.length == 0) {
                ArmorStand armorstand = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                armorstand.getEquipment().setHelmet(new ItemStack(Material.WHITE_STAINED_GLASS));
                armorstand.setArms(true);
                armorstand.setBodyPose(new EulerAngle(0, Math.toRadians(16), 0));
                armorstand.setLeftLegPose(new EulerAngle(Math.toRadians(28), Math.toRadians(16), 0));
                armorstand.setLeftArmPose(new EulerAngle(Math.toRadians(16), Math.toRadians(16), 0));
                armorstand.setRightArmPose(new EulerAngle(Math.toRadians(255), Math.toRadians(16), 0));

            }else if(args.length == 1){
                String name = args[0];
                ArmorStand armorstand = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                armorstand.getEquipment().setHelmet(new ItemStack(Material.WHITE_STAINED_GLASS));
                armorstand.setCustomName(name);
                armorstand.setArms(true);

            }else{
                StringBuilder builder = new StringBuilder();

                for (int i = 0; i < args.length; i++) {
                    builder.append(args[i]);
                    builder.append(" ");
                }

                String bName = builder.toString();
                bName = bName.stripTrailing();
                ArmorStand armorstand = (ArmorStand) p.getWorld().spawnEntity(p.getLocation(), EntityType.ARMOR_STAND);
                armorstand.getEquipment().setHelmet(new ItemStack(Material.WHITE_STAINED_GLASS));
                armorstand.setCustomName(bName);
                armorstand.setArms(true);
            }

        }

        return true;
    }
}
