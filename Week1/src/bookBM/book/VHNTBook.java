package bookBM.book;

import bookBM.Book;

public class VHNTBook extends Book {
    private int bookId = super.getBookId();
    private String specialized = "Van hoa - Nghe thuat";

    @Override
    public int getBookId() {
        return bookId;
    }
    public String getSpecialized() {
        return specialized;
    }

    public VHNTBook() {
    }

    public VHNTBook(String bookName, String author, int year){
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
