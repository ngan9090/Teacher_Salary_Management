package main;

import entity.Subject;
import entity.Teacher;
import entity.teaching.Teaching;
import service.SubjectService;
import service.TeacherService;
import service.TeachingService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class mainRun {
    public static Teacher[] teachers = new Teacher[100];
    public static Subject[] subjects = new Subject[100];
    public static Teaching[] teachings = new Teaching[100];

    public static TeachingService teachingService = new TeachingService();
    public static TeacherService teacherService = new TeacherService();
    public static SubjectService subjectService = new SubjectService();

    public static void main(String[] args) {
        function();
    }

    public static void function(){
        do {
            int functionChoice = choiceFunction();
            switch (functionChoice) {
                case 1:
                    SubjectService.addNewSubject();
                    break;
                case 2:
                    SubjectService.printSubject();
                    break;
                case 3:
                    TeacherService.addNewTeacher();
                    break;
                case 4:
                    TeacherService.printTeacher();
                    break;
                case 5:
                    teachingService.createTeaching();
                    teachingService.showTeachings();
                    break;
                case 6:
                    teachingService.sortTeaching();
                    break;
                case 7:
                    teachingService.salaryCalculation();
                    break;
                case 8:
                    System.exit(0);
            }
        } while (true);
    }
    public static void menu(){
        System.out.println("Quản lý trả lương cho giáo viên thỉnh giảng. ");
        System.out.println("1. Nhập danh sách môn học mới. ");
        System.out.println("2. In ra danh sách môn học trong trường. ");
        System.out.println("3. Nhập danh sách giảng viên mới. ");
        System.out.println("4. In danh sách giảng viên trong trường. ");
        System.out.println("5. Phân công giảng dạy cho giảng viên và in ra danh sách giảng dạy. ");
        System.out.println("6. Sắp xếp danh sách thỉnh giảng. ");
        System.out.println("7. Tính toán và lập bảng lương. ");
        System.out.println("8. Thoát");
        System.out.print("Sự lựa chọn của bạn: ");
    }

    public static int choiceFunction(){
        menu();
        do{
            try {
                int choice = new Scanner(System.in).nextInt();
                if (choice > 0 && choice < 9) {
                    return choice;
                }
                System.out.print("Nhập lựa chọn của bạn giữa số 1 và 8: ");
            }catch(InputMismatchException e){
                System.out.print("Chức năng chọn là một số nguyên. Vui lòng chọn lại số nguyên từ 1 đến 8: ");
            }
        }while(true);
    }
}

