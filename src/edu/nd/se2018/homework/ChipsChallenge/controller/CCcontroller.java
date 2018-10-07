package edu.nd.se2018.homework.ChipsChallenge.controller;

import edu.nd.se2018.homework.ChipsChallenge.model.CCModel;
import edu.nd.se2018.homework.ChipsChallenge.view.CCView;
import edu.nd.se2018.homework.ChipsChallenge.view.MapDisplay;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;

public class CCcontroller {
	CCModel chip;
	CCView ccView;
	private ObservableList<Node> root;
	private int scale;
	private static CCcontroller instance = null;
	public static CCcontroller getInstance(MapDisplay map, CCModel chip) {
		if (instance == null) {
			instance = new CCcontroller(map, chip);
		}
		return instance;
	}
	protected CCcontroller(MapDisplay map, CCModel chip) {
		this.chip = chip;
		ccView = new CCView(chip);
		chip.attachView(ccView);
	}
	
	public void loadRootAndScale(ObservableList<Node> root, int scale)
	{
		this.root = root;
		this.scale = scale;
		this.chip.loadRootAndScale(this.root, this.scale);
	}
	
	public void moveEvent(KeyEvent ke) {
		int [] pos = chip.getPosition();
		switch(ke.getCode()){
			case RIGHT:
				chip.setPosition(pos[0]+1, pos[1]);
				break;
			case LEFT:
				chip.setPosition(pos[0]-1, pos[1]);
				break;
			case UP:
				chip.setPosition(pos[0], pos[1]-1);
				break;
			case DOWN:
				chip.setPosition(pos[0], pos[1]+1);
				break;
			case ESCAPE:
				Platform.exit();
				break;
			default:
				break;
		}
		
	}
	
	public Node getImageView() {
		return ccView.view;
	}

}
