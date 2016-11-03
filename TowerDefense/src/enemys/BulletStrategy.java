package enemys;

public interface BulletStrategy 
{
	public void setEnemyEfect(Enemy enemy);
	public void clearEfect(Enemy enemy);
	public void update(Enemy enemy);
}
