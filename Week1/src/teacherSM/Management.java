package teacherSM;

import teacherSM.subject.Subject;
import teacherSM.teacher.*;

public class Management {
    Teacher teacher;
    Subject[] subject = new Subject[100];
    int[] soLop = new int[100];


    public Subject[] addListSubject(Subject[] s){
        System.out.println("nhap so luong mon hoc muon them");
        String sl = Main.in.next();
        while (Main.checkValid(sl,"\\d")==false){
            System.out.println("Nhap sai, nhap lai:");
            sl = Main.in.next();
        }
        int sl1 = Integer.parseInt(sl);
        int j = 1;
        for (int i = 0; i < s.length; i++) {
            if(j>sl1) break;
            if(s[i]==null){
                System.out.println("Nhap mon hoc thu "+j+":");
                Subject s1 = new Subject();
                System.out.println("Nhap ten mon hoc:");
                s1.setName(Main.in.next());
                System.out.println("Nhap tong so tiet hoc:");
                s1.setSoTietHoc(Main.in.nextInt());
                System.out.println("Nhap so tiet ly thuyet:");
                s1.setSoTietLyThuyet(Main.in.nextInt());
                System.out.println("Nhap hoc phi 1 tiet");
                s1.setHocPhi(Main.in.nextInt());
                s[i] = s1;
                j++;
            }
        }

        return s;
    }

    public void showMonHoc(Subject[] s){
        System.out.println("Danh sach mon hoc:");
        for (int i = 0; i < s.length; i++) {
            if (s[i] == null){
                break;
            }
            System.out.print("\t");
            System.out.println(s[i].toString());
        }
    }

    public Teacher[] addListTeacher(Teacher[] teachers){
        System.out.println("nhap so luong giang vien muon them");
        String sl = Main.in.next();
        while (Main.checkValid(sl,"\\d")==false){
            System.out.println("Nhap sai, nhap lai:");
            sl = Main.in.next();
        }
        int sl1 = Integer.parseInt(sl);
        int j = 1;
        for (int i = 0; i < teachers.length; i++) {
            if(j>sl1) break;
            if(teachers[i]==null){
                System.out.println("Nhap giang vien thu "+j+":");
                System.out.println("Chon loai giang vien");
                System.out.println("1: Giao su tien si");
                System.out.println("2: Pho giao su tien si");
                System.out.println("3: Giao vien chinh");
                System.out.println("4: Tien si");

                int lgv = 0;
                do{
                    lgv = Main.in.nextInt();
                }while (lgv < 0 || lgv >5);
                Teacher s1 = null;
                switch (lgv){
                    case 1:
                        s1 = new GSTS();
                        break;
                    case 2:
                        s1 = new PGSTS();
                        break;
                    case 3:
                        s1 = new GVC();
                        break;
                    case 4:
                        s1 = new TS();
                        break;
                }

                System.out.println("Nhap ten giang vien:");
                s1.setName(Main.in.next());
                System.out.println("Nhap dia chi giang vien:");
                s1.setAddress(Main.in.next());
                System.out.println("Nhap so dien thoai giang vien:");
                s1.setPhone(Main.in.next());
                teachers[i] = s1;
                j++;
            }
        }
        return teachers;
    }

    public void showListTeacher(Teacher[] teachers){
        System.out.println("Danh sach mon hoc:");
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null){
                break;
            }
            System.out.print("\t");
            System.out.println(teachers[i].toString());
        }
    }

    public Subject searchSubject(Subject[] subjects,int id){
        for (int i = 0; i <subjects.length ; i++) {
            if(subjects[i]== null) break;
            if(subjects[i].getId() == id){
                return subjects[i];
            }
        }
        return null;
    }

    public int tongSoTietHoc(Management mng){
        int sum = 0;
        for (int i = 0; i < mng.subject.length; i++) {
            if (mng.subject[i] == null) break;
            sum += mng.soLop[i] * mng.subject[i].getSoTietHoc();
        }
        return sum;
    }

    public boolean checkSubject(Subject[] subjects,int id){
        for (int i = 0; i < subjects.length; i++) {
            if(subjects[i]==null) break;
            if(subjects[i].getId()==id) return false;
        }
        return true;
    }

    public Management[] bangKeKhai(Management[] mng,Teacher[] teachers,Subject[] subjects){
        if(teachers[0] == null) {
            System.out.println("Chưa có giảng viên trong danh sách");
            return null;
        }
        if(subjects[0] == null) {
            System.out.println("Chưa có môn học nào trong danh sách");
            return null;
        }
        System.out.println("Lập bảng kê khai giảng viên");
        for (int i = 0; i < mng.length; i++) {
            mng[i] = new Management();
            if(teachers[i]==null){
                break;
            }
            mng[i].teacher = teachers[i];
            System.out.println("Giảng viên "+teachers[i].getId()+":");
            System.out.println("Các môn giảng dậy của giảng viên "+teachers[i].getId()+":");
            int k = 0;
            d:
            do {
                System.out.println("Nhập mã môn học thứ "+(k+1)+"(nhập 0 để kết thúc):");
                //int ids;
                do {
                    int ids = Main.in.nextInt();
                    if(!checkSubject(mng[i].subject,ids)){
                        System.out.println("Môn học đã được nhập,hãy nhập môn học khác(nhập 0 để kết thúc)");
                        continue;
                    }
                    if (ids == 0) break d;
                    Subject sb = searchSubject(subjects,ids);
                    if (sb != null ){
                        mng[i].subject[k] = sb;
                        System.out.println("Nhập số lớp của môn học(tối đa 3):");

                        do {
                            int sll = Main.in.nextInt();
                            if(sll>3){
                                System.out.println("không được quá 3 lớp, Nhập lại");
                                continue;
                            }
                            if(mng[i].subject[k].getSoTietHoc()*sll+tongSoTietHoc(mng[i])>200){

                                System.out.println("Đã vượt quá 200 tiết học, nhập lại");
                                continue;
                            }
                            mng[i].soLop[k] = sll;
                            System.out.println("Đã có "+tongSoTietHoc(mng[i])+" tiết học(tối đa 200)");
                            break ;
                        }while (true);
                        k++;
                        break;
                    }
                    System.out.println("Nhập sai id môn học, nhập lại");
                }while (true);
            }while (true);
        }
        return mng;
    }

    public void showBangKeKhai(Management[] mng){
        if(mng[0]==null) {
            System.out.println("Chưa lập bảng kê khai");
            return;
        }
        System.out.println("====Bảng kê khai giảng dậy====");
        for (int i = 0; i < mng.length; i++) {
            if(mng[i].teacher==null) break;
            System.out.println("GIảng viên "+mng[i].teacher.getId()+":"+mng[i].teacher.getName()+":");
            for (int j = 0; j < mng[i].subject.length; j++) {
                if (mng[i].subject[j] == null) break;
                System.out.print("\t\t");
                System.out.println("Môn học "+mng[i].subject[j].getId()+":"+mng[i].subject[j].getName()+" Số lớp: "+mng[i].soLop[j]);
            }
            System.out.println("\t\tTổng số tiết học: "+tongSoTietHoc(mng[i]));

        }
    }

    public float tinhLuong(){
        float total = 0;
        for (int i = 0; i < subject.length; i++) {
            if(subject[i]==null) break;
            total +=subject[i].tienMonHoc()*soLop[i];
        }
        return total;
    }

    public Management[] sortByName(Management[] mng){

        for (int i = 0; i < mng.length; i++) {
            if(mng[i] == null) break;
            for (int j = i; j < mng.length; j++) {
                if(mng[j].teacher == null) break;
                if(mng[i].teacher.getName().compareTo(mng[j].teacher.getName())>0 ){
                    Management temp = mng[i];
                    mng[i] = mng[j];
                    mng[j] = temp;
                }
            }
        }
        return mng;
    }

    public Management[] sortBySTGD(Management[] mng){
        for (int i = 0; i < mng.length; i++) {
            if (mng[i]==null) break;
            for (int j = i; j < mng.length; j++) {
                if (mng[j]==null) break;
                if (tongSoTietHoc(mng[i])<tongSoTietHoc(mng[j])){
                    Management temp = mng[i];
                    mng[i] = mng[j];
                    mng[j] = temp;
                }
            }

        }
        return mng;
    }

    public void salary(Management[] mng){
        float[] salary = new float[100];
        for (int i = 0; i < mng.length; i++) {
            if (mng[i].teacher==null) break;
            salary[i] = mng[i].tinhLuong();
            System.out.print("Giảng viên "+mng[i].teacher.getId()+":"+mng[i].teacher.getName());
            System.out.print(" Có tổng lương là: "+salary[i]+"\n");
        }
    }
}
