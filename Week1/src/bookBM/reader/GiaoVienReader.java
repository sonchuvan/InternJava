package bookBM.reader;

import bookBM.Reader;

public class GiaoVienReader extends Reader {
    private int id = super.getId();
    private String type = "Giao vien";
    @Override
    public int getId() {
        return id;
    }

    public GiaoVienReader(String name, String address, String phone) {
        this.setName(name);
        this.setAddress(address);
        this.setPhone(phone);
    }

    public GiaoVienReader() {
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
