package Managers;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import Panels.HomePanel;
import Panels.Login;
import Panels.StudentInfoPanel;

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
		this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
            	try {
					dbm.stopConnection();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
                System.exit(0);
            }
        });
		try {
			initLogin(override);			
		}catch(Exception e) {
			
		}
		
		getContentPane().removeAll();
		getContentPane().invalidate();
		getContentPane().add(new HomePanel(dbm, this, new StudentInfoPanel(dbm)));
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
