package bookBM;

public class Book {
    private static int bookId = 10000;
    private String bookName;
    private String author;
    private int year;
    private String specialized;

    public String getSpecialized() {
        return specialized;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public void nhapsach(){
        Management.in.nextLine();
        System.out.println("nhap thong tin sach: ");
        System.out.println("nhap ten sach: ");
        this.setBookName(Management.in.nextLine());
        System.out.println("nhap tac gia: ");
        this.setAuthor(Management.in.nextLine());
        System.out.println("nhap nam san xuat: ");
        this.setYear(Management.in.nextInt());
    }
    public Book(){
        bookId++;
    }
    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
