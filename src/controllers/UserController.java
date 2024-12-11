package controllers;

import models.Employee;
import models.Student;
import models.Teacher;
import models.Manager;
import enums.UserType;

import java.util.Vector;

import dll.DBContext;

public class UserController {

    // Метод для создания нового пользователя
    public static boolean createUser(
            String username,
            String password, 
            UserType type) {
        switch(type) {
            case TEACHER:
                Teacher newTeacher = new Teacher(username, password);
                DBContext.teacher.add(newTeacher);  // Добавляем преподавателя в базу
                return DBContext.saveTeachers();   // Сохраняем данные преподавателей
            case STUDENT:
                Student newStudent = new Student(username, password);
                DBContext.student.add(newStudent);  // Добавляем студента в базу
                return DBContext.saveStudents();   // Сохраняем данные студентов
            case MANAGER:
                Manager newManager = new Manager(username, password);
                DBContext.manager.add(newManager);  // Добавляем менеджера в базу
                return DBContext.saveManagers();   // Сохраняем данные менеджеров
            default:
                return false;
        }
    }

    // Метод для получения пользователей по типу
    public static Object getUsers(UserType type) {
        switch(type) {
            case TEACHER:
                return DBContext.getTeachers();  // Получаем всех преподавателей
            case STUDENT:
                return DBContext.getStudents();  // Получаем всех студентов
            case MANAGER:
                return DBContext.getManagers();  // Получаем всех менеджеров
            default:
                return null;
        }
    }

    // Метод для авторизации пользователя
    public static boolean authorize(String fileName, String username, String password) {
        if(fileName.equals("teacher.txt")) {
            Vector<Teacher> teachers = (Vector<Teacher>) getUsers(UserType.TEACHER);
            for(Teacher t: teachers) {
                if (t.getUsername().equals(username) && t.getPassword().equals(password))
                    return true;
            }
        } else if(fileName.equals("student.txt")) {
            Vector<Student> students = (Vector<Student>) getUsers(UserType.STUDENT);
            for(Student s: students) {
                if (s.getUsername().equals(username) && s.getPassword().equals(password))
                    return true;
            }
        } else if(fileName.equals("manager.txt")) {
            Vector<Manager> managers = (Vector<Manager>) getUsers(UserType.MANAGER);
            for(Manager m: managers) {
                if (m.getUsername().equals(username) && m.getPassword().equals(password))
                    return true;
            }
        }
        return false;
    }
}
