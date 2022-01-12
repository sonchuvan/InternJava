package bookBM;

import bookBM.book.CNTTBook;
import bookBM.book.DTVTBook;
import bookBM.book.KHTNBook;
import bookBM.book.VHNTBook;
import bookBM.reader.CaoHocReader;
import bookBM.reader.GiaoVienReader;
import bookBM.reader.SinhVienReader;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Management[] mng = new Management[100];
        service sv = new service();
        int lc;
        do {
            System.out.println("=========================================");
            System.out.println("Moi lua chon");
            System.out.println("1. Nhap ban doc moi");
            System.out.println("2. Nhap sach moi");
            System.out.println("3. Hien thi danh sach ban doc");
            System.out.println("4. Hien thi danh sach sach");
            System.out.println("5. Lap bang quan ly muon sach");
            System.out.println("6. sap xep bang quan ly muon sach");
            System.out.println("0. Exit");
            System.out.println("=========================================");
            lc = Management.in.nextInt();
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
                    System.out.println("Bang quan ly muon sach sau khi sap xep:");
                    System.out.println("=======================================================================================");
                    for (int i = 0; i < mng.length; i++) {
                        if (mng[i]==null) break;
                        mng[i].show();
                        System.out.println("=======================================================================================");
                    }
                    break;
                case 0:
            }

        } while (lc!=0);


    }

}
