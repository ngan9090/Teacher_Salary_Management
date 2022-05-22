package entity;

import java.util.Scanner;

public class Subject implements Input{
    public static int AUTO_ID = 100;

    private int subjectId;
    private String subjectName;
    private int lessonTotal;
    private int theoryLessonTotal;
    private float cost;

    public int getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getLessonTotal() {
        return lessonTotal;
    }

    public void setLessonTotal(int lessonTotal) {
        this.lessonTotal = lessonTotal;
    }

    public int getTheoryLessonTotal() {
        return theoryLessonTotal;
    }

    public void setTheoryLessonTotal(int theoryLessonTotal) {
        this.theoryLessonTotal = theoryLessonTotal;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", lessonTotal=" + lessonTotal +
                ", theoryLessonTotal=" + theoryLessonTotal +
                ", cost=" + cost +
                '}';
    }

    @Override
    public void inputInformation(String style){
        this.subjectId = Subject.AUTO_ID++;
        System.out.print("\nNhập tên môn học: ");
        this.subjectName = new Scanner(System.in).nextLine();
        System.out.print("Nhập tổng số tiết học: ");
        this.lessonTotal = new Scanner(System.in).nextInt();
        System.out.print("Nhập tổng số tiết lý thuyết: ");
        this.theoryLessonTotal = new Scanner(System.in).nextInt();
        System.out.print("Nhập kinh phí: ");
        this.cost = new Scanner(System.in).nextFloat();
    }

}
