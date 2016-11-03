package towers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import main_package.GameUtility;

public class Player 
{
	private ArrayList<Tower> towers;
	private int helts;
	private int startHelts;
	private BufferedImage heltBarImage;
	private int healtBarX;
	private int healttBarY;
	private int menuBarX;
	private int menuBarY;
	private int menuBarOffsetX;
	private BufferedImage[] manuBarIcons;
	private boolean damaged;
	private long damagedStartTime;
	
	public Player(int startHelts) 
	{
		this.startHelts=startHelts;
		this.helts=startHelts;
		healtBarX=1400;
		healttBarY=900;
		menuBarOffsetX=50;
		menuBarY=850;
		menuBarX=600;
		
	}
	
	public void load()
	{
		try {
			heltBarImage=GameUtility.loadImage("res/healthbar.png");
			manuBarIcons=new BufferedImage[4];
			manuBarIcons[0]=GameUtility.loadImage("res/fireball1.png");
			manuBarIcons[1]=GameUtility.loadImage("res/frost.png");
			manuBarIcons[2]=GameUtility.loadImage("res/arrow.png");
			manuBarIcons[3]=GameUtility.loadImage("res/melee.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void update()
	{
		if(damaged==true)
		{
			damagedTimer();
		}
	}
	
	private void damagedTimer()
	{
		long damagedElapsedTime=(System.nanoTime()-damagedStartTime)/1000000;
		//System.out.println("start+time"+damagedStartTime/1000000);
		//System.out.println("time"+System.nanoTime()/1000000);
		if(damagedElapsedTime>500)
		{
			//System.out.println("?????????????????????????????????????????????????????????????????????????????????????????????????????????");
			damaged=false;
		}
	}
	
	
	public void draw(Graphics g)
	{
		
		for(int i=0;i<manuBarIcons.length;i++)
		{
			g.drawImage(manuBarIcons[i],menuBarX+i*manuBarIcons[i].getWidth()+menuBarOffsetX*i,menuBarY,null);
		}
		
		
		g.drawImage(heltBarImage,healtBarX,healttBarY,null);
		g.setColor(new Color(0,0,50,127));
		
		g.fillRect(healtBarX+5,healttBarY+5,heltBarImage.getWidth()-10,heltBarImage.getHeight()-10);
		g.setColor(new Color(200,0,0,127));
		int procenat=heltBarImage.getWidth()/100;
		int procenatHelta=startHelts/100*helts;
		g.fillRect(healtBarX+5,healttBarY+5,procenatHelta*procenat-10,heltBarImage.getHeight()-10);
		if(damaged==true)
		{
			g.setColor(new Color(255,0,0,170));
			g.fillRect(0,0,2000,2000);
		}
		
	}

	public ArrayList<Tower> getTowers() {
		return towers;
	}

	public void setTowers(ArrayList<Tower> towers) {
		this.towers = towers;
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

	public BufferedImage getHeltBarImage() {
		return heltBarImage;
	}

	public void setHeltBarImage(BufferedImage heltBarImage) {
		this.heltBarImage = heltBarImage;
	}

	public int getHealtBarX() {
		return healtBarX;
	}

	public void setHealtBarX(int healtBarX) {
		this.healtBarX = healtBarX;
	}

	public int getHealttBarY() {
		return healttBarY;
	}

	public void setHealttBarY(int healttBarY) {
		this.healttBarY = healttBarY;
	}

	public int getMenuBarX() {
		return menuBarX;
	}

	public void setMenuBarX(int menuBarX) {
		this.menuBarX = menuBarX;
	}

	public int getMenuBarY() {
		return menuBarY;
	}

	public void setMenuBarY(int menuBarY) {
		this.menuBarY = menuBarY;
	}

	public int getMenuBarOffsetX() {
		return menuBarOffsetX;
	}

	public void setMenuBarOffsetX(int menuBarOffsetX) {
		this.menuBarOffsetX = menuBarOffsetX;
	}

	public BufferedImage[] getManuBarIcons() {
		return manuBarIcons;
	}

	public void setManuBarIcons(BufferedImage[] manuBarIcons) {
		this.manuBarIcons = manuBarIcons;
	}

	public boolean isDamaged() {
		return damaged;
	}

	public void setDamaged(boolean damaged) {
		this.damaged = damaged;
	}

	public long getDamagedStartTime() {
		return damagedStartTime;
	}

	public void setDamagedStartTime(long damagedStartTime) {
		this.damagedStartTime = damagedStartTime;
	}

}
