package teacherSM.teacher;

public class GSTS extends Teacher{
    @Override
    void setLevel() {
        this.level = "GSTS";
    }
    public GSTS(){
        setLevel();
    }
    public GSTS(String name, String address, String phone) {
        super(name, address, phone);
        setLevel();
    }
}
