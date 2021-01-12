package com.example.MCPlugin;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.Objects;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("econ")).setExecutor(new EconCommand());
    }
}
