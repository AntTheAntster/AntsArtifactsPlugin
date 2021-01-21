package uk.co.anttheantster.antsartifactsplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import uk.co.anttheantster.antsartifactsplugin.artifacts.StrengthArtifact;

public class AddArtifactEffects implements Listener {

    public void artifactListener(PlayerInteractEvent e){
        Player player = e.getPlayer();

        if (player.getInventory().containsAtLeast(StrengthArtifact.artifact, 1)){
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "effect " + player.getName() + " minecraft:strength 18000 2");
        }
    }

}
