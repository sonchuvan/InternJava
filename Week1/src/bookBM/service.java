package bookBM;

import bookBM.book.CNTTBook;
import bookBM.book.DTVTBook;
import bookBM.book.KHTNBook;
import bookBM.book.VHNTBook;
import bookBM.reader.CaoHocReader;
import bookBM.reader.GiaoVienReader;
import bookBM.reader.SinhVienReader;

import java.util.Scanner;

public class service{
    public Reader[] readers = new Reader[100];
    public Book[] books = new Book[100];
    public void nhapBanDoc(){
        System.out.println("nhap so luong ban doc muon them:");
        int sl = Management.in.nextInt();
        int i = 0;
        while (readers[i]!=null){
            i++;
        }
        for (int j = 0; j < sl; j++) {
            System.out.println("moi chon kieu ban doc:");
            System.out.println("1: Sinh vien");
            System.out.println("2: Cao hoc");
            System.out.println("3: Giao vien");
            int ds = Management.in.nextInt();
            switch (ds){
                case 1:
                    readers[i] = new SinhVienReader();
                    readers[i].nhapBanDoc();
                    i++;
                    break;
                case 2:
                    readers[i] = new CaoHocReader();
                    readers[i].nhapBanDoc();
                    i++;
                    break;
                case 3:
                    readers[i] = new GiaoVienReader();
                    readers[i].nhapBanDoc();
                    i++;
                    break;
            }
        }
    }
    public void showBanDoc(){
        System.out.println("Danh sach ban doc");
        for (int i = 0; i < 100; i++) {
            if(readers[i]==null) break;
            System.out.println("STT "+i+":"+readers[i].toString());
        }
    }
    public void nhapSach(){
        System.out.println("nhap so luong sach muon them:");
        int sl = Management.in.nextInt();
        int i = 0;
        while (books[i]!=null){
            i++;
        }
        for (int j = 0; j < sl; j++) {
            System.out.println("moi chon dau sach can nhap vao:");
            System.out.println("1: sach CNTT");
            System.out.println("2: sach DTVT");
            System.out.println("3: sach KHTN");
            System.out.println("4: sach VHNT");
            int ds = Management.in.nextInt();
            switch (ds){
                case 1:
                    books[i] = new CNTTBook();
                    books[i].nhapsach();
                    i++;
                    break;
                case 2:
                    books[i] = new DTVTBook();
                    books[i].nhapsach();
                    i++;
                    break;
                case 3:
                    books[i] = new KHTNBook();
                    books[i].nhapsach();
                    i++;
                    break;
                case 4:
                    books[i] = new VHNTBook();
                    books[i].nhapsach();
                    i++;
                    break;
            }
        }
    }
    public void showSach(){
        System.out.println("Danh sach sach:");
        for (int i = 0; i < 100; i++) {
            if(books[i]==null) break;
            System.out.println("STT "+i+":"+books[i].toString());
        }
    }
    public Management[] sortByName(Management[] mng){
        for (int i = 0; i < mng.length; i++) {

            if(mng[i]==null) break;
            System.out.println(mng[i].reader.getName());
            for (int j = i+1; j < mng.length; j++) {
                if(mng[j]==null) break;
                if(mng[i].reader.getName().compareTo(mng[j].reader.getName())>0 ){
                    Management temp = mng[i];
                    mng[i] = mng[j];
                    mng[j] = temp;
                }
            }

        }
        return mng;
    }
}
