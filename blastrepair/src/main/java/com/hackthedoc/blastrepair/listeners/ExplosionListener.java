package com.hackthedoc.blastrepair.listeners;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import com.hackthedoc.blastrepair.Plugin;
import com.hackthedoc.blastrepair.managers.ExplosionRepairManager;

public class ExplosionListener implements Listener {
    private final ExplosionRepairManager repairManager;

    public ExplosionListener() {
        this.repairManager = new ExplosionRepairManager();
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        List<Block> affectedBlocks = event.blockList().stream()
            .filter(block -> block.getType() != Material.AIR)
            .collect(Collectors.toList());

        double delay = Plugin.getInstance().getConfigManager().getRepairDelay();
        double speed = Plugin.getInstance().getConfigManager().getRepairSpeed();

        Plugin.getInstance().getServer().getScheduler().runTaskLater(Plugin.getInstance(), new Runnable() {
            @Override
            public void run() {
                repairManager.repairBlocks(affectedBlocks, speed);
            }
        }, (long)delay*20L);
    }
}
