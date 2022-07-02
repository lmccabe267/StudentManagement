
public class Main {
	
	static boolean online = false;
	
	public static void main(String[]args) throws Exception{
		
		if(online) {
			DBManager dbm = new DBManager("jdbc:mysql://localhost:3306/school", "root", args[0]);
			new SystemManager(dbm);
			dbm.printResultSet(dbm.query("SELECT * FROM students"));
			
			dbm.stopConnection();
		}else {
			new SystemManager(null);
		}
		
		
		
		
	}
	
	
}
