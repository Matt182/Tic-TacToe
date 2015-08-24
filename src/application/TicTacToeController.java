package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;

public class TicTacToeController {
	private boolean isFirstPlayer = true;
	
	@FXML Button b1;    
	@FXML Button b2;   
	@FXML Button b3; 
	@FXML Button b4; 
	@FXML Button b5; 
	@FXML Button b6;  
	@FXML Button b7;  
	@FXML Button b8;  
	@FXML Button b9;   
	@FXML GridPane gameBoard;

	
	public void menuClickHandler(ActionEvent evt){
		MenuItem clickedMenu = (MenuItem) evt.getTarget();
		String menuLbl = clickedMenu.getText();
		
		if(menuLbl.equals("Play")){
			ObservableList<Node> btns = gameBoard.getChildren();
			btns.forEach(btn ->{
				((Button) btn).setText("");
				((Button) btn).setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						buttonClickHandler(event);
						
					}
					
				});
				btn.getStyleClass().remove("winning-button");
			});
			isFirstPlayer = true;
		}
	}
	
	@FXML public void buttonClickHandler(ActionEvent evt){
		Button clickedBtn = (Button) evt.getTarget();
		String btnlbl = clickedBtn.getText();
		
		if (btnlbl.equals("") && isFirstPlayer){
			clickedBtn.setText("X");
			isFirstPlayer = false;
		}else if(btnlbl.equals("") && !isFirstPlayer){
			clickedBtn.setText("O");
			isFirstPlayer = true;
		}
		if(find3InARow() || find3InACol() || find3InADia()){
			removeHandlers();
		}
		
	}
	
	private void removeHandlers(){
		ObservableList<Node> btns = gameBoard.getChildren();
		btns.forEach(btn -> {
			((Button) btn).setOnAction(null);
		});
	}
	
	private boolean find3InARow(){
		
		if(isFirstPlayer){
			if(b1.getText().equals("O") && b2.getText().equals("O") && b3.getText().equals("O")){
				HighLight(b1,b2,b3);
				return true;
			} else if(b4.getText().equals("O") && b5.getText().equals("O") && b6.getText().equals("O")){
				HighLight(b4,b5,b6);
				return true;
			}else if(b7.getText().equals("O") && b8.getText().equals("O") && b9.getText().equals("O")){
				HighLight(b7,b8,b9);
				return true;
			}else{
				return false;
			}
		}else{
			if(b1.getText().equals("X") && b2.getText().equals("X") && b3.getText().equals("X")){
				HighLight(b1,b2,b3);
				return true;
			} else if(b4.getText().equals("X") && b5.getText().equals("X") && b6.getText().equals("X")){
				HighLight(b4,b5,b6);
				return true;
			}else if(b7.getText().equals("X") && b8.getText().equals("X") && b9.getText().equals("X")){
				HighLight(b7,b8,b9);
				return true;
			}else{
				return false;
			}
		}
	}
	private boolean find3InACol(){
		
		if(isFirstPlayer){
			if(b1.getText().equals("O") && b4.getText().equals("O") && b7.getText().equals("O")){
				HighLight(b1,b4,b7);
				return true;
			} else if(b2.getText().equals("O") && b5.getText().equals("O") && b8.getText().equals("O")){
				HighLight(b2,b5,b8);
				return true;
			}else if(b3.getText().equals("O") && b6.getText().equals("O") && b9.getText().equals("O")){
				HighLight(b3,b6,b9);
				return true;
			}else{
				return false;
			}
		}else{
			if(b1.getText().equals("X") && b4.getText().equals("X") && b7.getText().equals("X")){
				HighLight(b1,b4,b7);
				return true;
			} else if(b2.getText().equals("X") && b5.getText().equals("X") && b8.getText().equals("X")){
				HighLight(b2,b5,b8);
				return true;
			}else if(b3.getText().equals("X") && b6.getText().equals("X") && b9.getText().equals("X")){
				HighLight(b3,b6,b9);
				return true;
			}else{
				return false;
			}
		}
	}
	private boolean find3InADia(){
	
		if (isFirstPlayer){
			if(b1.getText().equals("O") && b5.getText().equals("O") && b9.getText().equals("O")){
				HighLight(b1,b5,b9);
				 return true;
			}else if(b3.getText().equals("O") && b5.getText().equals("O") && b7.getText().equals("O")){
				HighLight(b3,b5,b7);
				return true;
			}else{
				return false;
			}
		}else{
			if(b1.getText().equals("X") && b5.getText().equals("X") && b9.getText().equals("X")){
				HighLight(b1,b5,b9);
				 return true;
			}else if(b3.getText().equals("X") && b5.getText().equals("X") && b7.getText().equals("X")){
				HighLight(b3,b5,b7);
				return true;
			}else{
				return false;
		}
		}
	}
	private void HighLight(Button first, Button sec, Button third){
		first.getStyleClass().add("winning-button");
		sec.getStyleClass().add("winning-button");
		third.getStyleClass().add("winning-button");
	}
}
