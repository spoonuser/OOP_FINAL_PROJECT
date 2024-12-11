package dll;

import models.User;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataStorage {
    private static final String FILE_PATH = "/Users/fariza/eclipse-workspace/Telepuziki/src/data/user.txt"; 

    private List<User> users;

    public DataStorage() {
        this.users = new ArrayList<>();
        loadData(); // Загружаем данные при инициализации
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
        saveData(); // Сохраняем данные после добавления нового пользователя
    }

    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(users);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных: " + e.getMessage());
        }
    }

    private void loadData() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return; // Если файла нет, ничего не загружаем
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            users = (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке данных: " + e.getMessage());
        }
    }
}
