package graphics;

public class Vector2 
{
	private int x;
	private int y;
	
	public Vector2(int x,int y) 
	{
		this.x=x;
		this.y=y;
	}
	
	public Vector2(final Vector2 vector2)
	{
		this.x=vector2.x;
		this.y=vector2.y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		
		return "("+this.x+","+this.y+")";
	}

}
