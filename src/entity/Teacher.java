package entity;

import value.TeacherTitle;

import java.util.Scanner;

public class Teacher extends People{
    private int teacherId;
    private TeacherTitle level;

    public static int AUTO_ID = 100;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public TeacherTitle getLevel() {
        return level;
    }

    public void setLevel(TeacherTitle level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", level='" + level + '\'' +
                '}';
    }

    @Override
    public void inputInformation(String style){
        this.teacherId = Teacher.AUTO_ID++;
        super.inputInformation("Teacher");
        levelInput();
    }

    private void levelInput() {
        System.out.print("Hãy chọn số từ 1 đến 4. ");
        System.out.println("\n1. " + TeacherTitle.GS);
        System.out.println("2. " + TeacherTitle.PGS);
        System.out.println("3. " + TeacherTitle.GV);
        System.out.println("4. " + TeacherTitle.TS);
        System.out.print("Nhập sự lựa chọn của bạn: ");
        int choice = 0;
        do{
            choice = new Scanner(System.in).nextInt();
            if(choice < 1 || choice > 4) {
                System.out.println("Hãy nhập lại sự lựa chọn từ 1 đến 4. ");
            }
        }while(choice < 1 || choice > 4);

        switch (choice){
            case 1:
                this.level = TeacherTitle.GS;
                break;
            case 2:
                this.level = TeacherTitle.PGS;
                break;
            case 3:
                this.level = TeacherTitle.GV;
                break;
            case 4:
                this.level = TeacherTitle.TS;
                break;
        }
    }
}
