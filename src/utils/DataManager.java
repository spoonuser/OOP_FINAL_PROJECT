package utils;

import models.User;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private static final String FILE_NAME = "/Users/fariza/eclipse-workspace/Telepuziki/src/data/user.txt";

    // Сохраняем пользователей в файл
    public static void saveUsers(List<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(users);
            System.out.println("Данные успешно сохранены.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных: " + e.getMessage());
        }
    }

    // Загружаем пользователей из файла
    public static List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            users = (List<User>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден. Возможно, данных еще нет.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке данных: " + e.getMessage());
        }
        return users;
    }
}
