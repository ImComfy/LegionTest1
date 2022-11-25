package me.comfy.legiontest1.listeners;

import me.comfy.legiontest1.LegionTest1;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.*;

public class PlayerJoinListener implements Listener {

    LegionTest1 plugin;

    public PlayerJoinListener(LegionTest1 plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if (plugin.getConfig().getBoolean("motd")){
            for (int i = 0; i < plugin.getConfig().getList("motd-messages").size(); i++){
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getList("motd-messages").get(i).toString()));
            }
        }

        p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 20, 20);

        e.setJoinMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "!" + ChatColor.DARK_GRAY + "] " + ChatColor.AQUA + p.getDisplayName() + ChatColor.GOLD + " has joined the game.");

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("test", "dummy", ChatColor.RED + "Placeholder");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        if (p.isOp()){
            Score rank = objective.getScore(ChatColor.RED + "Rank: " + ChatColor.translateAlternateColorCodes('&', "&##579bffAdmin"));
            rank.setScore(11);
        }else {
            Score rank = objective.getScore(ChatColor.RED + "Rank: " + ChatColor.GRAY + "non haha L");
            rank.setScore(11);
        }

        Score score = objective.getScore(ChatColor.GOLD + "Money: $" + ChatColor.GREEN + 1);
        score.setScore(10);

        Score website = objective.getScore(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + ChatColor.UNDERLINE + "https://inyourwalls.net");

        p.setScoreboard(scoreboard);
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.setQuitMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "!" + ChatColor.DARK_GRAY + "] " + ChatColor.AQUA + p.getDisplayName() + ChatColor.GOLD + " has left the game.");
    }

}
