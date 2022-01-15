package teacherSM.subject;

public class Subject {
    private static int idTemp = 100;
    private int id;
    private String name;
    private int soTietHoc;
    private int soTietLyThuyet;
    private float hocPhi;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSoTietHoc() {
        return soTietHoc;
    }

    public void setSoTietHoc(int soTietHoc) {
        this.soTietHoc = soTietHoc;
    }

    public int getSoTietLyThuyet() {
        return soTietLyThuyet;
    }

    public void setSoTietLyThuyet(int soTietLyThuyet) {
        this.soTietLyThuyet = soTietLyThuyet;
    }

    public float getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(float hocPhi) {
        this.hocPhi = hocPhi;
    }

    public Subject() {
        id = idTemp++;
    }

    public Subject(String name, int soTietHoc, int soTietLyThuyet, float hocPhi) {
        this.id = idTemp++;
        this.name = name;
        this.soTietHoc = soTietHoc;
        this.soTietLyThuyet = soTietLyThuyet;
        this.hocPhi = hocPhi;

    }

    public float tienMonHoc(){
        float total = (float) (soTietLyThuyet*hocPhi+(soTietHoc-soTietLyThuyet)*0.7);
        return total;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "ID='" + this.id + '\'' +
                "name='" + name + '\'' +
                ", soTietHoc=" + soTietHoc +
                ", soTietLyThuyet=" + soTietLyThuyet +
                ", hocPhi=" + hocPhi +
                '}';
    }
}
