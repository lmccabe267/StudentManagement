package Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import java.util.Objects;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Managers.DBManager;
import People.Student;

@SuppressWarnings("serial")
public class StudentListPanel extends JPanel{

	DBManager dbm;
	JScrollPane studentListScroll;
	JTable studentTable;
	int defaultWidth;
	
	public StudentListPanel(DBManager dbm) {
		this.dbm = dbm;
		setLayout(new BorderLayout());
		
		try {
			studentTable = createTable(dbm.queryStudent("SELECT * FROM students"), dbm.getColumnHeaders(dbm.query("SELECT * FROM students")));
			studentTable.setGridColor(Color.black);
			studentTable.setShowGrid(true);
			studentTable.setShowVerticalLines(true);
			studentListScroll = new JScrollPane(studentTable);
			
			JLabel title = new JLabel("STUDENTS");
			
			add(title, BorderLayout.NORTH);			
			add(studentListScroll, BorderLayout.CENTER);
			setVisible(true);
		}catch(Exception e) {
			System.out.println("Error populating studentList");
			if(Objects.isNull(dbm)) {
				System.out.println("DATABASE IS OFFLINE");
			}
			e.printStackTrace();
		}
		
	}
	
	
	private JTable createTable(List<Student> studentList, List<String> headers) {
		String columns[] = new String[headers.size()];
		for(int i = 0; i < columns.length; ++i) {
			columns[i] = headers.get(i);
		}
		String data[][] = new String[studentList.size()][headers.size()];
		
		int i = 0;
		for(Student student: studentList) {
			data[i][0] = student.getID() + "";
			data[i][1] = student.getFirstName();
			data[i][2] = student.getLastName();
			data[i][3] = student.getGrade() + "";
			++i;
		}
		
		DefaultTableModel model = new DefaultTableModel(data, columns);
		System.out.println("table generated");
		return new JTable(model) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
	}
	
	public void updateTable() {
		try {
			studentTable = createTable(dbm.queryStudent("SELECT * FROM students"), dbm.getColumnHeaders(dbm.query("SELECT * FROM students")));
			redrawTable(studentTable);
		} catch (Exception e) {
			System.out.println("ERROR UPDATING TABLE");
			e.printStackTrace();
		}
		
	}
	
	public void redrawTable(JTable table) {
		studentListScroll.setViewportView(table);
		studentTable.setGridColor(Color.black);
		studentTable.setShowGrid(true);
		studentTable.setShowVerticalLines(true);
	}
	
	
	
}
