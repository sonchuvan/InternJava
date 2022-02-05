package studentGPAManagementV2.entity;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Subject implements Serializable {

    private static int AUTO_ID = 100;
    public static final String DC = "Đại cương";
    public static final String CSN = "Cơ sở ngành";
    public static final String CN = "Chuyên ngành";

    private int subjectID;
    private String subjectName;
    private int numberLession;
    private String subjectType;

    public int getSubjectID() {
        return subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getNumberLession() {
        return numberLession;
    }

    public void setNumberLession(int numberLession) {
        this.numberLession = numberLession;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public Subject() {
    }

    public Subject(String subjectName, int numberLession, String subjectType) {
        this.subjectName = subjectName;
        this.numberLession = numberLession;
        this.subjectType = subjectType;
    }

    @Override
    public String toString() {
        return"subjectID: " + subjectID +
                ", subjectName: " + subjectName +
                ", numberLession: " + numberLession +
                ", subjectType: " + subjectType +
                '}';
    }

    public void inputInfor() {
        this.subjectID = AUTO_ID;
        AUTO_ID++;
        System.out.println("Nhập thông tin môn học:");
        System.out.println("Nhập tên môn học:");
        this.subjectName = new Scanner(System.in).nextLine();
        System.out.println("Nhập Nhập số tiết của môn học");
        do {
            try {
                int number = new Scanner(System.in).nextInt();
                if (number > 0) {
                    this.numberLession = number;
                    break;
                }
                System.out.println("Số tiết phải lớn hơn không, vui lòng nhập lại.");
            } catch (InputMismatchException ex) {
                System.out.println("Số tiết của môn học phải là số nguyên, vui lòng nhập lại.");
            }
        } while (true);
        System.out.println("Chọn loại môn học:");
        System.out.println("1. Đại cương");
        System.out.println("2. Cơ sở ngành");
        System.out.println("3. Chuyên ngành");
        do {
            try {
                int number = new Scanner(System.in).nextInt();
                if (number >= 1 && number <= 3){
                    switch (number){
                        case 1:
                            this.subjectType = DC;
                            break;
                        case 2:
                            this.subjectType = CSN;
                            break;
                        case 3:
                            this.subjectType = CN;
                            break;
                    }
                    break;
                }
                System.out.println("Lựa chọn phải là các số từ 1-3, vui lòng nhập lại");
            } catch (InputMismatchException ex) {
                System.out.println("Lựa chọn phải là số nguyên, vui lòng nhập lại");
            }
        } while (true);

    }
}
