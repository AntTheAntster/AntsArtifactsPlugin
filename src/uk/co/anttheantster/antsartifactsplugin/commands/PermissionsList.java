package uk.co.anttheantster.antsartifactsplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class PermissionsList {

    public static void permissionsMessage(CommandSender sender){

        sender.sendMessage(ChatColor.GOLD + "---(AntsArtifacts Permissions)---");
        sender.sendMessage(ChatColor.YELLOW + "/Gems Help - gems.admin.help");
        sender.sendMessage(ChatColor.YELLOW + "/Gems <Player> - gems.use");
        sender.sendMessage(ChatColor.YELLOW + "/Gems Give <Player> <Amount> - gems.admin.give");
        sender.sendMessage(ChatColor.YELLOW + "/Gems Take <Player> <Amount> - gems.admin.take");
        sender.sendMessage(ChatColor.YELLOW + "/Gems ResetGems <Player> - gems.admin.reset");
        sender.sendMessage(ChatColor.YELLOW + "/Gems Reload - gems.reload");
        sender.sendMessage(ChatColor.YELLOW + "/Gems Permissions - gems.admin.permissions");
        sender.sendMessage(ChatColor.YELLOW + "/Gems Shop - gems.shop");

    }

}
