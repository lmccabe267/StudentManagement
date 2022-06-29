import java.sql.*;

/*
 * 1.import --> java.sql
 * 2.load and register driver --> com.mysql.jdbc.Driver
 * 3.create connection --> Connection
 * 4.create a statement --> Statement
 * 5.execute the query ->
 * 6.process the results ->
 * 7.close
 */



public class Main {
	public static void main(String[]args) throws Exception{
		
		String url = "jdbc:mysql://localhost:3306/school";
		String uname = "root";
		String pass = args[0];
		String query = "select name from students where student_id=2";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		rs.next();
		String name = rs.getString("name");
		
		System.out.println(name);
		
		st.close();
		con.close();
	}
}
