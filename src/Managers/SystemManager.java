package Managers;

public class SystemManager {
	
	DBManager dbm;
	WindowManager windowM;
	
	public SystemManager(DBManager dbm, boolean override) {
		this.dbm = dbm;
		windowM = new WindowManager(dbm, override);
	}
	
	
}
