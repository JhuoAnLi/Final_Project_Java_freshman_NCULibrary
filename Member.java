import java.time.*;
import java.time.chrono.ChronoLocalDate;
import javax.swing.*;

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

    protected String borrowed_books[] = new String[50];
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    java.net.URL resourcer = classLoader.getResource("resources/" + "Personal_information.png");
    ImageIcon Personal_informationn = new ImageIcon(resourcer);

    java.net.URL resourcerr = classLoader.getResource("resources/" + "Money.png");
    ImageIcon Moneyy = new ImageIcon(resourcerr);

    java.net.URL resourcerrr = classLoader.getResource("resources/" + "Code.png");
    ImageIcon Codee = new ImageIcon(resourcerrr);

    Admin admin = new Admin("Admin", "Admin", "Admin");
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

    public void borrow_book(String name, String Account) {
        if (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the book name!", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            for (int y = 0; y < Admin.books.length; y++) {
                if (Admin.books[y] != null && Admin.books[y].getName().equals(name)
                        && Admin.books[y].getStatus().equals("Available")) {

                    for (int t = 0; t < App.members.length; t++) {
                        if (App.members[t].getAccount().equals(Account)) {

                            if (App.members[t].getBorrow_num() < App.members[t].getMax_borrow()) {
                                App.members[t].setBorrow_num(App.members[t].getBorrow_num() + 1);
                                Admin.books[y].setTotalBorrowNum(Admin.books[y].getTotalBorrowNum() + 1);
                                Admin.books[y].setBorrower(Account);
                                Admin.books[y].setStatus("Unavailable");
                                Admin.books[y].setBorrow_time(LocalDateTime.now());
                                // Admin.books[y].setReturn_time(App.members[t].getDeadlinee());
                                for (int g = 0; g < borrowed_books.length; g++) {
                                    if (borrowed_books[g] == null) {
                                        borrowed_books[g] = Admin.books[y].getName();
                                        break;
                                    }
                                }
                                JOptionPane.showMessageDialog(null,
                                        "Borrow successfully!\nYou have to return the book before "
                                                + Admin.books[y].getReturn_time(App.members[t].getDeadlinee()) + " !",
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
                } else if (Admin.books[y] != null && Admin.books[y].getName().equals(name)
                        && Admin.books[y].getStatus().equals("Unavailable")) {
                    for (int h = 0; h < App.members.length; h++) {
                        String abv[] = { "Yes", "No" };
                        if (App.members[h] != null && Admin.books[y].getBorrower() == App.members[h].getAccount()) {
                            if (App.members[h].getIdentity().equals("Student")) {
                                int yy = JOptionPane.showOptionDialog(null,
                                        "The book is not available!\nReturn date would be "
                                                + Admin.books[y].getReturn_time(10) + " !\nDo you want to reserve it?",
                                        Account, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, abv,
                                        abv[0]);
                                if (yy == 0) {
                                    for (int hj = 0; hj < App.members.length; hj++) {
                                        if (App.members[hj].getAccount().equals(Account)) {
                                            App.members[hj].setReservee(true);
                                            Admin.books[y].setReserve();
                                            JOptionPane.showMessageDialog(null, "Reserve successfully!",
                                                    "Reserve successfully!",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                    }

                                } else {
                                    Admin.books[y].setUnReserve();
                                    JOptionPane.showMessageDialog(null, "Alright! Please borrow other books!",
                                            "Reserve failed!",
                                            JOptionPane.ERROR_MESSAGE);
                                    break;
                                }

                            } else if (App.members[h].getIdentity().equals("Teacher")) {
                                int yy = JOptionPane.showOptionDialog(null,
                                        "The book is not available!\nReturn date would be "
                                                + Admin.books[y].getReturn_time(12) + " !\nDo you want to reserve it?",
                                        Account, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, abv,
                                        abv[0]);
                                if (yy == 0) {
                                    for (int hj = 0; hj < App.members.length; hj++) {
                                        if (App.members[hj].getAccount().equals(Account)) {
                                            App.members[hj].setReservee(true);
                                            Admin.books[y].setReserve();
                                            JOptionPane.showMessageDialog(null, "Reserve successfully!",
                                                    "Reserve successfully!",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                    }
                                } else {
                                    Admin.books[y].setUnReserve();
                                    JOptionPane.showMessageDialog(null, "Alright! Please borrow other books!",
                                            "Reserve failed!",
                                            JOptionPane.ERROR_MESSAGE);
                                    break;
                                }

                            } else if (App.members[h].getIdentity().equals("Staff")) {
                                int yy = JOptionPane.showOptionDialog(null,
                                        "The book is not available!\nReturn date would be "
                                                + Admin.books[y].getReturn_time(14) + " !\nDo you want to reserve it?",
                                        Account, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, abv,
                                        abv[0]);
                                if (yy == 0) {
                                    for(int hj=0 ;hj<App.members.length; hj++){
                                        if(App.members[hj].getAccount().equals(Account)){
                                            App.members[hj].setReservee(true);
                                            Admin.books[y].setReserve();
                                             JOptionPane.showMessageDialog(null, "Reserve successfully!",
                                            "Reserve successfully!",
                                            JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                    }
                                } else {
                                    Admin.books[y].setUnReserve();
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

                } else if (Admin.books[y] == null && y == Admin.books.length - 1) {
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

            for (int y = 0; y < Admin.books.length; y++) {
                if (Admin.books[y] != null && Admin.books[y].getAuthor().equals(name)
                        && Admin.books[y].getStatus().equals("Available")) {

                    for (int t = 0; t < App.members.length; t++) {
                        if (App.members[t].getAccount().equals(Account)) {

                            if (App.members[t].getBorrow_num() < App.members[t].getMax_borrow()) {
                                Admin.books[y].setTotalBorrowNum(Admin.books[y].getTotalBorrowNum() + 1);
                                App.members[t].setBorrow_num(App.members[t].getBorrow_num() + 1);
                                Admin.books[y].setBorrower(Account);
                                Admin.books[y].setStatus("Unavailable");
                                Admin.books[y].setBorrow_time(LocalDateTime.now());
                                // Admin.books[y].setReturn_time(App.members[t].getDeadlinee());
                                for (int g = 0; g < borrowed_books.length; g++) {
                                    if (borrowed_books[g] == null) {
                                        borrowed_books[g] = Admin.books[y].getName();
                                        break;
                                    }
                                }
                                JOptionPane.showMessageDialog(null,
                                        "Borrow successfully!\nYou have to return the book before "
                                                + Admin.books[y].getReturn_time(App.members[t].getDeadlinee()) + " !",
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
                } else if (Admin.books[y] != null && Admin.books[y].getAuthor().equals(name)
                        && Admin.books[y].getStatus().equals("Unavailable")) {
                    for (int h = 0; h < App.members.length; h++) {
                        String[] abv = { "Yes", "No" };
                        if (App.members[h] != null && Admin.books[y].getBorrower() == App.members[h].getAccount()) {
                            if (App.members[h].getIdentity().equals("Student")) {
                                int yy = JOptionPane.showOptionDialog(null,
                                        "The book is not available!\nReturn date would be "
                                                + Admin.books[y].getReturn_time(10) + " !\nDo you want to reserve it?",
                                        Account, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, abv,
                                        abv[0]);
                                if (yy == 0) {
                                    for(int hj=0 ;hj<App.members.length; hj++){
                                        if(App.members[hj].getAccount().equals(Account)){
                                            App.members[hj].setReservee(true);
                                            Admin.books[y].setReserve();
                                             JOptionPane.showMessageDialog(null, "Reserve successfully!",
                                            "Reserve successfully!",
                                            JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                    }
                                } else {
                                    Admin.books[y].setUnReserve();
                                    JOptionPane.showMessageDialog(null, "Alright! Please borrow other books!",
                                            "Reserve failed!",
                                            JOptionPane.ERROR_MESSAGE);
                                    break;
                                }

                            } else if (App.members[h].getIdentity().equals("Teacher")) {
                                int yy = JOptionPane.showOptionDialog(null,
                                        "The book is not available!\nReturn date would be "
                                                + Admin.books[y].getReturn_time(12) + " !\nDo you want to reserve it?",
                                        Account, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, abv,
                                        abv[0]);
                                if (yy == 0) {
                                    for(int hj=0 ;hj<App.members.length; hj++){
                                        if(App.members[hj].getAccount().equals(Account)){
                                            App.members[hj].setReservee(true);
                                            Admin.books[y].setReserve();
                                             JOptionPane.showMessageDialog(null, "Reserve successfully!",
                                            "Reserve successfully!",
                                            JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                    }
                                } else {
                                    Admin.books[y].setUnReserve();
                                    JOptionPane.showMessageDialog(null, "Alright! Please borrow other books!",
                                            "Reserve failed!",
                                            JOptionPane.ERROR_MESSAGE);
                                    break;
                                }

                            } else if (App.members[h].getIdentity().equals("Staff")) {
                                int yy = JOptionPane.showOptionDialog(null,
                                        "The book is not available!\nReturn date would be "
                                                + Admin.books[y].getReturn_time(14) + " !\nDo you want to reserve it?",
                                        Account, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, abv,
                                        abv[0]);
                                if (yy == 0) {
                                    for(int hj=0 ;hj<App.members.length; hj++){
                                        if(App.members[hj].getAccount().equals(Account)){
                                            App.members[hj].setReservee(true);
                                            Admin.books[y].setReserve();
                                             JOptionPane.showMessageDialog(null, "Reserve successfully!",
                                            "Reserve successfully!",
                                            JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                    }
                                } else {
                                    Admin.books[y].setUnReserve();
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

                } else if (Admin.books[y] == null && y == Admin.books.length - 1) {
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

            for (int y = 0; y < Admin.books.length; y++) {
                if (Admin.books[y] != null && Admin.books[y].getPublisher().equals(name)
                        && Admin.books[y].getStatus().equals("Available")) {

                    for (int t = 0; t < App.members.length; t++) {
                        if (App.members[t].getAccount().equals(Account)) {

                            if (App.members[t].getBorrow_num() < App.members[t].getMax_borrow()) {
                                Admin.books[y].setTotalBorrowNum(Admin.books[y].getTotalBorrowNum() + 1);
                                App.members[t].setBorrow_num(App.members[t].getBorrow_num() + 1);
                                Admin.books[y].setBorrower(Account);
                                Admin.books[y].setStatus("Unavailable");
                                Admin.books[y].setBorrow_time(LocalDateTime.now());
                                // Admin.books[y].setReturn_time(App.members[t].getDeadlinee());
                                for (int g = 0; g < borrowed_books.length; g++) {
                                    if (borrowed_books[g] == null) {
                                        borrowed_books[g] = Admin.books[y].getName();
                                        break;
                                    }
                                }
                                JOptionPane.showMessageDialog(null,
                                        "Borrow successfully!\nYou have to return the book before "
                                                + Admin.books[y].getReturn_time(App.members[t].getDeadlinee()) + " !",
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
                } else if (Admin.books[y] != null && Admin.books[y].getPublisher().equals(name)
                        && Admin.books[y].getStatus().equals("Unavailable")) {
                    for (int h = 0; h < App.members.length; h++) {
                        String abv[] = { "Yes", "No" };
                        if (App.members[h] != null && Admin.books[y].getBorrower() == App.members[h].getAccount()) {
                            if (App.members[h].getIdentity().equals("Student")) {
                                int yy = JOptionPane.showOptionDialog(null,
                                        "The book is not available!\nReturn date would be "
                                                + Admin.books[y].getReturn_time(10) + " !\nDo you want to reserve it?",
                                        Account, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, abv,
                                        abv[0]);
                                if (yy == 0) {
                                    for(int hj=0 ;hj<App.members.length; hj++){
                                        if(App.members[hj].getAccount().equals(Account)){
                                            App.members[hj].setReservee(true);
                                            Admin.books[y].setReserve();
                                             JOptionPane.showMessageDialog(null, "Reserve successfully!",
                                            "Reserve successfully!",
                                            JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                    }
                                } else {
                                    Admin.books[y].setUnReserve();
                                    JOptionPane.showMessageDialog(null, "Alright! Please borrow other books!",
                                            "Reserve failed!",
                                            JOptionPane.ERROR_MESSAGE);
                                    break;
                                }

                            } else if (App.members[h].getIdentity().equals("Teacher")) {
                                int yy = JOptionPane.showOptionDialog(null,
                                        "The book is not available!\nReturn date would be "
                                                + Admin.books[y].getReturn_time(12) + " !\nDo you want to reserve it?",
                                        Account, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, abv,
                                        abv[0]);
                                if (yy == 0) {
                                    for(int hj=0 ;hj<App.members.length; hj++){
                                        if(App.members[hj].getAccount().equals(Account)){
                                            App.members[hj].setReservee(true);
                                            Admin.books[y].setReserve();
                                             JOptionPane.showMessageDialog(null, "Reserve successfully!",
                                            "Reserve successfully!",
                                            JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                    }
                                } else {
                                    Admin.books[y].setUnReserve();
                                    JOptionPane.showMessageDialog(null, "Alright! Please borrow other books!",
                                            "Reserve failed!",
                                            JOptionPane.ERROR_MESSAGE);
                                    break;
                                }

                            } else if (App.members[h].getIdentity().equals("Staff")) {
                                int yy = JOptionPane.showOptionDialog(null,
                                        "The book is not available!\nReturn date would be "
                                                + Admin.books[y].getReturn_time(14) + " !\nDo you want to reserve it?",
                                        Account, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, abv,
                                        abv[0]);
                                if (yy == 0) {
                                    for(int hj=0 ;hj<App.members.length; hj++){
                                        if(App.members[hj].getAccount().equals(Account)){
                                            App.members[hj].setReservee(true);
                                            Admin.books[y].setReserve();
                                             JOptionPane.showMessageDialog(null, "Reserve successfully!",
                                            "Reserve successfully!",
                                            JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                    }
                                } else {
                                    Admin.books[y].setUnReserve();
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

                } else if (Admin.books[y] == null && y == Admin.books.length - 1) {
                    JOptionPane.showMessageDialog(null, "No information available!\nPlease try again!",
                            "Borrow failed!", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
        }
    }

    public void return_book(String name2, String account) {

        for (int i = 0; i < Admin.books.length; i++) {
            if (Admin.books[i] != null && Admin.books[i].getStatus().equals("Unavailable")
                    && Admin.books[i].getName().equals(name2)) {
                if (!Admin.books[i].getBorrower().equals(account)) {
                    JOptionPane.showMessageDialog(null, "You are not the borrower of this book!",
                            "Return failed!", JOptionPane.ERROR_MESSAGE);
                    break;
                } else {
                    Admin.books[i].setStatus("Available");
                    Admin.books[i].setBorrower("No one");

                    for (int t = 0; t < App.members.length; t++) {

                        if (Admin.books[i] != null && App.members[t].getIdentity() == "Student"
                                && App.members[t].getAccount().equals(account)) {
                            App.members[t].setHistory(Admin.books[i].getName());
                            for (int h = 0; h < borrowed_books.length; h++) {
                                if (borrowed_books[h] == Admin.books[i].getName()) {
                                    borrowed_books[h] = null;
                                    break;
                                }
                            }

                            if (Admin.books[i].getReturn_date(10).isBefore(LocalDateTime.now())) {
                                App.members[t].setTotalFine(App.members[t].getTotalFine() + 100);
                                String abf[] = { "Already", "Not yet" };
                                int ghg = JOptionPane.showOptionDialog(null,
                                        "The book is overdue!\nHave you paid the fine?", "Overdue",
                                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, Moneyy, abf, abf[0]);
                                if (ghg == 0) {
                                    JOptionPane.showMessageDialog(null,
                                            "Return successfully!\nYou have paid already!",
                                            "Return successfully!", JOptionPane.INFORMATION_MESSAGE);
                                } else if (ghg == 1) {
                                    JOptionPane.showMessageDialog(null,
                                            "Please transfer the money into the following bank account!\nAccount Number: 004-12345677654321",
                                            "Please pay the fine!", JOptionPane.INFORMATION_MESSAGE, Codee);
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Return successfully!\nThere is no fine to pay.",
                                        "Return successfully!", JOptionPane.INFORMATION_MESSAGE);
                            }
                            if (App.members[t].getAccount().equals(account)) {
                                App.members[t].setBorrow_num(App.members[t].getBorrow_num() - 1);

                                if (App.members[t].getBorrow_num() < 0) {
                                    App.members[t].setBorrow_num(0);
                                    JOptionPane.showMessageDialog(null,
                                            "You still have " + App.members[t].getBorrow_num()
                                                    + " book (s) to return!");
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "You still have " + App.members[t].getBorrow_num()
                                                    + " book (s) to return!");
                                }
                            }

                            break;
                        }
                        if (Admin.books[i] != null && App.members[t].getIdentity() == "Teacher"
                                && App.members[t].getAccount().equals(account)) {
                            App.members[t].setHistory(Admin.books[i].getName());
                            for (int h = 0; h < borrowed_books.length; h++) {
                                if (borrowed_books[h] == Admin.books[i].getName()) {
                                    borrowed_books[h] = null;
                                    break;
                                }
                            }

                            if (Admin.books[i].getReturn_date(12).isBefore(LocalDateTime.now())) {
                                App.members[t].setTotalFine(App.members[t].getTotalFine() + 150);
                                String abf[] = { "Already", "Not yet" };
                                int ghg = JOptionPane.showOptionDialog(null,
                                        "The book is overdue!\nHave you paid the fine?", "Overdue",
                                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, Moneyy, abf, abf[0]);
                                if (ghg == 0) {
                                    JOptionPane.showMessageDialog(null,
                                            "Return successfully!\nYou have paid already!",
                                            "Return successfully!", JOptionPane.INFORMATION_MESSAGE);
                                } else if (ghg == 1) {
                                    JOptionPane.showMessageDialog(null,
                                            "Please transfer the money into the following bank account!\nAccount Number: 004-12345677654321",
                                            "Please pay the fine!", JOptionPane.INFORMATION_MESSAGE, Codee);
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Return successfully!\nThere is no fine to pay.",
                                        "Return successfully!", JOptionPane.INFORMATION_MESSAGE);
                            }
                            if (App.members[t].getAccount().equals(account)) {
                                App.members[t].setBorrow_num(App.members[t].getBorrow_num() - 1);

                                if (App.members[t].getBorrow_num() < 0 && Admin.books[i] != null) {
                                    App.members[t].setBorrow_num(0);
                                    JOptionPane.showMessageDialog(null,
                                            "You still have " + App.members[t].getBorrow_num()
                                                    + " book (s) to return!");
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "You still have " + App.members[t].getBorrow_num()
                                                    + " book (s) to return!");
                                }
                            }
                            break;
                        }
                        if (Admin.books[i] != null && App.members[t].getIdentity() == "Staff"
                                && App.members[t].getAccount().equals(account)) {
                            App.members[t].setHistory(Admin.books[i].getName());
                            for (int h = 0; h < borrowed_books.length; h++) {
                                if (borrowed_books[h] == Admin.books[i].getName()) {
                                    borrowed_books[h] = null;
                                    break;
                                }
                            }

                            if (Admin.books[i].getReturn_date(14).isBefore(LocalDateTime.now())) {
                                App.members[t].setTotalFine(App.members[t].getTotalFine() + 200);
                                String abf[] = { "Already", "Not yet" };
                                int ghg = JOptionPane.showOptionDialog(null,
                                        "The book is overdue!\nHave you paid the fine?", "Overdue",
                                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, Moneyy, abf, abf[0]);
                                if (ghg == 0) {
                                    JOptionPane.showMessageDialog(null,
                                            "Return successfully!\nYou have paid already!",
                                            "Return successfully!", JOptionPane.INFORMATION_MESSAGE);
                                } else if (ghg == 1) {
                                    JOptionPane.showMessageDialog(null,
                                            "Please transfer the money into the following bank account!\nAccount Number: 004-12345677654321",
                                            "Please pay the fine!", JOptionPane.INFORMATION_MESSAGE, Codee);
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Return successfully!\nThere is no fine to pay.",
                                        "Return successfully!", JOptionPane.INFORMATION_MESSAGE);
                            }
                            if (App.members[t].getAccount().equals(account)) {
                                App.members[t].setBorrow_num(App.members[t].getBorrow_num() - 1);

                                if (App.members[t].getBorrow_num() < 0) {
                                    App.members[t].setBorrow_num(0);
                                    JOptionPane.showMessageDialog(null,
                                            "You still have " + App.members[t].getBorrow_num()
                                                    + " book (s) to return!");
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "You still have " + App.members[t].getBorrow_num()
                                                    + " book (s) to return!");
                                }
                            }
                            break;
                        }

                    }
                    break;
                }
            }
            if (Admin.books[i] != null && Admin.books[i].getStatus().equals("Available")
                    && Admin.books[i].getName().equals(name2)) {
                JOptionPane.showMessageDialog(null, "This book is not borrowed yet!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                break;
            }
            if (Admin.books[i] == null && i == Admin.books.length - 1) {
                JOptionPane.showMessageDialog(null, "This book doesn't exist!\nPlease try again!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                break;
            }

        }

    }

    public void personal_information(String name) {
        String g[] = { "Books", "Modify", "Exit" };
        String gg[] = { "Name", "Identity", "Password", "Exit" };
        String e[] = { "Student", "Teacher", "Staff" };
        String ff = "";

        for (int i = 0; i < borrowed_books.length; i++) {
            for (int j = 0; j < Admin.books.length; j++) {
                for (int k = 0; k < App.members.length; k++) {

                    if (borrowed_books[i] != null && Admin.books[j] != null
                            && borrowed_books[i] == Admin.books[j].getName()) {
                        if (App.members[k] != null && App.members[k].getName().equals(name)) {

                            if (App.members[k] != null && App.members[k].getIdentity().equals("Student")) {
                                ff += borrowed_books[i] + "  "
                                        + (Admin.books[j].getReturn_date(10).isBefore(LocalDateTime.now())
                                                ? "[Overdue] (Pay $100)\n"
                                                : "\n")
                                        + " ( " + Admin.books[j].getBorrow_time() + " ~ " + "\n"
                                        + Admin.books[j].getReturn_time(10) + " )\n";

                                break;
                            } else if (App.members[k] != null && App.members[k].getIdentity().equals("Teacher")) {
                                ff += borrowed_books[i] + "  "
                                        + (Admin.books[j].getReturn_date(12).isBefore(LocalDateTime.now())
                                                ? "[Overdue] (Pay $150)\n"
                                                : "\n")
                                        + " ( " + Admin.books[j].getBorrow_time() + " ~ " + "\n"
                                        + Admin.books[j].getReturn_time(12) + " )\n";
                                break;
                            } else if (App.members[k] != null && App.members[k].getIdentity().equals("Staff")) {
                                ff += borrowed_books[i] + "  "
                                        + (Admin.books[j].getReturn_date(14).isBefore(LocalDateTime.now())
                                                ? "[Overdue] (Pay $200)\n"
                                                : "\n")
                                        + " ( " + Admin.books[j].getBorrow_time() + " ~ " + "\n"
                                        + Admin.books[j].getReturn_time(14) + " )\n";

                                break;
                            }

                        }
                    }
                }
            }

        }

        for (int i = 0; i < App.members.length; i++) {
            if (App.members[i] != null && App.members[i].getName().equals(name)) {
                int choice = JOptionPane.showOptionDialog(null,
                        "Name: " + App.members[i].getName() + "\n" + "Identity: " + App.members[i].getIdentity() + "\n"
                                + "Account: " + App.members[i].getAccount() + "\n" + "Password: "
                                + App.members[i].getPassword() + "\n",
                        "Personal information", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                        Personal_informationn, g, g[0]);
                if (choice == 1) {
                    String choice_1 = (String) JOptionPane.showInputDialog(null,
                            "Please choose what you want to modify XD :", "Modifying", JOptionPane.QUESTION_MESSAGE,
                            null, gg, gg[0]);
                    if (choice_1.equals("Name")) {
                        String name_1 = JOptionPane.showInputDialog(null,
                                "Please enter your new name (No empty input) : ", "Modifying",
                                JOptionPane.QUESTION_MESSAGE);
                        if (name_1.equals("") || name_1.equals(" ")) {
                            JOptionPane.showMessageDialog(null, "No empty input!");

                        } else {
                            App.members[i].setName(name_1);
                            JOptionPane.showMessageDialog(null, "Modify successfully!");
                        }

                    } else if (choice_1.equals("Identity")) {
                        int identity_1 = JOptionPane.showOptionDialog(null, "Please enter your new identity!",
                                "Modifying", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, e,
                                e[0]);
                        if (identity_1 == 0) {
                            App.members[i].setIdentity("Student");
                        } else if (identity_1 == 1) {
                            App.members[i].setIdentity("Teacher");
                        } else {
                            App.members[i].setIdentity("Staff");
                        }
                        JOptionPane.showMessageDialog(null, "Modify successfully!");

                    } else if (choice_1.equals("Password")) {
                        String password_1 = JOptionPane.showInputDialog(null,
                                "Please enter your new password (No empty input) : ", "Modifying",
                                JOptionPane.QUESTION_MESSAGE);
                        if (password_1.equals("") || password_1.equals(" ")) {
                            JOptionPane.showMessageDialog(null, "No empty input!");
                        } else {
                            App.members[i].setPassword(password_1);
                            JOptionPane.showMessageDialog(null, "Modify successfully!");

                        }

                    } else if (choice_1.equals("Exit")) {
                        break;
                    }
                } else if (choice == 0) {
                    JOptionPane.showMessageDialog(null, "Borrowed_book(s): "
                            + App.members[i].getBorrow_num() + "\nThe name of borrowed books:\n" + ff
                            + "History: " + App.members[i].getHistory() + "\n" + "Total paid fine: "
                            + App.members[i].getTotalFine() + "\n");
                } else {
                    break;
                }

            }
        }
    }
}