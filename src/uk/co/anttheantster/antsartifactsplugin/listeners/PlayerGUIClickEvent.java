package uk.co.anttheantster.antsartifactsplugin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import uk.co.anttheantster.antsartifactsplugin.Main;
import uk.co.anttheantster.antsartifactsplugin.artifacts.*;
import uk.co.anttheantster.antsartifactsplugin.files.PlayerDataFile;

public class PlayerGUIClickEvent implements Listener {

    FileConfiguration config = Main.getInstance().getConfig();
    FileConfiguration playerData = PlayerDataFile.get();

    String strengthArtifactName = config.getString("Strength.Artifact Name");
    String speedArtifactName = config.getString("Speed.Artifact Name");
    String hasteArtifactName = config.getString("Haste.Artifact Name");
    String jumpBoostArtifactName = config.getString("Jump Boost.Artifact Name");
    String healthBoostArtifactName = config.getString("Health Boost.Artifact Name");
    String regenerationArtifactName = config.getString("Regeneration.Artifact Name");
    String fireResistanceArtifactName = config.getString("Fire Resistance.Artifact Name");
    String resistanceArtifactName = config.getString("Resistance.Artifact Name");

    @EventHandler (priority = EventPriority.HIGHEST)
    public void playerGUIClickEvent(InventoryClickEvent e) {

        String artifactBoughtRAW = ChatColor.translateAlternateColorCodes('&', config.getString("Artifact Bought"));

        Player player = (Player) e.getWhoClicked();

        if (e.getClickedInventory().getTitle().equalsIgnoreCase(config.getString("Shop Title"))) {

            int playerGems = playerData.getInt("Players." + player.getUniqueId().toString() + ".Gems");

            if (e.getCurrentItem().getItemMeta().getDisplayName().equals(strengthArtifactName)) {
                int cost = config.getInt("Strength.Cost");

                if (!(cost > playerGems)) {
                    removeGems(player, cost);

                    StrengthArtifact.giveArtifact(player);
                    String artifactBought = artifactBoughtRAW.replace("{artifact}", e.getCurrentItem().getItemMeta().getDisplayName());
                    player.sendMessage(artifactBought);
                } else {
                    player.sendMessage(ChatColor.RED + "Not Enough Gems!");
                }
            }

            if (e.getCurrentItem().getItemMeta().getDisplayName().equals(speedArtifactName)) {
                int cost = config.getInt("Speed.Cost");

                if (!(cost > playerGems)) {
                    removeGems(player, cost);

                    SpeedArtifact.giveArtifact(player);
                    String artifactBought = artifactBoughtRAW.replace("{artifact}", e.getCurrentItem().getItemMeta().getDisplayName());
                    player.sendMessage(artifactBought);
                } else {
                    player.sendMessage(ChatColor.RED + "Not Enough Gems!");
                }
            }

            if (e.getCurrentItem().getItemMeta().getDisplayName().equals(hasteArtifactName)) {
                int cost = config.getInt("Haste.Cost");

                if (!(cost > playerGems)) {
                    removeGems(player, cost);

                    HasteArtifact.giveArtifact(player);
                    String artifactBought = artifactBoughtRAW.replace("{artifact}", e.getCurrentItem().getItemMeta().getDisplayName());
                    player.sendMessage(artifactBought);
                } else {
                    player.sendMessage(ChatColor.RED + "Not Enough Gems!");
                }
            }

            if (e.getCurrentItem().getItemMeta().getDisplayName().equals(jumpBoostArtifactName)) {
                int cost = config.getInt("Jump Boost.Cost");

                if (!(cost > playerGems)) {
                    removeGems(player, cost);

                    JumpBoostArtifact.giveArtifact(player);
                    String artifactBought = artifactBoughtRAW.replace("{artifact}", e.getCurrentItem().getItemMeta().getDisplayName());
                    player.sendMessage(artifactBought);
                } else {
                    player.sendMessage(ChatColor.RED + "Not Enough Gems!");
                }
            }

            if (e.getCurrentItem().getItemMeta().getDisplayName().equals(healthBoostArtifactName)) {
                int cost = config.getInt("Health Boost.Cost");

                if (!(cost > playerGems)) {
                    removeGems(player, cost);

                    HealthBoostArtifact.giveArtifact(player);
                    String artifactBought = artifactBoughtRAW.replace("{artifact}", e.getCurrentItem().getItemMeta().getDisplayName());
                    player.sendMessage(artifactBought);
                } else {
                    player.sendMessage(ChatColor.RED + "Not Enough Gems!");
                }
            }

            if (e.getCurrentItem().getItemMeta().getDisplayName().equals(regenerationArtifactName)) {
                int cost = config.getInt("Regeneration.Cost");

                if (!(cost > playerGems)) {
                    removeGems(player, cost);

                    RegenerationArtifact.giveArtifact(player);
                    String artifactBought = artifactBoughtRAW.replace("{artifact}", e.getCurrentItem().getItemMeta().getDisplayName());
                    player.sendMessage(artifactBought);
                } else {
                    player.sendMessage(ChatColor.RED + "Not Enough Gems!");
                }
            }

            if (e.getCurrentItem().getItemMeta().getDisplayName().equals(fireResistanceArtifactName)) {
                int cost = config.getInt("Fire Resistance.Cost");

                if (!(cost > playerGems)) {
                    removeGems(player, cost);

                    FireResistanceArtifact.giveArtifact(player);
                    String artifactBought = artifactBoughtRAW.replace("{artifact}", e.getCurrentItem().getItemMeta().getDisplayName());
                    player.sendMessage(artifactBought);
                } else {
                    player.sendMessage(ChatColor.RED + "Not Enough Gems!");
                }
            }

            if (e.getCurrentItem().getItemMeta().getDisplayName().equals(resistanceArtifactName)) {
                int cost = config.getInt("Resistance.Cost");

                if (!(cost > playerGems)) {
                    removeGems(player, cost);

                    ResistanceArtifact.giveArtifact(player);
                    String artifactBought = artifactBoughtRAW.replace("{artifact}", e.getCurrentItem().getItemMeta().getDisplayName());
                    player.sendMessage(artifactBought);
                } else {
                    player.sendMessage(ChatColor.RED + "Not Enough Gems!");
                }
            }

            e.setCancelled(true);
        }
    }

    public void removeGems(Player player, int gems){
        int g = playerData.getInt("Players." + player.getUniqueId().toString() + ".Gems");
        String pUUID = player.getUniqueId().toString();

        playerData.set("Players." + pUUID + ".Gems", g - gems);
        PlayerDataFile.save();
    }

}
