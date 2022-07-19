package Managers;
import java.awt.Dimension;

import javax.swing.JFrame;

import Panels.*;

@SuppressWarnings("serial")
public class WindowManager extends JFrame{
	
	DBManager dbm;
	
	public WindowManager(DBManager dbm, boolean override) {
		this.dbm = dbm;
		setSize(new Dimension(1000, 750));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("MANAGER");
		
		try {
			initLogin(override);			
		}catch(Exception e) {
			
		}
		
		getContentPane().removeAll();
		getContentPane().invalidate();
		getContentPane().add(new HomePanel(dbm, this));
		getContentPane().revalidate();
	}
	
	
	
	//displays login page and verifies login, if override is true, page is not displayed and user is logged in
	void initLogin(boolean override) throws InterruptedException {
		Login login = new Login();
		add(login);
		setVisible(true);
		if(override) {
			System.out.println("LOGIN OVERRIDEN");
			System.out.println("login successful");
			return;
		}
		while(!login.checkLoginStatus()) {
			Thread.sleep(500);
		}
		System.out.println("login successful");
	}
	
	
	
}