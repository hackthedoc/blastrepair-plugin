package com.hackthedoc.blastrepair.managers;

import org.bukkit.configuration.file.FileConfiguration;

import com.hackthedoc.blastrepair.Plugin;

public class ConfigManager {
    private FileConfiguration config;

    public void loadConfig() {
        Plugin.getInstance().saveDefaultConfig();
        config = Plugin.getInstance().getConfig();
    }

    public void reloadConfig() {
        Plugin.getInstance().reloadConfig();
        config = Plugin.getInstance().getConfig();
    }

    public double getRepairDelay() {
        return config.getDouble("delay", 2);
    }

    public double getRepairSpeed() {
        return config.getDouble("repair-speed", 0.5);
    }

    public boolean isRepairEnabledFor(String explosionType) {
        return config.getBoolean("explosion-types."+explosionType, false);
    }
}
