package com.hackthedoc.blastrepair;

import org.bukkit.plugin.java.JavaPlugin;

import com.hackthedoc.blastrepair.utils.MessageUtils;

public class Plugin extends JavaPlugin {

  public void onEnable() {
    MessageUtils.log("template enabled");
  }

  public void onDisable() {
    MessageUtils.log("template disabled");
  }
}
