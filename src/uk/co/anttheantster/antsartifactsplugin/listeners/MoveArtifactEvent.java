package uk.co.anttheantster.antsartifactsplugin.listeners;

import org.bukkit.block.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;
import uk.co.anttheantster.antsartifactsplugin.artifacts.StrengthArtifact;

public class MoveArtifactEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClick(InventoryClickEvent event) {

        Player p = (Player) event.getWhoClicked();
        Inventory clicked = event.getClickedInventory();
        if (event.getInventory().getHolder() instanceof Chest || event.getInventory().getHolder() instanceof DoubleChest || event.getInventory().getHolder() instanceof Dispenser || event.getInventory().getHolder() instanceof Hopper || event.getInventory().getHolder() instanceof Dropper) {

            if (clicked == event.getWhoClicked().getInventory()) {

                ItemStack clickedOn = event.getCurrentItem();
                if (clickedOn != null && event.getCurrentItem().hasItemMeta() && event.getCurrentItem().equals(StrengthArtifact.artifact)) {
                    if (p.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)){
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
