package ca.caustic.onewayportals.cacausticonewayportals;

// Need Bukkit plugin file access
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.ChatColor;

import org.bukkit.command.defaults.VersionCommand;

// Jetbrains Annotations
import org.jetbrains.annotations.NotNull;
// General Java
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


// Example Command Class
public class OnewayportalsCommandExecutor implements CommandExecutor {
    private final CaCausticOnewayportals plugin;

    public OnewayportalsCommandExecutor(CaCausticOnewayportals plugin) {
        this.plugin = plugin; // Store the plugin in situations where you need it.
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, @NotNull String label, String[] args) {
        // If the player typed /basic then do the following, note: If you only registered this executor for one command, you don't need this
        // Since we may have more than one name in the lists
        PluginDescriptionFile pdf = plugin.getDescription();
        // Command string holder
        // Convert our string to lower case and switch through the options. No point in wasting time on testing.
        String whatCommand = switch(cmd.getName().toLowerCase()){
            case "authors" -> {
                // Authors information command loosely based on version
                // #todo still broken
                sender.sendMessage("pre-auth");
                //sender.sendMessage("One Way Portals authors are currently: " + getAuthors(pdf));
                sender.sendMessage("One Way Portals authors are currently: " + getStrList(pdf, "authors"));
                sender.sendMessage("post-auth");
                // return true
                yield "authors";
            }case "basic" -> {
                // Our basic example test command
                sender.sendMessage("Basic Command Sent");
                // return true
                yield "basic";
            }
            case "version" -> {
                // Second skeleton command loosely based on version
                sender.sendMessage("One Way Portals Version is currently: " + plugin.getDescription().getVersion());
                // return true
                yield "version";
            }
            default -> {
                // This should be the fallback, however this is not working
                // #TODO sort out why the default is not picking up invalid commands. Suspect it has to do with how they are glued together or that bukkit has a handler that ignores. LOE
                sender.sendMessage("No valid command was sent");
                yield "false";
            }
        }; // End of Case L switch
        // Command verification Debugging - Case L switch result, it is assigned to whatCommand via yield
        sender.sendMessage("OWPortals DEBUG Command Sent was " + whatCommand);
        return false;
    }




    // Generically get all plugin string list items
    // supposedly from bukkit versioncommand
    private String getStrList(final PluginDescriptionFile desc,  @NotNull String label) {
        StringBuilder result = new StringBuilder();
        List<String> strListHolder;

        if(label.equals("authors")) {
            strListHolder = desc.getAuthors();
        } else {
            strListHolder = desc.getContributors();
        }
        for (int i = 0; i < strListHolder.size(); i++) {
            if (result.length() > 0) {
                result.append(ChatColor.WHITE);
                if (i < strListHolder.size() - 1) {
                    result.append(", ");
                } else {
                    result.append(" and ");
                }
            }
            result.append(ChatColor.GREEN);
            result.append(strListHolder.get(i));
        }
        return result.toString();
    }

}



