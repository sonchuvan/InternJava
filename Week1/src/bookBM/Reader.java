package bookBM;

public class Reader {
    private static int id = 10000;
    private String name;
    private String address;
    private String phone;
    private String type;

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

    public String getType() {
        return type;
    }
    public Reader() {
        id++;
    }
    public void nhapBanDoc(){
        Management.in.nextLine();
        System.out.println("nhap thong tin ban doc: ");
        System.out.println("nhap ten ban doc: ");
        this.setName(Management.in.nextLine());
        System.out.println("nhap dia chi: ");
        this.setAddress(Management.in.nextLine());
        System.out.println("nhap so dien thoai: ");
        this.setPhone(Management.in.nextLine());
    }
}
