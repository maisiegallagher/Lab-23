package co.grandcircus.Lab23;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.grandcircus.Lab23.Grade;

@Component
public class GradesDaoOld {
	
	public List<Grade> findAll() {
		try (Connection conn = getDBConnection()) {
			String query = "SELECT * FROM grade";
			// Step 3: create statement
			PreparedStatement st = conn.prepareStatement(query);
	
			// Step 4: retrieve results
			ResultSet rs = st.executeQuery();
	
			// Step 5: process results
			ArrayList<Grade> list = new ArrayList<>();
			while (rs.next()) {
				Long id = rs.getLong("id");
				String name = rs.getString("name");
				String type = rs.getString("type");
				double score = rs.getDouble("score");
				double total = rs.getDouble("total");
				list.add(new Grade(id, name, type, score, total));
			}
			
			return list;
		} catch(Exception ex) {
			ex.printStackTrace();
			return new ArrayList<>(0);
		}
	}

	private Connection getDBConnection() throws ClassNotFoundException, SQLException {
		// prep for step # 2
		String url = "jdbc:mysql://localhost:3306/lab23?useSSL=false";
		String userName = "maisiegallagher";
		String password = "java2020";

		// Step #1: Load and Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step #2: Create Connection
		Connection con = DriverManager.getConnection(url, userName, password);
		return con;
	}
}