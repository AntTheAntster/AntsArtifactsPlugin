package uk.co.anttheantster.antsartifactsplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import uk.co.anttheantster.antsartifactsplugin.Main;
import uk.co.anttheantster.antsartifactsplugin.files.PlayerDataFile;

public class TakeCommand {

    public static void takeCommand(CommandSender sender, String[] args){

        FileConfiguration config = Main.getPlugin(Main.class).getConfig();
        FileConfiguration playerData = PlayerDataFile.get();

        if (args.length == 3){
            Player target = Bukkit.getPlayer(args[1]);
            String tUUID = target.getUniqueId().toString();

            int tGems = playerData.getInt("Players." + tUUID + ".Gems");

            playerData.set("Players." + tUUID + ".Gems", tGems - Integer.parseInt(args[2]));
            PlayerDataFile.save();

            sender.sendMessage(ChatColor.GOLD + "Taken " + ChatColor.GREEN + args[2] + ChatColor.GOLD + " Gems from " + target.getName());
        }

    }

}
