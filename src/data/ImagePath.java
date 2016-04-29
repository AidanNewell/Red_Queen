package data;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.imageio.ImageIO;

public class ImagePath
{
	
	public static final String path = "assets/";
	
	public static Image HUD_BANNER;
	public static Image RIGHT_ARROW;
	public static Image LEFT_ARROW;
		
    public static void init()
    {
    	try{
    		HUD_BANNER = ImageIO.read(new File(path + "HUD_Banner.png"));
    		LEFT_ARROW = ImageIO.read(new File(path + "Left_Arrow.png"));
    		RIGHT_ARROW = ImageIO.read(new File(path + "Right_Arrow.png"));
    	}catch(Exception e){e.printStackTrace(); System.exit(1);}
    	
    	scale();
    }
    
    private static void scale()
    {
    	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    	int height = screen.height;
    	int width = screen.width;
    	HUD_BANNER = HUD_BANNER.getScaledInstance(width,height/7, Image.SCALE_SMOOTH);
    	LEFT_ARROW = LEFT_ARROW.getScaledInstance(width/8, 3*height/4, Image.SCALE_SMOOTH);
    	RIGHT_ARROW = RIGHT_ARROW.getScaledInstance(width/8, 3*height/4, Image.SCALE_SMOOTH);
    }
}