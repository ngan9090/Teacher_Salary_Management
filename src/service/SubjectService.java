package service;

import entity.Subject;
import entity.Teacher;
import main.mainRun;

import java.util.Scanner;

public class SubjectService {
    //Subject
    public static void addNewSubject() {
        System.out.print("Nhập n môn học : ");
        int subjectNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < subjectNumber; i++) {
            System.out.print("Nhập môn học số " + (i + 1) + ": ");
            Subject subject = new Subject();
            //add subject
            subject.inputInformation("môn học");
            //save subject
            saveSubject(subject);
        }
    }

    public static void printSubject() {
        for (int i = 0; i < mainRun.subjects.length; i++) {
            if (mainRun.subjects[i] == null) {
                continue;
            }
            System.out.println(mainRun.subjects[i]);
        }
    }

    public static void saveSubject(Subject subject) {
        for (int i = 0; i < mainRun.subjects.length; i++) {
            if (mainRun.subjects[i] == null) {
                mainRun.subjects[i] = subject;
                break;
            }
        }
    }

    public static boolean isSubjectNull() {
        for (int i = 0; i < mainRun.subjects.length; i++) {
            if (mainRun.subjects[i] != null) {
                return false;
            }
        }
        return true;
    }

    public Subject findSubjectById(int subjectId) {
        for (int i = 0; i < mainRun.subjects.length; i++) {
            if (subjectId == mainRun.subjects[i].getSubjectId()) {
                return mainRun.subjects[i];
            }
        }
        return null;
    }
}
