package models;

public class Teacher extends Employee {

    public Teacher(String login, String password, double salary) {
        super(login, password, salary);
    }

    @Override
    public void displayEmployeeInfo() {
        System.out.println("You are a teacher. Salary: " + salary);
    }

    @Override
    public void displayUserInfo() {
        System.out.println("You are a teacher");
        displayEmployeeInfo();
    }
}
