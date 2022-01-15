package teacherSM;

import teacherSM.subject.Subject;
import teacherSM.teacher.Teacher;

import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static boolean checkValid(String s,String x){
        boolean flag = false;
        return flag = s.matches(x);
    }
    public static void main(String[] args) {
        Management m = new Management();
        Subject[] subjects = new Subject[100];
        Teacher[] teachers = new Teacher[100];
        teacherSM.Management[] mng = new teacherSM.Management[100];
        int lc = 0;
        do {
            System.out.println("======================================================");
            System.out.println("Mời lựa chọn");
            System.out.println("1. Nhập danh sách môn học mới");
            System.out.println("2. Nhập danh sách giảng viên mới");
            System.out.println("3. Lập bảng kê khai giảng dậy");
            System.out.println("4. Sắp xếp danh sách theo tên giảng viên");
            System.out.println("5. Sắp xếp danh sách theo so tiêt giảng dạy");
            System.out.println("6. Lập bảng tính lương giảng viên");
            System.out.println("0. Exit");
            System.out.println("=======================================================");
            boolean flag;
            do {

                String digit = "[0-6]";
                String input = Main.in.next();
                flag = input.matches(digit);

                if (!flag){
                    System.out.println("nhập sai!, mời nhập lại");
                    continue;
                }
                lc = Integer.parseInt(input);

            } while (!flag);
            switch (lc){
                case 1:
                    subjects = m.addListSubject(subjects);
                    m.showMonHoc(subjects);
                    break;
                case 2:
                    teachers = m.addListTeacher(teachers);
                    m.showListTeacher(teachers);
                    break;
                case 3:
                    mng = m.bangKeKhai(mng,teachers,subjects);
                    m.showBangKeKhai(mng);
                    break;
                case 4:
                    System.out.println("Bảng kê khai sau khi sắp xếp theo tên");
                    mng = m.sortByName(mng);
                    m.showBangKeKhai(mng);
                    break;
                case 5:
                    System.out.println("Bảng kê khai sau khi sắp xếp theo số tiết");
                    mng = m.sortBySTGD(mng);
                    m.showBangKeKhai(mng);
                    break;
                case 6:
                    System.out.println("Bảng lương giang viên");
                    m.salary(mng);
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình");
                    break;
            }

        } while (lc!=0);


    }

}
