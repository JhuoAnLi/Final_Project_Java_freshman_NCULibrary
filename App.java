import java.io.IOException;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.*;

public class App {
    public static Member[] members = new Member[500];
    private static final Logger logger = Logger.getLogger(App.class.getName());
    // 圖片列表名稱
    private static String[] imageNames = {
        "bukubook3.png", "Add_books.png", "Admin.png", "author.png", "Borrow_books.png", 
        "Check_members.png", "Delete_books.png", "isbn.png", "login.png", "name.png", 
        "search.png", "Search_times.png", "Return_books.png", "register.png", "publisher.png", 
        "Staff.png", "status.png", "Student.png", "Teacher.png", "Update_books.png", 
        "Help.png", "Selfie.png", "Category.png"
    };
    private static String[] bookImageNames = {
        "Java.png", "C.png", "Go.png", 
        "ART WORK.png", "Insurgent Empire.png", "The Prince.png", "The Druid.png", 
        "Cod.png", "Cosmos.png", "The Social Animal.png", "Three Kingdoms.png"
    };
    // 變數名稱列表
    private static String[] variableNames = {
        "icon1", "Add_bookss", "Adminn", "Authorr", "Borrow_bookss", 
        "Check_memberss", "Delete_bookss", "Isbnn", "Loginn", "Namee", 
        "Searchh", "Search_timess", "Return_bookss", "Registerr", "Publisherr", 
        "Stafff", "Statuss", "Studentt", "Teacherr", "Update_bookss", 
        "Helpp", "Selfiee", "Categoryy"
    };
    // 創建一個 HashMap 來存儲變數名稱和對應的 ImageIcon 對象
    private static HashMap<String, ImageIcon> icons = new HashMap<>();
    private static ImageIcon[] array_icon = new ImageIcon[60];

    // 讀取圖片的方法
    private void loadImages(String[] imageNames, String[] variableNames, boolean isBookImage) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        for (int i = 0; i < imageNames.length; i++) {
            java.net.URL resource = classLoader.getResource("resources/" + imageNames[i]);
            if (resource == null) {
                System.out.println("Cannot find resource: " + imageNames[i]);
                continue;
            }
            if (isBookImage) {
                array_icon[i] = new ImageIcon(resource);
            } else {
                icons.put(variableNames[i], new ImageIcon(resource));
            }
        }
    }

    public void SetLogMethod() {
        try {
            FileHandler fh = new FileHandler("mylog.log");
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (IOException e) {
            logger.severe("Failed to create log file handler: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        App app = new App();
        app.SetLogMethod();
        Admin admin = new Admin("Admin", "Admin", "Admin");
        String gg = "";
        String register_identity = "";
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

        // 讀取圖片
        app.loadImages(imageNames, variableNames, false);
        app.loadImages(bookImageNames, null, true);

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
                    "Library Management System", JOptionPane.QUESTION_MESSAGE, icons.get("icon1"), a, a[0]);
            logger.info("The front page: " + choice);
            if (choice != null && choice.equals("Help")) {
                int abc = JOptionPane.showOptionDialog(null, "Please choose one of the following: ",
                        "Library Management System", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        icons.get("Helpp"), k, k[0]);
                logger.info("The help page: " + abc);
                if (abc == 0) {
                    int abcc = JOptionPane.showOptionDialog(null, "Please choose one of the following: ",
                            "Library Management System", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                            icons.get("Helpp"), h, h[0]);
                    logger.info("The rules page: " + abcc);
                    if (abcc == 0) {
                        JOptionPane.showMessageDialog(null,
                                "Deadline: 10 Seconds\nFine: 100 Dollars\nMax_borrow: 2 Books",
                                "Library Management System", JOptionPane.INFORMATION_MESSAGE, icons.get("Studentt"));
                        logger.info("The rules of student: " + abcc);
                    } else if (abcc == 1) {
                        JOptionPane.showMessageDialog(null,
                                "Deadline: 12 Seconds\nFine: 150 Dollars\nMax_borrow: 3 Books",
                                "Library Management System", JOptionPane.INFORMATION_MESSAGE, icons.get("Teacherr"));
                        logger.info("The rules of teacher: " + abcc);
                    } else if (abcc == 2) {
                        JOptionPane.showMessageDialog(null,
                                "Deadline: 14 Seconds\nFine: 200 Dollars\nMax_borrow: 4 Books",
                                "Library Management System", JOptionPane.INFORMATION_MESSAGE, icons.get("Stafff"));
                        logger.info("The rules of staff: " + abcc);
                    }
                } else if (abc == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Collection and marshalling: \nManager: Tommy\nGmail: tommy920125@gmail.com\n\nPromotion service group: \nManager: Anita\nGmail: anita.tw88@gmail.com\n\nInformation Systems Group: \nManager: Lawrence\nGmail: law5616583@gmail.com\n\nAdministration Room: \nManager: Eric\nGmail: liu911229@gmail.com\n\n",
                            "Library Management System", JOptionPane.INFORMATION_MESSAGE, icons.get("Selfiee"));
                    logger.info("The contact page: " + abc);
                }
            }
            if (choice != null && choice.equals("Rank")) {
                logger.info("The ranking page: " + choice);
                admin.ranking();
            }
            if (choice != null && choice.equals("Search")) {
                logger.info("The search page: " + choice);
                String search_choice = (String) JOptionPane.showInputDialog(null,
                        "Please choose one of the following: ",
                        "Library Management System", JOptionPane.QUESTION_MESSAGE, icons.get("Searchh"), f, f[0]);
                if (search_choice.equals("Category")) {
                    logger.info("The search page: " + search_choice);
                    String choiced = (String) JOptionPane.showInputDialog(null, "Please choose one of the following: ",
                            "Library Management System", JOptionPane.QUESTION_MESSAGE, icons.get("Categoryy"), m, m[0]);
                    if (choiced.equals("Exit")) {
                        logger.info("Exit the search page: " + search_choice);
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
                            logger.info("The search page: " + search_choice);
                            break;
                        }
                        if (Admin.books[i] == null && i == Admin.books.length - 1) {
                            JOptionPane.showMessageDialog(null, "The book doesn't exist!\nPlease try again!",
                                    "Library Management System",
                                    JOptionPane.INFORMATION_MESSAGE);
                            logger.info("The search page: " + search_choice);
                        }
                    }

                }
                if (search_choice.equals("Exit")) {
                    logger.info("Exit the search page: " + search_choice);
                    continue;
                }
                if (search_choice.equals("Status")) {
                    int search_content1 = JOptionPane.showOptionDialog(null, "Please choose one of the following: ",
                            "Library Management System", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                            icons.get("Statuss"), j, j[0]);
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
                                logger.info("The search page: " + search_choice);
                                break;
                            }
                            if (Admin.books[i] == null && i == Admin.books.length - 1) {
                                JOptionPane.showMessageDialog(null, "The book doesn't exist!\nPlease try again!",
                                        "Library Management System",
                                        JOptionPane.INFORMATION_MESSAGE);
                                logger.info("The search page: " + search_choice);
                            }
                        }

                    }
                } else if (search_choice.equals("Name")) {
                    String search_content = JOptionPane.showInputDialog(null,
                            "Please enter the content you want to search: ",
                            "Library Management System", JOptionPane.PLAIN_MESSAGE, icons.get("Namee"), null, "").toString();
                    logger.info("The search page: " + search_choice);
                    if (search_content.equals("")) {
                        JOptionPane.showMessageDialog(null, "The content is empty!\nPlease try again!",
                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                        logger.info("The search page: " + search_choice);
                        logger.warning("The content is empty!\nPlease try again!");
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
                            Admin.books[i].setsearchCount(Admin.books[i].getsearchCount() + 1);
                            break;

                        }
                        if (Admin.books[i] == null && i == Admin.books.length - 1) {
                            JOptionPane.showMessageDialog(null, "The book doesn't exist!\nPlease try again!",
                                    "Library Management System",
                                    JOptionPane.INFORMATION_MESSAGE);
                            logger.info("The search page: " + search_choice);
                            logger.warning("The book doesn't exist!\nPlease try again!");
                        }
                    }
                } else if (search_choice.equals("Author")) {
                    String search_content1 = JOptionPane.showInputDialog(null,
                            "Please enter the content you want to search: ",
                            "Library Management System", JOptionPane.PLAIN_MESSAGE, icons.get("Authorr"), null, "").toString();
                    if (search_content1.equals("")) {
                        JOptionPane.showMessageDialog(null, "The content is empty!\nPlease try again!",
                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                        logger.info("The search page: " + search_choice);
                        logger.warning("The content is empty!\nPlease try again!");
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
                            Admin.books[i].setsearchCount(Admin.books[i].getsearchCount() + 1);
                            logger.info("The search page: " + search_choice);
                            break;

                        } else if (Admin.books[i] == null && i == Admin.books.length - 1) {
                            JOptionPane.showMessageDialog(null, "The book doesn't exist!\nPlease try again!",
                                    "Library Management System",
                                    JOptionPane.INFORMATION_MESSAGE);
                            logger.info("The search page: " + search_choice);
                            logger.warning("The book doesn't exist!\nPlease try again!");
                        }
                    }
                } else if (search_choice.equals("Publisher")) {
                    String search_content2 = JOptionPane.showInputDialog(null,
                            "Please enter the content you want to search: ",
                            "Library Management System", JOptionPane.PLAIN_MESSAGE, icons.get("Publisherr"), null, "").toString();
                    if (search_content2.equals("")) {
                        JOptionPane.showMessageDialog(null, "The content is empty!\nPlease try again!",
                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                        logger.info("The search page: " + search_choice);
                        logger.warning("The content is empty!\nPlease try again!");
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
                            Admin.books[i].setsearchCount(Admin.books[i].getsearchCount() + 1);
                            logger.info("The search page: " + search_choice);
                            break;

                        }
                        if (Admin.books[i] == null && i == Admin.books.length - 1) {
                            JOptionPane.showMessageDialog(null, "The book doesn't exist!\nPlease try again!",
                                    "Library Management System",
                                    JOptionPane.INFORMATION_MESSAGE);
                            logger.info("The search page: " + search_choice);
                            logger.warning("The book doesn't exist!\nPlease try again!");
                        }
                    }
                } else if (search_choice.equals("ISBN")) {
                    String search_content3 = JOptionPane.showInputDialog(null,
                            "Please enter the content you want to search: ",
                            "Library Management System", JOptionPane.PLAIN_MESSAGE, icons.get("Isbnn"), null, "").toString();
                    if (search_content3.equals("") || search_content3.equals(" ")) {
                        JOptionPane.showMessageDialog(null, "The content is empty!\nPlease try again!",
                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                        logger.info("The search page: " + search_choice);
                        logger.warning("The content is empty!\nPlease try again!");
                        continue;
                    }

                    for (int i = 0; i < Admin.books.length; i++) {
                        if (Admin.books[i] != null
                                && Admin.books[i].getISBN() == Integer.parseInt(search_content3)) {
                            JOptionPane.showMessageDialog(null, Admin.books[i].toString(),
                                    "Library Management System",
                                    JOptionPane.INFORMATION_MESSAGE, array_icon[i]);
                            Admin.books[i].setsearchCount(Admin.books[i].getsearchCount() + 1);
                            logger.info("The search page: " + search_choice);
                            break;
                        } else if (Admin.books[i] == null && i == Admin.books.length - 1) {
                            JOptionPane.showMessageDialog(null, "The book doesn't exist!\nPlease try again!",
                                    "Library Management System",
                                    JOptionPane.INFORMATION_MESSAGE);
                            logger.info("The search page: " + search_choice);
                            logger.warning("The book doesn't exist!\nPlease try again!");

                        }

                    }
                }

            }
            if (choice != null && choice.equals("Register")) {
                do {
                    register_name = JOptionPane.showInputDialog(null,
                            "Please enter your name: ",
                            "Library Management System", JOptionPane.PLAIN_MESSAGE, icons.get("Registerr"), null, "").toString();
                    if (register_name.equals("") || register_name.equals(" ")) {
                        JOptionPane.showMessageDialog(null, "Please enter your name!",
                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                        logger.info("The register page: " + choice);
                        continue;

                    } else {
                        for (int i = 0; i < members.length; i++) {
                            if (members[i] != null && members[i].getName().equals(register_name)) {
                                JOptionPane.showMessageDialog(null,
                                        "The name has been registered!\nPlease try again!",
                                        "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                afrrr = 1;
                                logger.info("The register page: " + choice);
                                logger.warning("The name has been registered!\nPlease try again!");
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
                            "Library Management System", JOptionPane.PLAIN_MESSAGE, icons.get("Registerr"), null, "").toString();
                    if (register_account.equals("") || register_account.equals(" ")) {
                        JOptionPane.showMessageDialog(null, "Please enter your account!",
                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                        logger.info("The register page: " + choice);
                        continue;

                    } else {
                        for (int i = 0; i < members.length; i++) {
                            if (members[i] != null && members[i].getAccount().equals(register_account)) {
                                JOptionPane.showMessageDialog(null,
                                        "The account has been registered!\nPlease try again!",
                                        "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                afr = 1;
                                logger.info("The register page: " + choice);
                                logger.warning("The account has been registered!\nPlease try again!");
                                break;
                            }
                            if (register_account.equals("Admin")) {
                                JOptionPane.showMessageDialog(null,
                                        "The account is only for admin!\nPlease try again!",
                                        "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                afr = 1;
                                logger.info("The register page: " + choice);
                                logger.warning("The account is only for admin!\nPlease try again!");
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
                            "Library Management System", JOptionPane.PLAIN_MESSAGE, icons.get("Registerr"), null, "").toString();
                    if (register_password.equals("") || register_password.equals(" ")) {
                        JOptionPane.showMessageDialog(null, "Please enter your password!",
                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                        logger.info("The register page: " + choice);
                        continue;

                    } else {
                        haha = 0;
                    }
                } while (haha == 1);
                int yy = JOptionPane.showOptionDialog(null,
                        "Please enter your identity: ",
                        "Library Management System", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        icons.get("Registerr"),
                        h, h[0]);
                if (yy == 0) {
                    register_identity = "Student";
                    logger.info("The register page: " + choice);
                } else if (yy == 1) {
                    register_identity = "Teacher";
                    logger.info("The register page: " + choice);
                } else if (yy == 2) {
                    register_identity = "Staff";
                    logger.info("The register page: " + choice);
                }

                do {

                    register_age = JOptionPane.showInputDialog(null,
                            "Please enter your age (Age>15): ",
                            "Library Management System", JOptionPane.PLAIN_MESSAGE, icons.get("Registerr"), null, "").toString();
                    if (register_age.equals("") || register_age.equals(" ")) {
                        JOptionPane.showMessageDialog(null, "Please enter your age!",
                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                        logger.info("The register page: " + choice);
                        continue;

                    } else {
                        if (Integer.parseInt(register_age) < 16) {
                            JOptionPane.showMessageDialog(null, "Your age must be more than 15!\nPlease try again!",
                                    "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                            afrr = 1;
                            logger.info("The register page: " + choice);
                            logger.warning("Your age must be more than 15!\nPlease try again!");
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
                        logger.info("The register page: " + choice);
                        break;
                    }

                }

            }
            if (choice.equals("Login")) {
                String login_choice = (String) JOptionPane.showInputDialog(null, "Please choose one of the following: ",
                        "Library Management System", JOptionPane.QUESTION_MESSAGE, icons.get("Loginn"), d, d[0]);
                if (login_choice != null && login_choice.equals("Exit")) {
                    logger.info("Exit the login page: " + choice);
                    continue;
                }

                if (login_choice.equals("Admin")) {
                    account = JOptionPane.showInputDialog(null, "Please enter your account: ",
                            "Library Management System",
                            JOptionPane.QUESTION_MESSAGE, icons.get("Adminn"), null, "").toString();
                    logger.info("The login page: " + choice);
                    if (account == null) {
                        break;
                    }
                    password = JOptionPane.showInputDialog(null, "Please enter your password: ",
                            "Library Management System", JOptionPane.QUESTION_MESSAGE, icons.get("Adminn"), null, "").toString();
                    logger.info("The login page: " + choice);
                    if (password == null) {
                        break;
                    }
                    int ii = 1;

                    if (admin.login(account, password)) {
                        JOptionPane.showMessageDialog(null, "Admin logs in successfully!", "Library Management System",
                                JOptionPane.INFORMATION_MESSAGE);
                        logger.info("The login page: " + choice);
                        while (true) {
                            String admin_choice = (String) JOptionPane.showInputDialog(null,
                                    "Please choose one of the following: ", "Library Management System",
                                    JOptionPane.QUESTION_MESSAGE, icons.get("Adminn"), e, e[0]);

                            if (admin_choice.equals("Logout")) {
                                JOptionPane.showMessageDialog(null, "Logout successfully!",
                                        "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                logger.info("The login page: " + choice);
                                break;
                            }
                            if (admin_choice.equals("Add_book")) {
                                String name = JOptionPane.showInputDialog(null, "Please enter the name of the book: ",
                                        "Library Management System", JOptionPane.QUESTION_MESSAGE, icons.get("Add_bookss"), null, "")
                                        .toString();
                                if (name.equals("") || name.equals(" ")) {
                                    JOptionPane.showMessageDialog(null, "Please enter the name of the book!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    logger.info("The login page: " + choice);
                                    continue;
                                }
                                String author = JOptionPane.showInputDialog(null,
                                        "Please enter the author of the book: ",
                                        "Library Management System", JOptionPane.QUESTION_MESSAGE, icons.get("Add_bookss"), null, "")
                                        .toString();
                                if (author.equals("") || name.equals(" ")) {
                                    JOptionPane.showMessageDialog(null, "Please enter the author of the book!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    logger.info("The login page: " + choice);
                                    continue;
                                }
                                String publisher = JOptionPane.showInputDialog(null,
                                        "Please enter the publisher of the book: ", "Library Management System",
                                        JOptionPane.QUESTION_MESSAGE, icons.get("Add_bookss"), null, "").toString();
                                if (publisher.equals("") || name.equals(" ")) {
                                    JOptionPane.showMessageDialog(null, "Please enter the publisher of the book!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    continue;
                                }
                                String ISBN = JOptionPane.showInputDialog(null, "Please enter the ISBN of the book: ",
                                        "Library Management System", JOptionPane.QUESTION_MESSAGE, icons.get("Add_bookss"), null, "")
                                        .toString();
                                logger.info("The login page: " + choice);
                                if (ISBN.equals("") || name.equals(" ")) {
                                    JOptionPane.showMessageDialog(null, "Please enter the ISBN of the book!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    logger.info("The login page: " + choice);
                                    continue;
                                }
                                String category = (String) JOptionPane.showInputDialog(null,
                                        "Please choose one of the following: ",
                                        "Library Management System", JOptionPane.QUESTION_MESSAGE, icons.get("Add_bookss"), m, m[0]);
                                if (category.equals("")) {
                                    JOptionPane.showMessageDialog(null, "Please choose one of the following!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    logger.info("The login page: " + choice);
                                    continue;
                                }
                                int status = JOptionPane.showOptionDialog(null,
                                        "Please enter the status of the book: ",
                                        "Library Management System", JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.INFORMATION_MESSAGE, icons.get("Add_bookss"), j, j[0]);
                                logger.info("The login page: " + choice);
                                String avd = "";
                                if (status == 0) {
                                    avd = "Available";
                                } else if (status == 1) {
                                    avd = "Unavailable";
                                }

                                admin.add_book(name, author, publisher, Integer.parseInt(ISBN), category, avd);
                                JOptionPane.showMessageDialog(null, "Add successfully!", "Library Management System",
                                        JOptionPane.INFORMATION_MESSAGE);
                                logger.info("Add book successfully!");

                            }
                            if (admin_choice.equals("Delete_book")) {
                                String ISBN = JOptionPane.showInputDialog(null, "Please enter the ISBN of the book: ",
                                        "Library Management System", JOptionPane.QUESTION_MESSAGE, icons.get("Delete_bookss"), null,
                                        "").toString();
                                if (ISBN.equals("") || ISBN.equals(" ")) {
                                    JOptionPane.showMessageDialog(null, "Please enter the ISBN of the book!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    logger.info("The login page: " + choice);
                                    continue;
                                }
                                for (int hu = 0; hu < Admin.books.length; hu++) {
                                    if (Admin.books[hu] != null
                                            && Admin.books[hu].getISBN() == Integer.parseInt(ISBN)) {
                                        admin.delete_book(Integer.parseInt(ISBN));
                                        JOptionPane.showMessageDialog(null, "Delete successfully!",
                                                "Library Management System",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        logger.info("Delete book successfully!");
                                        break;
                                    } else if (Admin.books[hu] == null && hu == Admin.books.length - 1) {
                                        JOptionPane.showMessageDialog(null, "The book does not exist!",
                                                "Library Management System",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        logger.info("The book does not exist!");
                                        break;
                                    }
                                }

                            }
                            if (admin_choice.equals("Update_book")) {

                                String name = JOptionPane.showInputDialog(null, "Please enter the name of the book: ",
                                        "Library Management System", JOptionPane.QUESTION_MESSAGE, icons.get("Update_bookss"), null,
                                        "").toString();
                                if (name.equals("") || name.equals(" ")) {
                                    JOptionPane.showMessageDialog(null, "Please enter the name of the book!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    logger.info("The login page: " + choice);
                                    continue;
                                }
                                for (int yh = 0; yh < Admin.books.length; yh++) {
                                    if (Admin.books[yh] != null && Admin.books[yh].getName().equals(name)) {
                                        String update_choice = (String) JOptionPane.showInputDialog(null,
                                                "Please choose one of the following: ",
                                                "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                icons.get("Update_bookss"), ll,
                                                ll[0]);
                                        logger.info("The login page: " + choice);
                                        if (update_choice.equals("Exit")) {
                                            break;
                                        }
                                        if (update_choice.equals("Author")) {
                                            String author = JOptionPane.showInputDialog(null,
                                                    "Please enter the author of the book: ",
                                                    "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                    icons.get("Update_bookss"),
                                                    null, "").toString();
                                            if (author.equals("") || author.equals(" ")) {
                                                JOptionPane.showMessageDialog(null,
                                                        "Please enter the author of the book!",
                                                        "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                                logger.info("The login page: " + choice);
                                                continue;
                                            }
                                            admin.update_book_author(name, author);
                                            JOptionPane.showMessageDialog(null, "Update successfully!",
                                                    "Library Management System",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                            logger.info("Update book successfully!");
                                            break;
                                        }
                                        if (update_choice.equals("Publisher")) {
                                            String publisher = JOptionPane.showInputDialog(null,
                                                    "Please enter the publisher of the book: ",
                                                    "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                    icons.get("Update_bookss"),
                                                    null, "").toString();
                                            if (publisher.equals("") || publisher.equals(" ")) {
                                                JOptionPane.showMessageDialog(null,
                                                        "Please enter the publisher of the book!",
                                                        "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                                logger.info("The login page: " + choice);
                                                continue;
                                            }
                                            admin.update_book_publisher(name, publisher);
                                            JOptionPane.showMessageDialog(null, "Update successfully!",
                                                    "Library Management System",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                            logger.info("Update book successfully!");
                                            break;
                                        }
                                        if (update_choice.equals("ISBN")) {
                                            String ISBN = JOptionPane
                                                    .showInputDialog(null, "Please enter the ISBN of the book: ",
                                                            "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                            icons.get("Update_bookss"), null, "")
                                                    .toString();
                                            if (ISBN.equals("") || ISBN.equals(" ")) {
                                                JOptionPane.showMessageDialog(null,
                                                        "Please enter the ISBN of the book!",
                                                        "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                                logger.info("The login page: " + choice);
                                                continue;
                                            }
                                            admin.update_book_ISBN(name, Integer.parseInt(ISBN));
                                            JOptionPane.showMessageDialog(null, "Update successfully!",
                                                    "Library Management System",
                                                    JOptionPane.INFORMATION_MESSAGE);
                                            logger.info("Update book successfully!");
                                            break;
                                        }
                                        if (update_choice.equals("Category")) {
                                            String category = (String) JOptionPane.showInputDialog(null,
                                                    "Please choose one of the following: ",
                                                    "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                    icons.get("Update_bookss"), m,
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
                                            logger.info("Update book successfully!");
                                            break;
                                        }
                                        if (update_choice.equals("Status")) {
                                            int status = JOptionPane.showOptionDialog(null,
                                                    "Please enter the status of the book: ",
                                                    "Library Management System", JOptionPane.DEFAULT_OPTION,
                                                    JOptionPane.INFORMATION_MESSAGE, icons.get("Update_bookss"), j, j[0]);
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
                                            logger.info("Update book successfully!");
                                            break;
                                        }
                                    } else if (Admin.books[yh] == null && yh == Admin.books.length - 1) {
                                        JOptionPane.showMessageDialog(null, "The book doesn't exist!",
                                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                        logger.info("The login page: " + choice);
                                        logger.warning("The book doesn't exist!");
                                        break;
                                    }
                                }

                            }
                            if (admin_choice.equals("Check_members")) {
                                String member_account = JOptionPane.showInputDialog(null,
                                        "Please enter the account of the member: ",
                                        "Library Management System", JOptionPane.QUESTION_MESSAGE, icons.get("Check_memberss"), null,
                                        "").toString();
                                logger.info("The login page: " + choice);
                                if (member_account.equals("")) {
                                    JOptionPane.showMessageDialog(null, "Please enter the account of the member!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    logger.info("The login page: " + choice);
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
                                        "Library Management System", JOptionPane.QUESTION_MESSAGE, icons.get("Search_timess"), null,
                                        "").toString();
                                logger.info("The login page: " + choice);
                                if (book_name.equals("") || book_name.equals(" ")) {
                                    JOptionPane.showMessageDialog(null, "Please enter the name of the book!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    logger.info("The login page: " + choice);
                                    continue;
                                }
                                for (int t = 0; t < Admin.books.length; t++) {
                                    if (Admin.books[t] != null && Admin.books[t].getName().equals(book_name)) {
                                        JOptionPane.showMessageDialog(null,
                                                "Searching times: " + Admin.books[t].getsearchCount()
                                                        + "\nBorrowing times: " + Admin.books[t].getTotalBorrowNum(),
                                                "Library Management System", JOptionPane.INFORMATION_MESSAGE,
                                                icons.get("Search_timess"));
                                        logger.info("The login page: " + choice);
                                        break;
                                    }
                                    if (Admin.books[t] == null && t == Admin.books.length - 1) {
                                        JOptionPane.showMessageDialog(null,
                                                "The book doesn't exist!\nPlease try again!",
                                                "Library Management System",
                                                JOptionPane.INFORMATION_MESSAGE);
                                        logger.info("The login page: " + choice);
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
                            logger.info("The login page: " + choice);
                            logger.warning("Wrong account or password!");
                            ii = 0;
                            continue;
                        }

                    }

                }
                if (login_choice.equals("Student")) {
                    account = JOptionPane.showInputDialog(null, "Please enter your account: ",
                            "Library Management System",
                            JOptionPane.QUESTION_MESSAGE, icons.get("Studentt"), null, "").toString();
                    logger.info("The login page: " + choice);
                    if (account == null) {
                        break;
                    }
                    password = JOptionPane.showInputDialog(null, "Please enter your password: ",
                            "Library Management System", JOptionPane.QUESTION_MESSAGE, icons.get("Studentt"), null, "").toString();
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
                            logger.info("The login page: " + choice);
                            while (true) {
                                String student_choice = (String) JOptionPane.showInputDialog(null,
                                        "Please choose one of the following: ", "Library Management System",
                                        JOptionPane.QUESTION_MESSAGE, icons.get("Studentt"), b, b[0]);
                                if (student_choice.equals("Logout")) {
                                    JOptionPane.showMessageDialog(null, "Logout successfully!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    logger.info("The login page: " + choice);
                                    logger.info("Logout successfully!");
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
                                            logger.info("The login page: " + choice);
                                            members[o].setReservee(false);
                                            Admin.books[gh].setUnReserve();
                                            continue;
                                        }
                                    }
                                    String option = (String) JOptionPane.showInputDialog(null,
                                            "Please choose one of the following: ", "Library Management System",
                                            JOptionPane.QUESTION_MESSAGE, icons.get("Borrow_bookss"), l, l[0]);
                                    if (option.equals("Exit")) {
                                        logger.info("The login page: " + choice);
                                        continue;
                                    }
                                    if (option.equals("Name")) {
                                        String name = JOptionPane.showInputDialog(null,
                                                "Please enter the name of the book: ",
                                                "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                icons.get("Borrow_bookss"), null, "").toString();
                                        logger.info("The login page: " + choice);
                                        members[o].borrow_book(name, members[o].getAccount());

                                    }

                                    if (option.equals("Author")) {
                                        String author = JOptionPane.showInputDialog(null,
                                                "Please enter the author of the book: ",
                                                "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                icons.get("Borrow_bookss"), null, "").toString();
                                        logger.info("The login page: " + choice);
                                        members[o].borrow_book_author(author, members[o].getAccount());
                                    }
                                    if (option.equals("Publisher")) {
                                        String publisher = JOptionPane.showInputDialog(null,
                                                "Please enter the publisher of the book: ",
                                                "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                icons.get("Borrow_bookss"), null, "").toString();
                                        logger.info("The login page: " + choice);

                                        members[o].borrow_book_publisher(publisher, members[o].getAccount());
                                    }

                                } else if (student_choice.equals("Return_book")) {
                                    String name = JOptionPane.showInputDialog(null,
                                            "Please enter the name of the book: ",
                                            "Library Management System", JOptionPane.QUESTION_MESSAGE, icons.get("Return_bookss"),
                                            null, "").toString();
                                    logger.info("The login page: " + choice);
                                    if (name.equals("")) {
                                        JOptionPane.showMessageDialog(null, "Please enter the name of the book!",
                                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                        logger.info("The login page: " + choice);
                                        logger.warning("Please enter the name of the book!");
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
                                logger.warning("Wrong account or password!\nPlease try again!");
                                iii = 0;
                                continue;
                            }

                        }

                    }
                }
                if (login_choice.equals("Teacher")) {
                    account = JOptionPane.showInputDialog(null, "Please enter your account: ",
                            "Library Management System",
                            JOptionPane.QUESTION_MESSAGE, icons.get("Teacherr"), null, "").toString();
                    logger.info("The login page: " + choice);
                    if (account == null) {
                        break;
                    }
                    password = JOptionPane.showInputDialog(null, "Please enter your password: ",
                            "Library Management System", JOptionPane.QUESTION_MESSAGE, icons.get("Teacherr"), null, "").toString();
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
                            logger.info("The login page: " + choice);
                            while (true) {
                                String teacher_choice = (String) JOptionPane.showInputDialog(null,
                                        "Please choose one of the following: ", "Library Management System",
                                        JOptionPane.QUESTION_MESSAGE, icons.get("Teacherr"), b, b[0]);
                                if (teacher_choice.equals("Logout")) {
                                    JOptionPane.showMessageDialog(null, "Logout successfully!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    logger.info("The login page: " + choice);
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
                                            logger.info("The login page: " + choice);
                                            members[o].setReservee(false);
                                            Admin.books[gh].setUnReserve();
                                            continue;
                                        }
                                    }
                                    String option = (String) JOptionPane.showInputDialog(null,
                                            "Please choose one of the following: ", "Library Management System",
                                            JOptionPane.QUESTION_MESSAGE, icons.get("Borrow_bookss"), l, l[0]);
                                    if (option.equals("Exit")) {
                                        continue;
                                    }
                                    if (option.equals("Name")) {
                                        String name = JOptionPane.showInputDialog(null,
                                                "Please enter the name of the book: ",
                                                "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                icons.get("Borrow_bookss"), null, "").toString();
                                        logger.info("The login page: " + choice);

                                        members[o].borrow_book(name, members[o].getAccount());

                                    }

                                    if (option.equals("Author")) {
                                        String author = JOptionPane.showInputDialog(null,
                                                "Please enter the author of the book: ",
                                                "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                icons.get("Borrow_bookss"), null, "").toString();
                                        logger.info("The login page: " + choice);

                                        members[o].borrow_book_author(author, members[o].getAccount());
                                    }
                                    if (option.equals("Publisher")) {
                                        String publisher = JOptionPane.showInputDialog(null,
                                                "Please enter the publisher of the book: ",
                                                "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                icons.get("Borrow_bookss"), null, "").toString();
                                        logger.info("The login page: " + choice);

                                        members[o].borrow_book_publisher(publisher, members[o].getAccount());
                                    }

                                } else if (teacher_choice.equals("Return_book")) {
                                    String name = JOptionPane.showInputDialog(null,
                                            "Please enter the name of the book: ",
                                            "Library Management System", JOptionPane.QUESTION_MESSAGE, icons.get("Return_bookss"),
                                            null, "").toString();
                                    logger.info("The login page: " + choice);
                                    if (name.equals("")) {
                                        JOptionPane.showMessageDialog(null, "Please enter the name of the book!",
                                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                        logger.info("The login page: " + choice);
                                        logger.warning("Please enter the name of the book!");
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
                                logger.info("The login page: " + choice);
                                iiii = 0;
                                continue;
                            }

                        }

                    }
                } else if (login_choice.equals("Staff")) {
                    account = JOptionPane.showInputDialog(null, "Please enter your account: ",
                            "Library Management System",
                            JOptionPane.QUESTION_MESSAGE, icons.get("Stafff"), null, "").toString();
                    if (account == null) {
                        break;
                    }
                    password = JOptionPane.showInputDialog(null, "Please enter your password: ",
                            "Library Management System", JOptionPane.QUESTION_MESSAGE, icons.get("Stafff"), null, "").toString();
                    logger.info("The login page: " + choice);
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
                            logger.info("The login page: " + choice);
                            while (true) {
                                String staff_choice = (String) JOptionPane.showInputDialog(null,
                                        "Please choose one of the following: ", "Library Management System",
                                        JOptionPane.QUESTION_MESSAGE, icons.get("Stafff"), b, b[0]);
                                logger.info("The login page: " + choice);
                                if (staff_choice.equals("Logout")) {
                                    JOptionPane.showMessageDialog(null, "Logout successfully!",
                                            "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                    logger.info("The login page: " + choice);
                                    logger.info("Logout successfully!");
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
                                            logger.info("The login page: " + choice);
                                            members[o].setReservee(false);
                                            Admin.books[gh].setUnReserve();
                                            continue;
                                        }
                                    }
                                    String option = (String) JOptionPane.showInputDialog(null,
                                            "Please choose one of the following: ", "Library Management System",
                                            JOptionPane.QUESTION_MESSAGE, icons.get("Borrow_bookss"), l, l[0]);
                                    if (option.equals("Exit")) {
                                        logger.info("The login page: " + choice);
                                        continue;
                                    }
                                    if (option.equals("Name")) {
                                        String name = JOptionPane.showInputDialog(null,
                                                "Please enter the name of the book: ",
                                                "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                icons.get("Borrow_bookss"), null, "").toString();

                                        members[o].borrow_book(name, members[o].getAccount());

                                    }

                                    if (option.equals("Author")) {
                                        String author = JOptionPane.showInputDialog(null,
                                                "Please enter the author of the book: ",
                                                "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                icons.get("Borrow_bookss"), null, "").toString();
                                        logger.info("The login page: " + choice);

                                        members[o].borrow_book_author(author, members[o].getAccount());
                                    }
                                    if (option.equals("Publisher")) {
                                        String publisher = JOptionPane.showInputDialog(null,
                                                "Please enter the publisher of the book: ",
                                                "Library Management System", JOptionPane.QUESTION_MESSAGE,
                                                icons.get("Borrow_bookss"), null, "").toString();
                                        logger.info("The login page: " + choice);

                                        members[o].borrow_book_publisher(publisher, members[o].getAccount());
                                    }

                                } else if (staff_choice.equals("Return_book")) {
                                    String name = JOptionPane.showInputDialog(null,
                                            "Please enter the name of the book: ",
                                            "Library Management System", JOptionPane.QUESTION_MESSAGE, icons.get("Return_bookss"),
                                            null, "").toString();
                                    logger.info("The login page: " + choice);
                                    if (name.equals("")) {
                                        JOptionPane.showMessageDialog(null, "Please enter the name of the book!",
                                                "Library Management System", JOptionPane.INFORMATION_MESSAGE);
                                        logger.info("The login page: " + choice);
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
                                logger.info("The login page: " + choice);
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