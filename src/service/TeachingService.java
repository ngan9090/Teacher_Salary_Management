package service;

import entity.Subject;
import entity.Teacher;
import entity.teaching.SubjectTeaching;
import entity.teaching.Teaching;
import main.mainRun;
import util.DataUtil;

import javax.xml.crypto.Data;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import static main.mainRun.teachings;

public class TeachingService {

    private static boolean isNullOfEmptyTeacherOrSubject() {
        return mainRun.teachers[0] == null || mainRun.subjects[0] == null;
    }


    public void createTeaching() {
        if (isNullOfEmptyTeacherOrSubject()) {
            System.out.println("Bạn cần nhập thông tin giảng viên và môn học trước khi phân công giảng dạy.");
            return;
        }
        int teacherNumber = inputNumberOfTeacher();

        for (int i = 0; i < teacherNumber; i++) {
            Teacher teacher = inputTeacherId(i);
            System.out.println("Giảng viên vừa chọn là: " + teacher);

            int totalLesson = getTotalLesson(teacher);
            if (totalLesson >= 200) {
                System.out.println("Giảng viên bạn chọn đã vượt quá số tiết cho phép dạy, vui lòng phân công cho giảng viên khác");
                continue;
            }
            int subjectNumber = inputSubjectNumber();

            SubjectTeaching[] subjectTeachings = new SubjectTeaching[subjectNumber];
            createSubjectTeaching(subjectTeachings, subjectNumber, teacher);

            Teaching teaching = new Teaching(teacher, subjectTeachings);
            addTeachingToArray(teaching);
        }
    }

    private void addTeachingToArray(Teaching teaching) {
        for (int k = 0; k < teachings.length; k++) {
            if (DataUtil.isNullOrE(teachings[k])) {
                teachings[k] = teaching;
                break;
            }
        }
    }

    private void createSubjectTeaching(SubjectTeaching[] subjectTeachings, int subjectNumber, Teacher teacher) {
        for (int j = 0; j < subjectNumber; j++) {
            Subject subject = inputSubjectId(j, teacher);
            int classQuantity = inputClassQuantity(subject, j, teacher);
            SubjectTeaching subjectTeaching = new SubjectTeaching(subject, classQuantity);
            addSubjectTeachingToArray(subjectTeaching, subjectTeachings);
        }
    }

    private int inputClassQuantity(Subject subject, int j, Teacher teacher) {
        System.out.print("Nhập số lớp của môn " + subject.getSubjectName() + " mà giảng viên " + teacher.getName() + " muốn dạy: ");
        int classQuantity = -1;
        do {
            try {
                classQuantity = new Scanner(System.in).nextInt();
                if (classQuantity > 0 && classQuantity <= 3) {

                    int totalLessonTmp = getTotalLesson(teacher);
                    totalLessonTmp += subject.getLessonTotal() * classQuantity;
                    if (totalLessonTmp > 200) {
                        System.out.print("Nếu số lớp đăng ký dạy là " + classQuantity + " với môn học này thì tổng số tiết giảng dạy của giảng viên sẽ vượt quá 200, " + "vui lòng thu nhỏ số lớp giảng dạy cho môn học này: ");
                        continue;
                    }
                    break;
                }
                System.out.print("Số lớp giảng dạy cho 1 môn học là số nguyên dương và không được lớn hơn 3, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Số lớp muốn dạy phải là một số nguyên dương, không phải là chữ, vui lòng nhập lại: ");
            }
        } while (true);
        return classQuantity;
    }

    private Subject inputSubjectId(int j, Teacher teacher) {
        System.out.print("Nhập ID môn học thứ " + (j + 1) + "  mà giảng viên " + teacher.getName() + " muốn dạy: ");
        Subject subject = null;
        do {
            try {
                int subjectId = new Scanner(System.in).nextInt();
                subject = mainRun.subjectService.findSubjectById(subjectId);
                if (!DataUtil.isNullOrE(subject)) {
                    break;
                }
                System.out.print("ID môn học vừa nhập không tồn tại trong hệ thống, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("ID môn học phải là số nguyên dương, không phải là chữ, vui lòng nhập lại: ");
            }
        } while (true);
        return subject;
    }

    private void addSubjectTeachingToArray(SubjectTeaching subjectTeaching, SubjectTeaching[] subjectTeachings) {
        for (int k = 0; k < subjectTeachings.length; k++) {
            if (DataUtil.isNullOrE(subjectTeachings[k])) {
                subjectTeachings[k] = subjectTeaching;
                break;
            }
        }
    }

    private int inputSubjectNumber() {
        System.out.print("Nhập số lượng môn học mà giảng viên này muốn dạy: ");
        int subjectNumber = -1;
        do {
            try {
                subjectNumber = new Scanner(System.in).nextInt();
                if (subjectNumber > 0) {
                    break;
                }
                System.out.print("Số lớp phải là số nguyên, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Số lớp là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);
        return subjectNumber;
    }

    private Teacher inputTeacherId(int no) {
        System.out.print("Nhập ID của giảng viên thứ " + (no + 1) + " mà bạn muốn phân công: ");
        Teacher teacher = null;
        do {
            try {
                int teacherId = new Scanner(System.in).nextInt();
                teacher = mainRun.teacherService.findTeacherById(teacherId);
                if (!DataUtil.isNullOrE(teacher)) {
                    break;
                }
                System.out.print("ID giảng viên vừa nhập không tồn tại trong hệ thống, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("ID giảng viên phải là một số nguyên dương, không phải là chữ, vui lòng nhập lại: ");
            }
        } while (true);
        return teacher;
    }

    private int inputNumberOfTeacher() {
        System.out.print("Nhập số lượng giảng viên muốn phân công giảng dạy: ");
        int teacherNumber = -1;
        do {
            try {
                teacherNumber = new Scanner(System.in).nextInt();
                if (teacherNumber > 0) {
                    break;
                }
                System.out.print("Số giảng viên phải là số nguyên, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Số giảng viên là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);
        return teacherNumber;
    }

    private int getTotalLesson(Teacher teacher) {
//        if (DataUtil.isNullOrEmpty(teacher)) {
//            return 0;
//        }
        Teaching teaching = findTeaching(teacher.getTeacherId());
        if (DataUtil.isNullOrE(teaching)) {
            return 0;
        }
        return teaching.getCurrentTotalLesson();
    }


    private Teaching findTeaching(int teacherId) {

        for (int i = 0; i < teachings.length ; i++) {
            if (teachings[i] != null) {
                if (teachings[i].getTeacher().getTeacherId() == teacherId) {
                    return teachings[i];
                }
            }
        }
        return null;
    }

    public static void showTeachings() {
        for (int i = 0; i < teachings.length; i++) {
            if (DataUtil.isNullOrE(teachings[i])) {
                break;
            }
            System.out.println(teachings[i]);
        }
    }

    public static void sortTeaching() {
        int choice = 0;
        System.out.println("Chọn loại sắp sếp danh sách sách kê khai giảng dạy: ");
        System.out.println("     1.Theo họ tên giảng viên");
        System.out.println("     2.Theo số lượng tiết giảng dạy mỗi môn (giảm dần)");
        System.out.print("Nhập lựa chọn của bạn: ");
        do {
            choice = new Scanner(System.in).nextInt();
            if (choice >= 1 && choice < 3) {
                break;
            }
            System.out.print("Chọn giá trị 1 hoặc 2. Xin vui lòng chọn lại: ");
        } while (true);
        switch (choice) {
            case 1:
                sortTeachingByTeacherName();
                break;
            case 2:
                sortTeachingByLessionNumber();
                break;
        }
    }

    //Sort teaching by teacher name
    public static void sortTeachingByTeacherName() {
        for (int i = 0; i < teachings.length - 1; i++) {
            if (teachings[i] == null) {
                continue;
            }
            for (int j = 0; j < teachings.length; j++) {
                if (teachings[j] == null) {
                    continue;
                }
                if (teachings[i].getTeacher().getName().toLowerCase(Locale.ROOT).compareTo(teachings[j].getTeacher().getName().toLowerCase(Locale.ROOT)) < 0) {
                    Teaching temp = teachings[i];
                    teachings[i] = teachings[j];
                    teachings[j] = temp;
                }
            }
        }

        showTeachings();
    }

    //Sort teaching by lession total
    public static void sortTeachingByLessionNumber() {
        for (int i = 0; i < teachings.length - 1; i++) {
            if (teachings[i] == null) {
                continue;
            }
            for (int j = 0; j < teachings.length; j++) {
                if (teachings[j] != null) {
                    if (teachings[i].compareTo(teachings[j]) > 0) {
                        Teaching temp = teachings[i];
                        teachings[i] = teachings[j];
                        teachings[j] = temp;
                    }
                }
            }
        }
        showTeachings();
    }

    //Count salary
    public void salaryCalculation() {
            for (int j = 0; j < teachings.length; j++) {
                if (teachings[j] != null) {
                    System.out.println("Mã giảng viên: " + teachings[j].getTeacher().getTeacherId() +
                            " Tên giảng viên: " + teachings[j].getTeacher().getName() + " Tiền công: " + Teaching.sumLession(teachings[j]));
                }
            }

    }


}
