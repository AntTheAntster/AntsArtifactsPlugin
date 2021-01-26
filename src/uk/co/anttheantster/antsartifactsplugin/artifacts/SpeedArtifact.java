package uk.co.anttheantster.antsartifactsplugin.artifacts;

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import uk.co.anttheantster.antsartifactsplugin.Main;
import uk.co.anttheantster.antsartifactsplugin.commands.PlayerGUI;
import uk.co.anttheantster.antsartifactsplugin.files.PlayerDataFile;

import java.util.ArrayList;

public class SpeedArtifact {

    public static ItemStack artifact = new ItemStack(PlayerGUI.speedArtifact);
    public static ItemMeta artifactMeta = (ItemMeta) artifact.getItemMeta();

    public static void giveArtifact(Player player){
        FileConfiguration config = Main.getInstance().getConfig();
        FileConfiguration playerData = PlayerDataFile.get();

        HeadDatabaseAPI api = new HeadDatabaseAPI();

        String head = config.getString("Speed.HeadDB ID");

        ArrayList<String> strList = new ArrayList<String>();
        strList.add(ChatColor.GREEN + "Permanent Speed Effect");
        artifactMeta.setLore(strList);
        artifact.setItemMeta(artifactMeta);
        GiveArtifact.giveArtifact(player, artifact);
    }
}
