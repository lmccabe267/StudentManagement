package Panels.Dialogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import People.Student;

public class CreateStudentDialog {
	static JDialog dialog;
	static int size;
	static String name;
	static Student student;
	
	public CreateStudentDialog() {
		
	}
	
	public static Student showDialog(JFrame parent) {
		dialog = new JDialog(parent, "Create New Student", true);
		dialog.setLayout(new BorderLayout());
		dialog.setLocationRelativeTo(null);
		new Window();
		dialog.dispose();
		return student;
	}
	
	public static class Window{
		public Window() {
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			JLabel idLabel = new JLabel("Student ID:");
			JTextField idEntry = new JTextField(35);
			JLabel firstNameLabel = new JLabel("Student First Name:");
			JTextField firstNameEntry = new JTextField(35);
			JLabel lastNameLabel = new JLabel("Student Last Name:");
			JTextField lastNameEntry = new JTextField(35);
			JLabel gradeLabel = new JLabel("Student Grade:");
			Integer grades[] = {0,1,2,3,4,5,6,7,8,9,10,11,12}; 
			JComboBox<Integer> gradeEntry = new JComboBox<Integer>(grades);
			JButton submit = new JButton("Submit");
			submit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(!firstNameEntry.getText().equals("") && !lastNameEntry.getText().equals("") && !idEntry.getText().equals("")) {
						int grade = grades[gradeEntry.getSelectedIndex()];
						try {
							student = new Student(Integer.parseInt(idEntry.getText()), firstNameEntry.getText(), lastNameEntry.getText(), grade);
							dialog.dispose();
						}catch(Exception ex) {
							ex.printStackTrace();
							System.out.println("ERROR CREATING STUDENT");
						}
					}
					
				}
				
			});
			
			
			panel.add(idLabel);
			panel.add(idEntry);
			panel.add(firstNameLabel);
			panel.add(firstNameEntry);
			panel.add(lastNameLabel);
			panel.add(lastNameEntry);
			panel.add(gradeLabel);
			panel.add(gradeEntry);
			panel.add(submit);
			dialog.add(panel, BorderLayout.CENTER);
			dialog.pack();
			dialog.setVisible(true);
		}
	}
}
