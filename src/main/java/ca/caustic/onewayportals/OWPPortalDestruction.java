package ca.caustic.onewayportals;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class OWPPortalDestruction {

    public static boolean owpPortalDestructioon(Block centerBlock) {

        Bukkit.getLogger().info("Entered Function");
        // Crude and Rude to see what Happens
        // should double wrap this test lstBlockList.get(0).getBlock().getType()
        centerBlock.setType(Material.GLOWSTONE);
        // lstBlockList.get(0).getBlock().setType(Material.GLOWSTONE);
        Bukkit.getLogger().info("Is NETHER_PAIR and set block to glowstone  !");
        return true;
    }
}
