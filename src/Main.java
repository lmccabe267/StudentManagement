
public class Main {
	
	public static void main(String[]args) throws Exception{
		DBManager dbm = new DBManager("jdbc:mysql://localhost:3306/school", "root", args[0]);
		
		dbm.printResultSet(dbm.query("SELECT * FROM students"));
		
		dbm.stopConnection();
		
	}
	
	
}
