package studentGPAManagementV2.main;

import studentGPAManagementV2.entity.Student;
import studentGPAManagementV2.entity.Subject;
import studentGPAManagementV2.entity.studentTranscript.Transcript;
import studentGPAManagementV2.service.StudentService;
import studentGPAManagementV2.service.SubjectService;
import studentGPAManagementV2.service.TranscriptService;
import studentGPAManagementV2.util.DataUtil;
import studentGPAManagementV2.util.file.FileUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static Student[] students;
    public static Subject[] subjects;
    public static Transcript[] transcripts;

    public static StudentService studentService = new StudentService();
    public static SubjectService subjectService = new SubjectService();
    public static TranscriptService transcriptService = new TranscriptService();

    public static FileUtil fileUtil = new FileUtil();

    public static void main(String[] args) {
        initializeData();
        menu();
    }

    public static void initializeData() {
        Object[] studentFromFile = fileUtil.readDataFromFile(StudentService.FILE_NAME);
        Main.students = DataUtil.isNullOrEmpty(studentFromFile) ? new Student[100] :(Student[]) studentFromFile;

        Object[] subjectFromFile = fileUtil.readDataFromFile(SubjectService.FILE_NAME);
        Main.subjects = DataUtil.isNullOrEmpty(subjectFromFile) ? new Subject[100] :(Subject[]) subjectFromFile;

        Object[] transcriptFromFile = fileUtil.readDataFromFile(TranscriptService.FILE_NAME);
        Main.transcripts = DataUtil.isNullOrEmpty(transcriptFromFile) ? new Transcript[100] :(Transcript[]) transcriptFromFile;
    }

    public static int inputChoice() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("QUẢN LÝ ĐIỂM SINH VIÊN");
        System.out.println("1. Nhập danh sách sinh viên mới và in ra sanh sách sinh viên");
        System.out.println("2. Nhập danh sách môn học mới và in ra danh sách môn học");
        System.out.println("3. Lập bảng điểm cho sinh viên");
        System.out.println("4. Sắp xếp danh sách bảng điểm theo học tên sinh viên");
        System.out.println("5. Sắp xếp danh sách bảng điểm theo tên môn học");
        System.out.println("6. Tính điểm tổng kết chung cho mỗi sinh viên");
        System.out.println("0. Kết thúc chương trình");
        int choice = 0;
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if (choice >= 0 && choice <= 6) {
                    return choice;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Lựa chọn phải là số nguyên, vui lòng nhập lại.");
            }
        } while (true);
    }

    public static void menu() {
        do {
            int choice = inputChoice();
            switch (choice) {
                case 1:
                    studentService.addNewStudents();
                    studentService.showStudents();
                    break;
                case 2:
                    //subjectService.addNewSubjects();
                    subjectService.showSubjects();
                    break;
                case 3:
                    //transcriptService.addNewTranscripts();
                    transcriptService.showTranscripts();
                    break;
                case 4:
                    transcriptService.sortTranscriptByStudentName();
                    transcriptService.showTranscripts();
                    break;
                case 5:
                    transcriptService.sortTranscriptBySubjectName();
                    transcriptService.showTranscripts();
                    break;
                case 6:
                    transcriptService.showGPA();
                    break;
                case 0:
                    System.exit(0);
            }
        } while (true);
    }
}
