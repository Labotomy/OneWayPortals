package ca.caustic.onewayportals.owplistener;

import ca.caustic.onewayportals.cacausticonewayportals.CaCausticOnewayportals;
import ca.caustic.onewayportals.OWPPortalDestruction;

// Need core Java list access
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.util.Vector;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.BlockState;
import org.bukkit.event.block.*;
import org.bukkit.plugin.java.JavaPlugin;

// Import Master Bukkit versions
import org.bukkit.event.Listener;                                   // We need our Listener for portal create events
import org.bukkit.event.EventHandler;                               // Access Bukkit EventHandler
import org.bukkit.event.world.PortalCreateEvent;                    // Called when a portal is created

// need to add instance for access to the plugin to use the logger
public class OWPListener implements Listener {
    public CaCausticOnewayportals plugin;

    List<BlockState> lstBlockList = new ArrayList<BlockState>();            // Lets try strings first
    String strBlock1Test = "Not a String";
    List<Integer> lstBlockTestCoord = new ArrayList<Integer>(3);
    List<Vector> lstBoundingBoxList =  new ArrayList<Vector>(3);
    List<Vector> lstBoundingMinList =  new ArrayList<Vector>();
    List<Vector> lstBoundingMaxList =  new ArrayList<Vector>();
    String strWorld = "Not a String";
    String strEntity = "Not a String";
    String strReason = "Not a String";


    @EventHandler
    public void owpPortalCreate( PortalCreateEvent event) {
        Bukkit.getLogger().info("A Portal has been created!");
        // Lets start simple: PortalCreateEvent (List<BlockState> blocks, World world, Entity entity, PortalCreateEvent.CreateReason reason)
Integer counter= 0;
        lstBlockList = event.getBlocks();     // Get the event blocks - guessing coordinates
        strBlock1Test = lstBlockList.get(1).getBlock().getType().toString();
        lstBlockTestCoord.add(lstBlockList.get(1).getBlock().getX());
        lstBlockTestCoord.add(lstBlockList.get(1).getBlock().getY());
        lstBlockTestCoord.add(lstBlockList.get(1).getBlock().getZ());
        lstBoundingBoxList.add(lstBlockList.get(0).getBlock().getBoundingBox().getCenter());
        lstBoundingMinList.add(lstBlockList.get(0).getBlock().getBoundingBox().getMin());
        lstBoundingMaxList.add(lstBlockList.get(0).getBlock().getBoundingBox().getMax());


        strWorld = event.getWorld().toString();       // Get the world we are in
        strEntity = Objects.requireNonNull(event.getEntity()).toString();      // Get the Entity - Is this who created it or the portal itself?
        strReason = event.getReason().toString();      // Get portal Creation Reason  - reason we want: NETHER_PAIR

        Bukkit.getLogger().info("Portal is in World: " + strWorld + " and the reason it was created: " + strReason + " !");
        Bukkit.getLogger().info("Entity Barf?: " + strEntity + " !");
        // Gives object addresses Bukkit.getLogger().info("BlockList Barf?: " + lstBlockList.toString() + " !");
        Bukkit.getLogger().info("BlockList 1 Test - should be Type: " + strBlock1Test + " !");
        Bukkit.getLogger().info("BlockList 1 Test - should be Block 1 Coordinates: " +  lstBlockTestCoord.get(0).toString() +  "," + lstBlockTestCoord.get(1).toString() +  "," + lstBlockTestCoord.get(2).toString() +  " !");
        Bukkit.getLogger().info("BoundingBox Center Test - should be center Coordinates: " + lstBoundingBoxList.toString() +" !");
        Bukkit.getLogger().info("BoundingBox Test - should be Min Coordinates: " + lstBoundingMinList.toString() +" !");
        Bukkit.getLogger().info("BoundingBox Test - should be Max Coordinates: " + lstBoundingMaxList.toString() +" !");

        lstBoundingBoxList.clear();
        while(!lstBlockList.get(counter).getBlock().isEmpty()){
            lstBoundingBoxList.add(lstBlockList.get(counter).getBlock().getBoundingBox().getCenter());
            counter++;
        }
        Bukkit.getLogger().info("Number of Positions: " + counter + ", Block Centers: " + lstBoundingBoxList.toString() + " !");

        // Crude and Rude to see what Happens
        if(strReason.equals("NETHER_PAIR")) {
            // should double wrap this test lstBlockList.get(0).getBlock().getType()
            // lstBlockList.get(0).getBlock().setType(Material.GLOWSTONE);
            Bukkit.getLogger().info("Entered condition NETHER_PAIR");
            // is this working?
            OWPPortalDestruction.owpPortalDestructioon(lstBlockList.get(0).getBlock());
            Bukkit.getLogger().info("After Function");

        }

        // Need to sanitize our holders while they are class-wide
        lstBlockTestCoord.clear();
        lstBoundingBoxList.clear();

        //event.getWorld().
    }




}