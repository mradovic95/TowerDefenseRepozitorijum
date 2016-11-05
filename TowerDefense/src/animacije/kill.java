package animacije;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import enemys.Enemy;

public class kill extends Nabodi {
	particals[] partikli=new particals[100];
	boolean napravio=false;
	int ponovo=105;
	public kill(int x,int y,Color c1,Color c2){
		super(x,y);
		
		
		for(int i=0;i<partikli.length;i++){
			partikli[i]=new particals(x, y, 0, 0, 2, c1, c2);
		}
	}

	@Override
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub
		for(int i=0;i<partikli.length;i++)
			partikli[i].Draw(g);
	}

	@Override
	public void Update(Enemy enemy,int velocity) {
		// TODO Auto-generated method stub
		if(!napravio){
			napravio=true;
			for(int i=0;i<partikli.length;i++)
				partikli[i].oziviGa(x, y, 0, 0);
		}
		for(int i=0;i<partikli.length;i++)
			partikli[i].Update(null,0);
	}

}
