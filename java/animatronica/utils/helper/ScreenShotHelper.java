package animatronica.utils.helper;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ScreenShotHelper{
	
	
	public static void createScreenShot(String absolutePath){
        createScreenShot(absolutePath, new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
    }
    
    public static void createScreenShot(String absolutePath, Rectangle position){
        try{
            BufferedImage screenShot = new Robot().createScreenCapture(position);
            ImageIO.write(screenShot, absolutePath.substring(absolutePath.lastIndexOf(".") + 1).toUpperCase(), new File(absolutePath));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
