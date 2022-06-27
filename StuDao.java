package hrinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StuDao {
	private Connection con;
	PreparedStatement ps = null;
	Statement stmt = null;
	public Connection connect() throws ClassNotFoundException, SQLException {
		con = DBconn.getcon();
		return con;
	}
	public Student getInfo(String num) throws ClassNotFoundException, SQLException {
		Connection con;
		con = DBconn.getcon();
		ResultSet  rs = null;
		
		String sql = "SELECT name, phone, student_id FROM students_info WHERE student_id =?";
		ps = con.prepareStatement(sql);
		ps.setString(1, num);
		rs = ps.executeQuery();
		if (rs.next()) {
			String name = rs.getString("name");
			String phone = rs.getString("phone");
			String id = rs.getString("student_id");
			Student st = new Student(name, phone, id);
			return st;
		}
		return new Student("자료없음","--",num);
	}
	
	public int insert (Student st) throws SQLException {
		stmt = con.createStatement();
		String sql = "INSERT INTO students_info(name, phone, student_id) VALUES (?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, st.name);
		ps.setString(2, st.phone);
		ps.setString(3, st.id);
		int r =ps.executeUpdate();
		return r;	
	}
	public int update (Student st) throws SQLException {
		String sql = "UPDATE students_info SET phone =? WHERE student_id =? ";
		ps = con.prepareStatement(sql);
		ps.setString(1, st.phone);
		ps.setString(2, st.id);
		int r =ps.executeUpdate();
		return r;
		
	}
	public int delete(Student st) throws SQLException {
		String sql = "DELETE FROM students_info WHERE student_id =?";
		ps = con.prepareStatement(sql);
		ps.setString(1, st.id);
		int r = ps.executeUpdate();
		return r;
		
	}
    

}
