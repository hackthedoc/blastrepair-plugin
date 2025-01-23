package com.hackthedoc.blastrepair.commands.subcommands;

import org.bukkit.command.CommandSender;

import com.hackthedoc.blastrepair.Plugin;
import com.hackthedoc.blastrepair.utils.MessageUtils;

public class OffSubcommand {
    public static void execute(CommandSender sender, String[] args) {
        Plugin.getInstance().getConfigManager().disablePlugin();

        MessageUtils.sendSuccess(sender, "BlastRepair disabled!");
    }
}
