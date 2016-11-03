package enemys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import graphics.Animation;
import graphics.Vector2;
import main_package.ExtendenGameWindow;
import main_package.GameUtility;
import towers.Player;

public class Enemy 
{
	private BufferedImage heltImage;
	private boolean enabled;
	private ArrayList<ArrayList<Animation>> vrsteAnimacija;
	private ArrayList<Animation> animacije;
	private int x;
	private int y;
	private int width;
	private int height;
	private Vector2 speed;
	private int velocity;
	private int helts;
	private int startHelts;
	private int currentAinimation;
	private int currentWaypoint;
	private ArrayList<Vector2> waypoints;
	private Rectangle rectangle;
	private boolean hasEffect=false;
	private int currentVrsteAnimacija;
	
	
	
	public Enemy(int x,int y,int width,int height,ArrayList<Vector2> way)
	{
		
		currentVrsteAnimacija=0;
		startHelts=5;
		helts=startHelts;
		try {
			heltImage=GameUtility.loadImage("res/helt.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		enabled=false;
		velocity=4;
	    speed=new Vector2(0,velocity);
	    vrsteAnimacija=new ArrayList<ArrayList<Animation>>();
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
		//rectangle=new Rectangle(x, y, width, height);
		
	}
	
	public void update()
	{
		if(enabled==true)
		{
		followWaypoints();
		animatinCheck();
		vrsteAnimacija.get(currentVrsteAnimacija).get(currentAinimation).update();
		}
	}
	
	
	
	private void followWaypoints()
	{
		
		//Vector2 waypoint=waypoints.get(currentWaypoint);
		//double distance=GameUtility.distance(x,y,waypoint.getX(),waypoint.getY());
		if(currentWaypoint==waypoints.size() ||helts==0)
		{
			this.x=-50;
			this.y=50;
			enabled=false;
			ExtendenGameWindow.getInstance().getPlayer().setHelts(ExtendenGameWindow.getInstance().getPlayer().getHelts()-5);
			ExtendenGameWindow.getInstance().getPlayer().setDamaged(true);
			ExtendenGameWindow.getInstance().getPlayer().setDamagedStartTime(System.nanoTime());
			
			return;
		}
		Vector2 waypoint=waypoints.get(currentWaypoint);
		double distance=GameUtility.distance(x,y,waypoint.getX(),waypoint.getY());
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
		if(enabled==true)
		{
			
		g.drawImage(vrsteAnimacija.get(currentVrsteAnimacija).get(currentAinimation).getFrame(),x,y,null);
		g.setColor(Color.BLUE);
		g.fillRect(this.x+width/2-(startHelts*heltImage.getWidth())/2,y-5,startHelts*5,5);
		g.setColor(Color.WHITE);
		for(int i=0;i<helts;i++)
		{
			//g.setColor(Color.BLUE);
			//g.fillRect(this.x+width/2-(startHelts*heltImage.getWidth())/2,y-5,startHelts*5,5);
			g.drawImage(heltImage,this.x+width/2-(startHelts*heltImage.getWidth())/2+i*5,this.y-5,5,5,null);
		}
		}
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Vector2 getSpeed() {
		return speed;
	}

	public void setSpeed(Vector2 speed) {
		this.speed = speed;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getCurrentWaypoint() {
		return currentWaypoint;
	}

	public void setCurrentWaypoint(int currentWaypoint) {
		this.currentWaypoint = currentWaypoint;
	}

	public ArrayList<Vector2> getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(ArrayList<Vector2> waypoints) {
		this.waypoints = waypoints;
	}

	public BufferedImage getHeltImage() {
		return heltImage;
	}

	public void setHeltImage(BufferedImage heltImage) {
		this.heltImage = heltImage;
	}

	public int getHelts() {
		return helts;
	}

	public void setHelts(int helts) {
		this.helts = helts;
	}

	public int getStartHelts() {
		return startHelts;
	}

	public void setStartHelts(int startHelts) {
		this.startHelts = startHelts;
	}

	public Rectangle getRectangle() {
		return new Rectangle(x,y, width+30, height+30);
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public boolean isHasEffect() {
		return hasEffect;
	}

	public void setHasEffect(boolean hasEffect) {
		this.hasEffect = hasEffect;
	}

	public ArrayList<ArrayList<Animation>> getVrsteAnimacija() {
		return vrsteAnimacija;
	}

	public void setVrsteAnimacija(ArrayList<ArrayList<Animation>> vrsteAnimacija) {
		this.vrsteAnimacija = vrsteAnimacija;
	}

	public int getCurrentVrsteAnimacija() {
		return currentVrsteAnimacija;
	}

	public void setCurrentVrsteAnimacija(int currentVrsteAnimacija) {
		this.currentVrsteAnimacija = currentVrsteAnimacija;
	}

}
