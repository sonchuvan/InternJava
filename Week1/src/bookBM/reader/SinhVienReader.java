package bookBM.reader;

import bookBM.Reader;

public class SinhVienReader extends Reader {
    private int id = super.getId();
    private String type = "Sinh vien";

    @Override
    public int getId() {
        return id;
    }

    public SinhVienReader() {
    }

    public SinhVienReader(String name, String address, String phone) {
        this.setName(name);
        this.setAddress(address);
        this.setPhone(phone);
    }

    @Override
    public String toString() {
        return "{" +
                "id ='" + id + '\'' +
                "name='" + this.getName() + '\'' +
                "address='" + this.getAddress() + '\'' +
                "phone='" + this.getPhone() + '\'' +
                "type='" + type + '\'' +
                '}';
    }
}
