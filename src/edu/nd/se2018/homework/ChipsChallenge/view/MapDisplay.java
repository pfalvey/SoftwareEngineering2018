package edu.nd.se2018.homework.ChipsChallenge.view;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.Random;

public class MapDisplay {
	public int[][] map = new int[25][25];
	private ImageView[] chips = new ImageView[10];
	private ImageView[] walls = new ImageView[9];
	final int dimensions = 25;
	ImageView tileImageView;
	Image tileImage = new Image("images\\chip\\textures\\BlankTile.png", 50, 50, true, true);
	Image chipsImage;
	ImageView chipsImageView;
	Image gateImage = new Image("images\\chip\\textures\\chipWall.png", 50, 50, true,true);
	Image blueKeyWallImage = new Image ("images\\chip\\textures\\blueKeyWall.png", 50, 50, true,true);
	Image portalImage = new Image("images\\chip\\textures\\portal.png", 50, 50, true,true);
	Image wallImage = new Image("images\\chip\\textures\\blackWall.png", 50, 50, true,true);
	Image blueKeyImage = new Image("images\\chip\\textures\\blueKey.png", 50, 50, true,true);
	private ImageView gate = new ImageView(gateImage);
	private ImageView portal = new ImageView(portalImage);
	private ImageView blueKey = new ImageView(blueKeyImage);
	private ImageView blueKeyWall = new ImageView(blueKeyWallImage);
	
	ObservableList<Node> root;
	int scale;
	boolean level1 = true; // starts on level1
	
	public void setBlocks( ) {
		Random random = new Random();
		for (int i = 0; i < 25; i++) {
			int x = random.ints(0, 24).findFirst().getAsInt();
			int y =  random.ints(0, 24).findFirst().getAsInt();
			while ((x == 0) && (y == 0)|| (x == 7 && y == 8) || (x == 6 && y == 8) ) {
				x = random.ints(0, 24).findFirst().getAsInt();
				y =  random.ints(0, 24).findFirst().getAsInt();
			}
			this.map[x][y]= 1;
		}
	}
	
	public void setChips( ) {
		Random random = new Random();
		int low = 0;
		int high = 24;
		for (int i = 0; i < 10; i++) {
			int x = random.nextInt(high-low) + low;
			int y = random.nextInt(high-low) + low;
			while (((x < 18 && x > 13 && y > 13 && y < 18) || (x == 8 && y == 8)) && this.map[x][y] != 0)
			{
				x = random.nextInt(high-low) + low;
				y = random.nextInt(high-low) + low;
			}
			this.map[x][y]= 2;
		}
	}
	
	public void drawMap(ObservableList<Node> root, int scale) {
		this.root = root;
		this.scale = scale;
		int i = 0;
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
				rect.setStroke(Color.BLACK);
				if (map[x][y] == 1) {
					rect.setFill(Color.BROWN);
					root.add(rect);
				}
				else if (map[x][y] == 2) {
					chipsImage = new Image("images\\chip\\textures\\chipItem.png", 50, 50, true, true);
					chipsImageView = new ImageView(chipsImage);
					chipsImageView.setX(x * scale);
					chipsImageView.setY(y * scale);
					chipsImageView.setFitHeight(20);
					chipsImageView.setFitWidth(20);
					root.add(chipsImageView);
					chips[i] = chipsImageView;
					i++;
				}
				else {
					tileImageView = new ImageView(tileImage);
					tileImageView.setX(x * scale);
					tileImageView.setY(y * scale);
					root.add(tileImageView);
					this.map[x][y] = 0;
				}
			}
		}
	}
	
	public void drawLevel()
	{
		if (this.level1)
		{
			LevelMaker level = new LevelMaker(map, wallImage, scale, root, walls, gate, portal, blueKey, blueKeyWall, blueKeyImage, blueKeyWallImage, gateImage);
			level.drawLevelOne();
		}
		else 
		{
			LevelMaker level = new LevelMaker(map, wallImage, scale, root, walls, gate, portal, blueKey, blueKeyWall, blueKeyImage, blueKeyWallImage, gateImage);
			level.drawLevelTwo();
		}
	}
	public int getCell(int i, int j) {
		return map[i][j];
	}
	public int[][] getMap() {
		return(this.map);
	}
	public boolean isLevelOne()
	{
		return this.level1;
	}
	public void setLevelOne(boolean x)
	{
		this.level1 = x;
	}
	public void removeChip(int x, int y)
	{
		for (ImageView e : this.chips)
		{
			if (e.getX() == x * scale && e.getY() == y * scale)
			{
				e.setImage(tileImage);
				this.map[x][y] = 0;
			}
		}
	}
	public void removeKey(int x, int y)
	{
		blueKey.setImage(tileImage);
		this.map[x][y] = 0;
	}
	public void removeKeyWall(int x, int y)
	{
		blueKeyWall.setImage(tileImage);
		this.map[x][y] = 0;
	}
	public void removeGate(int x, int y)
	{
		gate.setImage(tileImage);
		this.map[x][y] = 0;
	}
}