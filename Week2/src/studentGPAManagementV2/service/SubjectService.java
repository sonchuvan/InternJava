package studentGPAManagementV2.service;

import studentGPAManagementV2.entity.Subject;
import studentGPAManagementV2.main.Main;
import studentGPAManagementV2.util.DataUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SubjectService {
    public static final String FILE_NAME = "subject.dat";

    public void addNewSubjects(){
        System.out.println("Nhập số lượng môn học muốn thêm");
        int number = -1;
        do {
            try {
                number = new Scanner(System.in).nextInt();
                if (number >= 0){
                    break;
                }
                System.out.println("Số môn học phải lớn hơn 0, vui lòng nhập lại");
            }catch (InputMismatchException ex){
                System.out.println("Số môn học phải là số nguyên, vui lòng nhập lại.");
            }
        }while (true);
        for (int i = 0; i < number; i++) {
            Subject subject = new Subject();
            subject.inputInfor();
            addSubjectToList(subject);
        }
        Main.fileUtil.writeDataToFile(Main.subjects,FILE_NAME);
    }

    private void addSubjectToList(Subject subject) {
        for (int i = 0; i < Main.subjects.length; i++) {
            if(DataUtil.isNullOrEmpty(Main.subjects[i])){
                Main.subjects[i] = subject;
                break;
            }
        }
    }
    public void showSubjects(){
        System.out.println("--------------------------------------------------------------");
        for (int i = 0; i < Main.subjects.length; i++) {
            Subject subject = Main.subjects[i];
            if (DataUtil.isNullOrEmpty(subject)){
                break;
            }
            System.out.println(subject.toString());
        }
    }

    public Subject searchSubjectFromSubjects(int subjectID){
        Subject[] subjects = Main.subjects;
        Subject subject;
        for (Subject value : subjects) {
            if (DataUtil.isNullOrEmpty(value)) {
                return null;
            }
            if (value.getSubjectID() == subjectID) {
                subject = value;
                return subject;
            }
        }
        return null;
    }
}
