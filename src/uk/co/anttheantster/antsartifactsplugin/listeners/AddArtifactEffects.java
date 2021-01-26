package uk.co.anttheantster.antsartifactsplugin.listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import uk.co.anttheantster.antsartifactsplugin.Main;
import uk.co.anttheantster.antsartifactsplugin.artifacts.*;

public class AddArtifactEffects implements Listener {

    boolean activeStrengthEffect = false;
    boolean activeSpeedEffect = false;
    boolean activeHasteEffect = false;
    boolean activeJumpBoostEffect = false;
    boolean activeHealthBoostEffect = false;
    boolean activeRegenerationEffect = false;
    boolean activeFireResistanceEffect = false;
    boolean activeResistanceEffect = false;

    Player player;

    @EventHandler (priority = EventPriority.HIGH)
    public void artifactListener(PlayerInteractEvent e){

        FileConfiguration config = Main.getInstance().getConfig();

        player = e.getPlayer();

        if (e.getAction() == Action.RIGHT_CLICK_AIR){
            if (player.getItemInHand().equals(StrengthArtifact.artifact)){
                if (!activeStrengthEffect){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100000, config.getInt("Strength.Level") - 1));
                    activeStrengthEffect = true;
                    return;
                }
                player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                activeStrengthEffect = false;
            }
            if (player.getItemInHand().equals(SpeedArtifact.artifact)){
                if (!activeSpeedEffect){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, config.getInt("Speed.Level") - 1));
                    activeSpeedEffect = true;
                    return;
                }
                player.removePotionEffect(PotionEffectType.SPEED);
                activeSpeedEffect = false;
            }
            if (player.getItemInHand().equals(HasteArtifact.artifact)){
                if (!activeHasteEffect){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1000000, config.getInt("Haste.Level") - 1));
                    activeHasteEffect = true;
                    return;
                }
                player.removePotionEffect(PotionEffectType.FAST_DIGGING);
                activeHasteEffect = false;
            }
            if (player.getItemInHand().equals(JumpBoostArtifact.artifact)){
                if (!activeJumpBoostEffect){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, config.getInt("Jump Boost.Level") - 1));
                    activeJumpBoostEffect = true;
                    return;
                }
                player.removePotionEffect(PotionEffectType.JUMP);
                activeJumpBoostEffect = false;
            }
            if (player.getItemInHand().equals(HealthBoostArtifact.artifact)){
                if (!activeHealthBoostEffect){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000000, config.getInt("Health Boost.Level") - 1));
                    activeHealthBoostEffect = true;
                    return;
                }
                player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
                activeHealthBoostEffect = false;
            }
            if (player.getItemInHand().equals(RegenerationArtifact.artifact)){
                if (!activeRegenerationEffect){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000000, config.getInt("Regeneration.Level") - 1));
                    activeRegenerationEffect = true;
                    return;
                }
                player.removePotionEffect(PotionEffectType.REGENERATION);
                activeRegenerationEffect = false;
            }
            if (player.getItemInHand().equals(FireResistanceArtifact.artifact)){
                if (!activeFireResistanceEffect){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000000, config.getInt("Fire Resistance.Level") - 1));
                    activeFireResistanceEffect = true;
                    return;
                }
                player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                activeFireResistanceEffect = false;
            }
            if (player.getItemInHand().equals(ResistanceArtifact.artifact)){
                if (!activeResistanceEffect){
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, config.getInt("Resistance.Level") - 1));
                    activeResistanceEffect = true;
                    return;
                }
                player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
                activeResistanceEffect = false;
            }

        }

    }
}
