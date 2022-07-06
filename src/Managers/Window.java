package Managers;
import java.awt.Dimension;

import javax.swing.JFrame;

import Panels.*;

@SuppressWarnings("serial")
public class Window extends JFrame{
	
	DBManager dbm;
	
	public Window(DBManager dbm, boolean override) {
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
		getContentPane().add(new HomePanel(dbm));
		getContentPane().revalidate();
	}
	
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
