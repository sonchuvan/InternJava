package teacherSalaryManagement.service;

import teacherSalaryManagement.entity.Subject;
import teacherSalaryManagement.main.Main;
import teacherSalaryManagement.util.DataUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SubjectService {
    public static final String SUBJECT_DATA_FILE = "subject1.dat";

    public void showSubjects() {
        for (int i = 0; i < Main.subjects.length; i++) {
            Subject subject = Main.subjects[i];
            if (DataUtil.isNullOrEmpty(subject)) {
                break;
            }
            System.out.println(subject);
        }
    }

    public void addNewSubject() {
        System.out.print("Nhập số môn học muốn thêm mới: ");
        int subjectNumber = -1;
        do {
            try {
                subjectNumber = new Scanner(System.in).nextInt();
                if (subjectNumber > 0) {
                    break;
                }
                System.out.print("Số môn học muốn thêm mới phải là số nguyên, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.print("Số môn học muốn thêm mới phải là một số nguyên, vui lòng nhập lại: ");
            }
        } while (true);
        for (int i = 0; i < subjectNumber; i++) {
            Subject subject = new Subject();
            subject.inputInfo();
            addSubjectToArray(subject);
        }
        Main.fileUtil.writeDataToFile(Main.subjects, SUBJECT_DATA_FILE);
    }

    public void addSubjectToArray(Subject subject) {
        for (int i = 0; i < Main.subjects.length; i++) {
            if (DataUtil.isNullOrEmpty(Main.subjects[i])) {
                Main.subjects[i] = subject;
                break;
            }
        }
    }

    public Subject findSubjectById(int subjectId) {
        if (DataUtil.isNullOrEmptyArray(Main.subjects)){
            return null;
        }
        for (int i = 0; i < Main.subjects.length; i++) {
            if (DataUtil.isNullOrEmpty(Main.subjects[i])){
                break;
            }
            if (subjectId == Main.subjects[i].getId()) {
                return Main.subjects[i];
            }
        }
        return null;
    }
}
