import java.io.IOException;

import javax.swing.*;

public class App {
    public static Member[] members = new Member[500];

    public static void main(String[] args) throws IOException {

        Admin admin = new Admin("Admin", "Admin", "Admin");
        String gg = "";
        String register_identity = "";
        int searchTimes1 = 0;
        int afr = 1;
        int afrr = 1;
        int afrrr = 1;
        int haha = 1;
        String register_password = "";
        String register_account = "";
        String register_name = "";
        String register_age;
        String account;
        String password;
        ImageIcon[] array_icon = new ImageIcon[60];
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        java.net.URL resource = classLoader.getResource("bukubook3.png");
        ImageIcon icon1 = new ImageIcon(resource);
        java.net.URL resource2 = classLoader.getResource("Add_books.png");
        ImageIcon Add_bookss = new ImageIcon(resource2);
        java.net.URL resource3 = classLoader.getResource("Admin.png");
        ImageIcon Adminn = new ImageIcon(resource3);
        java.net.URL resource4 = classLoader.getResource("author.png");
        ImageIcon Authorr = new ImageIcon(resource4);
        java.net.URL resource5 = classLoader.getResource("Borrow_books.png");
        ImageIcon Borrow_bookss = new ImageIcon(resource5);
        java.net.URL resource6 = classLoader.getResource("Check_members.png");
        ImageIcon Check_memberss = new ImageIcon(resource6);
        java.net.URL resource7 = classLoader.getResource("Delete_books.png");
        ImageIcon Delete_bookss = new ImageIcon(resource7);
        java.net.URL resource8 = classLoader.getResource("isbn.png");
        ImageIcon Isbnn = new ImageIcon(resource8);
        java.net.URL resource9 = classLoader.getResource("login.png");
        ImageIcon Loginn = new ImageIcon(resource9);
        java.net.URL resource10 = classLoader.getResource("name.png");
        ImageIcon Namee = new ImageIcon(resource10);
        java.net.URL resource11 = classLoader.getResource("search.png");
        ImageIcon Searchh = new ImageIcon(resource11);
        java.net.URL resource12 = classLoader.getResource("Search_times.png");
        ImageIcon Search_timess = new ImageIcon(resource12);
        java.net.URL resource13 = classLoader.getResource("Return_books.png");
        ImageIcon Return_bookss = new ImageIcon(resource13);
        java.net.URL resource14 = classLoader.getResource("register.png");
        ImageIcon Registerr = new ImageIcon(resource14);
        java.net.URL resource15 = classLoader.getResource("publisher.png");
        ImageIcon Publisherr = new ImageIcon(resource15);
        java.net.URL resource16 = classLoader.getResource("Staff.png");
        ImageIcon Stafff = new ImageIcon(resource16);
        java.net.URL resource17 = classLoader.getResource("status.png");
        ImageIcon Statuss = new ImageIcon(resource17);
        java.net.URL resource18 = classLoader.getResource("Student.png");
        ImageIcon Studentt = new ImageIcon(resource18);
        java.net.URL resource19 = classLoader.getResource("Teacher.png");
        ImageIcon Teacherr = new ImageIcon(resource19);
        java.net.URL resource20 = classLoader.getResource("Update_books.png");
        ImageIcon Update_bookss = new ImageIcon(resource20);
        java.net.URL resource21 = classLoader.getResource("Help.png");
        ImageIcon Helpp = new ImageIcon(resource21);
        java.net.URL resource22 = classLoader.getResource("Selfie.png");
        ImageIcon Selfiee = new ImageIcon(resource22);
        java.net.URL resource23 = classLoader.getResource("Category.png");
        ImageIcon Categoryy = new ImageIcon(resource23);
        java.net.URL resource24 = classLoader.getResource("Java.png");
        array_icon[0] = new ImageIcon(resource24);
        java.net.URL resource27 = classLoader.getResource("C.png");
        array_icon[1] = new ImageIcon(resource27);
        java.net.URL resource33 = classLoader.getResource("Go.png");
        array_icon[2] = new ImageIcon(resource33);
        java.net.URL resource41 = classLoader.getResource("ART WORK.png");
        array_icon[3] = new ImageIcon(resource41);
        java.net.URL resource44 = classLoader.getResource("Insurgent Empire.png");
        array_icon[4] = new ImageIcon(resource44);
        java.net.URL resource49 = classLoader.getResource("The Prince.png");
        array_icon[5] = new ImageIcon(resource49);
        java.net.URL resource50 = classLoader.getResource("The Druid.png");
        array_icon[6] = new ImageIcon(resource50);
        java.net.URL resource55 = classLoader.getResource("Cod.png");
        array_icon[7] = new ImageIcon(resource55);
        java.net.URL resource58 = classLoader.getResource("Cosmos.png");
        array_icon[8] = new ImageIcon(resource58);
        java.net.URL resource59 = classLoader.getResource("The Social Animal.png");
        array_icon[9] = new ImageIcon(resource59);
        java.net.URL resource63 = classLoader.getResource("Three Kingdoms.png");
        array_icon[10] = new ImageIcon(resource63);

        members[0] = new Staff("Ben", "Ben", "Ben", "Staff", 45);
        members[1] = new Teacher("Mary", "Mary", "Mary", "Teacher", 35);
        members[2] = new Student("Tom", "Tom", "Tom", "Student", 25);
        members[3] = new Staff("Jack", "Jack", "Jack", "Staff", 30);
        members[4] = new Student("Jen", "Jen", "Jen", "Student", 20);
        members[5] = new Teacher("Jenny", "Jenny", "Jenny", "Teacher", 40);
        members[6] = new Student("John", "John", "John", "Student", 18);

        admin.add_book("Java", "James Gosling", "Sun", 12345, "Language", "Available");
        admin.add_book("C", "Dennis Ritchie", "Bell", 12348, "Language", "Available");
        admin.add_book("Go", "Google", "Google", 12354, "Language", "Available");
        admin.add_book("ART WORK", "Heather Darcy Bhandari ", "Free Press", 12362, "Art", "Available");
        admin.add_book("Insurgent Empire", "Priyamvada Gopal", "Verso", 12365, "World History", "Available");
        admin.add_book("The Prince", "Niccolò Machiavelli", "Dante University", 12370, "Philosophy", "Available");
        admin.add_book("The Druid", "Jeff Wheeler", "47North", 12371, "Religion", "Available");
        admin.add_book("Cod", "Mark Kurlansky", "Vintage", 12376, "Natural Science", "Available");
        admin.add_book("Cosmos", "Carl Sagan", "Random House", 12379, "Applied Science", "Available");
        admin.add_book("The Social Animal", "David Brooks", "Worth Publishers", 12380, "Social Science", "Available");
        admin.add_book("Three Kingdoms", "Luo Guanzhong", "Foreign Language Press", 12384, "Chinese History",
                "Available");

        String a[] = { "Search", "Login", "Register", "Rank", "Help" };
        String b[] = { "Borrow_book", "Return_book", "Personal_information", "Logout" };
        String d[] = { "Admin", "Student", "Teacher", "Staff", "Exit" };
        String e[] = { "Add_book", "Delete_book", "Update_book", "Check_fine", "Check_members", "Check_books",
                "Searching & Borrowing times", "Logout" };
        String f[] = { "Category", "Name", "Author", "Publisher", "ISBN", "Status", "Exit" };
        String h[] = { "Student", "Teacher", "Staff" };
        String j[] = { "Available", "Unavailable" };
        String k[] = { "Rules in members", "Contact us" };
        String l[] = { "Name", "Author", "Publisher", "Exit" };
        String m[] = { "Philosophy", "Religion", "Natural Science", "Applied Science", "Social Science",
                "Chinese History", "World History", "Language", "Art", "Exit" };
        String ll[] = { "Author", "Publisher", "ISBN", "Category", "Status", "Exit" };

        while (true) {
            String choice = (String) JOptionPane.showInputDialog(null,
                    "Welcome to NCU Library!\nPlease choose one of the following: ",
                    "Library Management System", JOptionPane.QUESTION_MESSAGE, icon1, a, a[0]);
            if (choice != null && choice.equals("Help")) {
                int abc = JOptionPane.showOptionDialog(null, "Please choose one of the following: ",
                        "Library Management System", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        Helpp, k, k[0]);
                if (abc == 0) {
                    int abcc = JOptionPane.showOptionDialog(null, "Please choose one of the following: ",
                            "Library Management System", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                            Helpp, h, h[0]);
                    if (abcc == 0) {
                        JOptionPane.showMessageDialog(null,
                                "Deadline: 10 Seconds\nFine: 100 Dollars\nMax_borrow: 2 Books",
                                "Library Management System", JOptionPane.INFORMATION_MESSAGE, Studentt);
                    } else if (abcc == 1) {
                        JOptionPane.showMessageDialog(null,
                                "Deadline: 12 Seconds\nFine: 150 Dollars\nMax_borrow: 3 Books",
                                "Library Management System", JOptionPane.INFORMATION_MESSAGE, Teacherr);
                    } else if (abcc == 2) {
                        JOptionPane.showMessageDialog(null,
                                "Deadline: 14 Seconds\nFine: 200 Dollars\nMax_borrow: 4 Books",
                                "Library Management System", JOptionPane.INFORMATION_MESSAGE, Stafff);
                    }
                } else if (abc == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Collection and marshalling: \nManager: Tommy\nGmail: tommy920125@gmail.com\n\nPromotion service group: \nManager: Anita\nGmail: anita.tw88@gmail.com\n\nInformation Systems Group: \nManager: Lawrence\nGmail: law5616583@gmail.com\n\nAdministration Room: \nManager: Eric\nGmail: liu911229@gmail.com\n\n",
                            "Library Management System", JOptionPane.INFORMATION_MESSAGE, Selfiee);
                }
            }
            if (choice != null && choice.equals("Rank")) {
                admin.ranking();
            }
            if (choice != null && choice.equals("Search")) {
                String search_choice = (String) JOptionPane.showInputDialog(null,
                        "Please choose one of the following: ",
                        "Library Management System", JOptionPane.QUESTION_MESSAGE, Searchh, f, f[0]);
                if (search_choice.equals("Category")) {
                    String choiced = (String) JOptionPane.showInputDialog(null, "Please choose one of the following: ",
                            "Library Management System", JOptionPane.QUESTION_MESSAGE, Categoryy, m, m[0]);
                    if (choiced.equals("Exit")) {
                        continue;
                    }
                    String yu = "";
                    int gh = 1;
                    for (int y = 0; y < Admin.books.length; y++) {
                        if (Admin.books[y] != null && Admin.books[y].getCategory().equals(choiced)) {
                            yu += gh + ". " + Admin.books[y].getName() + "\n";
                            gh++;
                        }

                    }

                    for (int i = 0; i < Admin.books.length; i++) {
                        if (Admin.books[i] != null && Admin.books[i].getCategory().equals(choiced)) {
                            JOptionPane.showMessageDialog(null, yu, "Library Management System",
                                    JOptionPane.INFORMATION_MESSAGE);

                            break;
                        }
                        if (Admin.books[i] == null && i == Admin.books.length - 1) {
                            JOptionPane.showMessageDialog(null, "The book doesn't exist!\nPlease try again!",
                                    "Library Management System",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                }
                if (search_choice.equals("Exit")) {
                    continue;
                }
                if (search_choice.equals("Status")) {
                    int search_content1 = JOptionPane.showOptionDialog(null, "Please choose one of the following: ",
                            "Library Management System", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                            Statuss, j, j[0]);
                    if (search_content1 == 0) {
                        gg = "Available";
                    } else if (search_content1 == 1) {
                        gg = "Unavailable";
                    }

                    if (search_choice.equals("Status")) {
                        String ak = "";
                        int fr = 1;
                        for (int i = 0; i < Admin.books.length; i++) {
                            if (Admin.books[i] != null && Admin.books[i].getStatus().equals(gg)) {

                                ak += " " + fr + ". " + Admin.books[i].getName() + "\n";
                                fr++;

                            }

                        }
                        for (int i = 0; i < Admin.books.length; i++) {
                            if (Admin.books[i] != null && Admin.books[i].getStatus().equals(gg)) {
                                JOptionPane.showMessageDialog(null, ak, "Library Management System",
                                        JOptionPane.INFORMATION_MESSAGE);
                                break;
                            }
                            if (Admin.books[i] == null && i == Admin.books.length - 1) {
                                JOptionPane.showMessageDialog(null, "The book doesn't exist!\nPlease try again!",
                                        "Library Management System",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                        }

                    }
                } else if (search_choice.equals("Name")) {
                    String search_content = JOptionPane.showInputDialog(null,
                            "Please enter the content you want to search: ",
                            "Library Management System", JOptionPane.PLAIN_MESSAGE, Namee, null, "").toString();
                    if (search_content.equals("")) {
                        JOptionPane.showMessageDialog(null, "The content is empty!\nPlease try again!",
                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                        continue;
                    }

                    String ff = "";
                    for (int i = 0; i < Admin.books.length; i++) {

                        if (Admin.books[i] != null && Admin.books[i].getName().equals(search_content)) {

                            for (int th = 0; th < Admin.books.length; th++) {
                                if (Admin.books[th] != null && Admin.books[th].getName().equals(search_content)) {
                                    ff += Admin.books[th].toString() + "\n\n";

                                }
                            }
                            JOptionPane.showMessageDialog(null, ff,
                                    "Library Management System",
                                    JOptionPane.INFORMATION_MESSAGE, array_icon[i]);
                            Admin.books[i].setsearchCount(Admin.books[i].getsearchCount()+1);
                            break;

                        }
                        if (Admin.books[i] == null && i == Admin.books.length - 1) {
                            JOptionPane.showMessageDialog(null, "The book doesn't exist!\nPlease try again!",
                                    "Library Management System",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } else if (search_choice.equals("Author")) {
                    String search_content1 = JOptionPane.showInputDialog(null,
                            "Please enter the content you want to search: ",
                            "Library Management System", JOptionPane.PLAIN_MESSAGE, Authorr, null, "").toString();
                    if (search_content1.equals("")) {
                        JOptionPane.showMessageDialog(null, "The content is empty!\nPlease try again!",
                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                        continue;
                    }
                    String fff = "";
                    for (int i = 0; i < Admin.books.length; i++) {
                        if (Admin.books[i] != null && Admin.books[i].getAuthor().equals(search_content1)) {

                            for (int thg = 0; thg < Admin.books.length; thg++) {
                                if (Admin.books[thg] != null
                                        && Admin.books[thg].getAuthor().equals(search_content1)) {
                                    fff += Admin.books[thg].toString() + "\n\n";
                                }
                            }
                            JOptionPane.showMessageDialog(null, fff,
                                    "Library Management System",
                                    JOptionPane.INFORMATION_MESSAGE, array_icon[i]);
                                    Admin.books[i].setsearchCount(Admin.books[i].getsearchCount()+1);
                            break;

                        } else if (Admin.books[i] == null && i == Admin.books.length - 1) {
                            JOptionPane.showMessageDialog(null, "The book doesn't exist!\nPlease try again!",
                                    "Library Management System",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } else if (search_choice.equals("Publisher")) {
                    String search_content2 = JOptionPane.showInputDialog(null,
                            "Please enter the content you want to search: ",
                            "Library Management System", JOptionPane.PLAIN_MESSAGE, Publisherr, null, "").toString();
                    if (search_content2.equals("")) {
                        JOptionPane.showMessageDialog(null, "The content is empty!\nPlease try again!",
                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                        continue;
                    }
                    String ffff = "";
                    for (int i = 0; i < Admin.books.length; i++) {
                        if (Admin.books[i] != null && Admin.books[i].getPublisher().equals(search_content2)) {

                            for (int thr = 0; thr < Admin.books.length; thr++) {
                                if (Admin.books[thr] != null
                                        && Admin.books[thr].getPublisher().equals(search_content2)) {
                                    ffff += Admin.books[thr].toString() + "\n\n";
                                }
                            }
                            JOptionPane.showMessageDialog(null, ffff,
                                    "Library Management System",
                                    JOptionPane.INFORMATION_MESSAGE, array_icon[i]);
                                    Admin.books[i].setsearchCount(Admin.books[i].getsearchCount()+1);
                            break;

                        }
                        if (Admin.books[i] == null && i == Admin.books.length - 1) {
                            JOptionPane.showMessageDialog(null, "The book doesn't exist!\nPlease try again!",
                                    "Library Management System",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } else if (search_choice.equals("ISBN")) {
                    String search_content3 = JOptionPane.showInputDialog(null,
                            "Please enter the content you want to search: ",
                            "Library Management System", JOptionPane.PLAIN_MESSAGE, Isbnn, null, "").toString();
                    if (search_content3.equals("") || search_content3.equals(" ")) {
                        JOptionPane.showMessageDialog(null, "The content is empty!\nPlease try again!",
                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                        continue;
                    }

                    for (int i = 0; i < Admin.books.length; i++) {
                        if (Admin.books[i] != null
                                && Admin.books[i].getISBN() == Integer.parseInt(search_content3)) {
                            JOptionPane.showMessageDialog(null, Admin.books[i].toString(),
                                    "Library Management System",
                                    JOptionPane.INFORMATION_MESSAGE, array_icon[i]);
                                    Admin.books[i].setsearchCount(Admin.books[i].getsearchCount()+1);
                            break;
                        } else if (Admin.books[i] == null && i == Admin.books.length - 1) {
                            JOptionPane.showMessageDialog(null, "The book doesn't exist!\nPlease try again!",
                                    "Library Management System",
                                    JOptionPane.INFORMATION_MESSAGE);

                        }

                    }
                }

            }
            if (choice != null && choice.equals("Register")) {
                do {
                    register_name = JOptionPane.showInputDialog(null,
                            "Please enter your name: ",
                            "Library Management System", JOptionPane.PLAIN_MESSAGE, Registerr, null, "").toString();
                    if (register_name.equals("") || register_name.equals(" ")) {
                        JOptionPane.showMessageDialog(null, "Please enter your name!",
                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                        continue;

                    } else {
                        for (int i = 0; i < members.length; i++) {
                            if (members[i] != null && members[i].getName().equals(register_name)) {
                                JOptionPane.showMessageDialog(null,
                                        "The name has been registered!\nPlease try again!",
                                        "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                afrrr = 1;
                                break;
                            }

                            if (members[i] == null && i == members.length - 1) {
                                afrrr = 0;
                                break;
                            }
                        }
                    }
                } while (afrrr == 1);

                do {

                    register_account = JOptionPane.showInputDialog(null,
                            "Please enter the account you want to register: ",
                            "Library Management System", JOptionPane.PLAIN_MESSAGE, Registerr, null, "").toString();
                    if (register_account.equals("") || register_account.equals(" ")) {
                        JOptionPane.showMessageDialog(null, "Please enter your account!",
                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                        continue;

                    } else {
                        for (int i = 0; i < members.length; i++) {
                            if (members[i] != null && members[i].getAccount().equals(register_account)) {
                                JOptionPane.showMessageDialog(null,
                                        "The account has been registered!\nPlease try again!",
                                        "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                afr = 1;
                                break;
                            }
                            if (register_account.equals("Admin")) {
                                JOptionPane.showMessageDialog(null,
                                        "The account is only for admin!\nPlease try again!",
                                        "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                afr = 1;
                                break;
                            }
                            if (members[i] == null && i == members.length - 1) {
                                afr = 0;
                                break;
                            }
                        }
                    }

                } while (afr == 1);
                do {
                    register_password = JOptionPane.showInputDialog(null,
                            "Please enter the password you want to register: ",
                            "Library Management System", JOptionPane.PLAIN_MESSAGE, Registerr, null, "").toString();
                    if (register_password.equals("") || register_password.equals(" ")) {
                        JOptionPane.showMessageDialog(null, "Please enter your password!",
                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                        continue;

                    } else {
                        haha = 0;
                    }
                } while (haha == 1);
                int yy = JOptionPane.showOptionDialog(null,
                        "Please enter your identity: ",
                        "Library Management System", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        Registerr,
                        h, h[0]);
                if (yy == 0) {
                    register_identity = "Student";
                } else if (yy == 1) {
                    register_identity = "Teacher";
                } else if (yy == 2) {
                    register_identity = "Staff";
                }

                do {

                    register_age = JOptionPane.showInputDialog(null,
                            "Please enter your age (Age>15): ",
                            "Library Management System", JOptionPane.PLAIN_MESSAGE, Registerr, null, "").toString();
                    if (register_age.equals("") || register_age.equals(" ")) {
                        JOptionPane.showMessageDialog(null, "Please enter your age!",
                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                        continue;

                    } else {
                        if (Integer.parseInt(register_age) < 16) {
                            JOptionPane.showMessageDialog(null, "Your age must be more than 15!\nPlease try again!",
                                    "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                            afrr = 1;
                        } else {
                            afrr = 0;
                        }
                    }

                } while (afrr == 1);

                for (int i = 0; i < members.length; i++) {
                    if (members[i] == null) {
                        if (register_identity == "Student") {
                            members[i] = new Student(register_name, register_account, register_password,
                                    register_identity, Integer.parseInt(register_age));
                        } else if (register_identity == "Teacher") {
                            members[i] = new Teacher(register_name, register_account, register_password,
                                    register_identity, Integer.parseInt(register_age));
                        } else if (register_identity == "Staff") {
                            members[i] = new Staff(register_name, register_account, register_password,
                                    register_identity, Integer.parseInt(register_age));
                        }

                        JOptionPane.showMessageDialog(null, "Register successfully!", "Library Management System",
                                JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }

                }

            }
            if (choice.equals("Login")) {
                String login_choice = (String) JOptionPane.showInputDialog(null, "Please choose one of the following: ",
                        "Library Management System", JOptionPane.QUESTION_MESSAGE, Loginn, d, d[0]);
                if (login_choice != null && login_choice.equals("Exit")) {

                    continue;
                }

                if (login_choice.equals("Admin")) {
                    account = JOptionPane.showInputDialog(null, "Please enter your account: ",
                            "Library Management System",
                            JOptionPane.QUESTION_MESSAGE, Adminn, null, "").toString();
                    if (account == null) {
                        break;
                    }
                    password = JOptionPane.showInputDialog(null, "Please enter your password: ",
                            "Library Management System", JOptionPane.QUESTION_MESSAGE, Adminn, null, "").toString();
                    if (password == null) {
                        break;
                    }
                    int ii = 1;

                    if (admin.login(account, password)) {
                        JOptionPane.showMessageDialog(null, "Admin logs in successfully!", "Library Management System",
                                JOptionPane.INFORMATION_MESSAGE);
                        while (true) {
                            String admin_choice = (String) JOptionPane.showInputDialog(null,
                                    "Please choose one of the following: ", "Library Management System",
                                    JOptionPane.QUESTION_MESSAGE, Adminn, e, e[0]);
                            if (admin_choice.equals("Logout")) {
                                JOptionPane.showMessageDialog(null, "Logout successfully!",
                                        "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            }
                            if (admin_choice.equals("Add_book")) {
                                String name = JOptionPane.showInputDialog(null, "Please enter the name of the book: ",
                                        "Library Management System", JOptionPane.QUESTION_MESSAGE, Add_bookss, null, "")
                                        .toString();
                                if (name.equals("") || name.equals(" ")) {
                                    JOptionPane.showMessageDialog(null, "Please enter the name of the book!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    continue;
                                }
                                String author = JOptionPane.showInputDialog(null,
                                        "Please enter the author of the book: ",
                                        "Library Management System", JOptionPane.QUESTION_MESSAGE, Add_bookss, null, "")
                                        .toString();
                                if (author.equals("") || name.equals(" ")) {
                                    JOptionPane.showMessageDialog(null, "Please enter the author of the book!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    continue;
                                }
                                String publisher = JOptionPane.showInputDialog(null,
                                        "Please enter the publisher of the book: ", "Library Management System",
                                        JOptionPane.QUESTION_MESSAGE, Add_bookss, null, "").toString();
                                if (publisher.equals("") || name.equals(" ")) {
                                    JOptionPane.showMessageDialog(null, "Please enter the publisher of the book!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    continue;
                                }
                                String ISBN = JOptionPane.showInputDialog(null, "Please enter the ISBN of the book: ",
                                        "Library Management System", JOptionPane.QUESTION_MESSAGE, Add_bookss, null, "")
                                        .toString();
                                if (ISBN.equals("") || name.equals(" ")) {
                                    JOptionPane.showMessageDialog(null, "Please enter the ISBN of the book!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    continue;
                                }
                                String category = (String) JOptionPane.showInputDialog(null,
                                        "Please choose one of the following: ",
                                        "Library Management System", JOptionPane.QUESTION_MESSAGE, Add_bookss, m, m[0]);
                                if (category.equals("")) {
                                    JOptionPane.showMessageDialog(null, "Please choose one of the following!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    continue;
                                }
                                int status = JOptionPane.showOptionDialog(null,
                                        "Please enter the status of the book: ",
                                        "Library Management System", JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.INFORMATION_MESSAGE, Add_bookss, j, j[0]);
                                String avd = "";
                                if (status == 0) {
                                    avd = "Available";
                                } else if (status == 1) {
                                    avd = "Unavailable";
                                }

                                admin.add_book(name, author, publisher, Integer.parseInt(ISBN), category, avd);
                                JOptionPane.showMessageDialog(null, "Add successfully!", "Library Management System",
                                        JOptionPane.INFORMATION_MESSAGE);

                            }
                            if (admin_choice.equals("Delete_book")) {
                                String ISBN = JOptionPane.showInputDialog(null, "Please enter the ISBN of the book: ",
                                        "Library Management System", JOptionPane.QUESTION_MESSAGE, Delete_bookss, null,
                                        "").toString();
                                if (ISBN.equals("") || ISBN.equals(" ")) {
                                    JOptionPane.showMessageDialog(null, "Please enter the ISBN of the book!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    continue;
                                }
                                for (int hu = 0; hu < Admin.books.length; hu++) {
                                    if (Admin.books[hu] != null
                                            && Admin.books[hu].getISBN() == Integer.parseInt(ISBN)) {
                                        admin.delete_book(Integer.parseInt(ISBN));
                                        JOptionPane.showMessageDialog(null, "Delete successfully!",
                                                "Library Management System",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    } else if (Admin.books[hu] == null && hu == Admin.books.length - 1) {
                                        JOptionPane.showMessageDialog(null, "The book does not exist!",
                                                "Library Management System",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    }
                                }

                            }
                            if (admin_choice.equals("Update_book")) {

                                String name = JOptionPane.showInputDialog(null, "Please enter the name of the book: ",
                                        "Library Management System", JOptionPane.QUESTION_MESSAGE, Update_bookss, null,
                                        "").toString();
                                if (name.equals("") || name.equals(" ")) {
                                    JOptionPane.showMessageDialog(null, "Please enter the name of the book!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    continue;
                                }
                                for (int yh = 0; yh < Admin.books.length; yh++) {
                                    if (Admin.books[yh] != null && Admin.books[yh].getName().equals(name)) {
                                        String update_choice = (String) JOptionPane.showInputDialog(null,
                                                "Please choose one of the following: ",
                                                "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                Update_bookss, ll,
                                                ll[0]);
                                        if (update_choice.equals("Exit")) {
                                            break;
                                        }
                                        if (update_choice.equals("Author")) {
                                            String author = JOptionPane.showInputDialog(null,
                                                    "Please enter the author of the book: ",
                                                    "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                    Update_bookss,
                                                    null, "").toString();
                                            if (author.equals("") || author.equals(" ")) {
                                                JOptionPane.showMessageDialog(null,
                                                        "Please enter the author of the book!",
                                                        "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                                continue;
                                            }
                                            admin.update_book_author(name, author);
                                            JOptionPane.showMessageDialog(null, "Update successfully!",
                                                    "Library Management System",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                        if (update_choice.equals("Publisher")) {
                                            String publisher = JOptionPane.showInputDialog(null,
                                                    "Please enter the publisher of the book: ",
                                                    "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                    Update_bookss,
                                                    null, "").toString();
                                            if (publisher.equals("") || publisher.equals(" ")) {
                                                JOptionPane.showMessageDialog(null,
                                                        "Please enter the publisher of the book!",
                                                        "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                                continue;
                                            }
                                            admin.update_book_publisher(name, publisher);
                                            JOptionPane.showMessageDialog(null, "Update successfully!",
                                                    "Library Management System",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                        if (update_choice.equals("ISBN")) {
                                            String ISBN = JOptionPane
                                                    .showInputDialog(null, "Please enter the ISBN of the book: ",
                                                            "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                            Update_bookss, null, "")
                                                    .toString();
                                            if (ISBN.equals("") || ISBN.equals(" ")) {
                                                JOptionPane.showMessageDialog(null,
                                                        "Please enter the ISBN of the book!",
                                                        "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                                continue;
                                            }
                                            admin.update_book_ISBN(name, Integer.parseInt(ISBN));
                                            JOptionPane.showMessageDialog(null, "Update successfully!",
                                                    "Library Management System",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                        if (update_choice.equals("Category")) {
                                            String category = (String) JOptionPane.showInputDialog(null,
                                                    "Please choose one of the following: ",
                                                    "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                    Update_bookss, m,
                                                    m[0]);
                                            if (category.equals("")) {
                                                JOptionPane.showMessageDialog(null,
                                                        "Please choose one of the following!",
                                                        "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                                continue;
                                            }
                                            if (category.equals("Exit")) {
                                                break;
                                            }
                                            admin.update_book_category(name, category);
                                            JOptionPane.showMessageDialog(null, "Update successfully!",
                                                    "Library Management System",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                        if (update_choice.equals("Status")) {
                                            int status = JOptionPane.showOptionDialog(null,
                                                    "Please enter the status of the book: ",
                                                    "Library Management System", JOptionPane.DEFAULT_OPTION,
                                                    JOptionPane.INFORMATION_MESSAGE, Update_bookss, j, j[0]);
                                            String avd = "";
                                            if (status == 0) {
                                                avd = "Available";
                                            } else if (status == 1) {
                                                avd = "Unavailable";
                                            }
                                            admin.update_book_status(name, avd);
                                            JOptionPane.showMessageDialog(null, "Update successfully!",
                                                    "Library Management System",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                            break;
                                        }
                                    } else if (Admin.books[yh] == null && yh == Admin.books.length - 1) {
                                        JOptionPane.showMessageDialog(null, "The book doesn't exist!",
                                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    }
                                }

                            }
                            if (admin_choice.equals("Check_members")) {
                                String member_account = JOptionPane.showInputDialog(null,
                                        "Please enter the account of the member: ",
                                        "Library Management System", JOptionPane.QUESTION_MESSAGE, Check_memberss, null,
                                        "").toString();
                                if (member_account.equals("")) {
                                    JOptionPane.showMessageDialog(null, "Please enter the account of the member!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    continue;
                                }
                                admin.check_members(member_account);
                            }
                            if (admin_choice.equals("Check_books")) {
                                admin.check_books();
                            }
                            if (admin_choice.equals("Check_fine")) {
                                admin.check_fine();
                            }

                            if (admin_choice.equals("Searching & Borrowing times")) {

                                String book_name = JOptionPane.showInputDialog(null,
                                        "Please enter the name of the book: ",
                                        "Library Management System", JOptionPane.QUESTION_MESSAGE, Search_timess, null,
                                        "").toString();
                                if (book_name.equals("") || book_name.equals(" ")) {
                                    JOptionPane.showMessageDialog(null, "Please enter the name of the book!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    continue;
                                }
                                for (int t = 0; t < Admin.books.length; t++) {
                                    if (Admin.books[t] != null && Admin.books[t].getName().equals(book_name)) {
                                        JOptionPane.showMessageDialog(null,
                                                "Searching times: " + Admin.books[t].getsearchCount()
                                                        + "\nBorrowing times: " + Admin.books[t].getTotalBorrowNum(),
                                                "Library Management System", JOptionPane.INFORMATION_MESSAGE,
                                                Search_timess);

                                        break;
                                    }
                                    if (Admin.books[t] == null && t == Admin.books.length - 1) {
                                        JOptionPane.showMessageDialog(null,
                                                "The book doesn't exist!\nPlease try again!",
                                                "Library Management System",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    }

                                }
                            }
                        }
                    } else {

                        if (ii == 1) {
                            JOptionPane.showMessageDialog(null, "Wrong account or password!\nPlease try again!",
                                    "Library Management System",
                                    JOptionPane.INFORMATION_MESSAGE);
                            ii = 0;
                            continue;
                        }

                    }

                }
                if (login_choice.equals("Student")) {
                    account = JOptionPane.showInputDialog(null, "Please enter your account: ",
                            "Library Management System",
                            JOptionPane.QUESTION_MESSAGE, Studentt, null, "").toString();
                    if (account == null) {
                        break;
                    }
                    password = JOptionPane.showInputDialog(null, "Please enter your password: ",
                            "Library Management System", JOptionPane.QUESTION_MESSAGE, Studentt, null, "").toString();
                    if (password == null) {
                        break;
                    }
                    int iii = 1;
                    int kk = 0;
                    for (int o = 0; o < members.length; o++) {
                        if (kk == 1) {
                            break;
                        }
                        if (members[o] != null && members[o].getIdentity().equals("Student")
                                && members[o].login(account, password)) {

                            JOptionPane.showMessageDialog(null, members[o].getName() + " logs in successfully!",
                                    "Library Management System",
                                    JOptionPane.INFORMATION_MESSAGE);
                            while (true) {
                                String student_choice = (String) JOptionPane.showInputDialog(null,
                                        "Please choose one of the following: ", "Library Management System",
                                        JOptionPane.QUESTION_MESSAGE, Studentt, b, b[0]);
                                if (student_choice.equals("Logout")) {
                                    JOptionPane.showMessageDialog(null, "Logout successfully!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    kk = 1;
                                    break;

                                }
                                if (student_choice.equals("Borrow_book")) {
                                    for (int gh = 0; gh < Admin.books.length; gh++) {
                                        if (members[o].getReservee() && Admin.books[gh] != null
                                                && Admin.books[gh].getReserve()) {
                                            JOptionPane.showMessageDialog(null,
                                                    Admin.books[gh].getName()
                                                            + " is available !\nYou can borrow it now !",
                                                    "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                            members[o].setReservee(false);
                                            Admin.books[gh].setUnReserve();
                                            continue;
                                        }
                                    }
                                    String option = (String) JOptionPane.showInputDialog(null,
                                            "Please choose one of the following: ", "Library Management System",
                                            JOptionPane.QUESTION_MESSAGE, Borrow_bookss, l, l[0]);
                                    if (option.equals("Exit")) {
                                        continue;
                                    }
                                    if (option.equals("Name")) {
                                        String name = JOptionPane.showInputDialog(null,
                                                "Please enter the name of the book: ",
                                                "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                Borrow_bookss, null, "").toString();

                                        members[o].borrow_book(name, members[o].getAccount());

                                    }

                                    if (option.equals("Author")) {
                                        String author = JOptionPane.showInputDialog(null,
                                                "Please enter the author of the book: ",
                                                "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                Borrow_bookss, null, "").toString();

                                        members[o].borrow_book_author(author, members[o].getAccount());
                                    }
                                    if (option.equals("Publisher")) {
                                        String publisher = JOptionPane.showInputDialog(null,
                                                "Please enter the publisher of the book: ",
                                                "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                Borrow_bookss, null, "").toString();

                                        members[o].borrow_book_publisher(publisher, members[o].getAccount());
                                    }

                                } else if (student_choice.equals("Return_book")) {
                                    String name = JOptionPane.showInputDialog(null,
                                            "Please enter the name of the book: ",
                                            "Library Management System", JOptionPane.QUESTION_MESSAGE, Return_bookss,
                                            null, "").toString();
                                    if (name.equals("")) {
                                        JOptionPane.showMessageDialog(null, "Please enter the name of the book!",
                                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                        continue;
                                    }

                                    members[o].return_book(name, members[o].getAccount());

                                } else if (student_choice.equals("Personal_information")) {
                                    members[o].personal_information(members[o].getName());
                                }
                            }
                        } else if (members[o] == null && o == members.length - 1) {

                            if (iii == 1) {
                                JOptionPane.showMessageDialog(null, "Wrong account or password!\nPlease try again!",
                                        "Library Management System",
                                        JOptionPane.INFORMATION_MESSAGE);
                                iii = 0;
                                continue;
                            }

                        }

                    }
                }
                if (login_choice.equals("Teacher")) {
                    account = JOptionPane.showInputDialog(null, "Please enter your account: ",
                            "Library Management System",
                            JOptionPane.QUESTION_MESSAGE, Teacherr, null, "").toString();
                    if (account == null) {
                        break;
                    }
                    password = JOptionPane.showInputDialog(null, "Please enter your password: ",
                            "Library Management System", JOptionPane.QUESTION_MESSAGE, Teacherr, null, "").toString();
                    if (password == null) {
                        break;
                    }
                    int iiii = 1;
                    int kk = 0;
                    for (int o = 0; o < members.length; o++) {
                        if (kk == 1) {
                            break;
                        }
                        if (members[o] != null && members[o].getIdentity().equals("Teacher")
                                && members[o].login(account, password)) {
                            JOptionPane.showMessageDialog(null, members[o].getName() + " logs in successfully!",
                                    "Library Management System",
                                    JOptionPane.INFORMATION_MESSAGE);
                            while (true) {
                                String teacher_choice = (String) JOptionPane.showInputDialog(null,
                                        "Please choose one of the following: ", "Library Management System",
                                        JOptionPane.QUESTION_MESSAGE, Teacherr, b, b[0]);
                                if (teacher_choice.equals("Logout")) {
                                    JOptionPane.showMessageDialog(null, "Logout successfully!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    kk = 1;
                                    break;

                                }
                                if (teacher_choice.equals("Borrow_book")) {
                                    for (int gh = 0; gh < Admin.books.length; gh++) {
                                        if (members[o].getReservee() && Admin.books[gh] != null
                                                && Admin.books[gh].getReserve()) {
                                            JOptionPane.showMessageDialog(null,
                                                    Admin.books[gh].getName()
                                                            + " is available !\nYou can borrow it now !",
                                                    "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                            members[o].setReservee(false);
                                            Admin.books[gh].setUnReserve();
                                            continue;
                                        }
                                    }
                                    String option = (String) JOptionPane.showInputDialog(null,
                                            "Please choose one of the following: ", "Library Management System",
                                            JOptionPane.QUESTION_MESSAGE, Borrow_bookss, l, l[0]);
                                    if (option.equals("Exit")) {
                                        continue;
                                    }
                                    if (option.equals("Name")) {
                                        String name = JOptionPane.showInputDialog(null,
                                                "Please enter the name of the book: ",
                                                "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                Borrow_bookss, null, "").toString();

                                        members[o].borrow_book(name, members[o].getAccount());

                                    }

                                    if (option.equals("Author")) {
                                        String author = JOptionPane.showInputDialog(null,
                                                "Please enter the author of the book: ",
                                                "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                Borrow_bookss, null, "").toString();

                                        members[o].borrow_book_author(author, members[o].getAccount());
                                    }
                                    if (option.equals("Publisher")) {
                                        String publisher = JOptionPane.showInputDialog(null,
                                                "Please enter the publisher of the book: ",
                                                "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                Borrow_bookss, null, "").toString();

                                        members[o].borrow_book_publisher(publisher, members[o].getAccount());
                                    }

                                } else if (teacher_choice.equals("Return_book")) {
                                    String name = JOptionPane.showInputDialog(null,
                                            "Please enter the name of the book: ",
                                            "Library Management System", JOptionPane.QUESTION_MESSAGE, Return_bookss,
                                            null, "").toString();
                                    if (name.equals("")) {
                                        JOptionPane.showMessageDialog(null, "Please enter the name of the book!",
                                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                        continue;
                                    }
                                    members[o].return_book(name, members[o].getAccount());

                                } else if (teacher_choice.equals("Personal_information")) {
                                    members[o].personal_information(members[o].getName());
                                }
                            }
                        } else if (members[o] == null && o == members.length - 1) {

                            if (iiii == 1) {
                                JOptionPane.showMessageDialog(null, "Wrong account or password!\nPlease try again!",
                                        "Library Management System",
                                        JOptionPane.INFORMATION_MESSAGE);
                                iiii = 0;
                                continue;
                            }

                        }

                    }
                } else if (login_choice.equals("Staff")) {
                    account = JOptionPane.showInputDialog(null, "Please enter your account: ",
                            "Library Management System",
                            JOptionPane.QUESTION_MESSAGE, Stafff, null, "").toString();
                    if (account == null) {
                        break;
                    }
                    password = JOptionPane.showInputDialog(null, "Please enter your password: ",
                            "Library Management System", JOptionPane.QUESTION_MESSAGE, Stafff, null, "").toString();
                    if (password == null) {
                        break;
                    }
                    int iiiii = 1;
                    int kk = 0;
                    for (int o = 0; o < members.length; o++) {
                        if (kk == 1) {
                            break;
                        }
                        if (members[o] != null && members[o].getIdentity().equals("Staff")
                                && members[o].login(account, password)) {
                            JOptionPane.showMessageDialog(null, members[o].getName() + " logs in successfully!",
                                    "Library Management System",
                                    JOptionPane.INFORMATION_MESSAGE);
                            while (true) {
                                String staff_choice = (String) JOptionPane.showInputDialog(null,
                                        "Please choose one of the following: ", "Library Management System",
                                        JOptionPane.QUESTION_MESSAGE, Stafff, b, b[0]);
                                if (staff_choice.equals("Logout")) {
                                    JOptionPane.showMessageDialog(null, "Logout successfully!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    kk = 1;
                                    break;

                                }
                                if (staff_choice.equals("Borrow_book")) {
                                    for (int gh = 0; gh < Admin.books.length; gh++) {
                                        if (members[o].getReservee() && Admin.books[gh] != null
                                                && Admin.books[gh].getReserve()) {
                                            JOptionPane.showMessageDialog(null,
                                                    Admin.books[gh].getName()
                                                            + " is available !\nYou can borrow it now !",
                                                    "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                            members[o].setReservee(false);
                                            Admin.books[gh].setUnReserve();
                                            continue;
                                        }
                                    }
                                    String option = (String) JOptionPane.showInputDialog(null,
                                            "Please choose one of the following: ", "Library Management System",
                                            JOptionPane.QUESTION_MESSAGE, Borrow_bookss, l, l[0]);
                                    if (option.equals("Exit")) {
                                        continue;
                                    }
                                    if (option.equals("Name")) {
                                        String name = JOptionPane.showInputDialog(null,
                                                "Please enter the name of the book: ",
                                                "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                Borrow_bookss, null, "").toString();

                                        members[o].borrow_book(name, members[o].getAccount());

                                    }

                                    if (option.equals("Author")) {
                                        String author = JOptionPane.showInputDialog(null,
                                                "Please enter the author of the book: ",
                                                "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                Borrow_bookss, null, "").toString();

                                        members[o].borrow_book_author(author, members[o].getAccount());
                                    }
                                    if (option.equals("Publisher")) {
                                        String publisher = JOptionPane.showInputDialog(null,
                                                "Please enter the publisher of the book: ",
                                                "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                Borrow_bookss, null, "").toString();

                                        members[o].borrow_book_publisher(publisher, members[o].getAccount());
                                    }

                                } else if (staff_choice.equals("Return_book")) {
                                    String name = JOptionPane.showInputDialog(null,
                                            "Please enter the name of the book: ",
                                            "Library Management System", JOptionPane.QUESTION_MESSAGE, Return_bookss,
                                            null, "").toString();
                                    if (name.equals("")) {
                                        JOptionPane.showMessageDialog(null, "Please enter the name of the book!",
                                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                        continue;
                                    }
                                    members[o].return_book(name, members[o].getAccount());

                                } else if (staff_choice.equals("Personal_information")) {
                                    members[o].personal_information(members[o].getName());
                                }
                            }
                        } else if (members[o] == null && o == members.length - 1) {

                            if (iiiii == 1) {
                                JOptionPane.showMessageDialog(null, "Wrong account or password!\nPlease try again!",
                                        "Library Management System",
                                        JOptionPane.INFORMATION_MESSAGE);
                                iiiii = 0;
                                continue;
                            }

                        }

                    }
                } else {

                    continue;
                }
            }
        }
    }
}