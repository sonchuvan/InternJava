package teacherSM.teacher;

public class TS extends Teacher{
    @Override
    void setLevel() {
        this.level = "TS";
    }

    public TS(){
        setLevel();
    }
    public TS(String name, String address, String phone) {
        super(name, address, phone);
        setLevel();
    }
}
