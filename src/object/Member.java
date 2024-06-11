package object;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import database.Mysql;
import view.App;

public abstract class Member extends User {

    protected String identity;
    protected int age;
    protected int max_borrow;
    protected int fine;
    protected int deadline;
    protected int borrow_num = 0;
    protected int borrow_day;
    protected int borrow_time;
    protected String borrowerr_book;
    protected String history = "";
    protected int TotalFine = 0;
    public boolean reservee = false;

    protected static String borrowed_books[] = new String[50];
    protected static ArrayList<object.Books> bookList = App.getBooks();
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    
    // java.net.URL resourcer = classLoader.getResource("./resources/" + "Personal_information.png");
    // ImageIcon Personal_informationn = new ImageIcon(resourcer);

    // java.net.URL resourcerr = classLoader.getResource("./resources/" + "Money.png");
    // ImageIcon Moneyy = new ImageIcon(resourcerr);

    // java.net.URL resourcerrr = classLoader.getResource("./resources/" + "Code.png");
    // ImageIcon Codee = new ImageIcon(resourcerrr);

    // Admin admin = new Admin("Admin", "Admin", "Admin");
    ChronoLocalDate now = LocalDate.now();
    LocalDateTime now1 = LocalDateTime.now();

    public Member(String name, String account, String password, String identity, int age) {
        super(name, account, password);
        setIdentity(identity);
        setAge(age);
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdentity() {
        return identity;
    }

    public int getAge() {
        return age;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    abstract int getFine();

    public void setDeadlinee(int deadline) {
        this.deadline = deadline;
    }

    abstract int getDeadlinee();

    public void setMax_borrow(int max_borrow) {
        this.max_borrow = max_borrow;
    }

    abstract int getMax_borrow();

    public void setBorrow_num(int borrow_num) {
        this.borrow_num = borrow_num;
    }

    public int getBorrow_num() {
        return borrow_num;
    }

    public void setBorrower(String borrowerr) {
        this.borrowerr_book = borrowerr;
    }

    public String getBorrower() {
        return borrowerr_book;
    }

    public void setReservee(boolean reservee) {
        this.reservee = reservee;
    }

    public boolean getReservee() {
        return reservee;
    }

    public void setTotalFine(int TotalFine) {
        this.TotalFine = TotalFine;
    }

    public int getTotalFine() {
        return TotalFine;
    }

    public boolean login(String accountt, String passwordd) {
        if (accountt.equals(account) && passwordd.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public void setHistory(String history) {
        this.history += history + " ";
    }

    public String getHistory() {
        return history;
    }

    public String toString() {
        return "name: " + name;
    }

    public static void borrow_book(String name, String Account) {
        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the book name!", "Error", JOptionPane.ERROR_MESSAGE);

        } else {
            for (int y = 0; y < bookList.size(); y++) {
                if (bookList.get(y) != null && bookList.get(y).getName().equals(name)
                        && bookList.get(y).getStatus().equals("Available")) {
                    ArrayList<Member> memberList = App.getMembers();
                    System.out.println(memberList.size());
                    for (int t = 0; t < memberList.size(); t++) {
                        if (memberList.get(t).getAccount().equals(Account)) {
                            if (memberList.get(t).getBorrow_num() < memberList.get(t).getMax_borrow()) {
                                memberList.get(t).setBorrow_num(memberList.get(t).getBorrow_num() + 1);
                                bookList.get(y).setTotalBorrowNum(bookList.get(y).getTotalBorrowNum() + 1);
                                bookList.get(y).setBorrower(Account);
                                bookList.get(y).setStatus("Unavailable");
                                bookList.get(y).setsearchCount(bookList.get(y).getsearchCount() + 1);
                                Mysql.borrowBook(bookList.get(y));
                                bookList.get(y).setBorrow_time(LocalDateTime.now());
                                // bookList.get(y).setReturn_time(memberList.get(t).getDeadlinee());
                                for (int g = 0; g < borrowed_books.length; g++) {
                                    if (borrowed_books[g] == null) {
                                        borrowed_books[g] = bookList.get(y).getName();
                                        break;
                                    }
                                }
                                JOptionPane.showMessageDialog(null,
                                        "Borrow successfully!\nYou have to return the book before "
                                                + bookList.get(y).getReturn_time(memberList.get(t).getDeadlinee()) + " !",
                                        "Borrow successfully!", JOptionPane.INFORMATION_MESSAGE);
                                break;

                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "You have reached the maximum of books you can borrow!",
                                        "Borrow failed!", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                        }
                    }
                    break;
                } else if (bookList.get(y) != null && bookList.get(y).getName().equals(name)
                        && bookList.get(y).getStatus().equals("Unavailable")) {
                    ArrayList<Member> memberList = App.getMembers();
                    for (int h = 0; h < memberList.size(); h++) {
                        String abv[] = { "Yes", "No" };
                        if (memberList.get(h) != null && bookList.get(y).getBorrower() ==memberList.get(h).getAccount()) {
                            if (memberList.get(h).getIdentity().equals("Student")) {
                                int yy = JOptionPane.showOptionDialog(null,
                                        "The book is not available!\nReturn date would be "
                                                + bookList.get(y).getReturn_time(10) + " !\nDo you want to reserve it?",
                                        Account, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, abv,
                                        abv[0]);
                                if (yy == 0) {
                                    for (int hj = 0; hj < memberList.size(); hj++) {
                                        if (memberList.get(hj).getAccount().equals(Account)) {
                                            memberList.get(hj).setReservee(true);
                                            bookList.get(y).setReserve();
                                            JOptionPane.showMessageDialog(null, "Reserve successfully!",
                                                    "Reserve successfully!",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                    }

                                } else {
                                    bookList.get(y).setUnReserve();
                                    JOptionPane.showMessageDialog(null, "Alright! Please borrow other books!",
                                            "Reserve failed!",
                                            JOptionPane.ERROR_MESSAGE);
                                    break;
                                }

                            } else if (memberList.get(h).getIdentity().equals("Teacher")) {
                                int yy = JOptionPane.showOptionDialog(null,
                                        "The book is not available!\nReturn date would be "
                                                + bookList.get(y).getReturn_time(12) + " !\nDo you want to reserve it?",
                                        Account, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, abv,
                                        abv[0]);
                                if (yy == 0) {
                                    for (int hj = 0; hj < memberList.size(); hj++) {
                                        if (memberList.get(hj).getAccount().equals(Account)) {
                                            memberList.get(hj).setReservee(true);
                                            bookList.get(y).setReserve();
                                            JOptionPane.showMessageDialog(null, "Reserve successfully!",
                                                    "Reserve successfully!",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                    }
                                } else {
                                    bookList.get(y).setUnReserve();
                                    JOptionPane.showMessageDialog(null, "Alright! Please borrow other books!",
                                            "Reserve failed!",
                                            JOptionPane.ERROR_MESSAGE);
                                    break;
                                }

                            } else if (memberList.get(h).getIdentity().equals("Staff")) {
                                int yy = JOptionPane.showOptionDialog(null,
                                        "The book is not available!\nReturn date would be "
                                                + bookList.get(y).getReturn_time(14) + " !\nDo you want to reserve it?",
                                        Account, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, abv,
                                        abv[0]);
                                if (yy == 0) {
                                    for(int hj=0 ;hj<memberList.size(); hj++){
                                        if(memberList.get(hj).getAccount().equals(Account)){
                                            memberList.get(hj).setReservee(true);
                                            bookList.get(y).setReserve();
                                             JOptionPane.showMessageDialog(null, "Reserve successfully!",
                                            "Reserve successfully!",
                                            JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                    }
                                } else {
                                    bookList.get(y).setUnReserve();
                                    JOptionPane.showMessageDialog(null, "Alright! Please borrow other books!",
                                            "Reserve failed!",
                                            JOptionPane.ERROR_MESSAGE);
                                    break;
                                }
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "You have reached the maximum of books you can borrow!",
                                        "Borrow failed!", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                        }
                    }

                    break;

                } else if (bookList.get(y) == null && y == bookList.size() - 1) {
                    JOptionPane.showMessageDialog(null, "No information available!\nPlease try again!",
                            "Borrow failed!", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
        }
    }

    public void borrow_book_author(String name, String Account) {
        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the book author!", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            for (int y = 0; y < bookList.size(); y++) {
                if (bookList.get(y) != null && bookList.get(y).getAuthor().equals(name)
                        && bookList.get(y).getStatus().equals("Available")) {
                    ArrayList<Member> memberList = App.getMembers();
                    for (int t = 0; t < memberList.size(); t++) {
                        if (memberList.get(t).getAccount().equals(Account)) {

                            if (memberList.get(t).getBorrow_num() < memberList.get(t).getMax_borrow()) {
                                bookList.get(y).setTotalBorrowNum(bookList.get(y).getTotalBorrowNum() + 1);
                                memberList.get(t).setBorrow_num(memberList.get(t).getBorrow_num() + 1);
                                bookList.get(y).setBorrower(Account);
                                bookList.get(y).setStatus("Unavailable");
                                Mysql.borrowBook(bookList.get(y));
                                bookList.get(y).setBorrow_time(LocalDateTime.now());
                                // bookList.get(y).setReturn_time(memberList.get(t).getDeadlinee());
                                for (int g = 0; g < borrowed_books.length; g++) {
                                    if (borrowed_books[g] == null) {
                                        borrowed_books[g] = bookList.get(y).getName();
                                        break;
                                    }
                                }
                                JOptionPane.showMessageDialog(null,
                                        "Borrow successfully!\nYou have to return the book before "
                                                + bookList.get(y).getReturn_time(memberList.get(t).getDeadlinee()) + " !",
                                        "Borrow successfully!", JOptionPane.INFORMATION_MESSAGE);
                                break;

                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "You have reached the maximum of books you can borrow!",
                                        "Borrow failed!", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                        }
                    }
                    break;
                } else if (bookList.get(y) != null && bookList.get(y).getAuthor().equals(name)
                        && bookList.get(y).getStatus().equals("Unavailable")) {
                    ArrayList<Member> memberList = App.getMembers();
                    for (int h = 0; h < memberList.size(); h++) {
                        String[] abv = { "Yes", "No" };
                        if (memberList.get(h) != null && bookList.get(y).getBorrower() == memberList.get(h).getAccount()) {
                            if (memberList.get(h).getIdentity().equals("Student")) {
                                int yy = JOptionPane.showOptionDialog(null,
                                        "The book is not available!\nReturn date would be "
                                                + bookList.get(y).getReturn_time(10) + " !\nDo you want to reserve it?",
                                        Account, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, abv,
                                        abv[0]);
                                if (yy == 0) {
                                    for(int hj=0 ;hj<memberList.size(); hj++){
                                        if(memberList.get(hj).getAccount().equals(Account)){
                                            memberList.get(hj).setReservee(true);
                                            bookList.get(y).setReserve();
                                             JOptionPane.showMessageDialog(null, "Reserve successfully!",
                                            "Reserve successfully!",
                                            JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                    }
                                } else {
                                    bookList.get(y).setUnReserve();
                                    JOptionPane.showMessageDialog(null, "Alright! Please borrow other books!",
                                            "Reserve failed!",
                                            JOptionPane.ERROR_MESSAGE);
                                    break;
                                }

                            } else if (memberList.get(h).getIdentity().equals("Teacher")) {
                                int yy = JOptionPane.showOptionDialog(null,
                                        "The book is not available!\nReturn date would be "
                                                + bookList.get(y).getReturn_time(12) + " !\nDo you want to reserve it?",
                                        Account, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, abv,
                                        abv[0]);
                                if (yy == 0) {
                                    for(int hj=0 ;hj<memberList.size(); hj++){
                                        if(memberList.get(hj).getAccount().equals(Account)){
                                            memberList.get(hj).setReservee(true);
                                            bookList.get(y).setReserve();
                                             JOptionPane.showMessageDialog(null, "Reserve successfully!",
                                            "Reserve successfully!",
                                            JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                    }
                                } else {
                                    bookList.get(y).setUnReserve();
                                    JOptionPane.showMessageDialog(null, "Alright! Please borrow other books!",
                                            "Reserve failed!",
                                            JOptionPane.ERROR_MESSAGE);
                                    break;
                                }

                            } else if (memberList.get(h).getIdentity().equals("Staff")) {
                                int yy = JOptionPane.showOptionDialog(null,
                                        "The book is not available!\nReturn date would be "
                                                + bookList.get(y).getReturn_time(14) + " !\nDo you want to reserve it?",
                                        Account, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, abv,
                                        abv[0]);
                                if (yy == 0) {
                                    for(int hj=0 ;hj<memberList.size(); hj++){
                                        if(memberList.get(hj).getAccount().equals(Account)){
                                            memberList.get(hj).setReservee(true);
                                            bookList.get(y).setReserve();
                                             JOptionPane.showMessageDialog(null, "Reserve successfully!",
                                            "Reserve successfully!",
                                            JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                    }
                                } else {
                                    bookList.get(y).setUnReserve();
                                    JOptionPane.showMessageDialog(null, "Alright! Please borrow other books!",
                                            "Reserve failed!",
                                            JOptionPane.ERROR_MESSAGE);
                                    break;
                                }
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "You have reached the maximum of books you can borrow!",
                                        "Borrow failed!", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                        }
                    }

                    break;

                } else if (bookList.get(y) == null && y == bookList.size() - 1) {
                    JOptionPane.showMessageDialog(null, "No information available!\nPlease try again!",
                            "Borrow failed!", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
        }
    }

    public void borrow_book_publisher(String name, String Account) {
        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the book publisher!", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            for (int y = 0; y < bookList.size(); y++) {
                if (bookList.get(y) != null && bookList.get(y).getPublisher().equals(name)
                        && bookList.get(y).getStatus().equals("Available")) {
                    ArrayList<Member> memberList = App.getMembers();
                    for (int t = 0; t < memberList.size(); t++) {
                        if (memberList.get(t).getAccount().equals(Account)) {

                            if (memberList.get(t).getBorrow_num() < memberList.get(t).getMax_borrow()) {
                                bookList.get(y).setTotalBorrowNum(bookList.get(y).getTotalBorrowNum() + 1);
                                memberList.get(t).setBorrow_num(memberList.get(t).getBorrow_num() + 1);
                                bookList.get(y).setBorrower(Account);
                                bookList.get(y).setStatus("Unavailable");
                                Mysql.borrowBook(bookList.get(y));
                                bookList.get(y).setBorrow_time(LocalDateTime.now());
                                // bookList.get(y).setReturn_time(memberList.get(t).getDeadlinee());
                                for (int g = 0; g < borrowed_books.length; g++) {
                                    if (borrowed_books[g] == null) {
                                        borrowed_books[g] = bookList.get(y).getName();
                                        break;
                                    }
                                }
                                JOptionPane.showMessageDialog(null,
                                        "Borrow successfully!\nYou have to return the book before "
                                                + bookList.get(y).getReturn_time(memberList.get(t).getDeadlinee()) + " !",
                                        "Borrow successfully!", JOptionPane.INFORMATION_MESSAGE);
                                break;

                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "You have reached the maximum of books you can borrow!",
                                        "Borrow failed!", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                        }
                    }
                    break;
                } else if (bookList.get(y) != null && bookList.get(y).getPublisher().equals(name)
                        && bookList.get(y).getStatus().equals("Unavailable")) {
                    ArrayList<Member> memberList = App.getMembers();
                    for (int h = 0; h < memberList.size(); h++) {
                        String abv[] = { "Yes", "No" };
                        if (memberList.get(h) != null && bookList.get(y).getBorrower() == memberList.get(h).getAccount()) {
                            if (memberList.get(h).getIdentity().equals("Student")) {
                                int yy = JOptionPane.showOptionDialog(null,
                                        "The book is not available!\nReturn date would be "
                                                + bookList.get(y).getReturn_time(10) + " !\nDo you want to reserve it?",
                                        Account, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, abv,
                                        abv[0]);
                                if (yy == 0) {
                                    for(int hj=0 ;hj<memberList.size(); hj++){
                                        if(memberList.get(hj).getAccount().equals(Account)){
                                            memberList.get(hj).setReservee(true);
                                            bookList.get(y).setReserve();
                                             JOptionPane.showMessageDialog(null, "Reserve successfully!",
                                            "Reserve successfully!",
                                            JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                    }
                                } else {
                                    bookList.get(y).setUnReserve();
                                    JOptionPane.showMessageDialog(null, "Alright! Please borrow other books!",
                                            "Reserve failed!",
                                            JOptionPane.ERROR_MESSAGE);
                                    break;
                                }

                            } else if (memberList.get(h).getIdentity().equals("Teacher")) {
                                int yy = JOptionPane.showOptionDialog(null,
                                        "The book is not available!\nReturn date would be "
                                                + bookList.get(y).getReturn_time(12) + " !\nDo you want to reserve it?",
                                        Account, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, abv,
                                        abv[0]);
                                if (yy == 0) {
                                    for(int hj=0 ;hj<memberList.size(); hj++){
                                        if(memberList.get(hj).getAccount().equals(Account)){
                                            memberList.get(hj).setReservee(true);
                                            bookList.get(y).setReserve();
                                             JOptionPane.showMessageDialog(null, "Reserve successfully!",
                                            "Reserve successfully!",
                                            JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                    }
                                } else {
                                    bookList.get(y).setUnReserve();
                                    JOptionPane.showMessageDialog(null, "Alright! Please borrow other books!",
                                            "Reserve failed!",
                                            JOptionPane.ERROR_MESSAGE);
                                    break;
                                }

                            } else if (memberList.get(h).getIdentity().equals("Staff")) {
                                int yy = JOptionPane.showOptionDialog(null,
                                        "The book is not available!\nReturn date would be "
                                                + bookList.get(y).getReturn_time(14) + " !\nDo you want to reserve it?",
                                        Account, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, abv,
                                        abv[0]);
                                if (yy == 0) {
                                    for(int hj=0 ;hj<memberList.size(); hj++){
                                        if(memberList.get(hj).getAccount().equals(Account)){
                                            memberList.get(hj).setReservee(true);
                                            bookList.get(y).setReserve();
                                             JOptionPane.showMessageDialog(null, "Reserve successfully!",
                                            "Reserve successfully!",
                                            JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                    }
                                } else {
                                    bookList.get(y).setUnReserve();
                                    JOptionPane.showMessageDialog(null, "Alright! Please borrow other books!",
                                            "Reserve failed!",
                                            JOptionPane.ERROR_MESSAGE);
                                    break;
                                }
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "You have reached the maximum of books you can borrow!",
                                        "Borrow failed!", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                        }
                    }

                    break;

                } else if (bookList.get(y) == null && y == bookList.size() - 1) {
                    JOptionPane.showMessageDialog(null, "No information available!\nPlease try again!",
                            "Borrow failed!", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
        }
    }

    public void return_book(String name2, String account) {
        ArrayList<Member> memberList = App.getMembers();
        Member currentUser = App.getLoginMember();
        // find the book's index
        int bookIndex = -1;
        int userIndex = -1;
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i) != null && bookList.get(i).getStatus().equals("Unavailable")
                    && bookList.get(i).getName().equals(name2)) {
                bookIndex = i;
                break;
            }
        }
        for(int t=0; t<memberList.size(); t++){
            if(memberList.get(t).getAccount() == currentUser.getAccount()){
                userIndex = t;
                break;
            }
        }
        if(bookIndex == -1){
            JOptionPane.showMessageDialog(null, "No such book!", "Return failed!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(bookList.get(bookIndex).getBorrower() != account){
            JOptionPane.showMessageDialog(null, "You are not the borrower of this book!", "Return failed!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        memberList.get(userIndex).setHistory(bookList.get(bookIndex).getName());
        if(currentUser.getIdentity() == "Student"){
            // TODO: use SQL to manage the record?
            // find member in the memberList
            for (int h = 0; h < borrowed_books.length; h++) {
                if (borrowed_books[h] == bookList.get(bookIndex).getName()) {
                    borrowed_books[h] = null;
                    break;
                }
            }
            if(bookList.get(bookIndex).getReturn_date(10).isBefore(LocalDateTime.now())){
                memberList.get(userIndex).setTotalFine(memberList.get(userIndex).getTotalFine() + 100);
                String abf[] = { "Already", "Not yet" };
                int ghg = JOptionPane.showOptionDialog(null,
                        "The book is overdue!\nHave you paid the fine?", "Overdue",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, abf, abf[0]);
                if (ghg == 0) {
                    JOptionPane.showMessageDialog(null,
                            "Return successfully!\nYou have paid already!",
                            "Return successfully!", JOptionPane.INFORMATION_MESSAGE);
                } else if (ghg == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Please transfer the money into the following bank account!\nAccount Number: 004-12345677654321",
                            "Please pay the fine!", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Return successfully!\nThere is no fine to pay.",
                        "Return successfully!", JOptionPane.INFORMATION_MESSAGE);
            }
            
            memberList.get(userIndex).setBorrow_num(memberList.get(userIndex).getBorrow_num() - 1);
            if (memberList.get(userIndex).getBorrow_num() < 0) {
                memberList.get(userIndex).setBorrow_num(0);
                JOptionPane.showMessageDialog(null,
                        "You still have " + memberList.get(userIndex).getBorrow_num()
                                + " book (s) to return!");
            } else {
                JOptionPane.showMessageDialog(null,
                        "You still have " + memberList.get(userIndex).getBorrow_num()
                                + " book (s) to return!");
            }
        }
        else if(currentUser.getIdentity() == "Teacher"){
            for (int h = 0; h < borrowed_books.length; h++) {
                if (borrowed_books[h] == bookList.get(bookIndex).getName()) {
                    borrowed_books[h] = null;
                    break;
                }
            }
            if(bookList.get(bookIndex).getReturn_date(12).isBefore(LocalDateTime.now())){
                memberList.get(userIndex).setTotalFine(memberList.get(userIndex).getTotalFine() + 100);
                String abf[] = { "Already", "Not yet" };
                int ghg = JOptionPane.showOptionDialog(null,
                        "The book is overdue!\nHave you paid the fine?", "Overdue",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, abf, abf[0]);
                if (ghg == 0) {
                    JOptionPane.showMessageDialog(null,
                            "Return successfully!\nYou have paid already!",
                            "Return successfully!", JOptionPane.INFORMATION_MESSAGE);
                } else if (ghg == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Please transfer the money into the following bank account!\nAccount Number: 004-12345677654321",
                            "Please pay the fine!", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Return successfully!\nThere is no fine to pay.",
                        "Return successfully!", JOptionPane.INFORMATION_MESSAGE);
            }
            
            memberList.get(userIndex).setBorrow_num(memberList.get(userIndex).getBorrow_num() - 1);
            if (memberList.get(userIndex).getBorrow_num() < 0) {
                memberList.get(userIndex).setBorrow_num(0);
                JOptionPane.showMessageDialog(null,
                        "You still have " + memberList.get(userIndex).getBorrow_num()
                                + " book (s) to return!");
            } else {
                JOptionPane.showMessageDialog(null,
                        "You still have " + memberList.get(userIndex).getBorrow_num()
                                + " book (s) to return!");
            }
        }
        else if(currentUser.getIdentity() == "Staff"){
            for (int h = 0; h < borrowed_books.length; h++) {
                if (borrowed_books[h] == bookList.get(bookIndex).getName()) {
                    borrowed_books[h] = null;
                    break;
                }
            }
            if(bookList.get(bookIndex).getReturn_date(14).isBefore(LocalDateTime.now())){
                memberList.get(userIndex).setTotalFine(memberList.get(userIndex).getTotalFine() + 100);
                String abf[] = { "Already", "Not yet" };
                int ghg = JOptionPane.showOptionDialog(null,
                        "The book is overdue!\nHave you paid the fine?", "Overdue",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, abf, abf[0]);
                if (ghg == 0) {
                    JOptionPane.showMessageDialog(null,
                            "Return successfully!\nYou have paid already!",
                            "Return successfully!", JOptionPane.INFORMATION_MESSAGE);
                } else if (ghg == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Please transfer the money into the following bank account!\nAccount Number: 004-12345677654321",
                            "Please pay the fine!", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Return successfully!\nThere is no fine to pay.",
                        "Return successfully!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (bookList.get(bookIndex) != null && bookList.get(bookIndex).getStatus().equals("Available")
                && bookList.get(bookIndex).getName().equals(name2)) {
            JOptionPane.showMessageDialog(null, "This book is not borrowed yet!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        if (bookList.get(bookIndex) == null && bookIndex == bookList.size() - 1) {
            JOptionPane.showMessageDialog(null, "This book doesn't exist!\nPlease try again!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        bookList.get(bookIndex).setBorrower("");
        bookList.get(bookIndex).setStatus("Available");
        Mysql.returnBook(bookList.get(bookIndex));

    }
    public int getBill(){
        // check the member's borrowed books and calculate the total fine
        bookList = App.getBooks();
        
        int TotalFine = 0;
        for(int i=0; i<bookList.size(); i++){
            if(bookList.get(i).getBorrower() == App.getLoginMember().getName()){
                if(identity.equals("Student")){
                    if(bookList.get(i).getReturn_date(10).isBefore(LocalDateTime.now())){
                        TotalFine += 100;
                    }
                }else if(identity.equals("Teacher")){
                    if(bookList.get(i).getReturn_date(12).isBefore(LocalDateTime.now())){
                        TotalFine += 150;
                    }
                }else if(identity.equals("Staff")){
                    if(bookList.get(i).getReturn_date(14).isBefore(LocalDateTime.now())){
                        TotalFine += 200;
                    }
                }
            }
        }
        return TotalFine;
    }

    
}