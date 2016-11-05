package animacije;


import java.awt.Color;
import java.awt.Graphics;

import enemys.Enemy;
import graphics.Vector2;
import main_package.GameUtility;

public class Tornado extends Nabodi {
	particals[] part=new particals[152];
	int brParticla=152;
	Color color1,color2,color;
	int vreme=0;
	int prostlo=0;
	int velicina;
	double dx,dy;
	int tip;
	private Vector2 speed;
	
	public Tornado(int x,int y,double dx,double dy,Color color,Color c1,Color c2,int tip){
		super(x,y);
		this.dx=dx;
		this.dy=dy;
		color1=c1;
		color2=c2;
		this.color=color;
		velicina=20;
		speed=new Vector2(x, y);
		for(int i=0;i<brParticla;i++){
			part[i]=new particals(x, y, 0, 0, 1, c1,c2);
			//part[i].oziviGa(x, y, dx, dy);
		}
		this.tip=tip;
	}

	@Override
	public void Draw(Graphics g){
		
		g.setColor(new Color(color.getRed(),color.getGreen(),color.getBlue(),100));
		g.fillOval(x-velicina/2, y-velicina/2, velicina, velicina);
		g.setColor(color);
		g.drawOval(x-velicina/2-1, y-velicina/2-1, velicina+1,velicina+1);
		for(int i=0;i<brParticla;i++)
			if(part[i].ziv)
				part[i].Draw(g);
	}


	int najvecibr=0;
	@Override
	public void Update(Enemy enemy,int velocity) {

		double distance=GameUtility.distance(x,y,enemy.getX(),enemy.getY());
		speed.setX((int)((enemy.getX()+50-x)*velocity/distance));
		speed.setY((int)((enemy.getY()-y)*velocity/distance));

		dx=speed.getX();
		dy=speed.getY();

		x+=dx;
		y+=dy;
		int br=0;
		for(int i=0;i<brParticla;i++)
			if(part[i].ziv){
				br++;
				part[i].UpdateData(dx, dy);
				part[i].Update(null,0);
			}
		
	}

	public void setXY(int x,int y){
		for(int i=0;i<part.length;i++){
			part[i].oziviGa(x, y,0,0);
			}
		super.x=x;
		super.y=y;
	}
}
