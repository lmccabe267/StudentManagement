package Panels;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Login extends JPanel{
	
	private boolean loggedIn = false;
	
	public Login() {
		
		setLayout(new FlowLayout());
		JLabel prompt = new JLabel("Enter Password:");
		JTextField entry = new JTextField(35);
		//entry.setBounds(new Rectangle(100, 75, 93, 28));
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					loggedIn = checkPassword(entry.getText());
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		
		
		add(prompt);
		add(entry);
		add(submit);
	}
	
	/*
	boolean checkPassword(String password) throws FileNotFoundException {
		if(password.equals(this.password))return true;
		return false;
	}
	*/
	
	boolean checkPassword(String password) throws Exception{
		
		File file = new File("res/logins.dat");
		Scanner scan = new Scanner(file);
		if(password.equals(scan.next())) {
			scan.close();
			System.out.println("logged in");
			return true;
		}
		System.out.println("incorrect password");
		scan.close();
		return false;
	}
	
	public boolean checkLoginStatus() {
		return loggedIn;
	}
	
}
