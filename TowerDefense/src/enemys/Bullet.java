package enemys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import animacije.TestNabod;
import animacije.Tornado;
import graphics.Vector2;
import main_package.GameUtility;

public class Bullet 
{
	Tornado tn=new Tornado(0, 0, 0, 0, new Color(255,0,0), new Color(255,155,110), new Color(0,0,0), 0);
	private int x;
	private int y;
	private int width;
	private int heigth;
	private BufferedImage image;
	private Vector2 speed;
	private int velocity;
	private int damage;
	private Rectangle rectangle;
	private boolean enabled;
	private Enemy enemy;
	//private boolean hasEffect=false;
	private boolean spicio=false;
	private long efectStartTime;
	private long effectDuration=5000;
	BulletStrategy bulletStrategy;
	
	
	public Bullet(int x,int y,int width,int heigth) 
	{
		enabled=true;
		speed=new Vector2(0,0);
		velocity=10;
		this.x=x;
		this.y=y;
		this.width=width;
		this.heigth=heigth;
		rectangle=new Rectangle(x, y,width,heigth);
		this.damage=1;
		this.bulletStrategy=new FireStrategy();
		tn.setXY(x, y);
	}
	
	/*
	public void setDirection(Enemy target)
	{
		double distance=GameUtility.distance(x,y,target.getX(),target.getY());
		speed.setX((int)((target.getX()+50-this.x)*velocity/distance));
		speed.setY((int)((target.getY()-this.y)*velocity/distance));
		//this.x+=speed.getX();
		//this.y+=speed.getY();
	}
	*/
	
	private void checkEffect()
	{
		long effectElapsedTime=(System.nanoTime()-efectStartTime)/1000000;
		if(effectElapsedTime>effectDuration)
		{
			
			enemy.setHasEffect(false);
			spicio=false;
			bulletStrategy.clearEfect(enemy);
		}
		
	}
	
	public void update()
	{
		if(spicio==true)
		{
			bulletStrategy.update(enemy);
			
			checkEffect();
		}
		if(enabled==true)
		{
			tn.Update(enemy, velocity);
			if(enemy.isEnabled()==false)
			{
				//setX(-1000);
				enabled=false;
				//System.out.println("Pao je na falseeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
			}
			double distance=GameUtility.distance(x,y,enemy.getX(),enemy.getY());
			speed.setX((int)((enemy.getX()-this.x)*velocity/distance));
			speed.setY((int)((enemy.getY()-this.y)*velocity/distance));
		this.x+=speed.getX();
		this.y+=speed.getY();
		}
	}
	
	public void draw(Graphics g)
	{
		if(enabled==true)
		{
		tn.Draw(g);
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

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
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

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public Rectangle getRectangle() {
		return new Rectangle(x,y,5,5);
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Enemy getEnemy() {
		return enemy;
	}

	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}

	public boolean isSpicio() {
		return spicio;
	}

	public void setSpicio(boolean spicio) {
		this.spicio = spicio;
	}

	public long getEfectStartTime() {
		return efectStartTime;
	}

	public void setEfectStartTime(long efectStartTime) {
		this.efectStartTime = efectStartTime;
	}

	public long getEffectDuration() {
		return effectDuration;
	}

	public void setEffectDuration(long effectDuration) {
		this.effectDuration = effectDuration;
	}

	public BulletStrategy getBulletStrategy() {
		return bulletStrategy;
	}

	public void setBulletStrategy(BulletStrategy bulletStrategy) {
		this.bulletStrategy = bulletStrategy;
	}

}
