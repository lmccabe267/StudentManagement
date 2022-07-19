package Panels;
import java.awt.BorderLayout;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Managers.DBManager;

@SuppressWarnings("serial")
public class HomePanel extends JPanel {
	
	public HomePanel(DBManager dbm) {
		
		setLayout(new BorderLayout());
		StudentListPanel studentListPanel = new StudentListPanel(dbm);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem newStudent = new JMenuItem("new");
		JMenuItem delete = new JMenuItem("delete");
		JMenuItem logout = new JMenuItem("logout");
		
		
		file.add(newStudent);
		file.add(delete);
		file.add(logout);
		menuBar.add(file);

		

		add(menuBar, BorderLayout.NORTH);
		add(studentListPanel, BorderLayout.CENTER);
		setVisible(true);
	}
}

