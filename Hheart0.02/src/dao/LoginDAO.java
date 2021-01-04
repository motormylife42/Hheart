package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;


public class LoginDAO {

	private final String JDBC_URL="jdbc:h2:~/example";
	private final String DB_USER="sa";
	private final String DB_PASS="";
	//DB情報設定

	public List<User>findAll() {
		List<User> empList = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql ="SELECT MAIL,PASS FROM LOGININFO";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			//SQL関連

		while(rs.next()) {
			String id = rs.getString("MAIL");
			String pass = rs.getString("PASS");
			User user = new User(id, pass);
			empList.add(user);

		}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return empList;
	}
	
}