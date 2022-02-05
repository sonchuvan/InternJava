package studentGPAManagementV2.entity.studentTranscript;

import studentGPAManagementV2.entity.Student;
import studentGPAManagementV2.entity.Subject;
import studentGPAManagementV2.main.Main;
import studentGPAManagementV2.util.DataUtil;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Transcript implements Serializable {

    private Student student;
    private SubjectScore[] subjectScore = new SubjectScore[100];

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public SubjectScore[] getSubjectScore() {
        return subjectScore;
    }

    public void setSubjectScore(SubjectScore[] subjectScore) {
        this.subjectScore = subjectScore;
    }

    public Transcript() {
    }

    public Transcript(Student student, SubjectScore[] subjectScore) {
        this.student = student;
        this.subjectScore = subjectScore;
    }

    public void inputTranscript() {
        System.out.println("Nhập mã sinh viên cần nhập điểm: ");
        do {
            try {
                int studentID = new Scanner(System.in).nextInt();
                Student student = Main.studentService.searchStudent(studentID);
                if (DataUtil.isNullOrEmpty(student)) {
                    System.out.println("Mã sinh viên không tồn tại");
                    continue;
                }
                if (Main.transcriptService.searchStudentFromTranscript(studentID)) {
                    System.out.println("Sinh viên này đã được nhập điểm, mời nhập mã sinh viên khác");
                    continue;
                }
                this.student = student;
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Mã sinh viên cần là 1 số nguyên, mời nhập lại.");
            }
        } while (true);
        inputSubjectScore();
    }

    public void inputSubjectScore() {
        System.out.println("Nhập số lượng môn học của sinh viên");
        int subjectNumber = -1;
        do {
            try {
                subjectNumber = new Scanner(System.in).nextInt();
                if(subjectNumber < 0){
                    System.out.println("Số lượng môn học cần lớn hơn 0, mời nhập lại");
                    continue;
                }
                break;
            }catch (InputMismatchException ex){
                System.out.println("Số lượng môn cần là số nguyên, mời nhập lại");
            }
        }while (true);
        for (int i = 0; i < subjectNumber; i++) {
            System.out.println("Mời nhập mã môn:");
            SubjectScore subjectScore = new SubjectScore();
            do {

                try {
                    int subjectID = new Scanner(System.in).nextInt();
                    Subject subject = Main.subjectService.searchSubjectFromSubjects(subjectID);
                    if (DataUtil.isNullOrEmpty(subject)) {
                        System.out.println("Mã môn học không tồn tại, mời nhập lại");
                        continue;
                    }
                    if (Main.transcriptService.searchSubjectFromTranscript(subjectID, this.subjectScore)) {
                        System.out.println("Môn học đã được nhập điểm,mời nhập mã môn khác.");
                        continue;
                    }
                    subjectScore.setSubject(subject);
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("Mã môn cần là số nguyên, mời nhập lại.");
                }
            } while (true);
            System.out.println("Nhập điểm cho môn học vừa nhập: ");
            do {
                try {
                    float score = new Scanner(System.in).nextFloat();
                    if (score >= 0 && score <= 10) {
                        subjectScore.setScore(score);
                        break;
                    }
                    System.out.println("Điểm phải là số thực từ 0 - 10, mời nhập lại.");
                } catch (InputMismatchException exception) {
                    System.out.println("Điểm phải là 1 số thực, mời nhập lại");
                }
            } while (true);
            addSubjectScoreToList(subjectScore);
        }

    }

    public void addSubjectScoreToList(SubjectScore subjectScore) {
        for (int i = 0; i < this.subjectScore.length; i++) {
            if (DataUtil.isNullOrEmpty(this.subjectScore[i])) {
                this.subjectScore[i] = subjectScore;
                break;
            }
        }
    }

    public String showListSubjectScore(){
        String s ="\n\t\t";
        for (int i = 0; i < subjectScore.length; i++) {
            if (DataUtil.isNullOrEmpty(subjectScore[i])){
                break;
            }
            s += subjectScore[i].toString()+"\n\t\t";
        }
        return s;
    }
    @Override
    public String toString() {
        return "Sinh viên: " + student.getStudentName() + showListSubjectScore();
    }
}
