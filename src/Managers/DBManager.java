package Managers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import People.Student;

/*
 * 1.import --> java.sql
 * 2.load and register driver --> com.mysql.jdbc.Driver
 * 3.create connection --> Connection
 * 4.create a statement --> Statement
 * 5.execute the query ->
 * 6.process the results ->
 * 7.close
 * 
 * DML: executeUpdate()
 * DQL: executeQuery()
 */

public class DBManager {
	
	String url, username, password;
	Connection con;
	
	public DBManager(String url, String username, String password) throws Exception {
		this.url = url;
		this.username = username;
		this.password = password;
		
		initConnection();
	}
	
	void initConnection() throws Exception{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			System.out.println("CONNECTION SUCCESSFUL");
	}
	
	
	public void stopConnection() throws Exception{
			System.out.println("CONNECTED TERMINATED");
			con.close();
	}
	
	public ResultSet query(String query) throws Exception{
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		return rs;
	}
	
	int update(String update) throws Exception{
		Statement st = con.createStatement();
		int count = st.executeUpdate(update);
		return count;
	}
	
	public void printResultSet(ResultSet rs) throws Exception {
		
		String data = "";
		
		while(rs.next()) {
			data = rs.getInt(1) + " : " + rs.getString(2);
			System.out.println(data);
		}
		rs.close();
	}
	
	public List<Student> queryStudent(String query) throws Exception {
		List<Student> studentList = new ArrayList<Student>();
		ResultSet queryResult = query(query);
		while(queryResult.next()) {
		 	studentList.add(new Student(queryResult));
		}
		queryResult.close();
		return studentList;
	}
}