
public class SystemManager {
	
	DBManager dbm;
	Window window;
	
	
	public SystemManager(DBManager dbm) {
		this.dbm = dbm;
		window = new Window(dbm);
	}
}
