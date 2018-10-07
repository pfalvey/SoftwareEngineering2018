package edu.nd.se2018.homework.ChipsChallenge.view;

import java.util.Observable;
import java.util.Observer;

import edu.nd.se2018.homework.ChipsChallenge.model.CCModel;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CCView implements Observer {
	public ImageView view;
	private Image chipImage;
	
	
	public CCView(CCModel chip) {
		chipImage = new Image("\\images\\chip\\textures\\chipDown.png", 50, 50, true, true);
		view = new ImageView(chipImage);
		view.setFitHeight(20);
		view.setFitWidth(20);
		int[] pos = chip.getPosition();
		view.setX(pos[0] * 20);
		view.setY(pos[1] * 20);
	}
	
	public Node getView() {
		return(view);	
	}
	
	public void resetChip()
	{
		chipImage = new Image("\\images\\chip\\textures\\chipDown.png", 50, 50, true, true);
		view = new ImageView(chipImage);
		view.setFitHeight(20);
		view.setFitWidth(20);
		view.setX(0 * 20);
		view.setY(0 * 20);
	}

	@Override
	public void update(Observable o, Object arg) {
		int[] pos = ((CCModel)o).getPosition();
		view.setX(pos[0] * 20);
		view.setY(pos[1] * 20);	
	}

}