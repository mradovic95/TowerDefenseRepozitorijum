package enemys;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import graphics.Animation;
import main_package.GameUtility;
import map.Level;

public class EnemyManager 
{
	public ArrayList<Enemy> enemyes;
	private BufferedImage spriteSheet;
	private Animation animation1;
    private Animation animation2;
	private Animation animation3;
	private Animation animation4;
	private BufferedImage slike1[];
	private BufferedImage slike2[];
	private BufferedImage slike3[];
    private	BufferedImage slike4[];
	private Level lvl;
	private long addEnemyTime=1500;
	private int currentEnemy;
	private long startTime;
	
	
	public EnemyManager(Level lvl)
	{
		this.lvl=lvl;
		currentEnemy=0;
	}
	
	public void load()
	{
		enemyes=new ArrayList<Enemy>();
		currentEnemy=0;
		animation1=new Animation();
		animation2=new Animation();
		animation3=new Animation();
		animation4=new Animation();
		slike1=new BufferedImage[3];
		slike2=new BufferedImage[3];
		slike3=new BufferedImage[3];
		slike4=new BufferedImage[3];
		
				
		try {	
			spriteSheet=GameUtility.loadImage("res/orc.png");
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
			for(int i=0;i<20;i++)
			{
				Enemy en=new Enemy(-50,50,50,50,lvl.getWaypoints());
				en.getAnimacije().add(animation1);
				en.getAnimacije().add(animation2);
				en.getAnimacije().add(animation3);
				en.getAnimacije().add(animation4);
				enemyes.add(en);
				
			}
			startTime=System.nanoTime();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update()
	{
		
		long elapseTime=(System.nanoTime()-startTime)/1000000;
		System.out.println(elapseTime);
		if(elapseTime>addEnemyTime)
		{
			
			enemyes.get(currentEnemy++).setEnabled(true);
			startTime=System.nanoTime();
		}
		if(currentEnemy==enemyes.size())
		{
			currentEnemy=0;
		}
		
		for(Enemy en:enemyes)
		{
			if(en.isEnabled()==true)
			{
				en.update();
			}
		}
		
		
		
	}
	
	public void draw(Graphics g)
	{
		for(Enemy en:enemyes)
		{
			if(en.isEnabled()==true)
			{
				en.draw(g);
			}
		}
	}

}
