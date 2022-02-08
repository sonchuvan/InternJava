package teacherSalaryManagement.service;

import teacherSalaryManagement.entity.Teacher;
import teacherSalaryManagement.main.Main;
import teacherSalaryManagement.util.DataUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TeacherService {

    public static final String TEACHER_DATA_FILE = "teacher1.dat";

    public void addNewTeacher() {
        System.out.print("Nhập số giảng viên muốn thêm mới: ");
        int teacherNumber = -1;
        do {
            try {
                teacherNumber = new Scanner(System.in).nextInt();
                if (teacherNumber > 0) {
                    break;
                }
                System.out.print("Số giảng viên muốn thêm mới phải là số nguyên, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Số giảng viên muốn thêm mới phải là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < teacherNumber; i++) {
            Teacher teacher = new Teacher();
            teacher.inputInfo();
            addTeacherToArray(teacher);
        }
        Main.fileUtil.writeDataToFile(Main.teachers, TEACHER_DATA_FILE);
    }

    public void addTeacherToArray(Teacher teacher) {
        for (int i = 0; i < Main.teachers.length; i++) {
            if (DataUtil.isNullOrEmpty(Main.teachers[i])) {
                Main.teachers[i] = teacher;
                break;
            }
        }
    }

    public void showTeachers() {
        for (int i = 0; i < Main.teachers.length; i++) {
            Teacher teacher = Main.teachers[i];
            if (DataUtil.isNullOrEmpty(teacher)) {
                break;
            }
            System.out.println(teacher);
        }
    }

    public Teacher findTeacherById(int teacherId) {
        for (int i = 0; i < Main.teachers.length; i++) {
            if (teacherId == Main.teachers[i].getId()) {
                return Main.teachers[i];
            }
        }
        return null;
    }
}
