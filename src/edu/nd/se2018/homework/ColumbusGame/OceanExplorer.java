package edu.nd.se2018.homework.ColumbusGame;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OceanExplorer extends Application
{
	Pane pane;
	Scene scene;
	int width = 625;
	int height = 625;
	int scalingFactor = 25;
	OceanMap map;
	Image shipImage;
	Image pirImage1;
	Image pirImage2;
	ImageView shipImageView;
	ImageView pirImageView1;
	ImageView pirImageView2;
	Ship ship;
	PirateShip pShip1;
	PirateShip pShip2;
	
	public static void main(String[] args) 
	{
		launch(args);
	}

	@Override
	public void start(Stage oceanStage) throws Exception 
	{
		pane = new AnchorPane();
		
		map = new OceanMap();
		map.drawMap(pane.getChildren(), scalingFactor);
		
		//add the ship to the map
		shipImage = new Image("images\\ColumbusShip.png", 25, 25, true, true);
		shipImageView = new ImageView(shipImage);
		ship = new Ship(map);
		shipImageView.setX(ship.getShipLocation().x*scalingFactor);
		shipImageView.setY(ship.getShipLocation().y*scalingFactor);
		pane.getChildren().add(shipImageView);
		
		//add pirates to map
		pirImage1 = new Image("images\\pirateship.gif", 25, 25, true, true);
		pirImage2 = new Image("images\\pirateship.gif", 25, 25, true, true);
		pirImageView1 = new ImageView(pirImage1);
		pirImageView2 = new ImageView(pirImage2);
		pShip1 = new PirateShip(map);
		pShip2 = new PirateShip(map);
		pirImageView1.setX(pShip1.getShipLocation().x*scalingFactor);
		pirImageView1.setY(pShip1.getShipLocation().y*scalingFactor);
		pirImageView2.setX(pShip2.getShipLocation().x*scalingFactor);
		pirImageView2.setY(pShip2.getShipLocation().y*scalingFactor);
		pane.getChildren().add(pirImageView1);
		pane.getChildren().add(pirImageView2);
		
		
		//make pirates observer's of CC's ship
		ship.addObserver(pShip1);
		ship.addObserver(pShip2);
		
		scene = new Scene(pane, width, height);
		oceanStage.setScene(scene);
		oceanStage.setTitle("Columbus Game");
		oceanStage.show();
		startSailing();
	}
	
	private void startSailing() 
	{
		//handle key presses
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() 
		{
			@Override
			public void handle(KeyEvent ke) 
			{
				switch(ke.getCode()) 
				{
					case RIGHT:
						ship.goEast();
						break;
					case LEFT:
						ship.goWest();
						break;
					case UP:
						ship.goNorth();
						break;
					case DOWN:
						ship.goSouth();
						break;
					default:
						break;
				}
				//update images
				shipImageView.setX(ship.getShipLocation().x*scalingFactor);
				shipImageView.setY(ship.getShipLocation().y*scalingFactor);
				pirImageView1.setX(pShip1.getShipLocation().x*scalingFactor);
				pirImageView1.setY(pShip1.getShipLocation().y*scalingFactor);
				pirImageView2.setX(pShip2.getShipLocation().x*scalingFactor);
				pirImageView2.setY(pShip2.getShipLocation().y*scalingFactor);
			}
		});
	}
}
