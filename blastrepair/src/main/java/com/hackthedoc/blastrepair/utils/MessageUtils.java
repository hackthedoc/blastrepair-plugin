package com.hackthedoc.blastrepair.utils;

import java.util.logging.Logger;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class MessageUtils {
    private static final Logger LOGGER=Logger.getLogger("BlastRepair");

    public static void log(String msg) {
        LOGGER.info(msg);
    }
    
    public static void sendError(Player player, String msg) {
        player.sendMessage(ChatColor.RED+msg);
    }
    
    public static void sendError(CommandSender sender, String msg) {
        sender.sendMessage(ChatColor.RED+msg);
    }

    public static void sendSuccess(Player player, String msg) {
        player.sendMessage(ChatColor.GREEN+msg);
    }

    public static void sendSuccess(CommandSender sender, String msg) {
        sender.sendMessage(ChatColor.GREEN+msg);
    }

    public static void sendLog(Player player, String msg) {
        player.sendMessage(ChatColor.YELLOW+msg);
    }

    public static void sendLog(CommandSender sender, String msg) {
        sender.sendMessage(ChatColor.YELLOW+msg);
    }
}
