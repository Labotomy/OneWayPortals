package ca.caustic.onewayportals.cacausticonewayportals;

// Annotations support
import org.jetbrains.annotations.NotNull;

import org.bukkit.entity.Entity;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

// Import Master Bukkit versions
import org.bukkit.Location;                                         // Location support
import org.bukkit.PortalType;                                       // Types of created portals
import org.bukkit.event.world.PortalCreateEvent;                    // Called when a portal is created
import org.bukkit.event.entity.EntityCreatePortalEvent;             // Called when an Entity-Player creates a portal - depreciated for the above
import org.bukkit.Particle;                                         // Particle Effect

import java.util.Objects;

// Import Master Spigot versions

public final class CaCausticOnewayportals extends JavaPlugin {
    // Need an event handler to listen for the portals
    private static final HandlerList handlers = new HandlerList();

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("onEnable has been invoked for OneWayPortals!");
        // Register our commands!
        // This will throw a NullPointerException if you don't have the command defined in your plugin.yml file!
        Objects.requireNonNull(this.getCommand("authors")).setExecutor(new OnewayportalsCommandExecutor(this));
        Objects.requireNonNull(this.getCommand("basic")).setExecutor(new OnewayportalsCommandExecutor(this));
        Objects.requireNonNull(this.getCommand("version")).setExecutor(new OnewayportalsCommandExecutor(this));


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("onDisable has been invoked for OneWayPortals!");
    }

    @NotNull
    public HandlerList getHandlers() {
        return handlers;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return handlers;
    }

}

