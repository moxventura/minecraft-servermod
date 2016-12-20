package com.moxventura.servermod;

import net.minecraftforge.common.MinecraftForge;
//import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.PermissionAPI;

@Mod(modid = ServerMod.MODID, version = ServerMod.VERSION)
public class ServerMod
{
    public static final String MODID = "moxventuraservermod";
    public static final String VERSION = "1.0";
    
	ServerModEventHandler events = new ServerModEventHandler();
	ServerModCommands commands = new ServerModCommands();
	
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		event.registerServerCommand(commands);
	}
	
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(events);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	PermissionAPI.registerNode(ServerModCommands.node, DefaultPermissionLevel.OP, "Commands for spawnmod");
    	// some example code
//        System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
    	
    }
}
