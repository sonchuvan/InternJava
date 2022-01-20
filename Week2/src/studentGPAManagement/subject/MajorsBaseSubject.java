package studentGPAManagement.subject;

public class MajorsBaseSubject extends Subject{

    @Override
    public void setSubjectType() {
        this.subjectType = "Cơ sở ngành";
    }
    public MajorsBaseSubject(String subjectName,int numberOfCredits){
        super(subjectName,numberOfCredits);
        setSubjectType();
    }
}
