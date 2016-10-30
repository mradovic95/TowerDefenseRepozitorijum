package map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Map 
{
	private int map[][];
	private int mapWidth;
	private int mapHeight;
	private int tileWidth;
	private int tileHeight;
	private BufferedImage[] images;
	private BufferedImage SpriteSheet;
	
	public void load(String path)
	{
		for(int i=0;i<4;i++)
		{
			System.out.println(SpriteSheet);
			images[i]=this.SpriteSheet.getSubimage(i*tileWidth,0,tileWidth,tileHeight);
		}
		
		
		ArrayList<ArrayList<Integer>> tempMap=new ArrayList<ArrayList<Integer>>();
		try 
		{
			BufferedReader reader=new BufferedReader(new FileReader(new File(path)));
			String line;
			
			while((line=reader.readLine())!=null)
			{
				if(line.isEmpty())
				{
					continue;
				}
				String values[]=line.trim().split(" ");
				ArrayList<Integer> row=new ArrayList<Integer>();
				for(String value : values)
				{
					//System.out.println(value);
					if(!value.isEmpty())
					{
						//System.out.println(Integer.parseInt(value));
						row.add(Integer.parseInt(value));
					}
				}
				tempMap.add(row);
			}
			reader.close();
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
	    {
			
			e.printStackTrace();
	    }
		
		//int width=tempMap.get(0).size();
		//int height=tempMap.size();
		System.out.println(map.length);
		System.out.println(map[0].length);
		for(int i=0;i<mapHeight;i++)
		{
			for(int j=0;j<mapWidth;j++)
			{
				//System.out.println(tempMap.get(i).get(j));
				
				
				this.map[i][j]=tempMap.get(i).get(j);
			}
		}	
		
		
	}
	
	public Map(BufferedImage spriteSheet,int mapWidth,int mapHeight,int tileWidth,int tileHeight) 
	{
		this.SpriteSheet=spriteSheet;
		this.mapWidth=mapWidth;
		this.mapHeight=mapHeight;
		this.tileWidth=tileWidth;
		this.tileHeight=tileHeight;
	    map=new int[mapHeight][mapWidth];
	   
	    images=new BufferedImage[4];
	}
	
	public void renderMapToScreen(Graphics g) 
	{
		for(int i=0;i<mapHeight;i++)
		{
			for(int j=0;j<mapWidth;j++)
			{
				
				g.drawImage(images[map[i][j]],j*tileWidth,i*tileHeight,null);
			}
		}
		
			
			
		
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}

	public int getMapWidth() {
		return mapWidth;
	}

	public void setMapWidth(int mapWidth) {
		this.mapWidth = mapWidth;
	}

	public int getMapHeight() {
		return mapHeight;
	}

	public void setMapHeight(int mapHeight) {
		this.mapHeight = mapHeight;
	}

	public int getTileWidth() {
		return tileWidth;
	}

	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}

	public int getTileHeight() {
		return tileHeight;
	}

	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}
	
	
}