package com.hackthedoc.blastrepair.listeners;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import com.hackthedoc.blastrepair.Plugin;
import com.hackthedoc.blastrepair.managers.ExplosionRepairManager;
import com.hackthedoc.blastrepair.utils.MessageUtils;

public class ExplosionListener implements Listener {
    private final ExplosionRepairManager repairManager;

    public ExplosionListener() {
        this.repairManager = new ExplosionRepairManager();
    }

    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        MessageUtils.log("explosion detected!");

        Entity entity = event.getEntity();
        String explositionType = "unknown";
        if (entity != null)
            explositionType = entity.getType().toString().toLowerCase();

        MessageUtils.log("explosion type is "+explositionType);
        
        if (!Plugin.getInstance().getConfigManager().isRepairEnabledFor(explositionType))
            return;
        
        MessageUtils.log("blast repair is enabled for this type of explosion");

        List<BlockState> affeBlockStates = new ArrayList<>();
        for (Block block : event.blockList()) {
            if (!block.getType().isAir())
                affeBlockStates.add(block.getState());
        }

        long delay = (long)Plugin.getInstance().getConfigManager().getRepairDelay() *20L;
        double speed = Plugin.getInstance().getConfigManager().getRepairSpeed();

        Plugin.getInstance().getServer().getScheduler().runTaskLater(Plugin.getInstance(), () -> {
            MessageUtils.log("starting repairal...");
            repairManager.repairBlocks(affeBlockStates, speed);
        }, delay);
    }
}
