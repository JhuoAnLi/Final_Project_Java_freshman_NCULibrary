package src;
public class Teacher extends Member {
    public Teacher(String name, String account, String password, String identity, int age) {
        super(name, account, password, identity, age);
    }

    public int getDeadlinee() {
        return 12;
    }

    public int getMax_borrow() {
        return 3;
    }

    public int getFine() {
        return 150;
    }
}
