package edu.nd.se2018.homework.ColumbusGame;

import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class OceanMap 
{
	final int dimensions = 25;
	int[][] oceanGrid = new int[dimensions][dimensions];
	Random islandGenerator;
	
	public OceanMap() 
	{
		makeIslands();
	}
	
	public void drawMap(ObservableList<Node> root, int scale) 
	{
		for (int x=0; x < dimensions; x++) {
			for (int y=0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
				rect.setStroke(Color.BLACK);
				if (oceanGrid[x][y] == 1) {
					rect.setFill(Color.GREEN);
				}
				else if (oceanGrid[x][y] == 2) {
					rect.setFill(Color.PALETURQUOISE);
				}
				else {
					rect.setFill(Color.PALETURQUOISE);
					oceanGrid[x][y] = 0;
				}
				root.add(rect);
			}
		}
	}
	
	public void setValOnGrid(int x, int y, int val) 
	{
		oceanGrid[x][y] = val;
	}
	
	public int getValOnGrid(int x, int y) 
	{
		return oceanGrid[x][y];
	}
	
	public int getDimensions() {
		return dimensions;
	}
	
	//make 10, non-duplicate islands
	private void makeIslands() 
	{
		islandGenerator = new Random();
		int numIslands = 0;
		while (numIslands < 10) 
		{
			int x = islandGenerator.nextInt(dimensions);
			int y = islandGenerator.nextInt(dimensions);
			if (x == 24 && y == 0) 
			{
				continue;
			}
			if (oceanGrid[x][y] != 1) 
			{
				oceanGrid[x][y] = 1;
				numIslands += 1;
			}
		}
	}
}
