package bookBM.reader;

import bookBM.Reader;

public class CaoHocReader extends Reader {
    private int id = super.getId();
    private String type = "Cao hoc";

    @Override
    public int getId() {
        return id;
    }
    @Override
    public String getName(){
        return super.getName();
    }
    public CaoHocReader(String name, String address, String phone) {
        this.setName(name);
        this.setAddress(address);
        this.setPhone(phone);
    }

    public CaoHocReader() {
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
