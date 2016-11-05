package enemys;

public class LightingStrategy implements BulletStrategy
{
	
	
	@Override
	public void setEnemyEfect(Enemy enemy) 
	{	
		enemy.setCurrentVrsteAnimacija(3);
		enemy.setVelocity(0);
		enemy.setStun(true);
		enemy.setStarX(enemy.getX()-25);
		enemy.setStarY(enemy.getY());
		//if(Math.abs(enemy.getSpeed().getX())>0)
		//{
		//	enemy.setX(enemy.getX()-100);
		//}
		//if(enemy.getSpeed().getY()>0)
		//{
			//enemy
		//}
		//enemy.setHelts(enemy.getHelts()-1);
		//enemy.setVelocity(enemy.getVelocity()-3);
		enemy.setHasEffect(true);
	}

	@Override
	public void clearEfect(Enemy enemy) 
	{
		//enemy.setVelocity(enemy.getVelocity()+3);
		//for(int i=0;i<enemy.getAnimacije().size();i++)
		//{
		//	enemy.getAnimacije().get(i).setDelay(enemy.getAnimacije().get(i).getDelay()/2);
		//}
		enemy.setVelocity(4);
		enemy.setCurrentVrsteAnimacija(0);
		enemy.setHasEffect(false);
		enemy.setStun(false);
		
	}

	@Override
	public void update(Enemy enemy) {
		
		
	}
	
} 


