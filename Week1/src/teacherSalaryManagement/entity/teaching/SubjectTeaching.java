package teacherSalaryManagement.entity.teaching;

import teacherSalaryManagement.entity.Subject;

import java.io.Serializable;

public class SubjectTeaching implements Serializable {
    private Subject subject;
    private int classQuantity;

    public SubjectTeaching(Subject subject) {
        this.subject = subject;
    }

    public SubjectTeaching(Subject subject, int classQuantity) {
        this.subject = subject;
        this.classQuantity = classQuantity;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getClassQuantity() {
        return classQuantity;
    }

    public void setClassQuantity(int classQuantity) {
        this.classQuantity = classQuantity;
    }

    @Override
    public String toString() {
        return "SubjectTeaching{" +
                "subject=" + subject.getName() +
                ", classQuantity=" + classQuantity +
                '}';
    }
}
