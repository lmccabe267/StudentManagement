package Panels;

import java.awt.ComponentOrientation;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Managers.DBManager;
import People.Student;

public class StudentInfoPanel extends JPanel{
	
	DBManager dbm;
	JLabel firstNameLabel, lastNameLabel, idLabel;
	JTextField firstName, lastName, id;
	JButton edit, delete;
	
	public StudentInfoPanel(DBManager dbm) {
		this.dbm = dbm;
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setLayout(new GridLayout(4,2));
		
		edit = new JButton("Edit");
		delete = new JButton("Delete");
		
		setBorder(new EmptyBorder(10, 10, 10, 10));
		firstNameLabel = new JLabel("First Name:");
		lastNameLabel = new JLabel("Last Name:");
		idLabel = new JLabel("ID:");
		
		firstName = new JTextField(35);
		firstName.setEditable(false);
		lastName = new JTextField(35);
		lastName.setEditable(false);
		id = new JTextField(35);
		id.setEditable(false);
		
		add(idLabel);
		add(id);
		
		add(firstNameLabel);
		add(firstName);
		
		add(lastNameLabel);
		add(lastName);
		
		add(edit);
		add(delete);
		
		
	}
	
	public int updateSelected(Student student) {
		try {
			id.setText(student.getID() + "");
			firstName.setText(student.getFirstName());
			lastName.setText(student.getLastName());
			System.out.println(student);
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	
	
}