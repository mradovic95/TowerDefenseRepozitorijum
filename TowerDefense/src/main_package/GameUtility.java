package main_package;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.nio.BufferUnderflowException;

import javax.imageio.ImageIO;

import rafgfxlib.Util;

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
	
	public static BufferedImage getFrostEffect(BufferedImage image)
	{
		if(image == null) { System.out.println("Nema slike!"); return null; }
		//ImageViewer.showImageWindow(image, "RAF Racunarska Grafika");
		WritableRaster source = image.getRaster();
		WritableRaster target = Util.createRaster(source.getWidth(), source.getHeight(), true);
		
		int rgb[] = new int[4];
		
		for(int y = 0; y < source.getHeight(); y++)
		{
			for(int x = 0; x < source.getWidth(); x++)
			{
				System.out.println(rgb[3]);
				source.getPixel(x, y, rgb);
			
				// Negativ slike dobijamo radeci komplement svih komponenti,
				// odnosno, novoR = 255 - staroR, itd, gdje ce onda (0,0,0)
				// postati (255,255,255), itd, sto i ocekujemo.
				if(rgb[3]!=0)
				{
				rgb[0] = rgb[0]-50<=0?0:rgb[0]-50;
					
				
				rgb[1]=rgb[1]-50<=0?0:rgb[1]-50;
				
				rgb[2] =255;
				
				}
				
				
				
				
				
				
				target.setPixel(x, y, rgb);
			}
		}
	    BufferedImage newImage=Util.rasterToImage(target);
	    return newImage;
	}
	
	public static BufferedImage getLightningEffect(BufferedImage image)
	{
		if(image == null) { System.out.println("Nema slike!"); return null; }
		//ImageViewer.showImageWindow(image, "RAF Racunarska Grafika");
		WritableRaster source = image.getRaster();
		WritableRaster target = Util.createRaster(source.getWidth(), source.getHeight(), true);
		
		int rgb[] = new int[4];
		
		for(int y = 0; y < source.getHeight(); y++)
		{
			for(int x = 0; x < source.getWidth(); x++)
			{
				System.out.println(rgb[3]);
				source.getPixel(x, y, rgb);
			
				// Negativ slike dobijamo radeci komplement svih komponenti,
				// odnosno, novoR = 255 - staroR, itd, gdje ce onda (0,0,0)
				// postati (255,255,255), itd, sto i ocekujemo.
				if(rgb[3]!=0)
				{
				rgb[0] =255-rgb[0];
				rgb[1]=255-rgb[1];
				rgb[2] =255-rgb[2];
				}
				
				
				
				
				
				
				target.setPixel(x, y, rgb);
			}
		}
	    BufferedImage newImage=Util.rasterToImage(target);
	    return newImage;
	}
	
	public static BufferedImage getWindEffect(BufferedImage image)
	{
		if(image == null) { System.out.println("Nema slike!"); return null; }
		//ImageViewer.showImageWindow(image, "RAF Racunarska Grafika");
		WritableRaster source = image.getRaster();
		WritableRaster target = Util.createRaster(source.getWidth(), source.getHeight(), true);
		
		int rgb[] = new int[4];
		
		for(int y = 0; y < source.getHeight(); y++)
		{
			for(int x = 0; x < source.getWidth(); x++)
			{
				System.out.println(rgb[3]);
				source.getPixel(x, y, rgb);
			
				// Negativ slike dobijamo radeci komplement svih komponenti,
				// odnosno, novoR = 255 - staroR, itd, gdje ce onda (0,0,0)
				// postati (255,255,255), itd, sto i ocekujemo.
				if(rgb[3]!=0)
				{
					if(rgb[3]!=0)
					{
						rgb[3]=60;
					}
				}
				
				
				
				
				
				
				target.setPixel(x, y, rgb);
			}
		}
	    BufferedImage newImage=Util.rasterToImage(target);
	    return newImage;
	}
	
	public static BufferedImage getFireEffect(BufferedImage image)
	{
		if(image == null) { System.out.println("Nema slike!"); return null; }
		//ImageViewer.showImageWindow(image, "RAF Racunarska Grafika");
		WritableRaster source = image.getRaster();
		WritableRaster target = Util.createRaster(source.getWidth(), source.getHeight(), true);
		
		int rgb[] = new int[4];
		
		for(int y = 0; y < source.getHeight(); y++)
		{
			for(int x = 0; x < source.getWidth(); x++)
			{
				System.out.println(rgb[3]);
				source.getPixel(x, y, rgb);
			
				// Negativ slike dobijamo radeci komplement svih komponenti,
				// odnosno, novoR = 255 - staroR, itd, gdje ce onda (0,0,0)
				// postati (255,255,255), itd, sto i ocekujemo.
				if(rgb[3]!=0)
				{
					rgb[0]=255;
					rgb[1] = rgb[1]-50<=0?0:rgb[1]-50;
						
					
					rgb[2]=rgb[2]-50<=0?0:rgb[2]-50;
				}
				
				
				
				
				
				
				target.setPixel(x, y, rgb);
			}
		}
	    BufferedImage newImage=Util.rasterToImage(target);
	    return newImage;
	}
	
	public static BufferedImage addBrightness(BufferedImage image,int brightness)
	{
        //image = Util.loadImage("doge.png");
		
		if(image == null) { System.out.println("Nema slike!"); return null; }
		
		WritableRaster source = image.getRaster();
		WritableRaster target = Util.createRaster(source.getWidth(), source.getHeight(), false);
		
		int rgb[] = new int[4];
		
		
		
		for(int y = 0; y < source.getHeight(); y++)
		{
			for(int x = 0; x < source.getWidth(); x++)
			{
				source.getPixel(x, y, rgb);
				
				// Koristimo funkciju koju smo napravili da pojednostavimo
				// ovu proceduru i skratimo kod.
				rgb[0] = rgb[0]+brightness>255?255:rgb[0]+brightness;
				rgb[1] = rgb[1]+brightness>255?255:rgb[1]+brightness;
				rgb[2] = rgb[2]+brightness>255?255:rgb[2]+brightness;
				
				target.setPixel(x, y, rgb);
			}
		}
	
		// Konverzija rastera u BufferedImage i prikaz u prozoru
		return Util.rasterToImage(target);
	}


}
