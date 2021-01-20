package uk.co.anttheantster.antsartifactsplugin.files;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import uk.co.anttheantster.antsartifactsplugin.Main;

import java.io.File;
import java.io.IOException;

public class PlayerDataFile {

    private static Plugin pl = Main.getPlugin(Main.class);


    private static File file;
    private static FileConfiguration customFile;


    //Finds and/or generates PlayerData File.
    public static void setup(){
        file = new File(pl.getDataFolder(), "PlayerData.yml");

        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }

        }

        customFile = YamlConfiguration.loadConfiguration(file);

    }

    public static FileConfiguration get(){
        return customFile;
    }

    public static void save(){
        try {
            customFile.save(file);
        } catch (IOException e){
            System.out.println("Couldn't save file");
        }
    }

    public static void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }

}
