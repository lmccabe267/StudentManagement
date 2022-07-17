package People;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
	
	int STUDENT_ID;
	String STUDENT_NAME;
	
	public Student(ResultSet rs) throws SQLException {
		STUDENT_ID = rs.getInt(1);
		STUDENT_NAME = rs.getString(2);
	}
	
	
	public String toString() {
		return(STUDENT_ID + " " + STUDENT_NAME);
	}
	
	public int getID() {
		return STUDENT_ID;
	}
	
	public String getName() {
		return STUDENT_NAME;
	}
}
