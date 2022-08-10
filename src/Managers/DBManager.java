package Managers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
	
	
	
	/*
	 * Starts connection between the client and the mysql server
	 * Uses the variables that are defined within the constructor to begin connection
	 * 
	 *
	 */
	//connects to the SQL database
	void initConnection() throws Exception{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			System.out.println("CONNECTION SUCCESSFUL");
	}
	
	//stops connection to SQL database
	public void stopConnection() throws Exception{
			System.out.println("CONNECTED TERMINATED");
			con.close();
	}
	
	
	/*
	 * sends a query to the SQL database
	 * @param query a string to be sent as a query to the database
	 * @return rs a result set received from the database as a result of the sent query
	 */
	public ResultSet query(String query) throws Exception{
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		return rs;
	}
	
	/*
	 * sends an update statement to the mysql server in order to modify the database
	 * @param String update: sql query to be executed
	 * @returns int count: number of lines that were changed in the database
	 */
	int update(String update) throws Exception{
		Statement st = con.createStatement();
		int count = st.executeUpdate(update);
		return count;
	}
	
	/*
	 * prints all content in the dataset
	 * @param rs ResultSet to be printed
	 */
	public void printResultSet(ResultSet rs) throws Exception {
		
		String data = "";
		
		while(rs.next()) {
			data = rs.getInt(1) + " : " + rs.getString(2);
			System.out.println(data);
		}
		rs.close();
	}
	
	/*
	 * returns a list of student objects created from the ResultSet received from the query
	 * @param query query to be sent to the database
	 * @return studentList a list of student objects received from the databse
	 */
	public List<Student> queryStudent(String query) throws Exception {
		List<Student> studentList = new ArrayList<Student>();
		ResultSet queryResult = query(query);
		while(queryResult.next()) {
		 	studentList.add(new Student(queryResult));
		}
		queryResult.close();
		return studentList;
	}
	
	
	/*
	 * Method to get a list of column headers for a table based on a result set
	 * @param ResultSet rs: result set to have headers extracted from
	 * @returns List<String> a list of the column headers found in the result set
	 */
	public List<String> getColumnHeaders(ResultSet rs) throws Exception{
		ResultSetMetaData rsmd = rs.getMetaData();
		List<String> headers = new ArrayList<String>();
		int columnCount = rsmd.getColumnCount();
		
		for(int i = 1; i <= columnCount; ++i) {
			headers.add(rsmd.getColumnName(i));
		}
		
		return headers;
		
	}
	
	/*
	 * Adds the student information to the database using a Student Object
	 * @param Student student: student object to be added to the database
	 * @returns int count: the amount of lines changed in the database, -1 if failed
	 */
	public int createStudent(Student student){
		try {
			return update("INSERT INTO students VALUES (" + student.getID() + ", '" + student.getFirstName() + "', '" + student.getLastName() + "', " + student.getGrade() + ");");
		} catch (Exception e) {
			System.out.println("ERROR IN createStudent method");
		}
		return -1;
	}
	
	/*
	 * Deletes the from the database corresponding to the student object passed in
	 * @param Student student the student to be deleted
	 * @returns the amount of lines changed in the database, -1 if failed
	 */
	public int deleteStudent(Student student) {
		try {
			return update("DELETE FROM students WHERE student_id=" + student.getID());
		} catch (Exception e) {
			System.out.println("Error deleting student");
		}
		
		return -1;
	}
}