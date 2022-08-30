package Panels;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Managers.DBManager;
import Panels.Dialogs.CreateStudentDialog;
import People.Student;

@SuppressWarnings("serial")
public class HomePanel extends JPanel {
	
	JFrame parent;
	DBManager dbm;
	StudentInfoPanel infoPanel;
	
	public HomePanel(DBManager dbm, JFrame parent, StudentInfoPanel infoPanel) {
		this.parent = parent;
		this.dbm = dbm;
		this.infoPanel = infoPanel;
		
		setLayout(new BorderLayout());
		StudentListPanel studentListPanel = new StudentListPanel(dbm, infoPanel);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem newStudent = new JMenuItem("new");
		newStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Student temp = CreateStudentDialog.showDialog(parent);
					if(dbm.queryStudent("SELECT * from students WHERE student_id=" + temp.getID()).size() != 0) {
						JOptionPane.showMessageDialog(parent, "Student with id: " + temp.getID() + " already exists in database.");
					}else {
						dbm.createStudent(temp);
					}
					
					studentListPanel.updateTable();
				} catch (Exception e1) {
					System.out.println("ERROR CREATING STUDENT in HomePanel");
				}
			}
			
		});
		JMenuItem delete = new JMenuItem("delete");

		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(studentListPanel, "Delete selected student?", "Are you sure?",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if(confirm == JOptionPane.YES_OPTION) {					
					infoPanel.deleteSelected(studentListPanel.getSelected());
				}
			}
		});
		
		JMenuItem logout = new JMenuItem("logout");
		
		StudentInfoPanel infoPane = infoPanel;
		
		file.add(newStudent);
		file.add(delete);
		file.add(logout);
		menuBar.add(file);

		
		infoPanel.add(studentListPanel);
		
		add(menuBar, BorderLayout.NORTH);
		add(studentListPanel, BorderLayout.CENTER);
		add(infoPane, BorderLayout.SOUTH);
		setVisible(true);
	}
}

