package hrinfo;

import java.sql.SQLException;

public class test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		StuDao sd = new StuDao();
		sd.connect();
		int r = sd.delete(new Student(null,null,"99"));
		
		

	}

}
