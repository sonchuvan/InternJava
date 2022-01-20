package studentGPAManagement;

import studentGPAManagement.student.Student;
import studentGPAManagement.student.StudentService;
import studentGPAManagement.subject.*;

import java.io.*;

public class AcademicTranscript implements Serializable {

    private static final String filepath = "D:\\ITSOL\\Week2\\src\\studentGPAManagement\\";
    private Student student;
    private Subject[] subjects = new Subject[100];
    private int[] scores = new int[100];

    StudentService studentService = new StudentService();
    SubjectService subjectService = new SubjectService();

    public int[] inputScore(int[] scores, Subject[] subjects) {
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i] == null) {
                break;
            }
            System.out.println("Nhập điểm môn " + subjects[i].getSubjectName() + ":");
            String kt = Main.in.nextLine();
            while (!kt.matches("10|[0-9]")) {
                System.out.println("Nhập lại điểm");
            }
            scores[i] = Integer.parseInt(kt);
        }
        return scores;
    }

    public void writeObjectToFile(Object[] serObj, String fileName) {
        try {
            FileOutputStream f = new FileOutputStream(new File(filepath + fileName));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(serObj);
            o.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object[] readObjectFromFile(String fileName) {
        try {
            FileInputStream fi = new FileInputStream(new File(filepath + fileName));
            ObjectInputStream oi = new ObjectInputStream(fi);
            Object[] objects = (Object[]) oi.readObject();
            return objects;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Subject[] addSubjectToList(AcademicTranscript academicTranscript, Subject[] subjects) {
        Subject[] temp = new Subject[100];
        System.out.println("Nhập số lượng môn học:");
        try {
            int sl = Main.in.nextInt();
            for (int i = 0; i < sl; i++) {
                System.out.println("Nhập mã môn học thứ " + (i + 1));
                do {
                    int id = Main.in.nextInt();
                    if (subjectService.searchSubjectById(id, subjects) == null) {
                        System.out.println("Nhập sai mã môn.");
                        continue;
                    }
                    if (subjectService.searchSubjectById(id, temp) != null) {
                        System.out.println("Đã nhập môn học này.");
                        continue;
                    }
                    temp[i] = subjectService.searchSubjectById(id, subjects);
                    do {
                        Main.in.nextLine();
                        System.out.println("Nhập điểm cho môn " + temp[i].getSubjectName() + ":");
                        String kt = Main.in.nextLine();
                        if (kt.matches("10|[0-9]")) {
                            academicTranscript.scores[i] = Integer.parseInt(kt);
                        } else {
                            System.out.println("Nhập sai định dạng điểm, nhập lại");
                            continue;
                        }
                        academicTranscript.scores[i+1] = -1;
                        break;
                    } while (true);
                    break;
                } while (true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return temp;
    }

    public AcademicTranscript[] inputTranscript(AcademicTranscript[] at, Student[] students, Subject[] subjects) {
        for (int i = 0; i < at.length; i++) {
            if (students[i] == null) break;
            at[i] = new AcademicTranscript();
            at[i].student = students[i];
            System.out.println("Nhập điểm cho sinh viên " + at[i].student.getStudentName() + ":");
            at[i].subjects = addSubjectToList(at[i], subjects);
        }
        return at;
    }

    public void showListAcademicStranscript(AcademicTranscript[] at) {
        System.out.println("Danh sách bảng điểm");
        for (int i = 0; i < at.length; i++) {
            if (at[i] == null) break;

            System.out.println(at[i].student.toString());
            System.out.print("\tĐiểm các môn: ");
            for (int j = 0; j < at[i].subjects.length; j++) {
                if (at[i].subjects[j] == null) break;
                System.out.print(at[i].subjects[j].getSubjectName() + ":" + (at[i].scores[j]) + ", ");
            }
            System.out.println();
        }
    }

    public AcademicTranscript[] sortByStudentName(AcademicTranscript[] at) {
        for (int i = 0; i < at.length; i++) {
            if (at[i] == null) break;
            for (int j = i; j < at.length; j++) {
                if (at[j] == null) break;
                if (at[i].student.getStudentName().compareTo(at[j].student.getStudentName()) > 0) {
                    AcademicTranscript temp = at[i];
                    at[i] = at[j];
                    at[j] = temp;
                }
            }
        }
        return at;
    }

    public AcademicTranscript[] sortBySubjectName(AcademicTranscript[] at) {
        for (int i = 0; i < at.length; i++) {
            if (at[i] == null) break;
            for (int j = 0; j < at[i].subjects.length; j++) {
                if (at[i].subjects[j] == null) break;
                for (int k = j; k < at[i].subjects.length; k++) {
                    if (at[i].subjects[k] == null) break;
                    if (at[i].subjects[j].getSubjectName().compareTo(at[i].subjects[k].getSubjectName()) > 0) {
                        Subject temp = at[i].subjects[j];
                        at[i].subjects[j] = at[i].subjects[k];
                        at[i].subjects[k] = temp;
                    }
                }
            }
        }
        return at;
    }

    public float calculateGPA(AcademicTranscript at){
        float score = 0;
        int sumNumberOfCredits = 0;
        for (int i = 0; i < at.scores.length; i++) {
            if (at.scores[i] == -1) break;
            score +=(at.scores[i]*at.subjects[i].getNumberOfCredits());
            sumNumberOfCredits += at.subjects[i].getNumberOfCredits();
        }
        return score/sumNumberOfCredits;
    }

    public void showGPA(AcademicTranscript[] at){
        System.out.println("Điểm tổng kết");
        for (int i = 0; i < at.length; i++) {
            if (at[i] == null) break;
            System.out.print("STT"+(i+1)+". "+at[i].student.getStudentName()+": ");
            System.out.println(calculateGPA(at[i]));
        }
    }

}
