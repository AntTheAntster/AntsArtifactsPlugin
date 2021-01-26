package uk.co.anttheantster.antsartifactsplugin.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import uk.co.anttheantster.antsartifactsplugin.Main;
import uk.co.anttheantster.antsartifactsplugin.files.PlayerDataFile;

public class onPlayerJoin implements Listener {
    FileConfiguration config = PlayerDataFile.get();
    FileConfiguration mainConfig = Main.getPlugin(Main.class).getConfig();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        String uuid = player.getUniqueId().toString();
        if (!config.contains("Players." + uuid)) {
            config.set("Players." + uuid + ".Gems", 0);
            PlayerDataFile.save();
        }

        PlaceholderAPI.setPlaceholders(player, "%gems_gemsAmount%");

    }
}
