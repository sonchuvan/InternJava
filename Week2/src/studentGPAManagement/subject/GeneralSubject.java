package studentGPAManagement.subject;

public class GeneralSubject extends Subject{

    @Override
    public void setSubjectType() {
        this.subjectType = "Đại cương";
    }
    public GeneralSubject(String subjectName,int numberOfCredits){
        super(subjectName,numberOfCredits);
        setSubjectType();
    }
}
