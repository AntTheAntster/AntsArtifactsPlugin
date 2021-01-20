package uk.co.anttheantster.antsartifactsplugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import uk.co.anttheantster.antsartifactsplugin.artifacts.StrengthArtifact;

public class AddArtifactEffects implements Listener {

    public void strengthListener(PlayerInteractEvent e){
        Player player = e.getPlayer();

        if (player.getInventory().containsAtLeast(StrengthArtifact.artifact, 1)){
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1800, 1));
        }
    }

}
