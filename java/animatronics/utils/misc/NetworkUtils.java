package animatronics.utils.misc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ThreadLanServerPing;
import net.minecraft.client.network.LanServerDetector.ThreadLanServerFind;
import net.minecraft.world.storage.ThreadedFileIOBase;
import net.minecraftforge.common.MinecraftForge;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import animatronics.Animatronics;


public class NetworkUtils{

	/*public static void downloadFile(String fileURL, String downloadedFileDirectory, String downloadedFileName){
		try(InputStream is = new URL(fileURL).openStream(); FileOutputStream fos = new FileOutputStream(downloadedFileDirectory + "/" + downloadedFileName)){
			byte[] buffer = new byte[1024 * 32];
			int bytesRead;
			while((bytesRead = is.read(buffer)) != -1){
				fos.write(buffer, 0, bytesRead);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}*/

	public static String[] loadTextFromURL(String url){
		List<String> strings = Lists.newArrayList();
		Scanner scanner = null;
		try{
			URLConnection connection = new URL(url).openConnection();
			scanner = new Scanner(connection.getInputStream(), "UTF-8");
			while(scanner.hasNextLine()){
				strings.add(scanner.nextLine());
			}
		}catch(IOException e){
			Animatronics.logger.error("Failed to url connection!", e);
		}finally{
			if(scanner != null){
				scanner.close();
			}
		}
		return strings.toArray(new String[strings.size()]);
	}
}
