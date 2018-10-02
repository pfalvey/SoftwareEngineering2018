package edu.nd.se2018.homework.ChipsChallenge.controller;

import edu.nd.se2018.homework.ChipsChallenge.model.CCModel;
import edu.nd.se2018.homework.ChipsChallenge.view.ChipGrid;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class CCcontroller {
	CCModel chip;
	ChipGrid chipGrid;
	
	public CCcontroller(int[][] map) {
		chip = new CCModel(0, 0, map);
		chipGrid = new ChipGrid(chip);
		chip.attachView(chipGrid);
		
	}
	
	public void moveEvent(KeyEvent ke) {
		int [] pos = chip.getPosition();
		switch(ke.getCode()){
			case RIGHT:
				System.out.println("right");
				chip.setPosition(pos[0]+1, pos[1]);
				break;
			case LEFT:
				System.out.println("left");
				chip.setPosition(pos[0]-1, pos[1]);
				break;
			case UP:
				System.out.println("up");
				chip.setPosition(pos[0], pos[1]-1);
				break;
			case DOWN:
				System.out.println("down");
				chip.setPosition(pos[0], pos[1]+1);
				break;
			default:
				break;
		}
		
	}
	
	public Node getImageView() {
		return chipGrid.view;
	}

}
