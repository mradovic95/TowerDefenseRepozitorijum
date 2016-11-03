package enemys;

public class FrostStrategy implements BulletStrategy
{
	@Override
	public void setEnemyEfect(Enemy enemy) 
	{	
		//enemy.setHelts(enemy.getHelts()-1);
		enemy.setCurrentVrsteAnimacija(1);
		enemy.setVelocity(enemy.getVelocity()-3);
		for(int i=0;i<enemy.getAnimacije().size();i++)
		{
			enemy.getAnimacije().get(i).setDelay(enemy.getAnimacije().get(i).getDelay()*2);
		}
		enemy.setHasEffect(true);
	}

	@Override
	public void clearEfect(Enemy enemy) 
	{
		//enemy.setCurrentVrsteAnimacija(0);
		enemy.setVelocity(enemy.getVelocity()+3);
		for(int i=0;i<enemy.getAnimacije().size();i++)
		{
			enemy.getAnimacije().get(i).setDelay(enemy.getAnimacije().get(i).getDelay()/2);
		}
		enemy.setCurrentVrsteAnimacija(0);
		enemy.setHasEffect(false);
	}

	@Override
	public void update(Enemy enemy) {
		// TODO Auto-generated method stub
		
	}
	
}
