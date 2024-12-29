package com.hackthedoc.template;

import org.bukkit.plugin.java.JavaPlugin;

import com.hackthedoc.template.utils.MessageUtils;

public class Plugin extends JavaPlugin {

  public void onEnable() {
    MessageUtils.log("template enabled");
  }

  public void onDisable() {
    MessageUtils.log("template disabled");
  }
}
