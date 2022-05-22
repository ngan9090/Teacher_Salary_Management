package entity.teaching;

import entity.Subject;
import entity.Teacher;
import util.DataUtil;

import java.util.Arrays;

public class Teaching implements Comparable<Teaching>{
    private Teacher teacher;
    private SubjectTeaching[] subjectTeachings;

    public Teaching() {
    }

    public Teaching(Teacher teacher, SubjectTeaching[] subjectTeachings) {
        this.teacher = teacher;
        this.subjectTeachings = subjectTeachings;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public SubjectTeaching[] getSubjectTeaching() {
        return subjectTeachings;
    }

    public void setSubjectTeaching(SubjectTeaching[] subjectTeachings) {
        this.subjectTeachings = subjectTeachings;
    }

    public int getCurrentTotalLesson() {
        if (DataUtil.isNullorEmpty(subjectTeachings)) {
            return 0;
        }
        int currentTotalLesson = 0;
        for (int i = 0; i < subjectTeachings.length; i++) {
            Subject subject = subjectTeachings[i].getSubject();
            int classQuantity = subjectTeachings[i].getClassQuantity();
            currentTotalLesson += subject.getLessonTotal() * classQuantity;
        }
        return currentTotalLesson;
    }

    @Override
    public String toString() {
        return "Teaching{" +
                "teacher=" + teacher +
                ", subjectTeachings=" + Arrays.toString(subjectTeachings) +
                '}';
    }

    @Override
    public int compareTo(Teaching teaching){
        int soluong1 = 0;
        int soluong2 = 0;
        for (int i = 0; i < this.subjectTeachings.length; i++) {
            soluong1 += this.subjectTeachings[i].getSubject().getLessonTotal();
        }
        for (int i = 0; i < teaching.subjectTeachings.length; i++) {
            soluong2 += teaching.subjectTeachings[i].getSubject().getLessonTotal();
        }
        return soluong1 - soluong2;
    }

    public static int sumLession(Teaching teaching){
        int sum = 0;
        for (int i = 0; i < teaching.subjectTeachings.length; i++) {
            sum += teaching.subjectTeachings[i].getClassQuantity()*teaching.subjectTeachings[i].getSubject().getCost();
        }
       return sum;
    }
}
