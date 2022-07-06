package Managers;

public class SystemManager {
	
	DBManager dbm;
	Window window;
	
	public SystemManager(DBManager dbm, boolean override) {
		this.dbm = dbm;
		window = new Window(dbm, override);
	}
	
	
}
