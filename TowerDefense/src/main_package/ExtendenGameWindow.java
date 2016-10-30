package main_package;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import map.Map;

public class ExtendenGameWindow extends GameWindow
{
	
	
	Map map;
	BufferedImage background_images;
	public ExtendenGameWindow(int width, int height) 
	{
		super(width, height);	
		
		
	}

	@Override
	public void load() 
	{
		try {
			background_images=ImageIO.read(new File("res/background_images.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(background_images);
		map=new Map(background_images,34,14,50,50);
		map.load("res/mapica.txt");
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		map.renderMapToScreen(g);
		
	}
}

