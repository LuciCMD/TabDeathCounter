package org.lucicmd.tabdeathcounter;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class TabDeathCounter extends JavaPlugin implements Listener {
    public TabDeathCounter() {
    }

    public void onEnable() {
        new Events(this);
    }

    public void name() {
    }
}
