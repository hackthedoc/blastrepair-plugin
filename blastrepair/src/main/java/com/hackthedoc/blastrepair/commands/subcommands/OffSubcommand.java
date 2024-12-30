package com.hackthedoc.blastrepair.commands.subcommands;

import org.bukkit.command.CommandSender;

import com.hackthedoc.blastrepair.Plugin;

public class OffSubcommand {
    public static void execute(CommandSender sender, String[] args) {
        Plugin.getInstance().getConfigManager().disablePlugin();
    }
}
