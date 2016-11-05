package towers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import enemys.EnemyManager;
import enemys.FireStrategy;
import enemys.FrostStrategy;
import enemys.LightingStrategy;
import enemys.WindStrategy;
import graphics.Animation;
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
	private BufferedImage[] manuBarIconsSelected;
	private boolean damaged;
	private long damagedStartTime;
	private int currentState;
	private BufferedImage turretImage;
	private BufferedImage turetTransparent;
	private BufferedImage turetRed;
	private Animation coinAnimation=new Animation();
	private BufferedImage[] coinImages;
	private int money;
	private int mouseX;
	private int mouseY;
	private boolean moze;
	
	
	//private ArrayList<Tower> towers;
	
	public Player(int startHelts) 
	{
		moze=false;
		money=200;
		try {
			turretImage=GameUtility.loadImage("res/turet.png");
			turetTransparent=GameUtility.getWindEffect(turretImage);
			turetRed=GameUtility.getFireEffect(turretImage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		towers=new ArrayList<Tower>();
		currentState=0;
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
			manuBarIconsSelected=new BufferedImage[4];
			manuBarIcons[0]=GameUtility.loadImage("res/fireball1.png");
			manuBarIcons[1]=GameUtility.loadImage("res/frost.png");
			manuBarIcons[2]=GameUtility.loadImage("res/arrow.png");
			manuBarIcons[3]=GameUtility.loadImage("res/melee.png");
			for(int i=0;i<manuBarIcons.length;i++)
			{
				manuBarIconsSelected[i]=GameUtility.addBrightness(manuBarIcons[i],100);
			}
			BufferedImage coinImage=GameUtility.loadImage("res/coin.png");
			coinImages=new BufferedImage[10];
			for(int i=0;i<10;i++)
			{
				coinImages[i]=GameUtility.cutImage(coinImage,i,0,60,60);
				
			}
			coinAnimation.setFrames(coinImages);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void update(EnemyManager manager)
	{
		for(Tower t:towers)
		{
			t.update(manager.enemyes);
		}
		if(damaged==true)
		{
			damagedTimer();
		}
		if(coinAnimation.isPlayedonce()==false)
		{
			coinAnimation.update();
		}
	}
	
	public void addTower(int x,int y)
	{
		Tower t=new Tower(null,turretImage,x, y);
		if(currentState==0)
		{
			t.setStrategy(new FireStrategy());
		}
		if(currentState==1)
		{
			t.setStrategy(new FrostStrategy());
		}
		if(currentState==2)
		{
			t.setStrategy(new WindStrategy());
		}
		if(currentState==3)
		{
			t.setStrategy(new LightingStrategy());
		}
		towers.add(t);
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
			if(currentState==i)
			{
				g.drawImage(manuBarIconsSelected[i],menuBarX+i*manuBarIcons[i].getWidth()+menuBarOffsetX*i,menuBarY,null);
			}
			else
			{
			g.drawImage(manuBarIcons[i],menuBarX+i*manuBarIcons[i].getWidth()+menuBarOffsetX*i,menuBarY,null);
			}
		}
		
		
		
			g.drawImage(coinAnimation.getFrame(),1400,800,null);
			g.setFont(new Font("Helvetica",Font.BOLD,50));
			g.drawString(""+money,1470,845);
		
		
		g.drawImage(heltBarImage,healtBarX,healttBarY,null);
		g.setColor(new Color(0,0,50,127));
		
		g.fillRect(healtBarX+5,healttBarY+5,heltBarImage.getWidth()-10,heltBarImage.getHeight()-10);
		g.setColor(new Color(200,0,0,127));
		int procenat=heltBarImage.getWidth()/100;
		int procenatHelta=startHelts/100*helts;
		g.fillRect(healtBarX+5,healttBarY+5,procenatHelta*procenat-10,heltBarImage.getHeight()-10);
		
		for(Tower t:towers)
		{
			t.draw(g);
		}
		if(damaged==true)
		{
			g.setColor(new Color(255,0,0,170));
			g.fillRect(0,0,2000,2000);
		}
		if(moze==true)
		{
		g.drawImage(turetTransparent,mouseX,mouseY,null);
		}
		else
		{
			g.drawImage(turetRed,mouseX,mouseY,null);
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

	public BufferedImage[] getManuBarIconsSelected() {
		return manuBarIconsSelected;
	}

	public void setManuBarIconsSelected(BufferedImage[] manuBarIconsSelected) {
		this.manuBarIconsSelected = manuBarIconsSelected;
	}

	public int getCurrentState() {
		return currentState;
	}

	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}

	public BufferedImage getTurretImage() {
		return turretImage;
	}

	public void setTurretImage(BufferedImage turretImage) {
		this.turretImage = turretImage;
	}

	public Animation getCoinAnimation() {
		return coinAnimation;
	}

	public void setCoinAnimation(Animation coinAnimation) {
		this.coinAnimation = coinAnimation;
	}

	public BufferedImage[] getCoinImages() {
		return coinImages;
	}

	public void setCoinImages(BufferedImage[] coinImages) {
		this.coinImages = coinImages;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public BufferedImage getTuretTransparent() {
		return turetTransparent;
	}

	public void setTuretTransparent(BufferedImage turetTransparent) {
		this.turetTransparent = turetTransparent;
	}

	public int getMouseX() {
		return mouseX;
	}

	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}

	public BufferedImage getTuretRed() {
		return turetRed;
	}

	public void setTuretRed(BufferedImage turetRed) {
		this.turetRed = turetRed;
	}

	public boolean isMoze() {
		return moze;
	}

	public void setMoze(boolean moze) {
		this.moze = moze;
	}

}
