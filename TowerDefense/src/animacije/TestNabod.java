package animacije;

import java.awt.Color;
import java.awt.Graphics;

import enemys.Enemy;
import graphics.Vector2;
import main_package.GameUtility;

public class TestNabod extends Nabodi {
	particals[] part=new particals[170];
	int brParticla=170;
	Color color1,color2;
	int vreme=0;
	int prostlo=0;
	int velicina;
	double dx,dy;
	int tip;
	private Vector2 speed;
	//int kolicina;
	public TestNabod(int x,int y,double dx,double dy,Color c1,Color c2,int tip){
		super(x,y);
		this.dx=dx;
		this.dy=dy;
		color1=c1;
		color2=c2;
		velicina=15;
		speed=new Vector2(x, y);
		for(int i=0;i<brParticla;i++)
			part[i]=new particals(x, y, 0, 0, 0, c1,c2);
		this.tip=tip;
	}
	
	
	
	@Override
	public void Draw(Graphics g){
		g.setColor(color1);
		g.fillOval(x-velicina/2, y-velicina/2, velicina, velicina);
		g.setColor(color2);
		g.drawOval(x-velicina/2-1, y-velicina/2-1, velicina+1,velicina+1);
		for(int i=0;i<brParticla;i++)
			if(part[i].ziv)
				part[i].Draw(g);
	}


	int najvecibr=0;
	@Override
	public void Update(Enemy enemy,int velocity ) {

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
		if(vreme<=0){
			vreme=2;
			int sto=0;
			for(int i=0;i<brParticla;i++)
				if(!part[i].ziv && sto<20){
					sto++;
					part[i].oziviGa(x,y,dx, dy);
				}
		}
		vreme--;
	}
	public void setXY(int x,int y){
		super.x=x;
		super.y=y;
	}

}
