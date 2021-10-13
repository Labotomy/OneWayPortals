package ca.caustic.onewayportals.owplistener;

import ca.caustic.onewayportals.cacausticonewayportals.CaCausticOnewayportals;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

// Import Master Bukkit versions
import org.bukkit.event.Listener;                                   // We need our Listener for portal create events
import org.bukkit.event.EventHandler;                               // Access Bukkit EventHandler
import org.bukkit.event.world.PortalCreateEvent;                    // Called when a portal is created

// need to add instance for access to the plugin to use the logger
public class OWPListener implements Listener {
    public CaCausticOnewayportals plugin;
    @EventHandler
    public void owpPortalCreate( PortalCreateEvent event) {
        Bukkit.getLogger().info("A Portal has been created!");
        //event.getWorld().
    }
}