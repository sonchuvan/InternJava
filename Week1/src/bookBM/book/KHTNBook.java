package bookBM.book;

import bookBM.Book;

public class KHTNBook extends Book {
    private int bookId = super.getBookId();
    private String specialized = "Khoa hoc tu nhien";

    @Override
    public int getBookId() {
        return bookId;
    }
    public String getSpecialized() {
        return specialized;
    }

    public KHTNBook() {
    }

    public KHTNBook(String bookName, String author, int year){
        this.setBookName(bookName);
        this.setAuthor(author);
        this.setYear(year);
    }
    @Override
    public String toString() {
        return " bookid='" + bookId+ '\'' +
                ", bookName='" + this.getBookName() + '\'' +
                ", author='" + this.getAuthor() + '\'' +
                ", specialized='" + this.getSpecialized() + '\'' +
                ", year=" + this.getYear();
    }
}
