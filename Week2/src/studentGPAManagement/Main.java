package studentGPAManagement;

import studentGPAManagement.student.Student;
import studentGPAManagement.student.StudentService;
import studentGPAManagement.subject.Subject;
import studentGPAManagement.subject.SubjectService;

import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Student[] students = new Student[100];
        Subject[] subjects = new Subject[100];
        StudentService studentService = new StudentService();
        SubjectService subjectService = new SubjectService();
        AcademicTranscript[] academicTranscripts = new AcademicTranscript[100];
        AcademicTranscript at = new AcademicTranscript();
        d:
        do {
            System.out.println("===============STUDENT GPA MANAGEMENT==============");
            System.out.println("1.Nhập danh sách sinh viên");
            System.out.println("2.Nhập danh sách môn học");
            System.out.println("3.Nhập điểm cho sinh viên");
            System.out.println("4.Sắp xếp danh sách bảng điểm theo tên sinh viên");
            System.out.println("5.Sắp xếp danh sách bảng điểm theo tên môn học");
            System.out.println("6.Tính điểm tổng kết");
            System.out.println("0. Kết thúc chương trình");
            System.out.println("===================================================");
            int lc = 0;
            String k1 = in.nextLine();
            while (!k1.matches("\\d+")){
                k1 = Main.in.nextLine();
            }
            lc = Integer.parseInt(k1);
            switch (lc) {
                case 1:
                    students = studentService.inputListStudent(students);
                    at.writeObjectToFile(students,"student.txt");
                    studentService.showListStudent((Student[]) at.readObjectFromFile("student.txt"));
                    break;
                case 2:
                    subjects = subjectService.inputListSubject(subjects);
                    at.writeObjectToFile(subjects,"subjects.txt");
                    subjectService.showListSubject((Subject[]) at.readObjectFromFile("subjects.txt"));
                    break;
                case 3:
                    academicTranscripts = at.inputTranscript(academicTranscripts,students,subjects);
                    at.writeObjectToFile(academicTranscripts,"adcademicTranscript.txt");
                    at.showListAcademicStranscript((AcademicTranscript[]) at.readObjectFromFile("adcademicTranscript.txt"));
                    break;
                case 4:
                    System.out.println("Bảng điểm sau khi sắp xếp theo tên sinh viên:");
                    academicTranscripts = at.sortByStudentName(academicTranscripts);
                    at.showListAcademicStranscript(academicTranscripts);
                    break;
                case 5:
                    System.out.println("Bảng điểm sau khi sắp xếp theo tên môn học:");
                    academicTranscripts = at.sortBySubjectName(academicTranscripts);
                    at.showListAcademicStranscript(academicTranscripts);
                    break;
                case 6:
                    System.out.println("Điểm tổng kết chung của các sinh viên:");
                    at.showGPA(academicTranscripts);
                    break;
                case 0:
                    break d;
            }
        } while (true);
    }

}
