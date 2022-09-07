package Panels;

import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Managers.DBManager;
import People.Student;

public class StudentInfoPanel extends JPanel{
	
	DBManager dbm;
	StudentListPanel studentListPanel;
	JLabel firstNameLabel, lastNameLabel, idLabel, gradeLabel;
	JTextField firstName, lastName, id, grade;
	JButton edit, delete;
	Boolean editing = false;
	
	public StudentInfoPanel(DBManager dbm) {
		this.dbm = dbm;
		
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setLayout(new GridLayout(3,4));
		
		edit = new JButton("Edit");
		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(editing) {
					firstName.setEditable(false);
					lastName.setEditable(false);
					id.setEditable(false);
					grade.setEditable(false);
					editing = false;
					edit.setText("Edit");
				}else {					
					firstName.setEditable(true);
					lastName.setEditable(true);
					id.setEditable(true);
					grade.setEditable(true);
					editing = true;
					edit.setText("Done");
				}
				
			}
		});
		delete = new JButton("Delete");
		
		setBorder(new EmptyBorder(10, 10, 10, 10));
		firstNameLabel = new JLabel("First Name:");
		lastNameLabel = new JLabel("Last Name:");
		idLabel = new JLabel("ID:");
		gradeLabel = new JLabel("Grade:");
		
		firstName = new JTextField(35);
		firstName.setEditable(false);
		lastName = new JTextField(35);
		lastName.setEditable(false);
		id = new JTextField(35);
		id.setEditable(false);
		grade = new JTextField(35);
		grade.setEditable(false);
		
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(studentListPanel, "Delete selected student?", "Are you sure?",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if(confirm == JOptionPane.YES_OPTION) {					
					deleteSelected(studentListPanel.getSelected());
				}
			}
			
		});
		
		add(idLabel);
		add(id);
		
		add(firstNameLabel);
		add(firstName);
		
		add(lastNameLabel);
		add(lastName);
		
		add(gradeLabel);
		add(grade);
		
		add(edit);
		add(delete);
		
		
	}
	
	public int updateSelected(Student student) {
		try {
			id.setText(student.getID() + "");
			firstName.setText(student.getFirstName());
			lastName.setText(student.getLastName());
			grade.setText(student.getGrade() + "");
			System.out.println(student);
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int deleteSelected(Student student) {
		try {
			System.out.println(student.getFirstName());
			dbm.deleteStudent(student);
			studentListPanel.updateTable();
			return 1;
		}catch(Exception e) {
			System.out.println("Error deleting student: " + student.getID());
		}
		return -1;
	}
	
	public void add(StudentListPanel slp) {
		this.studentListPanel = slp;
	}
	
	private void updateStudent(Student student) {
		
	}
	
}