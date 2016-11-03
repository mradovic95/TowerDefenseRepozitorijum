package enemys;

public class FireStrategy implements BulletStrategy
{
	private long burnStartTime;
	
	@Override
	public void setEnemyEfect(Enemy enemy) 
	{	
		enemy.setCurrentVrsteAnimacija(2);
		burnStartTime=System.nanoTime();
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
		long elapsedBurnTime=(System.nanoTime()-burnStartTime)/1000000;
		if(elapsedBurnTime>2000)
		{
			if(enemy.getHelts()>0)
			{
				enemy.setHelts(enemy.getHelts()-1);
				burnStartTime=System.nanoTime();
			}
		}
		
	}
	
}


