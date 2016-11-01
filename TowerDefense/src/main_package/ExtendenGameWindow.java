package main_package;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import enemys.Enemy;
import enemys.EnemyManager;
import graphics.Animation;
import graphics.Vector2;
import map.Level;
import map.Map;
import towers.Tower;

public class ExtendenGameWindow extends GameWindow
{
	
	
	Map map;
	BufferedImage background_images;
	BufferedImage spriteSheet;
	Level level1;
	Enemy enemy;
	Animation animation1;
	Animation animation2;
	Animation animation3;
	Animation animation4;
	BufferedImage slike1[];
	BufferedImage slike2[];
	BufferedImage slike3[];
	BufferedImage slike4[];
	BufferedImage turetImage;
	Tower tower;
	EnemyManager manager;
	
	
	
	public ExtendenGameWindow(int width, int height) 
	{
		super(width, height);	
		System.out.println(Math.toDegrees(Math.atan2(50,450)));
		
	}

	@Override
	public void load() 
	{
		
		
				
		try {
			background_images=ImageIO.read(new File("res/background_images.png"));
			
			turetImage=GameUtility.loadImage("res/turet.png");
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map=new Map(background_images,34,14,50,50);
		map.load("res/mapica.txt");
		level1=new Level(map);
		level1.addWaypoints(new Vector2(0,50),new Vector2(1350,50),new Vector2(1350,250),new Vector2(150,250),
				new Vector2(150,600),
				new Vector2(450,600),new Vector2(450,400),new Vector2(1050,400),
				new Vector2(1050,600),new Vector2(1650,600),new Vector2(1650,650));
		manager=new EnemyManager(level1);
		manager.load();
		
		
		tower=new Tower(null,turetImage,200,200);
		
		
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
		manager.update();
		tower.update(manager.enemyes);
		
	}

	@Override
	public void render(Graphics g) {
		level1.draw(g);
		manager.draw(g);
		tower.draw(g);
		
		
		
	}
}

