package Panels;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Login extends JPanel{
	
	String password = "password";
	
	
	public Login() {
		try {
			checkPassword("password");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	boolean checkPassword(String password) throws FileNotFoundException {
		if(password.equals(this.password))return true;
		return false;
	}
	
}
