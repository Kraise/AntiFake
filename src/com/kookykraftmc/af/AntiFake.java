package com.kookykraftmc.af;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

/**
 * Created by TimeTheCat on 3/17/2016.
 */
public class AntiFake extends JavaPlugin {
    //list of fake players
    public List<String> FPs;
    //list of badblocks
    public List<String> BBPlace;
    public List<String> BBBreak;
    public List<String> BBInter;
    //plugin description
    PluginDescriptionFile pdf = this.getDescription();
    //plugin prefix
    String prefix = pdf.getName();
    public void onEnable() {
        //create cfg
        getConfig().options().copyDefaults(true);
        saveConfig();
        //get list of blocks to prevent
        BBPlace = this.getConfig().getStringList("badPlace");
        BBBreak = this.getConfig().getStringList("badBreak");
        BBInter = this.getConfig().getStringList("badInteract");
        getLogger().info(prefix + " is loading!");
        //register event listener
        getServer().getPluginManager().registerEvents(new FPDDetector(this), this);
    }
    public void onDisable() {
        getLogger().info("Emptying fakeplayer list!");
        FPs.clear();
    }

}
