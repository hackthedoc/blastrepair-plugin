package com.hackthedoc.blastrepair.commands.subcommands;

import org.bukkit.command.CommandSender;

import com.hackthedoc.blastrepair.Plugin;
import com.hackthedoc.blastrepair.utils.MessageUtils;

public class ReloadSubcommand {
    public static void execute(CommandSender sender, String[] args) {
        Plugin.getInstance().getConfigManager().reloadConfig();
        
        MessageUtils.sendSuccess(sender, "BlastRepair plugin reloaded!");
    }
}
