package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;


public class Controller {
	
	@FXML
	private AnchorPane anchorPane;
	
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
	
	
	private int entryID = -1;
	
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
		}
	}
	
	public void evaluateRow(String text, int entryID) {
		
		char[] characters = text.toCharArray();
		char[] characterCategories = WordMethods.evaluateWord(text);
		
		Rectangle[] boxArray; 
		
		switch(entryID) {
		case(0):
			boxArray = new Rectangle[]{box0, box1, box2, box3, box4};
			break;
		case(1):
			boxArray = new Rectangle[]{box5, box6, box7, box8, box9};
			break;
		case(2):
			boxArray = new Rectangle[]{box10, box11, box12, box13, box14};
			break;
		case(3):
			boxArray = new Rectangle[]{box15, box16, box17, box18, box19};
			break;
		case(4):
			boxArray = new Rectangle[]{box20, box21, box22, box23, box24};
			System.out.println(WordMethods.getAnswer());
			break;
		default:
			boxArray = null;
			break;
		}
		
		
		
		
		
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
		}
	}
}
