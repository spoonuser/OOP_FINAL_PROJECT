package dll;

import models.Teacher;
import models.Student;
import models.Manager;

import java.io.*;
import java.util.Vector;
/*
DBContext будет классом, который хранит списки пользователей 
(преподавателей, студентов, менеджеров) и методы для работы с 
этими списками (сохранение и извлечение данных)
 */
public class DBContext {

    // Статические коллекции для хранения пользователей
    public static Vector<Teacher> teacher = new Vector<>();
    public static Vector<Student> student = new Vector<>();
    public static Vector<Manager> manager = new Vector<>();

    // Метод для сохранения преподавателей в файл
    public static boolean saveTeachers() {
        return serialize(teacher, "/Users/fariza/eclipse-workspace/Telepuziki/src/data/teacher.txt");
    }

    // Метод для сохранения студентов в файл
    public static boolean saveStudents() {
        return serialize(student, "/Users/fariza/eclipse-workspace/Telepuziki/src/data/student.txt");
    }

    // Метод для сохранения менеджеров в файл
    public static boolean saveManagers() {
        return serialize(manager, "/Users/fariza/eclipse-workspace/Telepuziki/src/data/manager.txt");
    }

    // Метод для получения преподавателей
    public static Vector<Teacher> getTeachers() {
        return deserialize("/Users/fariza/eclipse-workspace/Telepuziki/src/data/teacher.txt");
    }

    // Метод для получения студентов
    public static Vector<Student> getStudents() {
        return deserialize("/Users/fariza/eclipse-workspace/Telepuziki/src/data/student.txt");
    }

    // Метод для получения менеджеров
    public static Vector<Manager> getManagers() {
        return deserialize("/Users/fariza/eclipse-workspace/Telepuziki/src/data/manager.txt");
    }

    // Метод для сериализации объектов
    private static boolean serialize(Object obj, String filePath) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(obj);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Метод для десериализации объектов
    private static <T> T deserialize(String filePath) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return (T) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
