package edu.nd.se2018.homework.ChipsChallenge.view;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.Random;

public class MapDisplay {
	public int[][] map = new int[25][25];
	final int dimensions = 25;
	ImageView tileImageView;
	Image tileImage;
	
	public void setBlocks( ) {
		Random random = new Random();
		for (int i = 0; i < 25; i++) {
			int x = random.ints(0, 24).findFirst().getAsInt();
			int y =  random.ints(0, 24).findFirst().getAsInt();
			while ((x == 0) && (y == 0) || (x == 5) && (y == 7)) {
				x = random.ints(0, 24).findFirst().getAsInt();
				y =  random.ints(0, 24).findFirst().getAsInt();
			}
			this.map[x][y]= 1;
		}
	}
	public void drawMap(ObservableList<Node> root, int scale) {
		for (int x = 0; x < dimensions; x++) {
			for (int y = 0; y < dimensions; y++) {
				Rectangle rect = new Rectangle(x*scale, y*scale, scale, scale);
				rect.setStroke(Color.BLACK);
				if (map[x][y] == 1) {
					rect.setFill(Color.BROWN);
					root.add(rect);
				}
				else {
					tileImage = new Image("images\\chip\\textures\\BlankTile.png", 50, 50, true, true);
					tileImageView = new ImageView(tileImage);
					tileImageView.setX(x * scale);
					tileImageView.setY(y * scale);
					root.add(tileImageView);
					this.map[x][y] = 0;
				}
			}
		}
	}
	public int getCell(int i, int j) {
		return map[i][j];
	}
	public int[][] getMap() {
		return(this.map);
	}
}