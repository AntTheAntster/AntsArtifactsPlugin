package uk.co.anttheantster.antsartifactsplugin.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import uk.co.anttheantster.antsartifactsplugin.artifacts.*;

public class PlayerPlaceArtifact implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent e){

        if (e.getBlockPlaced().getType().equals(Material.SKULL) && e.getItemInHand().getItemMeta().equals(StrengthArtifact.artifact.getItemMeta())){
            e.setCancelled(true);
        }
        if (e.getBlockPlaced().getType().equals(Material.SKULL) && e.getItemInHand().getItemMeta().equals(SpeedArtifact.artifact.getItemMeta())){
            e.setCancelled(true);
        }
        if (e.getBlockPlaced().getType().equals(Material.SKULL) && e.getItemInHand().getItemMeta().equals(HasteArtifact.artifact.getItemMeta())){
            e.setCancelled(true);
        }
        if (e.getBlockPlaced().getType().equals(Material.SKULL) && e.getItemInHand().getItemMeta().equals(JumpBoostArtifact.artifact.getItemMeta())){
            e.setCancelled(true);
        }
        if (e.getBlockPlaced().getType().equals(Material.SKULL) && e.getItemInHand().getItemMeta().equals(HealthBoostArtifact.artifact.getItemMeta())){
            e.setCancelled(true);
        }
        if (e.getBlockPlaced().getType().equals(Material.SKULL) && e.getItemInHand().getItemMeta().equals(RegenerationArtifact.artifact.getItemMeta())){
            e.setCancelled(true);
        }
        if (e.getBlockPlaced().getType().equals(Material.SKULL) && e.getItemInHand().getItemMeta().equals(FireResistanceArtifact.artifact.getItemMeta())){
            e.setCancelled(true);
        }
        if (e.getBlockPlaced().getType().equals(Material.SKULL) && e.getItemInHand().getItemMeta().equals(ResistanceArtifact.artifact.getItemMeta())){
            e.setCancelled(true);
        }
    }
}
