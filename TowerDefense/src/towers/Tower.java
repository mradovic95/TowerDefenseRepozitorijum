package towers;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import enemys.Bullet;
import enemys.BulletStrategy;
import enemys.Enemy;
import graphics.Vector2;
import main_package.GameUtility;

public class Tower 
{
	private int x;
	private int y;
	private BufferedImage towerImage;
	private BufferedImage turetImage;
	AffineTransform tranform;
	private double angle;
	private Enemy target=null;
	private double radius;
	ArrayList<Bullet> bullets;
	private long fireStartTime;
	private long FireTime;
	private BulletStrategy strategy=null;
	
	public Tower(BufferedImage towerImage,BufferedImage turetImage,int x,int y) 
	{
		bullets=new ArrayList<Bullet>();
		//tranform=new AffineTransform();
		this.towerImage=towerImage;
		this.turetImage=turetImage;
		this.x=x;
		this.y=y;
		radius=1000;
		FireTime=1000;
		fireStartTime=System.nanoTime();
	}
	
	public void update(ArrayList<Enemy> enemyes)
	{
		
         
		 getClosestEnemy(enemyes);
		 if(target!=null)
		 {
			 long elapsedFireTime=(System.nanoTime()-fireStartTime)/1000000;
			 if(elapsedFireTime>FireTime)
			 {
         angle=Math.atan2((target.getX()+50-x),(target.getY()-y)*-1);
         Bullet b=new Bullet(x+25,y+25,5,5);
         b.setBulletStrategy(strategy);
         b.setEnemy(target);
         
         try {
			b.setImage(GameUtility.loadImage("res/helt.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         //b.setDirection(target);
         bullets.add(b);
             fireStartTime=System.nanoTime();
			 }
		 } 
		 for(Bullet b:bullets)
		 {
			 //System.out.println("Target"+enemyes.indexOf(target));
			 b.update();
			 if(b.getRectangle().intersects(b.getEnemy().getRectangle()))
			 {
				 if(b.getEnemy().isHasEffect()==false)
				 {
				 
				 //b.setEnemy(target);
				 b.getBulletStrategy().setEnemyEfect(b.getEnemy());
				 b.setSpicio(true);
				 b.setEfectStartTime(System.nanoTime());
				 b.getEnemy().setHasEffect(true);
				 }
				 
				 //System.out.println("Udariloooooooooooooooooooooooooooooooooooooooooooo");
				 b.setX(-1000);
				 b.setEnabled(false);
				 
				 
				 b.getEnemy().setHelts(b.getEnemy().getHelts()-b.getDamage());
				 //target.setEnabled(false);
				 //target.setX(-50);
				 //target.setY(50);
			 }
		 }
		 
        
	}
	
	private void getClosestEnemy(ArrayList<Enemy> enemyes)
	{
		target=null;
		double smalestRange=radius;
		for(Enemy e:enemyes)
		{
			if(e.isEnabled())
			{
			if(GameUtility.distance(x,y,e.getX(),e.getX())<smalestRange )
			{
				smalestRange=GameUtility.distance(x,y,e.getX(),e.getX());
				target=e;
			}
			}
		}
	}
	
	public void draw(Graphics g)
	{
		AffineTransform transform=new AffineTransform();
		//transform.setToIdentity();
		transform.translate(x,y);
		System.out.println(Math.toDegrees(angle));
		transform.rotate(angle,25,25);
		
		//transform.translate(25,25);
		 Graphics2D gr=(Graphics2D)g;
		gr.drawImage(turetImage,transform,null);
		for(Bullet b:bullets)
		 {
			 b.draw(g);
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

	public BufferedImage getTowerImage() {
		return towerImage;
	}

	public void setTowerImage(BufferedImage towerImage) {
		this.towerImage = towerImage;
	}

	public BufferedImage getTuretImage() {
		return turetImage;
	}

	public void setTuretImage(BufferedImage turetImage) {
		this.turetImage = turetImage;
	}

	public AffineTransform getTranform() {
		return tranform;
	}

	public void setTranform(AffineTransform tranform) {
		this.tranform = tranform;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public Enemy getTarget() {
		return target;
	}

	public void setTarget(Enemy target) {
		this.target = target;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public ArrayList<Bullet> getBullets() {
		return bullets;
	}

	public void setBullets(ArrayList<Bullet> bullets) {
		this.bullets = bullets;
	}

	public long getFireStartTime() {
		return fireStartTime;
	}

	public void setFireStartTime(long fireStartTime) {
		this.fireStartTime = fireStartTime;
	}

	public long getFireTime() {
		return FireTime;
	}

	public void setFireTime(long fireTime) {
		FireTime = fireTime;
	}

	public BulletStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(BulletStrategy strategy) {
		this.strategy = strategy;
	}

}
