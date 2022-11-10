package me.comfy.legiontest1.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

public class GameEndEvent extends Event {

    private Player winner;
    private Player loser;
    private int final_score;

    public GameEndEvent(Player winner, Player loser, int final_score){
        this.winner = winner;
        this.loser = loser;
        this.final_score = final_score;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getLoser() {
        return loser;
    }

    public int getFinal_score() {
        return final_score;
    }

    private static final HandlerList handlers = new HandlerList();

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
