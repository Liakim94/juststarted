package hrinfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn {
	private static Connection con = null;
	public static Connection getcon() throws ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##hr";
		String pw ="hr";
		
		Class.forName("oracle.jdbc.OracleDriver");
		con = DriverManager.getConnection(url,user,pw);
		return con;
		
	}
		
}
