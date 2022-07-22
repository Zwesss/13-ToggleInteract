package dev.tim.interacttutorial;

import dev.tim.interacttutorial.listeners.JoinListener;
import dev.tim.interacttutorial.listeners.ToggleFlyListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new ToggleFlyListener(), this);

    }
}
