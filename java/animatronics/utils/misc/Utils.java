package animatronics.utils.misc;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumChatFormatting;

import com.google.common.collect.Lists;

import animatronics.Animatronics;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.EntityRegistry;

public class Utils{

	public static final Random random = new Random();

	/**
	 *  Restart minecraft application.
	 */
	public static void restartMinecraftApplet(){
		String java = System.getProperty("java.home") + "/bin/javaw"; // java binary
		List<String> vmArguments = ManagementFactory.getRuntimeMXBean().getInputArguments(); // vm arguments
		StringBuffer vmArgsOneLine = new StringBuffer();
		for(String arg : vmArguments){
			if(!arg.contains("-agentlib")){ // if it's the agent argument : we ignore it otherwise the
				vmArgsOneLine.append(arg);    // address of the old application and the new one will be in conflict
				vmArgsOneLine.append(" ");
			}
		}
		final StringBuffer cmd = new StringBuffer("\"" + java + "\" " + vmArgsOneLine); // init the command to execute, add the vm args
		String[] mainCommand = System.getProperty("sun.java.command").split(" "); // program main and program arguments
		if(mainCommand[0].endsWith(".jar")){ // program main is a jar, add -jar mainJar
			cmd.append("-jar " + new File(mainCommand[0]).getPath());
		}else{ // else it's a .class, add the classpath and mainClass
			cmd.append("-cp \"" + System.getProperty("java.class.path") + "\" " + mainCommand[0]);
		}
		for(int i = 1; i < mainCommand.length; i++){ // finally add program arguments
			cmd.append(" ");
			cmd.append(mainCommand[i]);
		}
		// execute the command in a shutdown hook, to be sure that all the
		// resources have been disposed before restarting the application
		Runtime.getRuntime().addShutdownHook(new Thread(){
			public void run(){
				try{
					ProcessBuilder builder = new ProcessBuilder(cmd.toString());
					builder.inheritIO();    // inherit the console output from the super process (the process initiating the restart)
					builder.start();        // start the new process
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		});
		try{
			Animatronics.logger.info("---=== Restarting Minecraft Client! ===---");    // try to shutdown Minecraft applet
			Minecraft.getMinecraft().shutdownMinecraftApplet();
		}catch(NoClassDefFoundError e){
			Animatronics.logger.info("---=== Restarting Minecraft Server! ===---");    // if Minecraft class was not found                                                                    // (usually the case on a dedi-server),
			MinecraftServer.getServer().initiateShutdown();                            // then shutdown server
		}
	}

	public static EnumChatFormatting[] allChatFormattingColors(){
		ArrayList<EnumChatFormatting> colors = Lists.newArrayList();
		for(EnumChatFormatting value : EnumChatFormatting.values()){
			if(value.isColor()){
				colors.add(value);
			}
		}
		return colors.toArray(new EnumChatFormatting[colors.size()]);
	}

	public static EnumChatFormatting getRandomChatFormattingColor(){
		return Utils.allChatFormattingColors()[random.nextInt(Utils.allChatFormattingColors().length)];
	}

	public static void openInBrowser(String url){
		if(Desktop.isDesktopSupported()){
			try{
				Desktop.getDesktop().browse(new URI(url));
			}catch(Exception e){
				Animatronics.logger.error("Failed to browse " + url + "!");
			}
		}
	}
}
