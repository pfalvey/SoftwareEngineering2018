package edu.nd.se2018.homework.homework5.model.infrastructure.gate;

import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.homework5.model.infrastructure.Direction;
import edu.nd.se2018.homework.homework5.model.vehicles.Train;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Context class for Crossing Gate
 * @author jane
 *
 */
public class CrossingGate extends Observable implements Observer{
	
	// Crossing Gate location and its trigger & exit points
	private int anchorX;
	private int anchorY;
	private int movingX;
	private int movingY;
	private int triggerPoint;
	private int exitPoint;
	private int triggerPoint2;
	private int exitPoint2;
	private boolean isTrain1;
	private boolean isTrain2;
	

	private IGateState gateClosed;
	private IGateState gateOpen;
	private IGateState gateClosing;
	private IGateState gateOpening;
	private IGateState currentGateState;
	private Line line; 
	private Pane root;
	
	public String gateName;
	
	public CrossingGate(){}
	
	public CrossingGate(int xPosition, int yPosition, String crossingGate){		
		anchorX = xPosition;
		anchorY = yPosition;
		movingX = anchorX;
		movingY = anchorY-60;
		isTrain1 = false;
		isTrain2 = false;
		triggerPoint = anchorX+275;
		exitPoint = anchorX-275;
		triggerPoint2 = anchorX-275;
		exitPoint2 = anchorX+275;
		// Gate elements
		line = new Line(anchorX, anchorY,movingX,movingY);
		line.setStroke(Color.RED);
	    line.setStrokeWidth(10);
		
		// Gate States
		gateClosed = new GateClosed(this);
		gateOpen = new GateOpen(this);
		gateOpening = new GateOpening(this);
		gateClosing = new GateClosing(this);
		currentGateState = gateOpen;
		gateName = crossingGate;
	}
	
	public Line getGateLine(){
		return line;
	}
	
	public void operateGate(){
		currentGateState.operate();
	}
	
	public void close(){
		if (movingY<anchorY){		
		    movingX+=1;
		    movingY+=1;
			line.setStartX(anchorX);
			line.setStartY(anchorY);
			line.setEndX(movingX);
			line.setEndY(movingY);
		} else {
			currentGateState.gateFinishedClosing();
		}
	}
	
	public void open(){
		if (movingX>anchorX){
			movingX-=1;
			movingY-=1;		
			line.setStartX(anchorX);
			line.setStartY(anchorY);
			line.setEndX(movingX);
			line.setEndY(movingY);
		}  else {
			currentGateState.gateFinishedOpening();
		}
	}
	
	// State getters and setters
	public IGateState getGateClosedState(){
		return gateClosed;
	}
	public IGateState getGateOpenState(){
		return gateOpen;
	}
	public IGateState getGateClosingState(){
		return gateClosing;
	}
	public IGateState getGateOpeningState(){
		return gateOpening;
	}
	
	public void setGateState(IGateState newState){
		currentGateState = newState;
		setChanged();
		notifyObservers();
	}
	
	public String getTrafficCommand(){
		return currentGateState.getTrafficAction();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Train){
			Train train = (Train)o;
			if (train.getDirection() == Direction.EAST)
			{
				if (train.getVehicleX() > exitPoint2)
				{
					if (isTrain1 == false)
					{
						currentGateState.leaveStation();
					}
					isTrain2 = false;
				}
				else if(train.getVehicleX() > triggerPoint2){
					currentGateState.approachStation();
					isTrain2 = true;
				} 
			}
			if (train.getDirection() == Direction.WEST)
			{
				if (train.getVehicleX() < exitPoint)
				{
					if (isTrain2 == false)
					{
						currentGateState.leaveStation();
					}
					isTrain1 = false;
				}
				else if(train.getVehicleX() < triggerPoint){
					currentGateState.approachStation();
					isTrain1 = true;
				} 
			}
		}	
	}
}
