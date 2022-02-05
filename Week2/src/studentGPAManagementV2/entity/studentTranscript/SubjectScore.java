package studentGPAManagementV2.entity.studentTranscript;

import studentGPAManagementV2.entity.Subject;

import java.io.Serializable;

public class SubjectScore implements Serializable {

    private Subject subject;
    private float score;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public SubjectScore() {
    }

    public SubjectScore(Subject subject, float score) {
        this.subject = subject;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Môn học: " + subject.getSubjectName() +
                ", điểm: " + score +" ";
    }
}
