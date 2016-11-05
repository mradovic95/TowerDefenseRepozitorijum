package animacije;

import java.awt.Graphics;

import enemys.Enemy;

public abstract class Nabodi {
	public int x,y;
	public Nabodi(int xp,int yp){
		x=xp;
		y=yp;
	}
	public abstract void Draw(Graphics g);
	public abstract void Update(Enemy enemy,int velocity);
	
}
