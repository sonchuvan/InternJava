package teacherSM;

import teacherSM.subject.Subject;
import teacherSM.teacher.*;

public class Management {
    Teacher teacher;
    Subject[] subject = new Subject[100];
    int[] soLop = new int[100];


    public Subject[] addListSubject(Subject[] s){
        System.out.println("Nhập số lượng môn học muốn thêm");
        String sl = Main.in.next();
        while (Main.checkValid(sl,"\\d")==false){
            System.out.println("Nhập sai, mời nhập lại:");
            sl = Main.in.next();
        }
        int sl1 = Integer.parseInt(sl);
        int j = 1;
        for (int i = 0; i < s.length; i++) {
            if(j>sl1) break;
            if(s[i]==null){
                System.out.println("Nhập môn học thứ "+j+":");
                Subject s1 = new Subject();
                System.out.println("Nhập tên môn học:");
                s1.setName(Main.in.next());
                System.out.println("Nhập tổng số tiết học:");
                s1.setSoTietHoc(Main.in.nextInt());
                System.out.println("Nhập số tiết lý thuyết:");
                s1.setSoTietLyThuyet(Main.in.nextInt());
                System.out.println("Nhập học phí 1 tiết");
                s1.setHocPhi(Main.in.nextInt());
                s[i] = s1;
                j++;
            }
        }

        return s;
    }

    public void showMonHoc(Subject[] s){
        System.out.println("Danh sách môn học:");
        for (int i = 0; i < s.length; i++) {
            if (s[i] == null){
                break;
            }
            System.out.print("\t");
            System.out.println(s[i].toString());
        }
    }

    public Teacher[] addListTeacher(Teacher[] teachers){
        System.out.println("Nhập số lượng giảng viên muốn thêm");
        String sl = Main.in.next();
        while (Main.checkValid(sl,"\\d")==false){
            System.out.println("Nhập sai, mời nhập lại:");
            sl = Main.in.next();
        }
        int sl1 = Integer.parseInt(sl);
        int j = 1;
        for (int i = 0; i < teachers.length; i++) {
            if(j>sl1) break;
            if(teachers[i]==null){
                System.out.println("Nhập thông tin cho giảng viên thứ "+j+":");
                System.out.println("Chọn loại giảng viên");
                System.out.println("1: Giáo sư tiến sĩ");
                System.out.println("2: Phó giáo sư, tiến sĩ");
                System.out.println("3: Giáo viên chính");
                System.out.println("4: Tiến sĩ");

                int lgv = 0;
                String k1 = Main.in.next();
                while (Main.checkValid(k1,"[0-4]")==false){
                    System.out.println("Nhập sai, Mời nhập lại:");
                    k1 = Main.in.next();
                }
                lgv = Integer.parseInt(k1);
//                do{
//                    lgv = Main.in.nextInt();
//                }while (lgv < 0 || lgv >5);
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

                System.out.println("Nhập tên giảng viên:");
                s1.setName(Main.in.next());
                System.out.println("Nhập địa chỉ giảng viên:");
                s1.setAddress(Main.in.next());
                System.out.println("Nhập số điện thoại giảng viên:");
                s1.setPhone(Main.in.next());
                teachers[i] = s1;
                j++;
            }
        }
        return teachers;
    }

    public void showListTeacher(Teacher[] teachers){
        System.out.println("Danh sách giảng viên:");
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
                do {
                    int ids = 0;
                    boolean flag;
                    do {

                        String digit = "\\d";
                        String input = Main.in.next();
                        flag = input.matches(digit);

                        if (!flag){
                            System.out.println("nhập sai!, mời nhập lại");
                            continue;
                        }
                        ids = Integer.parseInt(input);

                    } while (!flag);
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
