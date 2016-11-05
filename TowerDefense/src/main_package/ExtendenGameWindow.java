package main_package;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import enemys.Enemy;
import enemys.EnemyManager;
import graphics.Animation;
import graphics.Vector2;
import map.Level;
import map.Map;
import towers.Player;
import towers.Tower;

public class ExtendenGameWindow extends GameWindow implements MouseListener,MouseMotionListener
{
	
	private static ExtendenGameWindow instance;
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
	//Tower tower;
	EnemyManager manager;
	ArrayList<Tower> towers;
	Player player;
	
	
	
	private ExtendenGameWindow(int width, int height) 
	{
		//setFocusable(true);
		super(width, height);	
		setFocusable(true);
		System.out.println(Math.toDegrees(Math.atan2(50,450)));
		towers=new ArrayList<Tower>();
		player=new Player(100);
		
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
		addMouseListener(this);
		addKeyListener(this);
		addMouseMotionListener(this);
		//setFocusable(true);
		
		player.load();
		
		//tower=new Tower(null,turetImage,200,200);
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		System.out.println("pritisnutoooooooooooooooo");
		if(e.getKeyCode()==KeyEvent.VK_1)
		{
			player.setCurrentState(0);
			
		}
		if(e.getKeyCode()==KeyEvent.VK_2)
		{
			player.setCurrentState(1);
		}
		if(e.getKeyCode()==KeyEvent.VK_3)
		{
			player.setCurrentState(2);

		}
		if(e.getKeyCode()==KeyEvent.VK_4)
		{
			player.setCurrentState(3);
		}
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
		//tower.update(manager.enemyes);
		
		player.update(manager);
	}

	@Override
	public void render(Graphics g) {
		level1.draw(g);
		manager.draw(g);
		//tower.draw(g);
		
		player.draw(g);
		
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		int x=e.getX();
		int y=e.getY();
		int poljeX=x/level1.getMap().getTileWidth();
		int poljeY=y/level1.getMap().getTileHeight();
		//Tower t=new Tower(null,turetImage,poljeX*level1.getMap().getTileWidth(),poljeY*level1.getMap().getTileHeight());
		//towers.add(t);
		if(player.isMoze()==true && player.getMoney()>=100)
		{
		player.addTower(poljeX*level1.getMap().getTileWidth(),poljeY*level1.getMap().getTileHeight());
		player.setMoney(player.getMoney()-200);
		}
		//player.draw(g);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static ExtendenGameWindow getInstance() {
		if(instance==null)
		{
			instance=new ExtendenGameWindow(1750,1000);
		}
		return instance;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int x=e.getX();
		int y=e.getY();
		int poljeX=x/level1.getMap().getTileWidth();
		int poljeY=y/level1.getMap().getTileHeight();
		player.setMouseX(poljeX*level1.getMap().getTileWidth());
		player.setMouseY(poljeY*level1.getMap().getTileHeight());
		if(poljeX>level1.getMap().getMapWidth() || poljeY>level1.getMap().getMapHeight())			
		{
			player.setMoze(false);
		}
		else
		{
			if(level1.getMap().getMap()[poljeY][poljeX]==1)
			{
				player.setMoze(false);
			}
			else {
				player.setMoze(true);
			}
			//player.setMoze(true);
		}
		
	}

	

	

	
}

