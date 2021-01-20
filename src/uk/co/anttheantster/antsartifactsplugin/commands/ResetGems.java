package uk.co.anttheantster.antsartifactsplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import uk.co.anttheantster.antsartifactsplugin.files.PlayerDataFile;

public class ResetGems {

    static FileConfiguration playerData = PlayerDataFile.get();

    public static void resetGems(CommandSender sender, String[] args){
        Player t = Bukkit.getPlayer(args[1]);
        if (t == null){
            sender.sendMessage(ChatColor.RED + "This player is not online or doesn't exist");
        }
        String uuid = t.getUniqueId().toString();

        if (args.length == 2){
            playerData.set("Players." + uuid + ".Gems", 0);
            PlayerDataFile.save();
            PlayerDataFile.reload();
            sender.sendMessage(ChatColor.GOLD + "Reset " + t.getName() + "'s Gems.");
        }
    }

}