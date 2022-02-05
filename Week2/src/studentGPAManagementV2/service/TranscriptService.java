package studentGPAManagementV2.service;

import studentGPAManagementV2.entity.studentTranscript.SubjectScore;
import studentGPAManagementV2.entity.studentTranscript.Transcript;
import studentGPAManagementV2.main.Main;
import studentGPAManagementV2.util.DataUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TranscriptService {
    public static final String FILE_NAME = "transcript.dat";

    public int studentNeedToEnterScore() {
        return countStudentFromStudents() - countStudentFromTranscript();
    }

    public int countStudentFromStudents() {
        int count = 0;
        for (int i = 0; i < Main.students.length; i++) {
            if (DataUtil.isNullOrEmpty(Main.students[i])) {
                break;
            }
            count++;
        }
        return count;
    }

    public int countStudentFromTranscript() {
        int count = 0;
        for (int i = 0; i < Main.transcripts.length; i++) {
            if (DataUtil.isNullOrEmpty(Main.transcripts[i])) {
                break;
            }
            count++;
        }
        return count;
    }

    public Boolean searchStudentFromTranscript(int studentID) {
        Transcript[] transcripts = Main.transcripts;
        for (Transcript transcript : transcripts) {
            if (DataUtil.isNullOrEmpty(transcript)) {
                return false;
            }
            if (transcript.getStudent().getStudentId() == studentID) {
                return true;
            }
        }
        return false;
    }

    public Boolean searchSubjectFromTranscript(int subjectID, SubjectScore[] subjectScore) {
        for (int i = 0; i < subjectScore.length; i++) {
            SubjectScore score = subjectScore[i];
            if (DataUtil.isNullOrEmpty(score)) {
                return false;
            }
            if (score.getSubject().getSubjectID() == subjectID) {
                return true;
            }
        }
        return false;
    }

    public void addNewTranscripts() {
        int numberSNTES = Main.transcriptService.studentNeedToEnterScore();
        System.out.println("Nhập điểm cho sinh viên:");
        if (numberSNTES == 0) {
            System.out.println("Toàn bộ sinh viên đã được nhập điểm");
            return;
        }
        System.out.println("Sô sinh viên chưa nhập điểm: " + numberSNTES);
        System.out.println("Nhập số lượng sinh viên muốn nhập điểm:");
        int number = -1;
        do {
            try {
                number = new Scanner(System.in).nextInt();
                if (number > numberSNTES) {
                    System.out.println("Số lượng sinh viên muốn nhập lớn hơn số lượng sinh viên chưa nhập điểm, mời nhập lại");
                    continue;
                }
                if (number <= 0) {
                    System.out.println("cần nhập số lượng lớn hơn 0. mời nhập lại");
                    continue;
                }
                for (int i = 0; i < number; i++) {
                    Transcript transcript = new Transcript();
                    transcript.inputTranscript();
                    addTranscriptToList(transcript);
                }
                Main.fileUtil.writeDataToFile(Main.transcripts, FILE_NAME);
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Số lượng sinh viên phải là số nguyên, vui lòng nhập lại");
            }
        } while (true);
    }

    public void addTranscriptToList(Transcript transcript) {
        for (int i = 0; i < Main.transcripts.length; i++) {
            if (DataUtil.isNullOrEmpty(Main.transcripts[i])) {
                Main.transcripts[i] = transcript;
                break;
            }
        }
    }

    public void showTranscripts() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Bảng điểm sinh viên");
        Transcript[] transcripts = Main.transcripts;
        for (Transcript transcript : transcripts) {
            if (DataUtil.isNullOrEmpty(transcript)) {
                break;
            }
            System.out.println(transcript);
        }
    }

    public void sortTranscriptByStudentName() {
        Transcript[] transcripts = Main.transcripts;
        for (int i = 0; i < transcripts.length; i++) {
            if (DataUtil.isNullOrEmpty(transcripts[i])) {
                break;
            }
            for (int j = i; j < transcripts.length; j++) {
                if (DataUtil.isNullOrEmpty(transcripts[j])) {
                    break;
                }
                if (transcripts[i].getStudent().getStudentName()
                        .compareTo(transcripts[j].getStudent().getStudentName()) > 0) {
                    Transcript temp = transcripts[i];
                    transcripts[i] = transcripts[j];
                    transcripts[j] = temp;
                }
            }
        }
        Main.transcripts = transcripts;
    }

    public void sortTranscriptBySubjectName() {
        Transcript[] transcripts = Main.transcripts;

        for (int i = 0; i < transcripts.length; i++) {
            if (DataUtil.isNullOrEmpty(transcripts[i])) {
                break;
            }
            SubjectScore[] subjectScore = transcripts[i].getSubjectScore();
            for (int j = 0; j < subjectScore.length; j++) {
                if (DataUtil.isNullOrEmpty(subjectScore[j])) {
                    break;
                }
                for (int k = j; k < subjectScore.length; k++) {
                    if (DataUtil.isNullOrEmpty(subjectScore[k])) {
                        break;
                    }
                    if (subjectScore[j].getSubject().getSubjectName()
                            .compareTo(subjectScore[k].getSubject().getSubjectName()) > 0) {
                        SubjectScore temp = subjectScore[j];
                        subjectScore[j] = subjectScore[k];
                        subjectScore[k] = temp;
                    }
                }
            }
            transcripts[i].setSubjectScore(subjectScore);
        }
        Main.transcripts = transcripts;
    }

    public float calculateGPA(Transcript transcripts) {
        SubjectScore[] subjectScores = transcripts.getSubjectScore();
        float score = 0;
        int sumNumberOfCredits = 0;
        for (int i = 0; i < subjectScores.length; i++) {
            if (DataUtil.isNullOrEmpty(subjectScores[i])){
                break;
            }
            score += subjectScores[i].getScore()*subjectScores[i].getSubject().getNumberLession();
            sumNumberOfCredits += subjectScores[i].getSubject().getNumberLession();
        }
        return score / sumNumberOfCredits;
    }

    public void showGPA() {
        System.out.println("Điểm tổng kết");
        Transcript[] transcripts = Main.transcripts;
        for (int i = 0; i < transcripts.length; i++) {
            if (DataUtil.isNullOrEmpty(transcripts[i])) break;
            System.out.print("STT" + (i + 1) + ". " + transcripts[i].getStudent().getStudentName() + ": ");
            System.out.println(calculateGPA(transcripts[i]));
        }
    }
}
