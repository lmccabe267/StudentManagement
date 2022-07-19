package Panels;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Managers.DBManager;
import Panels.Dialogs.CreateStudentDialog;

@SuppressWarnings("serial")
public class HomePanel extends JPanel {
	
	JFrame parent;
	
	public HomePanel(DBManager dbm, JFrame parent) {
		this.parent = parent;
		setLayout(new BorderLayout());
		StudentListPanel studentListPanel = new StudentListPanel(dbm);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem newStudent = new JMenuItem("new");
		newStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(CreateStudentDialog.showDialog(parent));
				
			}
			
		});
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

