package studentGPAManagement.subject;

import java.io.Serializable;

public class Subject implements Serializable {

    private static int id = 100;
    protected int subjectId;
    protected String subjectName;
    protected int numberOfCredits;
    protected String subjectType;

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType() {
    }

    protected Subject() {
        subjectId = id++;
    }

    public Subject(String subjectName, int numberOfCredits) {
        this.subjectId = id++;
        this.subjectName = subjectName;
        this.numberOfCredits = numberOfCredits;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", numberOfCredits=" + numberOfCredits +
                ", subjectType='" + subjectType + '\'' +
                '}';
    }
}
