package uk.co.anttheantster.antsartifactsplugin;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import uk.co.anttheantster.antsartifactsplugin.files.PlayerDataFile;

public class PluginPlaceholders extends PlaceholderExpansion {

    FileConfiguration playerData = PlayerDataFile.get();


    @Override
    public String getIdentifier() {
        return "gems";
    }

    @Override
    public String getAuthor() {
        return "AntTheAntster";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onPlaceholderRequest(Player p, String params) {
        if (p == null){
            return "";
        }
        if (params.equals("gemsAmount")){
            return String.valueOf(playerData.getInt("Players." + p.getUniqueId().toString() + ".Gems"));
        }

        return null;
    }
}
