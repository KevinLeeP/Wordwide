package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;  
import javafx.scene.media.MediaView;  
import javafx.scene.paint.Color;
import java.util.Arrays;
import java.io.File;
import javafx.util.Duration;



public class Controller {
	
	@FXML
	private AnchorPane anchorPane;
	
	@FXML
	private AnchorPane winScreen;
	@FXML
	private AnchorPane loseScreen;
	
	
	@FXML
	private TextField entryBox;
	
	@FXML
	private String entry;
	
	@FXML
	private Label TextBoxLabel;
	
	
	@FXML
	private Rectangle box0;
	@FXML
	private Rectangle box1;
	@FXML
	private Rectangle box2;
	@FXML
	private Rectangle box3;
	@FXML
	private Rectangle box4;
	@FXML
	private Rectangle box5;
	@FXML
	private Rectangle box6;
	@FXML
	private Rectangle box7;
	@FXML
	private Rectangle box8;
	@FXML
	private Rectangle box9;
	@FXML
	private Rectangle box10;
	@FXML
	private Rectangle box11;
	@FXML
	private Rectangle box12;
	@FXML
	private Rectangle box13;
	@FXML
	private Rectangle box14;
	@FXML
	private Rectangle box15;
	@FXML
	private Rectangle box16;
	@FXML
	private Rectangle box17;
	@FXML
	private Rectangle box18;
	@FXML
	private Rectangle box19;
	@FXML
	private Rectangle box20;
	@FXML
	private Rectangle box21;
	@FXML
	private Rectangle box22;
	@FXML
	private Rectangle box23;
	@FXML
	private Rectangle box24;
	
	@FXML
	private Label letter0;
	@FXML
	private Label letter1;
	@FXML
	private Label letter2;
	@FXML
	private Label letter3;
	@FXML
	private Label letter4;
	@FXML
	private Label letter5;
	@FXML
	private Label letter6;
	@FXML
	private Label letter7;
	@FXML
	private Label letter8;
	@FXML
	private Label letter9;
	@FXML
	private Label letter10;
	@FXML
	private Label letter11;
	@FXML
	private Label letter12;
	@FXML
	private Label letter13;
	@FXML
	private Label letter14;
	@FXML
	private Label letter15;
	@FXML
	private Label letter16;
	@FXML
	private Label letter17;
	@FXML
	private Label letter18;
	@FXML
	private Label letter19;
	@FXML
	private Label letter20;
	@FXML
	private Label letter21;
	@FXML
	private Label letter22;
	@FXML
	private Label letter23;
	@FXML
	private Label letter24;

	
	Media incorrectSoundMedia = new Media(new File("Sounds/click.mp3").toURI().toString());
	MediaPlayer incorrectSoundPlayer = new MediaPlayer(incorrectSoundMedia);
	
	
	private int entryID = -1;
	
	
	char[] winArray = {'C', 'C', 'C', 'C', 'C'};
	
	
	
	
	
	
	
	public void submit(ActionEvent e) {
		entry = entryBox.getText();
		entryBox.clear();
		
		anchorPane.setStyle("-fx-background-color: #2e2c2c");
		
		if(entry.length()!=5) {
		 TextBoxLabel.setText("Your Entry Is Not 5 Letters Long!");
		}else {
			TextBoxLabel.setText("Enter Your 5 Letter Guess! ");
			entryID++;
			evaluateRow(entry, entryID);
			
				
			if(Arrays.equals(winArray, WordMethods.evaluateWord(entry))) {
				winScreen.setVisible(true);
				winScreen.setDisable(false);
			}
			else if(entryID==4) {
				loseScreen.setVisible(true);
				loseScreen.setDisable(false);
			}
		}
		incorrectSoundPlayer.seek(Duration.ZERO);
		incorrectSoundPlayer.play();
	
	}
	
	
	public void reset(ActionEvent e) {
		entryID=-1;
		Rectangle[] allBoxArray = new Rectangle[]{box0, box1, box2, box3, box4, box5, box6, box7, box8, box9, box10, box11, box12, 
				box13, box14, box15, box16, box17, box18, box19, box20, box21, box22, box23, box24};
		
		Label[] allLabelArray = new Label[]{letter0, letter1, letter2, letter3, letter4,letter5, letter6, letter7, letter8, letter9, letter10, letter11, letter12, letter13,
				letter14, letter15, letter16, letter17, letter18, letter19, letter20, letter21, letter22, letter23, letter24 };
		
		for(int i=0; i<allBoxArray.length; i++) {
			allBoxArray[i].setFill(Color.rgb(37, 35, 35));
			allLabelArray[i].setText("");
			allLabelArray[i].setVisible(false);
		}
		
		winScreen.setVisible(false);
		loseScreen.setVisible(false);
		
		winScreen.setDisable(true);
		loseScreen.setDisable(true);
	}
	
	
	public void evaluateRow(String text, int entryID) {
	
		
		Rectangle[] boxArray; 
		Label[] textArray;
		
		
		switch(entryID) {
		case(0):
			WordMethods.generateAnswer();
			boxArray = new Rectangle[]{box0, box1, box2, box3, box4};
			textArray = new Label[]{letter0, letter1, letter2, letter3, letter4};
			
			break;
		case(1):
			boxArray = new Rectangle[]{box5, box6, box7, box8, box9};
			textArray = new Label[]{letter5, letter6, letter7, letter8, letter9};
			break;
		case(2):
			boxArray = new Rectangle[]{box10, box11, box12, box13, box14};
			textArray = new Label[]{letter10, letter11, letter12, letter13, letter14};
			break;
		case(3):
			boxArray = new Rectangle[]{box15, box16, box17, box18, box19};
			textArray = new Label[]{letter15, letter16, letter17, letter18, letter19};
			break;
		case(4):
			boxArray = new Rectangle[]{box20, box21, box22, box23, box24};
			textArray = new Label[]{letter20, letter21, letter22, letter23, letter24};
			
			
			
			break;
		default:
			boxArray = null;
			textArray = null;
			break;
		}
		System.out.println(WordMethods.getAnswer());
		
		
		char[] characters = text.toCharArray();
		char[] characterCategories = WordMethods.evaluateWord(text);
		
		
		
		for(int i=0; i<boxArray.length; i++) {
			//System.out.println(i);
		
			char status = characterCategories[i];
			
			if(status=='C') {
				boxArray[i].setFill(Color.rgb(18, 99, 25));
				//System.out.println("Green");
			}
			else if(status=='P'){
				boxArray[i].setFill(Color.rgb(191, 158, 36));
				//System.out.println("Yellow");
			}
			else {
				boxArray[i].setFill(Color.rgb(189, 60, 43));
				//System.out.println("Red");
			}
			textArray[i].setText((text.charAt(i)+"").toUpperCase());
			textArray[i].setVisible(true);
		}

	}
}
