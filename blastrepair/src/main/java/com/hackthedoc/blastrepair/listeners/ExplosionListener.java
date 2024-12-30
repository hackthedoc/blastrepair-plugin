package com.hackthedoc.blastrepair.listeners;

import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
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
        Entity entity = event.getEntity();

        List<Block> affectedBlocks = event.blockList().stream()
            .filter(block -> block.getType() != Material.AIR)
            .collect(Collectors.toList());

        double speed = Plugin.getInstance().getConfigManager().getRepairSpeed();

        repairManager.repairBlocks(affectedBlocks, speed);
    }
}
