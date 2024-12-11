package controllers;

import models.*;
import views.UserInterface;
import java.util.Scanner;

public class AuthenticationController {

    public static void registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите логин: ");
        String login = scanner.nextLine();

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        UserInterface.displayRoleSelectionMenu();

        int roleChoice = scanner.nextInt();
        scanner.nextLine();  // Для считывания остаточного символа новой строки

        User newUser = null;

        switch (roleChoice) {
            case 1: // Студент
                newUser = new Student(login, password);
                break;
            case 2: // Учитель
                System.out.print("Введите зарплату: ");
                double salaryTeacher = scanner.nextDouble();
                newUser = new Teacher(login, password, salaryTeacher);
                break;
            case 3: // Менеджер
                System.out.print("Введите зарплату: ");
                double salaryManager = scanner.nextDouble();
                newUser = new Manager(login, password, salaryManager);
                break;
            default:
                System.out.println("Неверный выбор.");
                return;
        }

        UserDatabase.addUser(newUser);  // Добавляем пользователя в базу и сохраняем в файл
        UserInterface.displayRegistrationSuccess();
    }

    public static void loginUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите логин: ");
        String login = scanner.nextLine();

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        User user = UserDatabase.findUser(login, password);

        if (user == null) {
            UserInterface.displayLoginError();
        } else {
            UserInterface.displayLoginSuccess();
            user.displayUserInfo();
        }
    }
}
