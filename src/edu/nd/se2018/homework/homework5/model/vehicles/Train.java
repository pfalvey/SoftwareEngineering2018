package edu.nd.se2018.homework.homework5.model.vehicles;

import java.util.Observable;

import edu.nd.se2018.homework.homework5.model.infrastructure.Direction;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Represents the train entity object
 * @author jane
 *
 */
public class Train extends Observable implements IVehicle{
	private double currentX = 0;
	private double currentY = 0;
	private double originalX = 0;
	private Image img;
	private ImageView imgView;
	private int trainLength = 35;
	Direction direction;
	
	public Train(int x, int y, Direction dir){
		this.currentX = x;
		this.currentY = y;
		originalX = x;
		img = new Image("images\\Train.PNG",120,trainLength,false,false);
		imgView = new ImageView(img);
		imgView.setX(currentX);
		imgView.setY(currentY);
		if (dir == Direction.EAST)
		{
			imgView.setScaleX(-1);
		}
		this.direction = dir;
	}
	
	public double getVehicleX(){
		return currentX;
	}
	
	public double getVehicleY(){
		return currentY;
	}
	
	public Direction getDirection()
	{
		return this.direction;
	}
	
	public void move(){
		if (direction == Direction.WEST)
		{
			currentX-=2;
		}
		else 
		{
			currentX+=2;
		}
		imgView.setX(currentX);
		setChanged();
		notifyObservers();
	}
	
	public boolean offScreen(){
		if (direction == Direction.WEST)
		{
			if (currentX < -200)
				return true;
			else
				return false;
		}
		else
		{
			if (currentX > 1600)
				return true;
			else
				return false;
		}
	}
	
	public void reset(){
		currentX = originalX;
	}

	//@Override
	public Node getImageView() {
		return imgView;
	}
}