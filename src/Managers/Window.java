package Managers;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Panels.Login;

@SuppressWarnings("serial")
public class Window extends JFrame{
	
	DBManager dbm;
	
	public Window(DBManager dbm) {
		this.dbm = dbm;
		setSize(new Dimension(1000, 750));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("MANAGER");
		try {
			initLogin();			
		}catch(Exception e) {
			
		}
		
		getContentPane().removeAll();
		getContentPane().invalidate();
		getContentPane().add(new JPanel());
		getContentPane().revalidate();
	}
	
	void initLogin() throws InterruptedException {
		Login login = new Login();
		add(login);
		setVisible(true);
		while(!login.checkLoginStatus()) {
			Thread.sleep(500);
		}
		System.out.println("login successful");
	}
	
	
	
}
