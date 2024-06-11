package object;


public class Student extends Member {
    public Student(String name, String account, String password, String identity, int age) {
        super(name, account, password, identity, age);
    }

    public int getDeadlinee() {
        return 10;
    }

    public int getMax_borrow() {
        return 2;
    }

    public int getFine() {
        return 100;
    }

}
