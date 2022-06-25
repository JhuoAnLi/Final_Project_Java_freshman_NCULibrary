import java.time.*;
import java.time.format.DateTimeFormatter;

public class Books {
    private String name;
    private String author;
    private String publisher;
    private int ISBN;
    private String status;
    private String category;
    public int searchCount = 0;
    public LocalDate deadline;
    public LocalDateTime borrow_time;
    public LocalDate return_date;
    public String borrower;
    LocalDateTime now = LocalDateTime.now();
    public LocalDateTime plusTime;
    public LocalDateTime plusTime2;
    public LocalDateTime plusTime3;
    protected int TotalBorrowNum = 0;
    public boolean reserve;

    public Books(String name, String author, String publisher, int ISBN, String category, String status) {
        setName(name);
        setAuthor(author);
        setPublisher(publisher);
        setISBN(ISBN);
        setStatus(status);
        setCategory(category);
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String n) {
        name = n;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setStatus(String borrowed) {
        this.status = borrowed;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getStatus() {
        return status;
    }

    public String toString() {
        return "Name: " + name + "\nAuthor: " + author + "\nPublisher: " + publisher + "\nISBN: " + ISBN + "\nStatus: "
                + status;
    }

    public void setBorrower(String name) {
        this.borrower = name;
    }

    public String getBorrower() {
        return this.borrower;
    }

    public void setTotalBorrowNum(int TotalBorrowNum) {
        this.TotalBorrowNum = TotalBorrowNum;
    }

    public int getTotalBorrowNum() {
        return TotalBorrowNum;
    }

    public void setBorrow_time(LocalDateTime now) {
        this.borrow_time = now;
        this.plusTime = now.plusSeconds(10);
        this.plusTime2 = now.plusSeconds(12);
        this.plusTime3 = now.plusSeconds(14);

    }

    public String getBorrow_time() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(borrow_time);
    }

    public String getReturn_time(int tt) {
        if (tt == 10) {
            return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(plusTime);
        } else if (tt == 12) {
            return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(plusTime2);
        } else {
            return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(plusTime3);
        }

    }

    public LocalDateTime getReturn_date(int r) {
        if (r == 10) {

            return plusTime;
        } else if (r == 12) {
            return plusTime2;
        } else {
            return plusTime3;
        }
    }

    public void setsearchCount(int searchCount) {
        this.searchCount = searchCount;
    }

    public int getsearchCount() {
        return searchCount;
    }

    public void setReserve() {
        reserve = true;
    }

    public void setUnReserve() {
        reserve = false;
    }

    public boolean getReserve() {
        return reserve;
    }

}