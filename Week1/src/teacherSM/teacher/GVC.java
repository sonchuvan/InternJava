package teacherSM.teacher;

public class GVC extends Teacher{
    @Override
    void setLevel() {
        this.level = "GVC";
    }

    public GVC(){
        setLevel();
    }
    public GVC(String name, String address, String phone) {
        super(name, address, phone);
        setLevel();
    }
}
