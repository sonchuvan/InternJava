package studentGPAManagement.subject;

public class SpecializedSubject extends Subject{

    @Override
    public void setSubjectType() {
        this.subjectType = "Chuyên ngành";
    }
    public SpecializedSubject(String subjectName,int numberOfCredits){
        super(subjectName,numberOfCredits);
        setSubjectType();
    }
}
