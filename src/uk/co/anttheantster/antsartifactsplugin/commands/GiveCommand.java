package uk.co.anttheantster.antsartifactsplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import uk.co.anttheantster.antsartifactsplugin.files.PlayerDataFile;

public class GiveCommand {

    public static void giveCommand(CommandSender sender, String[] args){
        Player p = (Player) sender;
        FileConfiguration playerData = PlayerDataFile.get();
        if (args.length == 3){
            Player t = Bukkit.getPlayer(args[1]);
            if (t != null){
                String uuid = t.getUniqueId().toString();
                int tGems = playerData.getInt("Players." + uuid + ".Gems");
                playerData.set("Players." + uuid + ".Gems", tGems + Integer.parseInt(args[2]));
                PlayerDataFile.save();
                sender.sendMessage(ChatColor.GOLD + "Given " + t.getName() + " " + ChatColor.GREEN + Integer.parseInt(args[2]) + ChatColor.GOLD + " Gems.");
            } else {
                sender.sendMessage(ChatColor.RED + "Player is not online or doesn't exist!");
            }
        } else {
            p.sendMessage(ChatColor.RED + "Incorrect Usage, use /gems help for correct usage.");
        }
    }

}
