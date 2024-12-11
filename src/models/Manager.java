package models;

public class Manager extends Employee {

    public Manager(String login, String password, double salary) {
        super(login, password, salary);
    }

    @Override
    public void displayEmployeeInfo() {
        System.out.println("You are a manager. Salary: " + salary);
    }

    @Override
    public void displayUserInfo() {
        System.out.println("You are a manager");
        displayEmployeeInfo();
    }
}
