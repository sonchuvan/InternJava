package bookBM;

import java.util.Scanner;

public class Management {
    static Scanner in = new Scanner(System.in);
    Reader reader;
    Book[] books = new Book[15];

    public Management(){

    }
    private boolean demDauSach(Book[] books,String dauSach){
        int dem = 0;
        for (int i = 0; i < books.length; i++) {
            if(books[i]==null) break;
            if(books[i].getSpecialized().equals(dauSach)){
                dem++;
            }
        }
        if(dem >= 3 ) return false;
        return true;
    }
    public Book searchBook(int id,Book[] books){
        for (int i = 0; i < books.length; i++) {
            if(books[i] == null) break;
            if (books[i].getBookId() == id){
                return books[i];
            }
        }
        return null;
    }
    public void addBook(Book book){
        for (int i = 0; i < 15; i++) {
            if(books[i] == null){
                books[i] = book;
                break;
            }
        }
    }
    public void muonsach(Reader reader,Book[] books1){
        this.reader = reader;
        System.out.println("Nhap so luong sach ban doc "+reader.getId()+" muon(<15): ");
        int sl = 0;
        boolean flag1;
        do {
            String digit = "\\d{1,2}";
            String input = Management.in.next();
            flag1 = input.matches(digit);
            if (!flag1){
                System.out.println("nhap sai!, moi nhap lai");
                continue;
            }
            sl = Integer.parseInt(input);
            if(sl > 15 ){
                flag1 = false;
                continue;
            }

        } while (!flag1);

        //int sl = in.nextInt();
        int j = 1;
        for (int i = 0; i < sl; i++) {
            if (books[books.length-1]!= null) {
                System.out.println("da muon toi da sach");
                break;
            }
            if(books[i]==null) {
                do {
                    System.out.println("Nhap id sach thu " + (j) + ":");
                    int id = 0;
                    boolean flag;
                    do {
                        String digit = "\\d{5}";
                        String input = Management.in.next();
                        flag = input.matches(digit);
                        if (!flag){
                            System.out.println("nhap sai!, moi nhap lai");
                            continue;
                        }
                        id = Integer.parseInt(input);

                    } while (!flag);
                    if(searchBook(id, books1)==null){
                        System.out.println("khong ton tai ID nay, Nhap lai id.");
                        continue;
                    }
                    j++;
                    Book b = searchBook(id, books1);
                    if (demDauSach(books, b.getSpecialized())) {
                        addBook(b);break;
                    } else {
                        System.out.println("qua so luong sach cua 1 dau sach, hay chon sach khac");
                        j--;
                    }
                }while (true);
            }

        }

    }
    public void show(){
        System.out.println("Ban doc "+reader.getId()+":"+reader.getName()+" da muon cac sach:");
        for (int i = 0; i < books.length; i++) {
            if (books[i]== null) break;
            System.out.print("\t");
            System.out.println(books[i].toString());
        }
    }
}
