package ca.caustic.onewayportals.cacausticonewayportals;

import ca.caustic.onewayportals.cacausticonewayportals.CaCausticOnewayportals;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

public class OWPPortalDestruction {
    private static CaCausticOnewayportals plugin;


    public boolean owpPortalDestruction(Block centerBlock) {
        Plugin whatInstance =  CaCausticOnewayportals.getInstance();
        //Plugin whatPlugin = (Plugin) this;

        Bukkit.getLogger().info("Entered Function");
        // Crude and Rude to see what Happens
        // should double wrap this test lstBlockList.get(0).getBlock().getType()
        new BukkitRunnable() {

            @Override
            public void run() {
                //The code inside will be executed in {timeInTicks} ticks.
                Bukkit.broadcastMessage("This message is shown after one second");
                centerBlock.setType(Material.GLOWSTONE);
                Bukkit.broadcastMessage("This message is shown after we change the block to glowstone");

            }
        }.runTaskLater(whatInstance, 40L);   // Your plugin instance, the time to be delayed.

        // centerBlock.setType(Material.GLOWSTONE);
        // lstBlockList.get(0).getBlock().setType(Material.GLOWSTONE);
        Bukkit.getLogger().info("Is NETHER_PAIR and set block to glowstone  !");
        return true;
    }
}
