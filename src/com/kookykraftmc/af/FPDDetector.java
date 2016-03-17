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
        if (isFP(e.getPlayer())) {
            if (plugin.BBs.contains(e.getBlock().getType().toString())) {
                e.setCancelled(true);
            }
        }
    }

    public void onBlockBreak(BlockBreakEvent e) {
        if (isFP(e.getPlayer())) {
            if (plugin.BBs.contains(e.getBlock().getType().toString())) {
                e.setCancelled(true);
            }
        }
    }
    public void onBlockInteract(PlayerInteractEvent e) {
        if (isFP(e.getPlayer())) {
            if (plugin.BBs.contains(e.getClickedBlock().getType().toString())) {
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
        plugin.FPs.add(name);
    }
}
