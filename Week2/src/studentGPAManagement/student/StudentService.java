package studentGPAManagement.student;

import studentGPAManagement.Main;

import java.io.Serializable;

public class StudentService implements Serializable {

    public Student inputStudent() {
        System.out.println("Nhập thông tin sinh viên:");
        System.out.println("Nhập tên sinh viên ");
        String name = Main.in.nextLine();
        System.out.println("Nhập địa chỉ sinh viên ");
        String address = Main.in.nextLine();
        System.out.println("Nhập số điện thoại sinh viên ");
        String phone = Main.in.nextLine();
        System.out.println("Nhập lớp của sinh viên ");
        String className = Main.in.nextLine();
        Student student = new Student(name, address, phone, className);
        return student;
    }

    public Student[] inputListStudent(Student[] students) {
        String slt = "";
        boolean flag = false;
        do {
            System.out.println("Nhập số lượng học sinh:");
            slt = Main.in.nextLine();
            if (slt.matches("\\d*")) {
                flag = true;
            }
        } while (!flag);
        int sl = Integer.parseInt(slt);
        int temp = 0;
        for (int i = 0; i < students.length; i++) {
            if (temp == sl) break;
            if (students[i] == null) {
                students[i] = inputStudent();
                temp++;
            }
        }
        return students;
    }

    public void showListStudent(Student[] students) {
        System.out.println("Danh sách sinh viên");
        for (Student value : students) {
            if (value == null) break;
            System.out.println(value);
        }
    }
}
