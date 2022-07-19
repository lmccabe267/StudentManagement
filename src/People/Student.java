package People;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
	
	int STUDENT_ID;
	String STUDENT_NAME;
	int STUDENT_GRADE;
	
	public Student(ResultSet rs) throws SQLException {
		STUDENT_ID = rs.getInt(1);
		STUDENT_NAME = rs.getString(2);
		STUDENT_GRADE = rs.getInt(3);
	}
	
	public Student(int id, String name, int grade) {
		this.STUDENT_ID = id;
		this.STUDENT_NAME = name;
		this.STUDENT_GRADE = grade;
	}
	
	
	public String toString() {
		return(STUDENT_ID + " " + STUDENT_NAME + " " + STUDENT_GRADE);
	}
	
	public int getID() {
		return STUDENT_ID;
	}
	
	public String getName() {
		return STUDENT_NAME;
	}
	
	public int getGrade() {
		return STUDENT_GRADE;
	}
}
