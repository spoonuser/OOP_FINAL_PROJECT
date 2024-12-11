package models;

public abstract class Employee extends User {
    protected double salary;

    public Employee(String login, String password, double salary) {
        super(login, password);
        this.salary = salary;
    }

    public abstract void displayEmployeeInfo();
}
