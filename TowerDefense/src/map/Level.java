package map;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Queue;

import graphics.Vector2;

public class Level 
{
	private Map map;
	private ArrayList<Vector2> waypoints;
	
	public Level(Map map)
	{
		waypoints=new ArrayList<Vector2>();
		this.map=map;
		
		
	}
	
	public void addWaypoints(Vector2 ... waypoints)
	{
		for(Vector2 waypoint : waypoints)
		{
			this.waypoints.add(waypoint);
		}
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public ArrayList<Vector2> getWaypoints() {
		return waypoints;
	}

	public void setWaypoints(ArrayList<Vector2> waypoints) {
		this.waypoints = waypoints;
	}

	public void draw(Graphics g)
	{
		map.renderMapToScreen(g);
	}

}
