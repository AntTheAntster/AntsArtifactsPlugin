package uk.co.anttheantster.antsartifactsplugin;

import be.maximvdw.placeholderapi.PlaceholderAPI;
import be.maximvdw.placeholderapi.PlaceholderReplaceEvent;
import be.maximvdw.placeholderapi.PlaceholderReplacer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.anttheantster.antsartifactsplugin.listeners.*;
import uk.co.anttheantster.antsartifactsplugin.commands.CommandController;
import uk.co.anttheantster.antsartifactsplugin.files.PlayerDataFile;

public class Main extends JavaPlugin {

    public static Main instance;

    PluginDescriptionFile pdf = getDescription();
    PluginManager pm = Bukkit.getPluginManager();

    String versionInConfig = getConfig().getString("Version");
    String versionInPlugin = pdf.getVersion();


    @Override
    public void onEnable() {
        instance = this;

        getLogger().info("Plugin Enabled! Version " + pdf.getVersion());

        //if (!pm.isPluginEnabled("HeadDatabase")){
        //    missingDependencies();
        //}

        if (!versionInConfig.equals(versionInPlugin)) {
            versionMismatch();
        }

        saveDefaultConfig();
        PlayerDataFile.setup();

        getCommand("gems").setExecutor(new CommandController());

        registerEvents();


        if (Bukkit.getPluginManager().isPluginEnabled("MVdWPlaceholderAPI")){
            PlaceholderAPI.registerPlaceholder(this, "gems_gemsAmount", new PlaceholderReplacer() {
                @Override
                public String onPlaceholderReplace(PlaceholderReplaceEvent placeholderReplaceEvent) {

                    return String.valueOf(PlayerDataFile.get().getInt("Players." + placeholderReplaceEvent.getPlayer().getUniqueId().toString() + ".Gems"));
                }
            });
        } else {
            return;
        }

    }

    @Override
    public void onDisable() {
        instance = null;

        getLogger().info("Plugin Disabled! Version " + pdf.getVersion());
    }

    public void versionMismatch(){
        getLogger().warning("Plugin Version Mismatch! Please join the discord listed in the config.yml or on the spigot page and make a ticket");
        pm.disablePlugin(this);
    }

    public void missingDependencies(){
        getLogger().warning("Plugin missing dependencies! Please join the discord listed in config.yml or on the spigot page and make a ticket");
        pm.disablePlugin(this);
    }

    public static Main getInstance(){
        return instance;
    }

    public void registerEvents(){
        pm.registerEvents(new onPlayerJoin(), this);
        pm.registerEvents(new PlayerGUIClickEvent(), this);
        pm.registerEvents(new AddArtifactEffects(), this);
        pm.registerEvents(new PlayerPlaceArtifact(), this);
        pm.registerEvents(new MoveArtifactEvent(), this);
        pm.registerEvents(new DropArtifactEvent(), this);

    }
}
