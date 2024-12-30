package com.hackthedoc.blastrepair.commands;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.hackthedoc.blastrepair.commands.subcommands.OffSubcommand;
import com.hackthedoc.blastrepair.commands.subcommands.OnSubcommand;
import com.hackthedoc.blastrepair.commands.subcommands.ReloadSubcommand;
import com.hackthedoc.blastrepair.utils.MessageUtils;

public class BlastrepairCommand implements CommandExecutor {
    private final Map<String, BiConsumer<CommandSender, String[]>> subcommands = new HashMap<>();
    
    public BlastrepairCommand() {
        subcommands.put("reload"    , ReloadSubcommand::execute );
        subcommands.put("off"       , OffSubcommand::execute    );
        subcommands.put("on"        , OnSubcommand::execute     );
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0)
            return false;
        
        BiConsumer<CommandSender, String[]> subcommand = subcommands.get(args[0]);

        if (subcommand != null)
            subcommand.accept(sender, args);
        else 
            MessageUtils.sendError(sender, "Unknown subcommand: "+args[0]);
        
        return true;
    }
}
