package People;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
	
	int STUDENT_ID;
	String STUDENT_FIRST_NAME;
	String STUDENT_LAST_NAME;
	int STUDENT_GRADE;
	
	public Student(ResultSet rs) throws SQLException {
		STUDENT_ID = rs.getInt(1);
		STUDENT_FIRST_NAME = rs.getString(2);
		STUDENT_LAST_NAME = rs.getString(3);
		STUDENT_GRADE = rs.getInt(4);
	}
	
	public Student(int id, String firstName, String lastName, int grade) {
		this.STUDENT_ID = id;
		this.STUDENT_FIRST_NAME = firstName;
		this.STUDENT_LAST_NAME = lastName;
		this.STUDENT_GRADE = grade;
	}
	
	
	public String toString() {
		return(STUDENT_ID + " " + STUDENT_FIRST_NAME + " " + STUDENT_LAST_NAME + " " + STUDENT_GRADE);
	}
	
	public int getID() {
		return STUDENT_ID;
	}
	
	public String getFirstName() {
		return STUDENT_FIRST_NAME;
	}
	
	public String getLastName() {
		return STUDENT_LAST_NAME;
	}
	
	public int getGrade() {
		return STUDENT_GRADE;
	}
}
