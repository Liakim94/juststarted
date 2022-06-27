package hrinfo;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class Popup implements Initializable {
		  @FXML 
		  private TextField text;
		  
		  @Override
		  public void initialize(URL location, ResourceBundle resources){
		  }
		  
		  public void initData(String data) {
		    text.setText(data);

		}
}
