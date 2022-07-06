package Panels;
import java.awt.BorderLayout;
import java.util.List;
import java.util.Objects;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Managers.DBManager;
import People.Student;

public class HomePanel extends JPanel {
	
	DBManager dbm;
	JScrollPane studentListScroll;
	List<Student> studentList;
	JList<Student> studentJList;
	DefaultListModel<Student> model;
	
	public HomePanel(DBManager dbm) {
		this.dbm = dbm;
		setLayout(new BorderLayout());
		
		
		model = new DefaultListModel<Student>();
		
		try {
			studentList = dbm.queryStudent("SELECT * FROM students");
			for(Student student: studentList) {
				model.addElement(student);
			}
			studentJList = new JList<Student>(model);
			studentListScroll = new JScrollPane(studentJList);
			
			add(studentListScroll);
			setVisible(true);
		}catch(Exception e) {
			System.out.println("Error populating studentList");
			if(Objects.isNull(dbm)) {
				System.out.println("DATABASE IS OFFLINE");
			}
			e.printStackTrace();
		}
		
	}
}
