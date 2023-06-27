package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database {

	private static Database instance = new Database();
	private String url = "jdbc:mysql://localhost:3306/?autoReconnect=true";
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String user = "root";
	private String password = "admin";
	
	private Database() {}
	
	public static Database getinstance() {
		return instance;
	}
	
	public Connection getConnection() {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, user, password);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void maakDB(Connection conn) {
		try {
			conn.createStatement().executeUpdate("CREATE DATABASE IF NOT EXISTS cardgame");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void maakTabel(Connection conn) {
		try {
			conn.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS cardgame.score (id int PRIMARY KEY AUTO_INCREMENT, name varchar(255), score int)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertScore(Connection conn, String naam, int score) {
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO cardgame.score (name, score) VALUES (?, ?)");
			ps.setString(1, naam);
			ps.setInt(2, score);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String displayLeaderboard(Connection conn) {
		
		StringBuilder sb = new StringBuilder();
		
		try {
			
			ResultSet rs = conn.createStatement().executeQuery("SELECT name, score FROM cardgame.score ORDER BY score DESC LIMIT 10");
			int index = 0;
			
			while (rs.next()) {
				index++;
				sb.append("<tr><th scope='row'>" + index + "</th><td>" + rs.getString("name") + "</td><td>" + rs.getInt("score") + "</td></tr>");
			}
			
			if (index == 0) {
				sb.append("<tr><td colspan='3'>No scores found!</td></tr>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
}
