package com.hackthedoc.blastrepair.managers;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.block.BlockState;

import com.hackthedoc.blastrepair.utils.MessageUtils;

public class ExplosionRepairManager {
    public void repairBlocks(List<BlockState> blocks, double speed) {
        for (int i = 0; i < blocks.size(); i++) {
            BlockState block = blocks.get(i);

            Bukkit.getScheduler().runTaskLater(com.hackthedoc.blastrepair.Plugin.getInstance(), () -> {
                MessageUtils.log("replacing a block at "+block.getLocation().toString());
                block.update(true, false);
            }, (long)(i*speed)*20L);
        }
    }
}
