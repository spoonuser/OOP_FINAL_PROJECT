package views;

import java.util.Scanner;

public class UserInterface {

    private static final Scanner scanner = new Scanner(System.in);

    
    public static void displayWelcomeMenu() {
        System.out.println("Welcome to WSP!");
        System.out.println("Select an option:");
        System.out.println("1. Регистрация");
        System.out.println("2. Вход");
        System.out.println("3. Выход");
        System.out.print("какую выберишь?  ");
    }

    
    public static int getUserChoice() {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 3) {
                    break;
                } else {
                    System.out.println("Пожалуйста, выберите от 1 до 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите число от 1 до 3.");
            }
        }
        return choice;
    }

    // Метод для получения строки от пользователя
    public static String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    // Метод для закрытия сканнера (если потребуется в конце программы)
    public static void closeScanner() {
        scanner.close();
    }
}
