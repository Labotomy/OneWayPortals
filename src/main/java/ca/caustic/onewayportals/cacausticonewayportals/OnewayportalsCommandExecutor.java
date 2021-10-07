package ca.caustic.onewayportals.cacausticonewayportals;

// Jetbrains Annotations
import org.jetbrains.annotations.NotNull;

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
        // Command string holder
        String whatCommand = cmd.getName();
        // Convert our string to lower case and switch through the options. No point in wasting time on testing.
        whatCommand = switch(cmd.getName().toLowerCase()){
            case "basic" -> {
                // Our basic example test command
                sender.sendMessage("Basic Command Sent");
                // return true
                yield "basic";
            }
            case "version" -> {
                // Second skeleton command loosely based on version
                sender.sendMessage("Version Command Sent " + whatCommand);
                // return true
                yield "version";
            }
            default -> {
                // This should be the fallback, however this is not working
                // #TODO sort out why the default is not picking up invalid commands. Suspect it has to do with how they are glued together. LOE
                sender.sendMessage("No valid command was sent");
                yield "false";
            }
        }; // End of Case L switch

        sender.sendMessage("Command Sent was " + whatCommand);
        return false;
    }
}
