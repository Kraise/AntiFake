package com.kookykraftmc.af;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

/**
 * Created by TimeTheCat on 3/17/2016.
 */
public class AntiFake extends JavaPlugin {
    //list of fake players
    public List<String> FPs = new Vector<String>();
    //list of badblocks
    public List<String> BBs;
    //plugin description
    PluginDescriptionFile pdf = this.getDescription();
    //plugin prefix
    String prefix = pdf.getName();
    public void onEnable() {
        //create cfg
        getConfig().options().copyDefaults(true);
        saveConfig();
        //get list of blocks to prevent
        BBs = this.getConfig().getStringList("badPlace");
        getLogger().info(prefix + " is loading!");
        //register event listener
        getServer().getPluginManager().registerEvents(new FPDDetector(this), this);
    }
    public void onDisable() {
        getLogger().info("Emptying fakeplayer list!");
        FPs.removeAll(FPs);
    }
}
