package ca.caustic.onewayportals.cacausticonewayportals;


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
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // If the player typed /basic then do the following, note: If you only registered this executor for one command, you don't need this
      //  if (cmd.getName().equalsIgnoreCase("basic")) {
      //      // doSomething
     //       return true;
      //  } //If this has happened the function will return true.
        // If this hasn't happened the value of false will be returned.
        String whatCommand = cmd.getName();

        whatCommand = switch(cmd.getName().toLowerCase()){
            case "basic" -> {
                // do something
                sender.sendMessage("Basic Command Sent");
                // return true
                yield "basic";
            }
            case "version" -> {
                // do something
                sender.sendMessage("Version Command Sent " + whatCommand);
                // return true
                yield "version";
            }
            default -> {
                // nothing happened return false
                sender.sendMessage("No valid command was sent");
                yield "false";
            }
        }; // End of Case L switch

        sender.sendMessage("Command Sent was " + whatCommand);
        return false;
    }
}
