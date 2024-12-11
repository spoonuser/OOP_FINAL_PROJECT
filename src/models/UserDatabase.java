package models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private static List<User> users = new ArrayList<>();
    private static final String FILE_NAME = "/Users/fariza/eclipse-workspace/Telepuziki/src/data/user.txt";

    // Метод для добавления пользователя в базу
    public static void addUser(User user) {
        users.add(user);
        saveUsersToFile();  // Сохраняем данные после добавления
    }

    // Метод для поиска пользователя по логину и паролю
    public static User findUser(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    // Метод для получения всех пользователей
    public static List<User> getUsers() {
        return users;
    }

    // Сохраняем список пользователей в файл (сериализация)
    public static void saveUsersToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(users);  // Записываем список пользователей в файл
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Загружаем пользователей из файла (десериализация)
    public static void loadUsersFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            users = (List<User>) ois.readObject();  // Читаем объекты пользователей из файла
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
