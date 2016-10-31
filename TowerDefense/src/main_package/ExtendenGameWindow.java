package main_package;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import enemys.Enemy;
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
	
	
	
	public ExtendenGameWindow(int width, int height) 
	{
		super(width, height);	
		System.out.println(Math.toDegrees(Math.atan2(50,450)));
		
	}

	@Override
	public void load() 
	{
		animation1=new Animation();
		animation2=new Animation();
		animation3=new Animation();
		animation4=new Animation();
		slike1=new BufferedImage[3];
		slike2=new BufferedImage[3];
		slike3=new BufferedImage[3];
		slike4=new BufferedImage[3];
		
				
		try {
			background_images=ImageIO.read(new File("res/background_images.png"));
			spriteSheet=GameUtility.loadImage("res/orc.png");
			turetImage=GameUtility.loadImage("res/turet.png");
			for(int i=0;i<3;i++)
			{
				slike1[i]=GameUtility.cutImage(spriteSheet,i,3,50,50);
			}
			for(int i=0;i<3;i++)
			{
				slike2[i]=GameUtility.cutImage(spriteSheet,i,1,50,50);
			}
			for(int i=0;i<3;i++)
			{
				slike3[i]=GameUtility.cutImage(spriteSheet,i,0,50,50);
			}
			for(int i=0;i<3;i++)
			{
				slike4[i]=GameUtility.cutImage(spriteSheet,i,2,50,50);
			}
			animation1.setFrames(slike1);
			animation2.setFrames(slike2);
			animation3.setFrames(slike3);
			animation4.setFrames(slike4);
			
			
			
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
		
		enemy=new Enemy(spriteSheet,0,0,50,50,level1.getWaypoints());
		enemy.getAnimacije().add(animation1);
		enemy.getAnimacije().add(animation2);
		enemy.getAnimacije().add(animation3);
		enemy.getAnimacije().add(animation4);
		tower=new Tower(null,turetImage,500,500);
		
		
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
		enemy.update();
		tower.update(enemy);
		
	}

	@Override
	public void render(Graphics g) {
		level1.draw(g);
		enemy.draw(g);
		tower.draw(g);
		
		
		
	}
}

