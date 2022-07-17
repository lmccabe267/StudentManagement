import Managers.DBManager;
import Managers.SystemManager;

public class Main {
	
	static boolean online = true;
	static boolean login_override = true;
	
	public static void main(String[]args) throws Exception{
		
		if(online) {
			DBManager dbm = new DBManager("jdbc:mysql://localhost:3306/school", "root", args[0]);
			new SystemManager(dbm, login_override);
		}else {
			new SystemManager(null, login_override);
		}
	}
	
	
}
