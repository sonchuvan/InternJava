package studentGPAManagement.student;

import java.io.Serializable;

public class Student implements Serializable {
    private static int id = 10000;
    protected int studentId;
    protected String studentName;
    protected String studentAddress;
    protected String studentPhone;
    protected String studentClass;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    protected Student() {
        studentId = id++;
    }

    public Student(String studentName, String studentAddress, String studentPhone, String studentClass) {
        this.studentId = id++;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentPhone = studentPhone;
        this.studentClass = studentClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentPhone='" + studentPhone + '\'' +
                ", studentClass='" + studentClass + '\'' +
                '}';
    }
}
