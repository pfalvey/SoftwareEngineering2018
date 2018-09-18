package edu.nd.se2018.homework.ColumbusGame;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class PirateShip implements Observer
{
	private Point currentLocation = new Point();
	Point observedPoint = new Point();
	OceanMap map;
	Random shipGenerator = new Random();


	//place ship in random free space
	PirateShip(OceanMap oceanMap) 
	{
		map = oceanMap;
		boolean placed = false;
		while (!placed) 
		{
			currentLocation.x = shipGenerator.nextInt(map.getDimensions());
			currentLocation.y = shipGenerator.nextInt(map.getDimensions());
			//CCS location
			if (currentLocation.x == 0 && currentLocation.y == 0) 
			{
				continue;
			}
			if (map.getValOnGrid(currentLocation.x, currentLocation.y) == 0) 
			{
				map.setValOnGrid(currentLocation.x, currentLocation.y, 2);
				placed = true;
			}
		}
	}

	public Point getShipLocation() 
	{
			return currentLocation;
	}

	public void setShipLocation(int x, int y) 
	{
		currentLocation.x = x;
		currentLocation.y = y;
	}
	//function to determine how to move the pirate
	public void advancePirateShip() 
	{
		int xDiff = currentLocation.x - observedPoint.x;
		int yDiff = currentLocation.y - observedPoint.y;
		if (Math.abs(xDiff) > Math.abs(yDiff)) 
		{
			//make sure space is available
			if (currentLocation.x < 24 && map.getValOnGrid(currentLocation.x+1, currentLocation.y) == 0 && xDiff < 0) 
			{
				this.goEast();
			}
			else if(currentLocation.x > 0 && map.getValOnGrid(currentLocation.x-1, currentLocation.y) == 0 && xDiff > 0) 
			{
				this.goWest();
			}
		}
		else 
		{
			if (currentLocation.y > 0 && map.getValOnGrid(currentLocation.x, currentLocation.y-1) == 0 && yDiff > 0) 
			{
				this.goNorth();
			}
			else if (currentLocation.y < 24 && map.getValOnGrid(currentLocation.x, currentLocation.y+1) == 0 && yDiff < 0) 
			{
				this.goSouth();
			}
		}
	}
			
	//similar to ship's movements
	public void goEast() 
	{
		//check edge
		if (currentLocation.x < 24) 
		{
			//make sure next spot empty
			if (map.getValOnGrid(currentLocation.x+1, currentLocation.y) == 0) 
			{
				map.setValOnGrid(currentLocation.x, currentLocation.y, 0);
				currentLocation.x += 1;
				map.setValOnGrid(currentLocation.x, currentLocation.y, 2);
			}
		}
	}

	public void goWest() 
	{
		if(currentLocation.x > 0) 
		{
			if (map.getValOnGrid(currentLocation.x-1, currentLocation.y) == 0) 
			{
				map.setValOnGrid(currentLocation.x, currentLocation.y, 0);
				currentLocation.x -= 1;
				map.setValOnGrid(currentLocation.x, currentLocation.y, 2);
			}
		}
	}

	public void goNorth() 
	{
		if (currentLocation.y > 0) 
		{
			if (map.getValOnGrid(currentLocation.x, currentLocation.y-1) == 0) 
			{
				map.setValOnGrid(currentLocation.x, currentLocation.y, 0);
				currentLocation.y -= 1;
				map.setValOnGrid(currentLocation.x, currentLocation.y, 2);
			}
		}
	}

	public void goSouth() 
	{
		if (currentLocation.y < 24) 
		{
			if (map.getValOnGrid(currentLocation.x, currentLocation.y+1) == 0) 
			{
				map.setValOnGrid(currentLocation.x, currentLocation.y, 0);
				currentLocation.y += 1;
				map.setValOnGrid(currentLocation.x, currentLocation.y, 2);
			}
		}
	}
	
	//what happens when the observable notifies the observer
	@Override
	public void update(Observable arg0, Object arg1) 
	{
		if (arg0 instanceof Ship) 
		{
			observedPoint = ((Ship)arg0).getShipLocation();
			advancePirateShip();
		}
	}
}


