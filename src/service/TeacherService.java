package service;

import entity.Teacher;
import main.mainRun;

import javax.xml.bind.SchemaOutputResolver;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TeacherService {
    //Teacher
    public static void addNewTeacher() {
        System.out.print("Nhập n giáo viên : ");
        int teacherNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < teacherNumber; i++) {
            System.out.print("Nhập giáo viên số " + (i + 1) + ": ");
            Teacher teacher = new Teacher();
            //Thêm giáo viên
            teacher.inputInformation("Giáo viên");
            //Lưu giáo viên
            saveTeacher(teacher);
        }
    }

    public static void printTeacher() {
        for (int i = 0; i < mainRun.teachers.length; i++) {
            if (mainRun.teachers[i] == null) {
                continue;
            }
            System.out.println(mainRun.teachers[i]);
        }
    }

    public static void saveTeacher(Teacher teacher) {
        for (int i = 0; i < mainRun.teachers.length; i++) {
            if (mainRun.teachers[i] == null) {
                mainRun.teachers[i] = teacher;
                break;
            }
        }
    }

    public static boolean isTeacherNull() {
        for (int i = 0; i < mainRun.teachers.length; i++) {
            if (mainRun.teachers[i] != null) {
                return false;
            }
        }
        return true;
    }

    public Teacher findTeacherById(int teacherId) {
        for (int i = 0; i < mainRun.teachers.length; i++) {
            if (teacherId == mainRun.teachers[i].getTeacherId()) {
                return mainRun.teachers[i];
            }
        }
        return null;
    }
}
