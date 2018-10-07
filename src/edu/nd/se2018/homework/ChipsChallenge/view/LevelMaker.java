package edu.nd.se2018.homework.ChipsChallenge.view;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LevelMaker {
	private int[][] map;
	private Image wallImage;
	private int scale;
	private ObservableList<Node> root;
	private ImageView[] walls = new ImageView[9];
	private ImageView gate;
	private ImageView portal;
	private ImageView blueKey;
	private ImageView blueKeyWall;
	private Image blueKeyImage;
	private Image blueKeyWallImage;
	private Image gateImage;
	
	public LevelMaker(int[][] map, Image wallImage, int scale, ObservableList<Node> root, ImageView[] walls, ImageView gate, ImageView portal, ImageView blueKey, ImageView blueKeyWall, Image blueKeyImage, Image blueKeyWallImage, Image gateImage)
	{
		this.map = map;
		this.wallImage = wallImage;
		this.scale = scale;
		this.root = root;
		this.walls = walls;
		this.gate = gate;
		this.portal = portal;
		this.blueKey = blueKey;
		this.blueKeyWall = blueKeyWall;
		this.blueKeyImage = blueKeyImage;
		this.blueKeyWallImage = blueKeyWallImage;
		this.gateImage = gateImage;
				
	}
	
	public void drawLevelOne()
	{
		//add walls
		map[15][14] = 1;
		ImageView wallView = new ImageView(wallImage);
		wallView.setX(15 * scale);
		wallView.setY(14 * scale);
		wallView.setFitHeight(20);
		wallView.setFitWidth(20);
		root.add(wallView);
		walls[0] = wallView;
		
		
		map[15][15] = 1;
		ImageView wallView1 = new ImageView(wallImage);
		wallView1.setX(15 * scale);
		wallView1.setY(15 * scale);
		wallView1.setFitHeight(20);
		wallView1.setFitWidth(20);
		root.add(wallView1);
		walls[1] = wallView1;
		
		map[15][16] = 1;
		ImageView wallView2 = new ImageView(wallImage);
		wallView2.setX(15 * scale);
		wallView2.setY(16 * scale);
		wallView2.setFitHeight(20);
		wallView2.setFitWidth(20);
		root.add(wallView2);
		walls[2] = wallView2;
		
		map[15][17] = 1;
		ImageView wallView3 = new ImageView(wallImage);
		wallView3.setX(15 * scale);
		wallView3.setY(17 * scale);
		wallView3.setFitHeight(20);
		wallView3.setFitWidth(20);
		root.add(wallView3);
		walls[3] = wallView3;
		
		map[16][17] = 1;
		ImageView wallView4 = new ImageView(wallImage);
		wallView4.setX(16 * scale);
		wallView4.setY(17 * scale);
		wallView4.setFitHeight(20);
		wallView4.setFitWidth(20);
		root.add(wallView4);
		walls[4] = wallView4;
		
		map[17][17] = 1;
		ImageView wallView5 = new ImageView(wallImage);
		wallView5.setX(17 * scale);
		wallView5.setY(17 * scale);
		wallView5.setFitHeight(20);
		wallView5.setFitWidth(20);
		root.add(wallView5);
		walls[5] = wallView5;
		
		map[17][16] = 1;
		ImageView wallView6 = new ImageView(wallImage);
		wallView6.setX(17 * scale);
		wallView6.setY(16 * scale);
		wallView6.setFitHeight(20);
		wallView6.setFitWidth(20);
		root.add(wallView6);
		walls[6] = wallView6;
		
		map[17][15] = 1;
		ImageView wallView7 = new ImageView(wallImage);
		wallView7.setX(17 * scale);
		wallView7.setY(15 * scale);
		wallView7.setFitHeight(20);
		wallView7.setFitWidth(20);
		root.add(wallView7);
		walls[7] = wallView7;
		
		map[17][14] = 1;
		ImageView wallView8 = new ImageView(wallImage);
		wallView8.setX(17 * scale);
		wallView8.setY(14 * scale);
		wallView8.setFitHeight(20);
		wallView8.setFitWidth(20);
		root.add(wallView8);
		walls[8] = wallView8;
		// add gate
		map[16][15] = 3;
		gate.setX(16 * scale);
		gate.setY(15 * scale);
		gate.setFitHeight(20);
		gate.setFitWidth(20);
		root.add(gate);
		//add blue key wall
		map [16][14] = 4;
		blueKeyWall.setX(16 * scale);
		blueKeyWall.setY(14 * scale);
		blueKeyWall.setFitHeight(20);
		blueKeyWall.setFitWidth(20);
		root.add(blueKeyWall);
		//add end portal
		map[16][16] = 5;
		portal.setX(16 * scale);
		portal.setY(16 * scale);
		portal.setFitHeight(20);
		portal.setFitWidth(20);
		root.add(portal);
		//add blue key
		map[8][8] = 6;
		blueKey.setX(8 * scale);
		blueKey.setY(8 * scale);
		blueKey.setFitHeight(20);
		blueKey.setFitWidth(20);
		root.add(blueKey);
	}
	public void drawLevelTwo()
	{
	
		
		//add walls
		map[15][14] = 1;
		ImageView wallView = new ImageView(wallImage);
		wallView.setX(15 * scale);
		wallView.setY(14 * scale);
		wallView.setFitHeight(20);
		wallView.setFitWidth(20);
		walls[0] = wallView;
		root.remove(wallView);
		root.add(wallView);
		
		
		map[15][15] = 1;
		ImageView wallView1 = new ImageView(wallImage);
		wallView1.setX(15 * scale);
		wallView1.setY(15 * scale);
		wallView1.setFitHeight(20);
		wallView1.setFitWidth(20);
		walls[1] = wallView1;
		root.remove(wallView1);
		root.add(wallView1);
		
		map[15][16] = 1;
		ImageView wallView2 = new ImageView(wallImage);
		wallView2.setX(15 * scale);
		wallView2.setY(16 * scale);
		wallView2.setFitHeight(20);
		wallView2.setFitWidth(20);
		walls[2] = wallView2;
		root.remove(wallView2);
		root.add(wallView2);
		
		map[15][17] = 1;
		ImageView wallView3 = new ImageView(wallImage);
		wallView3.setX(15 * scale);
		wallView3.setY(17 * scale);
		wallView3.setFitHeight(20);
		wallView3.setFitWidth(20);
		walls[3] = wallView3;
		root.remove(wallView3);
		root.add(wallView3);
		
		map[16][17] = 1;
		ImageView wallView4 = new ImageView(wallImage);
		wallView4.setX(16 * scale);
		wallView4.setY(17 * scale);
		wallView4.setFitHeight(20);
		wallView4.setFitWidth(20);
		walls[4] = wallView4;
		root.remove(wallView4);
		root.add(wallView4);
		
		map[17][17] = 1;
		ImageView wallView5 = new ImageView(wallImage);
		wallView5.setX(17 * scale);
		wallView5.setY(17 * scale);
		wallView5.setFitHeight(20);
		wallView5.setFitWidth(20);
		walls[5] = wallView5;
		root.remove(wallView5);
		root.add(wallView5);
		
		map[17][16] = 1;
		ImageView wallView6 = new ImageView(wallImage);
		wallView6.setX(17 * scale);
		wallView6.setY(16 * scale);
		wallView6.setFitHeight(20);
		wallView6.setFitWidth(20);
		walls[6] = wallView6;
		root.remove(wallView6);
		root.add(wallView6);
		
		map[17][15] = 1;
		ImageView wallView7 = new ImageView(wallImage);
		wallView7.setX(17 * scale);
		wallView7.setY(15 * scale);
		wallView7.setFitHeight(20);
		wallView7.setFitWidth(20);
		walls[7] = wallView7;
		root.remove(wallView7);
		root.add(wallView7);
		
		map[17][14] = 1;
		ImageView wallView8 = new ImageView(wallImage);
		wallView8.setX(17 * scale);
		wallView8.setY(14 * scale);
		wallView8.setFitHeight(20);
		wallView8.setFitWidth(20);
		walls[8] = wallView8;
		root.remove(wallView8);
		root.add(wallView8);
		
		//add wall surrounding bluekey
		map[7][7] = 1;
		ImageView wallView9 = new ImageView(wallImage);
		wallView9.setX(7 * scale);
		wallView9.setY(7 * scale);
		wallView9.setFitHeight(20);
		wallView9.setFitWidth(20);
		root.add(wallView9);
		
		map[8][7] = 1;
		ImageView wallView10 = new ImageView(wallImage);
		wallView10.setX(8 * scale);
		wallView10.setY(7 * scale);
		wallView10.setFitHeight(20);
		wallView10.setFitWidth(20);
		root.add(wallView10);
		
		map[9][7] = 1;
		ImageView wallView11 = new ImageView(wallImage);
		wallView11.setX(9 * scale);
		wallView11.setY(7 * scale);
		wallView11.setFitHeight(20);
		wallView11.setFitWidth(20);
		root.add(wallView11);
		
		map[9][8] = 1;
		ImageView wallView12 = new ImageView(wallImage);
		wallView12.setX(9 * scale);
		wallView12.setY(8 * scale);
		wallView12.setFitHeight(20);
		wallView12.setFitWidth(20);
		root.add(wallView12);
		
		map[9][9] = 1;
		ImageView wallView13 = new ImageView(wallImage);
		wallView13.setX(9 * scale);
		wallView13.setY(9 * scale);
		wallView13.setFitHeight(20);
		wallView13.setFitWidth(20);
		root.add(wallView13);
		
		map[8][9] = 1;
		ImageView wallView14 = new ImageView(wallImage);
		wallView14.setX(8 * scale);
		wallView14.setY(9 * scale);
		wallView14.setFitHeight(20);
		wallView14.setFitWidth(20);
		root.add(wallView14);
		
		map[7][9] = 1;
		ImageView wallView15 = new ImageView(wallImage);
		wallView15.setX(7 * scale);
		wallView15.setY(9 * scale);
		wallView15.setFitHeight(20);
		wallView15.setFitWidth(20);
		root.add(wallView15);
		
		
		// add gate
		map[7][8] = 3;
		gate.setX(7 * scale);
		gate.setY(8 * scale);
		gate.setFitHeight(20);
		gate.setFitWidth(20);
		gate.setImage(gateImage);
		root.remove(gate);
		root.add(gate);
		//add blue key wall
		map [16][14] = 4;
		blueKeyWall.setX(16 * scale);
		blueKeyWall.setY(14 * scale);
		blueKeyWall.setFitHeight(20);
		blueKeyWall.setFitWidth(20);
		blueKeyWall.setImage(blueKeyWallImage);
		root.remove(blueKeyWall);
		root.add(blueKeyWall);
		
		//add end portal
		map[16][16] = 5;
		portal.setX(16 * scale);
		portal.setY(16 * scale);
		portal.setFitHeight(20);
		portal.setFitWidth(20);
		root.remove(portal);
		root.add(portal);
		//add blue key
		map[8][8] = 6;
		blueKey.setX(8 * scale);
		blueKey.setY(8 * scale);
		blueKey.setFitHeight(20);
		blueKey.setFitWidth(20);
		blueKey.setImage(blueKeyImage);
		root.remove(blueKey);
		root.add(blueKey);
	}
}
