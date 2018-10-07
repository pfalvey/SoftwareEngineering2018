package edu.nd.se2018.homework.ChipsChallenge.model;

import java.util.Observable;

import edu.nd.se2018.homework.ChipsChallenge.view.CCView;
import edu.nd.se2018.homework.ChipsChallenge.view.MapDisplay;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CCModel extends Observable {
	int chips;
	boolean hasBlueKey = false;
	int x;
	int y;
	int[] position = new int[2];
	int[][] gameMap;
	Image tileImage;
	ImageView tileImageView;
	MapDisplay mapDisplay;
	boolean levelone = true;
	private ObservableList<Node> root;
	private int scale;
	private CCView ccView;
	
	public CCModel(int xPos, int yPos, MapDisplay map) {
		x = xPos;
		y = yPos;
		chips = 0;
		mapDisplay = map;
		gameMap = mapDisplay.getMap();
	}
	
	public void loadRootAndScale(ObservableList<Node> root, int scale)
	{
		this.root = root;
		this.scale = scale;
	}
	
	public int[] getPosition() {
		position[0] = this.x;
		position[1] = this.y;
		return(position);
	}
	
	
	public void setPosition(int xPos, int yPos) {
		if (xPos >= 0 && xPos < 25 && yPos >= 0 && yPos < 25) {
			if (gameMap[xPos][yPos] == 0 ) {
				this.x = xPos;
				this.y = yPos;
			}
			else if (gameMap[xPos][yPos] == 2) {
				this.x = xPos;
				this.y = yPos;
				this.mapDisplay.removeChip(xPos, yPos);
				this.addChip();	
			}
			else if (gameMap[xPos][yPos] == 6) {
				this.x = xPos;
				this.y = yPos;
				this.mapDisplay.removeKey(xPos, yPos);
				this.hasBlueKey = true;
			}
			else if (gameMap[xPos][yPos] == 4)
			{
				if (this.hasBlueKey)
				{
					this.x = xPos;
					this.y = yPos;
					this.mapDisplay.removeKeyWall(xPos, yPos);
				}
			}
			else if (gameMap[xPos][yPos] == 3)
			{
				if (this.chips == 10)
				{
					this.x = xPos;
					this.y = yPos;
					this.mapDisplay.removeGate(xPos, yPos);
				}
			}
			else if (gameMap[xPos][yPos] == 5)
			{
				this.x = xPos;
				this.y = yPos;
				if (levelone)
				{
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("New Level!");
					alert.setHeaderText("Level One Complete!");
					alert.setContentText("Click OK to go to level two!");
					alert.showAndWait();
					levelone = false;
					mapDisplay.setLevelOne(levelone);
					mapDisplay.setBlocks();
					mapDisplay.setChips();
					mapDisplay.drawMap(root, scale);
					mapDisplay.drawLevel();
					this.chips = 0;
					this.hasBlueKey = false;	
					this.x = 0;
					this.y = 0;
					this.ccView.resetChip();
					this.root.add(this.ccView.getView());
				}
				else
				{
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Game Complete!");
					alert.setHeaderText("You beat the game!");
					alert.setContentText("Click OK to exit!");
					alert.showAndWait();
					Platform.exit();
				}
			}
		}
		setChanged();
		notifyObservers();
	}
	
	public void addChip() {
		this.chips++;
	}
	
	public void attachView(CCView view) {
		addObserver(view);
		this.ccView = view;
	}
	
}