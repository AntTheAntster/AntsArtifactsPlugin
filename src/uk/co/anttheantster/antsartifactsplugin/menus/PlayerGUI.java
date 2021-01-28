package uk.co.anttheantster.antsartifactsplugin.menus;

import me.arcaniax.hdb.api.HeadDatabaseAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import uk.co.anttheantster.antsartifactsplugin.Main;
import uk.co.anttheantster.antsartifactsplugin.files.PlayerDataFile;

import java.util.ArrayList;

public class PlayerGUI {

    public static ItemStack strengthArtifact;
    public static ItemStack speedArtifact;
    public static ItemStack hasteArtifact;
    public static ItemStack healthBoostArtifact;
    public static ItemStack jumpBoostArtifact;
    public static ItemStack regenerationArtifact;
    public static ItemStack fireResistanceArtifact;
    public static ItemStack resistanceArtifact;

    public static void openPlayerGUI(CommandSender sender){

        FileConfiguration playerData = PlayerDataFile.get();
        FileConfiguration config = Main.getPlugin(Main.class).getConfig();

        PluginManager pm = Bukkit.getPluginManager();

        int gemBalanceSlot = config.getInt("GemBalance.Slot");
        int shopSize = config.getInt("Shop Size");

        HeadDatabaseAPI api = new HeadDatabaseAPI();

        ItemStack gemsAmountItem = null;

        Player player = (Player) sender;
        String pUUID = player.getUniqueId().toString();

        String guiTitle = config.getString("Shop Title");
        Inventory inv = Bukkit.createInventory(player, shopSize, ChatColor.translateAlternateColorCodes('&', guiTitle));

        int playerGems = playerData.getInt("Players." + pUUID + ".Gems");

        if (pm.isPluginEnabled("HeadDatabase")){
            gemsAmountItem = api.getItemHead(Integer.toString(config.getInt("GemBalance.HeadDB ID")));
        } else if (!pm.isPluginEnabled("HeadDatabase")){
            gemsAmountItem = new ItemStack(Material.getMaterial(config.getInt("GemBalance.Item ID")));
        }
        ItemMeta gemsAmountMeta = (ItemMeta) gemsAmountItem.getItemMeta();
        gemsAmountMeta.setDisplayName(ChatColor.GOLD + "Gems: " + ChatColor.GREEN + playerGems);
        gemsAmountItem.setItemMeta(gemsAmountMeta);

        //Strength Artifact
        if (pm.isPluginEnabled("HeadDatabase")){
            strengthArtifact = api.getItemHead(Integer.toString(config.getInt("Strength.HeadDB ID")));
        } else if (!pm.isPluginEnabled("HeadDatabase")){
            strengthArtifact = new ItemStack(Material.getMaterial(config.getInt("Strength.Item ID")));
        }
        ItemMeta strengthMeta = (ItemMeta) strengthArtifact.getItemMeta();
        strengthMeta.setDisplayName(config.getString("Strength.Artifact Name"));
        ArrayList<String> strLore = new ArrayList<String>();
        strLore.add(ChatColor.AQUA + "Cost: " + ChatColor.GREEN + config.getInt("Strength.Cost"));
        strengthMeta.setLore(strLore);
        strengthArtifact.setItemMeta(strengthMeta);

        //Speed Artifact
        if (pm.isPluginEnabled("HeadDatabase")){
            speedArtifact = api.getItemHead(Integer.toString(config.getInt("Speed.HeadDB ID")));
        } else if (!pm.isPluginEnabled("HeadDatabase")){
            speedArtifact = new ItemStack(Material.getMaterial(config.getInt("Speed.Item ID")));
        }
        ItemMeta speedMeta = (ItemMeta) speedArtifact.getItemMeta();
        speedMeta.setDisplayName(config.getString("Speed.Artifact Name"));
        ArrayList<String> spdLore = new ArrayList<String>();
        spdLore.add(ChatColor.AQUA + "Cost: " + ChatColor.GREEN + config.getInt("Speed.Cost"));
        speedMeta.setLore(spdLore);
        speedArtifact.setItemMeta(speedMeta);

        //Haste Artifact
        if (pm.isPluginEnabled("HeadDatabase")){
            hasteArtifact = api.getItemHead(Integer.toString(config.getInt("Haste.HeadDB ID")));
        } else if (!pm.isPluginEnabled("HeadDatabase")){
            hasteArtifact = new ItemStack(Material.getMaterial(config.getInt("Haste.Item ID")));
        }
        ItemMeta hasteMeta = (ItemMeta) hasteArtifact.getItemMeta();
        hasteMeta.setDisplayName(config.getString("Haste.Artifact Name"));
        ArrayList<String> hstLore = new ArrayList<String>();
        hstLore.add(ChatColor.AQUA + "Cost: " + ChatColor.GREEN + config.getInt("Haste.Cost"));
        hasteMeta.setLore(hstLore);
        hasteArtifact.setItemMeta(hasteMeta);

        //Jump Boost Artifact
        if (pm.isPluginEnabled("HeadDatabase")){
            jumpBoostArtifact = api.getItemHead(Integer.toString(config.getInt("Jump Boost.HeadDB ID")));
        } else if (!pm.isPluginEnabled("HeadDatabase")){
            jumpBoostArtifact = new ItemStack(Material.getMaterial(config.getInt("Jump Boost.Item ID")));
        }
        ItemMeta jumpBoostMeta = (ItemMeta) jumpBoostArtifact.getItemMeta();
        jumpBoostMeta.setDisplayName(config.getString("Jump Boost.Artifact Name"));
        ArrayList<String> jbLore = new ArrayList<String>();
        jbLore.add(ChatColor.AQUA + "Cost: " + ChatColor.GREEN + config.getInt("Jump Boost.Cost"));
        jumpBoostMeta.setLore(jbLore);
        jumpBoostArtifact.setItemMeta(jumpBoostMeta);

        //Health Boost Artifact
        if (pm.isPluginEnabled("HeadDatabase")){
            healthBoostArtifact = api.getItemHead(Integer.toString(config.getInt("Health Boost.HeadDB ID")));
        } else if (!pm.isPluginEnabled("HeadDatabase")){
            healthBoostArtifact = new ItemStack(Material.getMaterial(config.getInt("Health Boost.Item ID")));
        }
        ItemMeta healthBoostMeta = (ItemMeta) healthBoostArtifact.getItemMeta();
        healthBoostMeta.setDisplayName(config.getString("Health Boost.Artifact Name"));
        ArrayList<String> hbLore = new ArrayList<String>();
        hbLore.add(ChatColor.AQUA + "Cost: " + ChatColor.GREEN + config.getInt("Health Boost.Cost"));
        healthBoostMeta.setLore(hbLore);
        healthBoostArtifact.setItemMeta(healthBoostMeta);

        //Regeneration Artifact
        if (pm.isPluginEnabled("HeadDatabase")){
            regenerationArtifact = api.getItemHead(Integer.toString(config.getInt("Regeneration.HeadDB ID")));
        } else if (!pm.isPluginEnabled("HeadDatabase")){
            regenerationArtifact = new ItemStack(Material.getMaterial(config.getInt("Regeneration.Item ID")));
        }
        ItemMeta regenMeta = (ItemMeta) regenerationArtifact.getItemMeta();
        regenMeta.setDisplayName(config.getString("Regeneration.Artifact Name"));
        ArrayList<String> regLore = new ArrayList<String>();
        regLore.add(ChatColor.AQUA + "Cost: " + ChatColor.GREEN + config.getInt("Regeneration.Cost"));
        regenMeta.setLore(regLore);
        regenerationArtifact.setItemMeta(regenMeta);

        //Fire Resistance Artifact
        if (pm.isPluginEnabled("HeadDatabase")){
            fireResistanceArtifact = api.getItemHead(Integer.toString(config.getInt("Fire Resistance.HeadDB ID")));
        } else if (!pm.isPluginEnabled("HeadDatabase")){
            fireResistanceArtifact = new ItemStack(Material.getMaterial(config.getInt("Fire Resistance.Item ID")));
        }
        ItemMeta fireMeta = (ItemMeta) fireResistanceArtifact.getItemMeta();
        fireMeta.setDisplayName(config.getString("Fire Resistance.Artifact Name"));
        ArrayList<String> fireLore = new ArrayList<String>();
        fireLore.add(ChatColor.AQUA + "Cost: " + ChatColor.GREEN + config.getInt("Fire Resistance.Cost"));
        fireMeta.setLore(fireLore);
        fireResistanceArtifact.setItemMeta(fireMeta);

        //Resistance Artifact
        if (pm.isPluginEnabled("HeadDatabase")){
            resistanceArtifact = api.getItemHead(Integer.toString(config.getInt("Resistance.HeadDB ID")));
        } else if (!pm.isPluginEnabled("HeadDatabase")){
            resistanceArtifact = new ItemStack(Material.getMaterial(config.getInt("Resistance.Item ID")));
        }
        ItemMeta resistMeta = (ItemMeta) resistanceArtifact.getItemMeta();
        resistMeta.setDisplayName(config.getString("Resistance.Artifact Name"));
        ArrayList<String> resLore = new ArrayList<String>();
        resLore.add(ChatColor.AQUA + "Cost: " + ChatColor.GREEN + config.getInt("Resistance.Cost"));
        resistMeta.setLore(resLore);
        resistanceArtifact.setItemMeta(resistMeta);
        //
        //
        //

        ItemStack fillItem = new ItemStack(Material.matchMaterial(config.getString("Fill Material")), 1, (short) config.getInt("Fill Material Damage"));
        ItemMeta fillItemMeta = (ItemMeta) fillItem.getItemMeta();
        fillItemMeta.setDisplayName(" ");
        fillItem.setItemMeta(fillItemMeta);
        ArrayList<ItemStack> fillItemsArray = new ArrayList<ItemStack>();

        if (config.getBoolean("Fill Empty")){
            for (int i = 0; i < shopSize; i++){
                fillItemsArray.add(fillItem);
            }
            ItemStack[] fillItems = fillItemsArray.toArray(new ItemStack[fillItemsArray.size()]);
            inv.setContents(fillItems);
        }

        if (config.getBoolean("Strength.Enabled")){
            int slot = config.getInt("Strength.Slot");
            inv.setItem(slot, strengthArtifact);
        }
        if (config.getBoolean("Speed.Enabled")){
            int slot = config.getInt("Speed.Slot");
            inv.setItem(slot, speedArtifact);
        }
        if (config.getBoolean("Haste.Enabled")){
            int slot = config.getInt("Haste.Slot");
            inv.setItem(slot, hasteArtifact);
        }
        if (config.getBoolean("Jump Boost.Enabled")){
            int slot = config.getInt("Jump Boost.Slot");
            inv.setItem(slot, jumpBoostArtifact);
        }
        if (config.getBoolean("Health Boost.Enabled")){
            int slot = config.getInt("Health Boost.Slot");
            inv.setItem(slot, healthBoostArtifact);
        }
        if (config.getBoolean("Regeneration.Enabled")){
            int slot = config.getInt("Regeneration.Slot");
            inv.setItem(slot, regenerationArtifact);
        }
        if (config.getBoolean("Fire Resistance.Enabled")){
            int slot = config.getInt("Fire Resistance.Slot");
            inv.setItem(slot, fireResistanceArtifact);
        }
        if (config.getBoolean("Resistance.Enabled")){
            int slot = config.getInt("Resistance.Slot");
            inv.setItem(slot, resistanceArtifact);
        }

        inv.setItem(gemBalanceSlot, gemsAmountItem);
        player.openInventory(inv);




    }

}
