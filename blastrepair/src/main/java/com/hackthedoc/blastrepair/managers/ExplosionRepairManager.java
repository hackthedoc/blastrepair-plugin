package com.hackthedoc.blastrepair.managers;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class ExplosionRepairManager {
    public void repairBlocks(List<Block> blocks, double speed) {
        Bukkit.getScheduler().runTaskTimerAsynchronously(Bukkit.getPluginManager().getPlugin("BlastRepair"), new Runnable() {
            private int index = 0;
        
            @Override
            public void run() {
                if (index >= blocks.size()) {
                    Bukkit.getScheduler().cancelTask(this.hashCode());
                    return;
                }
                Block block = blocks.get(index);
                Location loc = block.getLocation();
                Material originalMaterial = block.getType();

                loc.getBlock().setType(originalMaterial);

                index++;
           }
        }, 0L, (long)(speed*20));
    }
}
