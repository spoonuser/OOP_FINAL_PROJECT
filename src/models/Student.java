package models;

public class Student extends User {

    public Student(String login, String password) {
        super(login, password);
    }

    @Override
    public void displayUserInfo() {
        System.out.println("You are student");
    }
}
