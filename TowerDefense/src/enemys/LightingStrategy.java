package enemys;

public class LightingStrategy implements BulletStrategy
{
	
	
	@Override
	public void setEnemyEfect(Enemy enemy) 
	{	
		enemy.setCurrentVrsteAnimacija(3);
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
		enemy.setCurrentVrsteAnimacija(0);
		enemy.setHasEffect(false);
	}

	@Override
	public void update(Enemy enemy) {
		
		
	}
	
} 


