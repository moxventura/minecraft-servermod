package com.moxventura.servermod;

import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.server.permission.PermissionAPI;
import java.util.Arrays;

public class ServerModCommands implements ICommand {

	public static String node = "moxventura.servermod.commands";
	
	@Override
	public String getCommandName() {
		return "servermod";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "servermod <command>\n"
				+ "commands:\n\n"
				+ " - ";
	}

	@Override
	public List<String> getCommandAliases() {
		return Arrays.asList("servernmod");
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		World world = sender.getEntityWorld(); 
	    if (world.isRemote) { 
            System.out.println("Not processing on Client side"); 
        } 
        else {
        	System.out.println("Called with args " + Arrays.toString(args));
        }
	    if (args.length == 0) {
	    	sender.addChatMessage(new TextComponentString(getCommandUsage(sender))); 
            return;
	    }
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return PermissionAPI.hasPermission((EntityPlayer) sender, ServerModCommands.node);
	}

	@Override
	public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args,
			BlockPos pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int compareTo(ICommand o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
