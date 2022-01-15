package teacherSM.teacher;

public abstract class Teacher {
    private static int idTemp =100;
    private int id;
    protected String name;
    protected String address;
    protected String phone;
    protected String level;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLevel() {
        return level;
    }

    abstract void setLevel();

    public Teacher() {
        this.id = idTemp++;
    }
    public Teacher(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.id = idTemp++;
    }
    @Override
    public String toString(){
        return "ID: "+ getId()+
                ", Name: "+getName()+
                ", Address: "+getAddress()+
                ", Phone: "+getPhone()+
                ", Level: "+getLevel();
    }

}
