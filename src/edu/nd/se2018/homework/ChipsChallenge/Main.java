package edu.nd.se2018.homework.ChipsChallenge;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import edu.nd.se2018.homework.ChipsChallenge.controller.CCcontroller;
import edu.nd.se2018.homework.ChipsChallenge.model.CCModel;
import edu.nd.se2018.homework.ChipsChallenge.view.*;

public class Main extends Application {
	AnchorPane root;
	Scene scene;
	MapDisplay gameMap;
	ImageView[][] tiles;
	Image tileImage;
	int scale = 20;
	CCModel chip;
	CCView ccView;
	CCcontroller ccController;

	@Override
	public void start(Stage gameStage) throws Exception {
		root = new AnchorPane();
		Scene scene = new Scene(root, 500, 500);
		gameMap = new MapDisplay();
		gameMap.setBlocks();
		gameMap.setChips();
		gameMap.drawMap(root.getChildren(), 20);
		gameMap.drawLevel();
		

		chip = new CCModel(0, 0, gameMap);
		chip.loadRootAndScale(root.getChildren(), scale);
		ccView = new CCView(chip);
		chip.attachView(ccView);
		ccController = CCcontroller.getInstance(gameMap, chip);
		ccController.loadRootAndScale(root.getChildren(), scale);
		root.getChildren().add(ccController.getImageView());
		
		gameStage.setScene(scene);
		gameStage.setTitle("Chip's Challenge");
		gameStage.show();		
		startGame(scene);
	}
	
	private void startGame(Scene scene) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				ccController.moveEvent(event);
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
