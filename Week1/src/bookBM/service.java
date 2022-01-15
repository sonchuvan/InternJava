package bookBM;

import bookBM.book.CNTTBook;
import bookBM.book.DTVTBook;
import bookBM.book.KHTNBook;
import bookBM.book.VHNTBook;
import bookBM.reader.CaoHocReader;
import bookBM.reader.GiaoVienReader;
import bookBM.reader.SinhVienReader;

public class service {
    public Reader[] readers = new Reader[100];
    public Book[] books = new Book[100];

    public void nhapBanDoc() {
        System.out.println("nhap so luong ban doc muon them:");
        int sl = Management.in.nextInt();
        int i = 0;
        while (readers[i] != null) {
            i++;
        }
        c:
        for (int j = 0; j < sl; j++) {
            System.out.println("moi chon kieu ban doc:");
            System.out.println("1: Sinh vien");
            System.out.println("2: Cao hoc");
            System.out.println("3: Giao vien");
            System.out.println("0: <==Exit");
            int ds1 = 0;
            boolean flag;
            do {
                String digit = "[0-3]";
                String input = Management.in.next();
                flag = input.matches(digit);
                if (!flag) {
                    System.out.println("nhap sai!, moi nhap lai");
                    continue;
                }
                ds1 = Integer.parseInt(input);

            } while (!flag);
            switch (ds1) {
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
                case 0:
                    break c;
            }
        }
    }

    public void showBanDoc() {
        System.out.println("Danh sach ban doc");
        for (int i = 0; i < 100; i++) {
            if (readers[i] == null) break;
            System.out.println("STT " + i + ":" + readers[i].toString());
        }
    }

    public void nhapSach() {
        System.out.println("nhap so luong sach muon them:");
        int sl = Management.in.nextInt();
        int i = 0;
        while (books[i] != null) {
            i++;
        }
        d:
        for (int j = 0; j < sl; j++) {
            System.out.println("moi chon dau sach can nhap vao:");
            System.out.println("1: sach CNTT");
            System.out.println("2: sach DTVT");
            System.out.println("3: sach KHTN");
            System.out.println("4: sach VHNT");
            System.out.println("0: <==Exit");
            int ds = 0;
            boolean flag;
            do {
                String digit = "[0-4]";
                String input = Management.in.next();
                flag = input.matches(digit);
                if (!flag) {
                    System.out.println("nhap sai!, moi nhap lai");
                    continue;
                }
                ds = Integer.parseInt(input);

            } while (!flag);
            switch (ds) {
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
                case 0:
                    break d;
            }
        }
    }

    public void showSach() {
        System.out.println("Danh sach sach:");
        for (int i = 0; i < 100; i++) {
            if (books[i] == null) break;
            System.out.println("STT " + i + ":" + books[i].toString());
        }
    }

    public Management[] sortByName(Management[] mng) {

        for (int i = 0; i < mng.length; i++) {
            if (mng[i] == null) break;
            //System.out.println(mng[i].reader.getName());
            for (int j = i; j < mng.length; j++) {
                if (mng[j] == null) break;
                if (mng[i].reader.getName().compareTo(mng[j].reader.getName()) > 0) {
                    Management temp = mng[i];
                    mng[i] = mng[j];
                    mng[j] = temp;
                }
            }

        }
        return mng;
    }

    public int countB(Book[] b) {
        int count = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] != null) {
                count++;
            }
        }
        return count;
    }

    public Management[] sortBySL(Management[] mng) {
        for (int i = 0; i < mng.length; i++) {
            if (mng[i] == null) break;
            for (int j = i; j < mng.length; j++) {
                if (mng[j] == null) break;
                if (countB(mng[i].books) < countB(mng[j].books)) {
                    Management temp = mng[i];
                    mng[i] = mng[j];
                    mng[j] = temp;
                }
            }
        }
        return mng;
    }

    public Management[] searchByName(Management[] mng, String name) {
        Management[] temp = new Management[mng.length];
        for (int i = 0; i < mng.length; i++) {
            if (mng[i] == null) break;
            if (mng[i].reader.getName().equalsIgnoreCase(name)) {
                for (int j = 0; j < temp.length; j++) {
                    if (temp[j] == null) {
                        temp[j] = mng[i];
                        break;
                    }
                }
            }
        }
        return temp;
    }
}
