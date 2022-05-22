package entity;

import java.util.Scanner;

public class People implements Input{
    protected String name;
    protected String address;
    protected int phoneNumber;

    public People() {
    }

    public People(String name, String address, Integer phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    @Override
    public void inputInformation(String style){
        System.out.print("\nNhập tên " + style + " : ");
        this.setName(new Scanner(System.in).nextLine());
        System.out.print("Nhập địa chỉ " + style + " : ");
        this.setAddress(new Scanner(System.in).nextLine());
        System.out.print("Nhập số điện thoại " + style + " : ");
        this.setPhoneNumber(new Scanner(System.in).nextInt());
    }
}
