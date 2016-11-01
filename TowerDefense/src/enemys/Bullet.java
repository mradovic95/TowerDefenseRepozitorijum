package enemys;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import graphics.Vector2;
import main_package.GameUtility;

public class Bullet 
{
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
	
	public Bullet(int x,int y,int width,int heigth) 
	{
		enabled=true;
		speed=new Vector2(0,0);
		velocity=15;
		this.x=x;
		this.y=y;
		this.width=width;
		this.heigth=heigth;
		rectangle=new Rectangle(x, y,width,heigth);
		this.damage=1;
	}
	
	public void setDirection(Enemy target)
	{
		double distance=GameUtility.distance(x,y,target.getX(),target.getY());
		speed.setX((int)((target.getX()+50-this.x)*velocity/distance));
		speed.setY((int)((target.getY()-this.y)*velocity/distance));
		//this.x+=speed.getX();
		//this.y+=speed.getY();
	}
	
	public void update()
	{
		if(enabled==true)
		{
		this.x+=speed.getX();
		this.y+=speed.getY();
		}
	}
	
	public void draw(Graphics g)
	{
		if(enabled==true)
		{
		g.drawImage(image, x,y,null);
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
		return new Rectangle(x,y,50,50);
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

}
