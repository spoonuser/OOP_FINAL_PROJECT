package controllers;

import models.*;
import views.UserInterface;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuController {

    // Храним пользователей в Map
    private static Map<String, User> users = new HashMap<>();

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            UserInterface.displayWelcomeMessage();  // Показать приветственное сообщение
            int choice = scanner.nextInt();  // Получить выбор пользователя

            switch (choice) {
                case 1: // Регистрация
                    registerUser();
                    break;
                case 2: // Вход
                    loginUser();
                    break;
                case 3: // Выход
                    System.out.println("Выход из программы...");
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void registerUser() {
        Scanner scanner = new Scanner(System.in);

        // Ввод логина и пароля
        System.out.println("Введите логин:");
        String username = scanner.nextLine();
        System.out.println("Введите пароль:");
        String password = scanner.nextLine();

        // Выбор роли
        System.out.println("Выберите вашу роль:");
        System.out.println("1. Студент");
        System.out.println("2. Учитель");
        System.out.println("3. Менеджер");
        int roleChoice = scanner.nextInt();

        User newUser = null;
        switch (roleChoice) {
            case 1:
                newUser = new Student(username, password);
                break;
            case 2:
                newUser = new Teacher(username, password);
                break;
            case 3:
                newUser = new Manager(username, password);
                break;
            default:
                System.out.println("Неверный выбор роли.");
                return;
        }

        // Сохраняем пользователя в карту
        users.put(username, newUser);
        System.out.println("Регистрация успешна! Пожалуйста, войдите.");
    }

    private static void loginUser() {
        Scanner scanner = new Scanner(System.in);

        // Ввод логина и пароля для входа
        System.out.println("Введите логин:");
        String username = scanner.nextLine();
        System.out.println("Введите пароль:");
        String password = scanner.nextLine();

        User user = users.get(username);

        // Проверка наличия пользователя и пароля
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Вход успешен!");

            // Переход в меню в зависимости от роли
            if (user instanceof Student) {
                ((Student) user).displayStudentMenu();
            } else if (user instanceof Teacher) {
                ((Teacher) user).displayTeacherMenu();
            } else if (user instanceof Manager) {
                ((Manager) user).displayManagerMenu();
            }
        } else {
            System.out.println("Неверный логин или пароль.");
        }
    }
}
