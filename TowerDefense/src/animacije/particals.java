package animacije;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import enemys.Enemy;

public class particals extends Nabodi {

	double dx,dy;
	int alpha=255;
	double xD,yD;
	int ugao;
	int tip,zivot,kolikoPostoji;
	Color color1,color2;
	boolean ziv;
	double pdx;
	double pdy;
	int velicina;
	int rotacija=0;
	Random r=new Random();
	public particals(int x,int y,double dx,double dy,int tip,Color c1,Color c2){
		super(x,y);
		this.dx=dx;
		this.dy=dy;
		this.tip=tip;
		this.color1=c1;
		this.color2=c2;
		ugao=0;
		kolikoPostoji=0;
		velicina=3;
	}
	
	

	@Override
	public void Draw(Graphics g) {
		if(ziv){
				crtanje(g);
		}
	}
	@Override
	public void Update(Enemy enemy,int velocity) {
		if(ziv){
			if(tip==0){
				cranjeUpdate0(pdx,pdy);
			}else if(tip==1){
				cranjeUpdate1(pdx,pdy);
			}else if(tip==2){
				cranjeUpdate2();
			}
		}
	}
	public void UpdateData(double pdx,double pdy){
		this.pdx=pdx;
		this.pdy=pdy;
	}
	
	
	
	public void crtanje(Graphics g){
		g.setColor(color1);
		g.fillOval(x-velicina/2, y, velicina, velicina/2);
		g.setColor(color2);
		g.drawOval(x-velicina/2, y,  velicina+1, velicina/2+1);

		g.setColor(color1);
		g.fillOval(x, y-velicina/2,  velicina/2, velicina);
		g.setColor(color2);
		g.drawOval(x, y-velicina/2,  velicina/2+1, velicina+1);
	}
	public void cranjeUpdate0(double pdx,double pdy){
		
		//ugao+=5;
		//double radijan=Math.toRadians(ugao);
		//double dx1,dy1;
		//dx1=dx*12*Math.sin(radijan);
		//dy1=dy*12*Math.cos(radijan);
		
		xD+=(dx)+pdx;
		yD+=(dy)+pdy;
		x=(int)xD;
		y=(int)yD;
		if(zivot-kolikoPostoji<=10)
			ziv=false;
		if(alpha>50)
		alpha-=30;
		else
			alpha=255;
		kolikoPostoji++;
		int prvi=(int) (pdx*dx*(-1.5));
		if(prvi<0)
			prvi=0;
		int drugi=(int) (pdy*dy*(-1.5));
		if(drugi<0)
			drugi=0;
		zivot=(int) (10*(prvi+drugi));
		if(zivot<10)
			zivot=15;
	}
	public void cranjeUpdate1(double pdx,double pdy){
		
		ugao+=15;
		double radijan=Math.toRadians(ugao);
		double dx1,dy1;
		dx1=dx*2*Math.sin(radijan);
		dy1=dy*2*Math.cos(radijan);
		
		xD+=(dx1)+pdx;
		yD+=(dy1)+pdy;
		x=(int)xD;
		y=(int)yD;
		//if(zivot-kolikoPostoji<=10)
			//ziv=false;
		if(alpha>50)
		alpha-=30;
		else
			alpha=255;
		kolikoPostoji++;
		int prvi=(int) (pdx*dx*(-1.5));
		if(prvi<0)
			prvi=0;
		int drugi=(int) (pdy*dy*(-1.5));
		if(drugi<0)
			drugi=0;
		zivot=(int) (10*(prvi+drugi));
		//if(zivot<10)
			zivot=1005;
	}
	
	public void cranjeUpdate2(){
		dx*=0.95;
		dy*=0.95;
		xD+=dx;
		yD+=dy;
		x=(int)xD;
		y=(int)yD;
		if(zivot-kolikoPostoji<=10)
			ziv=false;
		if(alpha>50)
		alpha-=30;
		else
			alpha=255;
		kolikoPostoji++;
		int prvi=(int) (pdx*dx*(-1.5));
		if(prvi<0)
			prvi=0;
		int drugi=(int) (pdy*dy*(-1.5));
		if(drugi<0)
			drugi=0;
		zivot=(int) (10*(prvi+drugi));
		//if(zivot<10)
			zivot=105;
	}
	
	
	public void oziviGa(int x,int y,double pdx,double pdy){
		this.pdx=pdx;
		this.pdy=pdy;
		
		ugao=r.nextInt(360);

		double radijan=Math.toRadians(ugao);
		if(tip==0){
		dx=(r.nextDouble()+1)*0.6*Math.cos(radijan);
		dy=(r.nextDouble()+1)*0.6*Math.sin(radijan);
		}else if(tip==1){
			ugao=r.nextInt(360);
			dx=(r.nextDouble()+1)*1.5;
			dy=(r.nextDouble()+1)*1.5;
			rotacija=r.nextInt(25)+5;
			
		}else if(tip==2){
			dx=(r.nextDouble())*0.1*Math.cos(radijan);
			dy=(r.nextDouble())*0.1*Math.sin(radijan);
			velicina=(int)(4-Math.abs((dx)*100));
			if((4-Math.abs((dx)*100))<2)
				velicina=2;
			else if((4-Math.abs((dx)*100))>3.8)
				velicina=(int)((4-Math.abs((dx)*100))*4);
			System.out.println(velicina);
			dx*=10;
			dy*=10;
		}
		
		this.xD=x;
		this.yD=y;
		this.x=x;
		this.y=y;
		ziv=true;
		int prvi=(int) (pdx*dx*(-1.5));
		if(prvi<0)
			prvi=0;
		int drugi=(int) (pdy*dy*(-1.5));
		if(drugi<0)
			drugi=0;
		zivot=(int) (10*(prvi+drugi));
		kolikoPostoji=0;
		if(zivot<20)
			zivot=25;
	}
	public void setXY(int x,int y){
		super.x=x;
		super.y=y;
	}
}
