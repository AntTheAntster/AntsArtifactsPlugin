package uk.co.anttheantster.antsartifactsplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class GemsHelp {

    public static void Help(CommandSender sender){

        sender.sendMessage(ChatColor.GOLD + "---(Ants Artifacts Help)---");
        sender.sendMessage(ChatColor.YELLOW + "/Gems Help - Displays this message");
        sender.sendMessage(ChatColor.YELLOW + "/Gems Shop - Opens the Artifacts Shop");
        sender.sendMessage(ChatColor.YELLOW + "/Gems <Player> - View your own or others Gems");
        sender.sendMessage(ChatColor.YELLOW + "/Gems Give <Player> <Amount> - Give a player gems");
        sender.sendMessage(ChatColor.YELLOW + "/Gems Take <Player> <Amount> - Take gems from a player");
        sender.sendMessage(ChatColor.YELLOW + "/Gems ResetGems <Player> - Reset a players gems to 0");
        sender.sendMessage(ChatColor.YELLOW + "/Gems Reload - Reload the configs");
        sender.sendMessage(ChatColor.YELLOW + "/Gems Admin - Open the admin gui");
        sender.sendMessage(ChatColor.YELLOW + "/Gems Permissions - Show all the permissions");

    }

}
