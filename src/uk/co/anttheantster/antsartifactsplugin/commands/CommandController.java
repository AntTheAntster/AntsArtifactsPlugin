package uk.co.anttheantster.antsartifactsplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import uk.co.anttheantster.antsartifactsplugin.Main;
import uk.co.anttheantster.antsartifactsplugin.files.PlayerDataFile;
import uk.co.anttheantster.antsartifactsplugin.menus.PlayerGUI;

public class CommandController implements CommandExecutor {

    FileConfiguration playerData = PlayerDataFile.get();
    FileConfiguration config = Main.getPlugin(Main.class).getConfig();

    String prefix = ChatColor.translateAlternateColorCodes('&', config.getString("Prefix"));

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (label.equalsIgnoreCase("gems")){
            if (!(sender instanceof Player)){
                sender.sendMessage("You must be a player to do that!");
                return false;
            }
            Player player = (Player) sender;
            int playerGems = playerData.getInt("Players." + player.getUniqueId().toString() + ".Gems");

            if (args.length == 0){
                if (player.hasPermission("gems.view")){
                    String viewOwnGemsRAW = ChatColor.translateAlternateColorCodes('&', config.getString("View Own Gems"));
                    String viewOwnGems = viewOwnGemsRAW.replace("{playername}", player.getName());
                    viewOwnGems = viewOwnGems.replace("{gems}", Integer.toString(playerGems));
                    player.sendMessage(viewOwnGems);
                    return false;
                }
                noPermissionMessage(sender);
                return false;
            }

            if (args[0].equalsIgnoreCase("give")){
                if (player.hasPermission("gems.admin.give")){
                    GiveCommand.giveCommand(sender, args);
                    return false;
                }
                noPermissionMessage(sender);
                return false;
            }
            if (args[0].equalsIgnoreCase("take")){
                if (player.hasPermission("gems.admin.take")){
                    TakeCommand.takeCommand(sender, args);
                    return false;
                }
                noPermissionMessage(sender);
                return false;
            }
            if (args[0].equalsIgnoreCase("help")){
                if (player.hasPermission("gems.admin.help")){
                    GemsHelp.Help(sender);
                    return false;
                }
                noPermissionMessage(sender);
                return false;
            }
            if (args[0].equalsIgnoreCase("reload")){
                if (player.hasPermission("gems.admin.reload")){
                    Main.getPlugin(Main.class).reloadConfig();
                    PlayerDataFile.reload();
                    player.sendMessage(ChatColor.GREEN + "Reload Complete.");
                    return false;
                }
                noPermissionMessage(sender);
                return false;
            }
            if (args[0].equalsIgnoreCase("resetgems")){
                if (player.hasPermission("gems.admin.reset")){
                    ResetGems.resetGems(sender, args);
                    return false;
                }
                noPermissionMessage(sender);
                return false;
            }
            if (args[0].equalsIgnoreCase("shop")){
                if(player.hasPermission("gems.shop")){
                    PlayerGUI.openPlayerGUI(sender);
                    return false;
                }
                noPermissionMessage(sender);
                return false;
            }

            if (args[0].equalsIgnoreCase("permissions")){
                if (player.hasPermission("gems.admin.permissions")){
                    PermissionsList.permissionsMessage(sender);
                    return false;
                }
                noPermissionMessage(sender);
                return false;
            }
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null){
                if (args[0].equalsIgnoreCase(target.getName())){
                    if (player.hasPermission("gems.view.others")){
                        int targetGems = playerData.getInt("Players." + target.getUniqueId().toString() + ".Gems");
                        String viewOthersGemsRAW = ChatColor.translateAlternateColorCodes('&', config.getString("View Others Gems"));
                        String viewOthersGems = viewOthersGemsRAW.replace("{targetname}", target.getName());
                        viewOthersGems = viewOthersGems.replace("{gems}", Integer.toString(targetGems));
                        player.sendMessage(viewOthersGems);
                        return false;
                    }

                    noPermissionMessage(sender);
                    return false;
                }
                return false;
            }

            player.sendMessage(ChatColor.RED + "Incorrect Usage.");
            return false;
        }

        return false;
    }

    public void noPermissionMessage(CommandSender sender){
        sender.sendMessage(prefix + ChatColor.RED + "Insufficient Permission.");
    }
}