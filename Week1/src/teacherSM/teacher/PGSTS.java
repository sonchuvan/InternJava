package teacherSM.teacher;

public class PGSTS extends Teacher{
    @Override
    void setLevel() {
        this.level = "PGSTS";
    }

    public PGSTS(){
        setLevel();
    }
    public PGSTS(String name, String address, String phone) {
        super(name, address, phone);
        setLevel();
    }
}
