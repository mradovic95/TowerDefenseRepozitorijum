package enemys;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import graphics.Animation;
import graphics.Vector2;
import main_package.GameUtility;

public  class Enemy 
{
	private ArrayList<Animation> animacije;
	private int x;
	private int y;
	private int width;
	private int height;
	private Vector2 speed;
	private int velocity;
	
	private int currentAinimation;
	private int currentWaypoint;
	private ArrayList<Vector2> waypoints;
	public Enemy(BufferedImage SpriteSheet,int x,int y,int width,int height,ArrayList<Vector2> way)
	{
		velocity=2;
	    speed=new Vector2(0,velocity);
		animacije=new ArrayList<Animation>();
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		currentAinimation=0;  
		currentWaypoint=0;
		waypoints=new ArrayList<Vector2>();
		for(Vector2 point :way)
		{
			waypoints.add(point);
			System.out.println(point);
		}
		
	}
	
	public void update()
	{
		followWaypoints();
		animatinCheck();
		animacije.get(currentAinimation).update();
	}
	
	private void followWaypoints()
	{
		
		Vector2 waypoint=waypoints.get(currentWaypoint);
		double distance=GameUtility.distance(x,y,waypoint.getX(),waypoint.getY());
		if(currentWaypoint==waypoints.size())
		{
			this.x=-1000;
		}
		System.out.println("distance"+distance+"  speedx"+speed.getX()+"    speedy"+speed.getY());
		if(distance<Math.abs(speed.getX()) ||distance<Math.abs(speed.getY()))
		{
			System.out.println("usao1");
			this.x=waypoint.getX();
			this.y=waypoint.getY();
			currentWaypoint++;
			System.out.println(currentWaypoint);
		}
		else
		{
			System.out.println("usao2");
			speed.setX((int)((waypoint.getX()-this.x)*velocity/distance));
			speed.setY((int)((waypoint.getY()-this.y)*velocity/distance));
			this.x+=speed.getX();
			this.y+=speed.getY();
		}
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(animacije.get(currentAinimation).getFrame(),x,y,null);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	private void animatinCheck()
	{
		if(speed.getX()<0 && speed.getY()==0)
		{
			currentAinimation=0;
		}
		if(speed.getX()>0 && speed.getY()==0)
		{
			currentAinimation=1;
		}
		if(speed.getX()==0 && speed.getY()<0)
		{
			currentAinimation=2;
		}
		if(speed.getX()==0 && speed.getY()>0)
		{
			currentAinimation=3;
		}
	}

	

	public ArrayList<Animation> getAnimacije() {
		return animacije;
	}

	public void setAnimacije(ArrayList<Animation> animacije) {
		this.animacije = animacije;
	}

	public int getCurrentAinimation() {
		return currentAinimation;
	}

	public void setCurrentAinimation(int currentAinimation) {
		this.currentAinimation = currentAinimation;
	}

}
