package main_package;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public final class GameUtility 
{
	private GameUtility()
	{
		
	}
	
	public static BufferedImage cutImage(BufferedImage spriteSheet,int col,int row,int width,int height)
	{
		BufferedImage img=spriteSheet.getSubimage(col*width,row*height,width,height);
		return img;
	}
	
	
	 
	public static BufferedImage loadImage(String path) throws IOException
	{
		if(path==null||path.isEmpty())
		{
			System.out.println("Path is null");
			return null;
		}
		
		BufferedImage image=ImageIO.read(new File(path));
		return image;
	}
	
	public static double distance(int x1,int y1,int x2,int y2)
	{
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	}

}
