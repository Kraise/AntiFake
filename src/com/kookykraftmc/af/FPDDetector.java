package com.kookykraftmc.af;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by TimeTheCat on 3/17/2016.
 */
public class FPDDetector implements Listener {
    public AntiFake plugin;
    public FPDDetector(AntiFake plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if (isFP(e.getPlayer()) == true) {
            if (plugin.BBPlace.contains(e.getBlock().getType().toString())) {
                e.setCancelled(true);
            }
        }
    }

    public void onBlockBreak(BlockBreakEvent e) {
        if (isFP(e.getPlayer()) == true) {
            if (plugin.BBBreak.contains(e.getBlock().getType().toString())) {
                e.setCancelled(true);
            }
        }
    }
    public void onBlockInteract(PlayerInteractEvent e) {
        if (isFP(e.getPlayer()) == true) {
            if (plugin.BBInter.contains(e.getClickedBlock().getType().toString())) {
                e.setCancelled(true);
            }
        }
    }
    boolean isFP(Player p) {
        if (p.getName().startsWith("[")) {
            addFP(p.getName());
            return true;
        } else {
            return false;
        }
    }
    void addFP(String name) {
        if (plugin.FPs.contains(name)) {
            //already have the fake player so don't need to add him again
        } else if (!plugin.FPs.contains(name)){
            plugin.FPs.add(name);
        }
    }
}
