package studentGPAManagement.subject;

import studentGPAManagement.Main;

import java.io.Serializable;

public class SubjectService implements Serializable {

    public boolean searchSubjectByName(Subject[] subjects,String name){
        for (Subject subject : subjects) {
            if (subject == null) break;
            if (subject.getSubjectName().equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    public Subject searchSubjectById(int id, Subject[] subjects) {
        for (Subject subject : subjects) {
            if (subject == null) break;
            if (subject.getSubjectId() == id) {
                return subject;
            }
        }
        return null;
    }

    public Subject inputSubject(Subject[] subjects) {
        Subject subject = null;
        System.out.println("Mời chọn loại môn học");
        System.out.println("1.Đại cương");
        System.out.println("2.Cơ Sở Ngành");
        System.out.println("3.Chuyên ngành");
        String k1 = Main.in.nextLine();
        while (!k1.matches("[1-3]")) {
            k1 = Main.in.nextLine();
        }
        int lc = Integer.parseInt(k1);
        String subjectName = "";
        do{
            System.out.println("Nhập tên Môn học ");
            subjectName = Main.in.nextLine();
            if(searchSubjectByName(subjects,subjectName)){
                System.out.println("Tên môn học đã tồn tại");
                continue;
            }
            break;
        }while (true);

        System.out.println("Nhập số đơn vị học trình");
        String k2 = Main.in.nextLine();
        while (!k2.matches("\\d+")) {
            k2 = Main.in.nextLine();
        }
        int numberOfCredits = Integer.parseInt(k2);
        switch (lc) {
            case 1:
                subject = new GeneralSubject(subjectName, numberOfCredits);
                break;
            case 2:
                subject = new MajorsBaseSubject(subjectName, numberOfCredits);
                break;
            case 3:
                subject = new SpecializedSubject(subjectName, numberOfCredits);
                break;
        }
        return subject;
    }

    public void showListSubject(Subject[] subjects) {
        System.out.println("Danh sách môn học");
        for (Subject subject : subjects) {
            if (subject == null) break;
            System.out.println(subject);
        }
    }

    public Subject[] inputListSubject(Subject[] subjects) {
        int sl = 0;
        System.out.println("Nhập số lượng môn học");
        String k1 = Main.in.nextLine();
        while (!k1.matches("\\d+")) {
            k1 = Main.in.nextLine();
        }
        sl = Integer.parseInt(k1);
        int temp = 0;
        for (int i = 0; i < subjects.length; i++) {
            if (temp == sl) break;
            if (subjects[i] == null) {
                subjects[i] = inputSubject(subjects);
                temp++;
            }
        }
        return subjects;
    }



}
