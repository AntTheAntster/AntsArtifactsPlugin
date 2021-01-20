package uk.co.anttheantster.antsartifactsplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.anttheantster.antsartifactsplugin.listeners.AddArtifactEffects;
import uk.co.anttheantster.antsartifactsplugin.commands.CommandController;
import uk.co.anttheantster.antsartifactsplugin.commands.TestCommand;
import uk.co.anttheantster.antsartifactsplugin.files.PlayerDataFile;
import uk.co.anttheantster.antsartifactsplugin.listeners.PlayerGUIClickEvent;
import uk.co.anttheantster.antsartifactsplugin.listeners.onPlayerJoin;

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

        if (!pm.getPlugin("HeadDatabase").isEnabled()){
            missingDependencies();
        }

        if (!versionInConfig.equals(versionInPlugin)) {
            versionMismatch();
        }

        saveDefaultConfig();
        PlayerDataFile.setup();

        getCommand("gems").setExecutor(new CommandController());
        getCommand("test").setExecutor(new TestCommand());

        pm.registerEvents(new AddArtifactEffects(), this);

        registerEvents();
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

    }
}
