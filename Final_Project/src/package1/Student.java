package package1;

import javax.swing.*;

public class Student extends User {
	public String id;
	public String course = "<html>"
	         + "1. PP1<br>"
	         + "2. PP2<br>"
	         + "3. Calculus<br>"
	         + "4. English Intermediate(B1)<br>"
	         + "5. Database<br>"
	         + "6. ADS"
	         + "</html>";
    public Student(String name, int age, String login, String password, String type, String id) {
    	super(name, age, login, password, type);
    	this.id = id;
	}
    public String view_courses() {
    	return course;
    }
    public String get_id() {
    	return id;
    }

	
}
