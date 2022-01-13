package bookBM;

public class Main {
    public static void main(String[] args) {
        Management[] mng = new Management[100];
        service sv = new service();
        int lc = 0;
        do {
            System.out.println("=========================================");
            System.out.println("Moi lua chon");
            System.out.println("1. Nhap ban doc moi");
            System.out.println("2. Nhap sach moi");
            System.out.println("3. Hien thi danh sach ban doc");
            System.out.println("4. Hien thi danh sach sach");
            System.out.println("5. Lap bang quan ly muon sach");
            System.out.println("6. sap xep bang quan ly muon sach theo ten ban doc");
            System.out.println("7. sap xep bang quan ly muon sach theo so luong muon");
            System.out.println("8. Search bang quan ly muon sach theo ten ban doc");
            System.out.println("0. Exit");
            System.out.println("=========================================");
            boolean flag;
            do {

                String digit = "[0-8]";
                String input = Management.in.next();
                flag = input.matches(digit);

                if (!flag){
                    System.out.println("nhap sai!, moi nhap lai");
                    continue;
                }
                lc = Integer.parseInt(input);

            } while (!flag);
            //lc = Management.in.nextInt();
            switch (lc){
                case 1:
                    sv.nhapBanDoc();break;
                case 2:
                    sv.nhapSach();break;
                case 3:
                    sv.showBanDoc();break;
                case 4:
                    sv.showSach();break;
                case 5:
                    if(sv.readers[0]==null || sv.books[0]==null){
                        System.out.println("chua co ban doc hoac chua co sach");
                    }
                    for (int i = 0; i < sv.readers.length; i++) {
                        if(sv.readers[i]==null) break;
                        mng[i] = new Management();
                        mng[i].muonsach(sv.readers[i],sv.books );
                    }
                    System.out.println("Bang quan ly muon sach:");
                    System.out.println("=======================================================================================");
                    for (int i = 0; i < mng.length; i++) {
                        if (mng[i]==null) break;
                        mng[i].show();
                        System.out.println("=======================================================================================");
                    }
                    break;
                case 6:
                    mng = sv.sortByName(mng);
                    System.out.println("Bang quan ly sap xep theo ten ban doc:");
                    System.out.println("=======================================================================================");
                    for (int i = 0; i < mng.length; i++) {
                        if (mng[i]==null) break;
                        mng[i].show();
                        System.out.println("=======================================================================================");
                    }
                    break;
                case 7:
                    mng = sv.sortBySL(mng);
                    System.out.println("Bang quan ly sap xep theo so luong muon:");
                    System.out.println("=======================================================================================");
                    for (int i = 0; i < mng.length; i++) {
                        if (mng[i]==null) break;
                        mng[i].show();
                        System.out.println("=======================================================================================");
                    }
                    break;
                case 8:
                    System.out.println("Nhap ten ban doc muon tim:");
                    String name = Management.in.next();
                    Management[] temp = sv.searchByName(mng,name);
                    if(temp[0]==null) {
                        System.out.println("khong co ban doc ten "+name);
                        break;
                    }
                    for (int i = 0; i < temp.length; i++) {
                        if(temp[i]==null) break;
                        temp[i].show();
                    }
                case 0:
                    System.out.println("ket thuc chuong trinh");
                    break;
            }

        } while (lc!=0);


    }

}
