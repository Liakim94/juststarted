package hrinfo;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Controller implements Initializable{
	
	@FXML private Button btn1, btn2, btn3, btn4;
	@FXML private TextField tf1, tf2, tf3, text;
	StuDao dao;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dao = new StuDao();
		try {
			dao.connect();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		btn1.setOnAction(e->{
			try {
				handle1(e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		btn2.setOnAction(e -> {
			try {
				handle2(e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		btn3.setOnAction(e -> {
			try {
				handle3(e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		btn4.setOnAction(e -> {
			try {
				handle4(e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
	}
private void handle4(ActionEvent e) throws SQLException {
	Student st = new Student(tf2.getText(), tf3.getText(),tf1.getText());
	dao.delete(st);
		
	}
private void handle3(ActionEvent e) throws SQLException {
		Student st = new Student(tf2.getText(), tf3.getText(),tf1.getText());
		dao.update(st);
		
	}
private void handle2(ActionEvent e) throws SQLException {
		Student st = new Student(tf2.getText(), tf3.getText(),tf1.getText());
		dao.insert(st);
		
	}
private void handle1(ActionEvent e) throws ClassNotFoundException, SQLException {
	Student st = dao.getInfo(tf1.getText());
	tf1.setText(st.id);
	tf2.setText(st.name);
	tf3.setText(st.phone);

}

}
