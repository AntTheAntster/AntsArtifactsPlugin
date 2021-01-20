package uk.co.anttheantster.antsartifactsplugin.artifacts;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveArtifact {

    public static void giveArtifact(Player player, ItemStack artifact){
        player.getInventory().addItem(artifact);
    }

}
