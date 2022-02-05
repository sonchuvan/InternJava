package studentGPAManagementV2.service;

import studentGPAManagementV2.entity.Student;
import studentGPAManagementV2.main.Main;
import studentGPAManagementV2.util.DataUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentService {
    public static final String FILE_NAME = "student.dat";

    public void addNewStudents() {
        int number = -1;
        System.out.println("Nhập số học sinh muốn thêm");
        do {
            try {
                number = new Scanner(System.in).nextInt();
                if (number >= 0) {
                    break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Số học sinh phải là số nguyên, vui lòng nhập lại.");
            }
        } while (true);
        for (int i = 0; i < number; i++) {
            Student student = new Student();
            student.inputInfor();
            addStudentToList(student);
        }
        Main.fileUtil.writeDataToFile(Main.students, FILE_NAME);
    }

    private void addStudentToList(Student student) {
        for (int i = 0; i < Main.students.length; i++) {
            if (DataUtil.isNullOrEmpty(Main.students[i])) {
                Main.students[i] = student;
                break;
            }
        }
    }

    public void showStudents() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Danh sách sinh viên");
        for (int i = 0; i < Main.students.length; i++) {
            Student student = Main.students[i];
            if (DataUtil.isNullOrEmpty(student)) {
                break;
            }
            System.out.println(student.toString());
        }
    }

    public Student searchStudent(int id) {
        Student student;
        Student[] students = Main.students;
        for (int i = 0; i < students.length; i++) {
            if (DataUtil.isNullOrEmpty(students[i])) {
                return null;
            }
            if (students[i].getStudentId() == id) {
                student = students[i];
                return student;
            }
        }
        return null;
    }
}
