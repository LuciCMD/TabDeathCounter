package org.lucicmd.tabdeathcounter;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class Events implements Listener {
    private TabDeathCounter plugin;

    public Events(TabDeathCounter plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, this.plugin);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        this.showDeath(p, p.getDisplayName(), "" + (p.getStatistic(Statistic.DEATHS) + 1));
    }

    @EventHandler
    public void onPlayerConnection(PlayerLoginEvent e) {
        Player p = e.getPlayer();
        this.showDeath(p, p.getDisplayName(), "" + p.getStatistic(Statistic.DEATHS));
    }

    private void showDeath(Player p, String name, String nbDeath) {
        p.setPlayerListName(ChatColor.translateAlternateColorCodes('&', name + "    " + "&5" + "Deaths: " + nbDeath));
    }
}
