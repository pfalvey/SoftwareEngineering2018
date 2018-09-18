package edu.nd.se2018.homework.ColumbusGame;

import java.awt.Point;
import java.util.Observable;

public class Ship extends Observable
{
	private Point currentLocation = new Point();
	OceanMap map;
	
	Ship(OceanMap oceanMap) 
	{
		map = oceanMap;
		currentLocation.x = 0;
		currentLocation.y = 0;
		map.setValOnGrid(currentLocation.x, currentLocation.y, 3);
	}
	
	
	public void setShipLocation(int x, int y) 
	{
		currentLocation.x = x;
		currentLocation.y = y;
	}
	
	public Point getShipLocation() 
	{
		return currentLocation;
	}
	
	
	//if space is free, move by 1 space
	public void goEast() 
	{
		//check edge
		if (currentLocation.x < 24) 
		{
			//make sure the next spot is empty
			if (map.getValOnGrid(currentLocation.x+1, currentLocation.y) == 0) 
			{
				map.setValOnGrid(currentLocation.x, currentLocation.y, 0);
				currentLocation.x += 1;
				map.setValOnGrid(currentLocation.x, currentLocation.y, 3);
				setChanged();
				notifyObservers();
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
				map.setValOnGrid(currentLocation.x, currentLocation.y, 3);
				setChanged();
				notifyObservers();
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
				map.setValOnGrid(currentLocation.x, currentLocation.y, 3);
				setChanged();
				notifyObservers();
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
				map.setValOnGrid(currentLocation.x, currentLocation.y, 3);
				setChanged();
				notifyObservers();
			}
		}
	}
}
