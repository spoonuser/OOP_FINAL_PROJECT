package main;

import models.User;
import models.Student;
import models.Teacher;
import models.Manager;
import utils.DataManager;
import views.UserInterface;

import java.util.List;
import java.util.Scanner;

public class TestApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<User> users = DataManager.loadUsers();

        while (true) {
            // Показываем главное меню
            UserInterface.displayWelcomeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка после ввода числа

            switch (choice) {
                case 1: // Регистрация
                    System.out.println("Введите логин:");
                    String login = scanner.nextLine();

                    System.out.println("Введите пароль:");
                    String password = scanner.nextLine();

                    System.out.println("Выберите роль:");
                    System.out.println("1. Студент");
                    System.out.println("2. Преподаватель");
                    System.out.println("3. Менеджер");

                    int roleChoice = scanner.nextInt();
                    scanner.nextLine(); // Очистка после ввода числа

                    User newUser;
                    switch (roleChoice) {
                        case 1:
                            newUser = new Student(login, password);
                            break;
                        case 2:
                            System.out.println("Введите зарплату преподавателя:");
                            double teacherSalary = scanner.nextDouble();
                            scanner.nextLine(); // Очистка после ввода числа
                            newUser = new Teacher(login, password, teacherSalary);
                            break;
                        case 3:
                            System.out.println("Введите зарплату менеджера:");
                            double managerSalary = scanner.nextDouble();
                            scanner.nextLine(); // Очистка после ввода числа
                            newUser = new Manager(login, password, managerSalary);
                            break;
                        default:
                            System.out.println("Неверный выбор роли. Попробуйте снова.");
                            continue;
                    }

                    users.add(newUser);
                    DataManager.saveUsers(users);
                    System.out.println("Пользователь успешно зарегистрирован!");
                    break;

                case 2: // Вход
                    System.out.println("Введите логин:");
                    String loginInput = scanner.nextLine();

                    System.out.println("Введите пароль:");
                    String passwordInput = scanner.nextLine();

                    boolean loggedIn = false;
                    for (User user : users) {
                        if (user.getLogin().equals(loginInput) && user.getPassword().equals(passwordInput)) {
                            loggedIn = true;
                            System.out.println("Добро пожаловать, " + user.getLogin() + "!");
                            user.displayUserInfo();
                            break;
                        }
                    }

                    if (!loggedIn) {
                        System.out.println("Неверный логин или пароль. Попробуйте снова.");
                    }
                    break;

                case 3: // Выход
                    System.out.println("Выход из программы...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}
