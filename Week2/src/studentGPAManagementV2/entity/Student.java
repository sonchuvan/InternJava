package studentGPAManagementV2.entity;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {

    private static int AUTO_ID = 10000;
    private int studentId;
    private String StudentName;
    private String address;
    private String phone;
    private String studentClass;

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public Student() {
    }

    public Student(String studentName, String address, String phone, String studentClass) {
        StudentName = studentName;
        this.address = address;
        this.phone = phone;
        this.studentClass = studentClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId: " + studentId +
                ", StudentName: " + StudentName +
                ", address: " + address +
                ", phone: " + phone +
                ", studentClass: " + studentClass +
                '}';
    }

    public void inputInfor() {
        this.studentId = AUTO_ID;
        AUTO_ID++;
        System.out.println("Nhập thông tin sinh viên:");
        System.out.println("Nhập tên:");
        this.StudentName = new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ:");
        this.address = new Scanner(System.in).nextLine();
        System.out.println("Nhập số điện thoại:");
        this.phone = new Scanner(System.in).nextLine();
        System.out.println("Nhập lớp:");
        this.studentClass = new Scanner(System.in).nextLine();
    }

}
