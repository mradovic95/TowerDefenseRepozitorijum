package towers;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import enemys.Enemy;

public class Tower 
{
	private int x;
	private int y;
	private BufferedImage towerImage;
	private BufferedImage turetImage;
	AffineTransform tranform;
	private double angle;
	
	public Tower(BufferedImage towerImage,BufferedImage turetImage,int x,int y) 
	{
		//tranform=new AffineTransform();
		this.towerImage=towerImage;
		this.turetImage=turetImage;
		this.x=x;
		this.y=y;
	}
	
	public void update(Enemy enemy)
	{
		
         
		   
         angle=Math.atan2((enemy.getX()-x),(enemy.getY()-y)*-1);
        // System.out.println(x);
         //System.out.println(enemy.getX());
         //System.out.println(y);
         //System.out.println(enemy.getY());
         
         //System.out.println(Math.toDegrees(Math.atan2(enemy.getX()-x,enemy.getY()-y)));
		  // AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

		    //20, 20 is a height and width of img ofc
		   //BufferedImage newImage =new BufferedImage(50, 50, turetImage.getType());
		   //op.filter(newImage,turetImage);
		   //this.turetImage=newImage;
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

}
