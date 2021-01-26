package uk.co.anttheantster.antsartifactsplugin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.potion.PotionEffectType;
import uk.co.anttheantster.antsartifactsplugin.artifacts.*;

public class DropArtifactEvent implements Listener {

    @EventHandler (priority = EventPriority.HIGH)
    public void onDrop(PlayerDropItemEvent e){
        if (e.getItemDrop().getItemStack().equals(StrengthArtifact.artifact)){
            if (e.getPlayer().hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)){
                e.setCancelled(true);
            }
        }
        if (e.getItemDrop().getItemStack().equals(SpeedArtifact.artifact)){
            if (e.getPlayer().hasPotionEffect(PotionEffectType.SPEED)){
                e.setCancelled(true);
            }
        }
        if (e.getItemDrop().getItemStack().equals(HasteArtifact.artifact)){
            if (e.getPlayer().hasPotionEffect(PotionEffectType.FAST_DIGGING)){
                e.setCancelled(true);
            }
        }
        if (e.getItemDrop().getItemStack().equals(JumpBoostArtifact.artifact)){
            if (e.getPlayer().hasPotionEffect(PotionEffectType.JUMP)){
                e.setCancelled(true);
            }
        }
        if (e.getItemDrop().getItemStack().equals(HealthBoostArtifact.artifact)){
            if (e.getPlayer().hasPotionEffect(PotionEffectType.HEALTH_BOOST)){
                e.setCancelled(true);
            }
        }
        if (e.getItemDrop().getItemStack().equals(RegenerationArtifact.artifact)){
            if (e.getPlayer().hasPotionEffect(PotionEffectType.REGENERATION)){
                e.setCancelled(true);
            }
        }
        if (e.getItemDrop().getItemStack().equals(FireResistanceArtifact.artifact)){
            if (e.getPlayer().hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)){
                e.setCancelled(true);
            }
        }
        if (e.getItemDrop().getItemStack().equals(ResistanceArtifact.artifact)){
            if (e.getPlayer().hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)){
                e.setCancelled(true);
            }
        }
    }

}
