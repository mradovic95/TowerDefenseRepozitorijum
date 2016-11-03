package main_package;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

public abstract class GameWindow extends Canvas implements KeyListener
{
	
	/**
	 * The width of the game screen.
	 */
	private int width;
	/**
	 * The height of the game screen.
	 */
	private int height;
	
	/**
	 * Instance of MainThread class.
	 * 
	 */
	private MainThread mainThread;
		
	public GameWindow(int width,int height) 
	{
		this.width=width;
		this.height=height;
		mainThread=new MainThread(this);
	}
	
	/**
	 * This method call {@link #load()} method,add the key listener to the JFrame who contains this window 
	 * and start mainThread.
	 */
	public void start()
	{
		load();
		Container parrent=this.getParent();
		while(parrent.getParent()!=null)
		{
			parrent=parrent.getParent();
		}
		parrent.addKeyListener(this);	
		//parrent.addMouseListener(this);
		mainThread.setRunning(true);
		mainThread.start();
	}
	/**
	In this method user initialize some objects and load images,spreteSheets 
	and other content.
	*/
	public abstract void load();
	/**
	In this method can add new objects,change parameters of objects,delete objects and do other
	thing to add dynamic to game.
	*/
	public abstract void update();
	/**
	 * In this method user decide which objects draw to screen.
	 * @param g graphics
	 */
	public abstract void render(Graphics g);
	
	/**
	 * This method do all preparations before draw objects to the screen. It call {@link #render(Graphics)} 
	 * method every time.With this method user dont worry about preparations and other technical things.
	 * User only decide what to draw in render method. 
	 * At the end this method show objects and release resources. 
	 */
	public void draw()
	{
		BufferStrategy bs=this.getBufferStrategy();
		if(bs==null)
		{
			System.out.println("Bs==null");
			createBufferStrategy(3);
			return;
		}
		Graphics g=bs.getDrawGraphics();
		g.setColor(Color.lightGray);
		g.fillRect(0,0, width, height);
		g.setColor(Color.WHITE);
		render(g);
		
		g.dispose();
		bs.show();
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
}
