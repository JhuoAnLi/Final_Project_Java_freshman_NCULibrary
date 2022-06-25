public class Staff extends Member {
    public Staff(String name, String account, String password, String identity, int age) {
        super(name, account, password, identity, age);
    }

    public int getDeadlinee() {
        return 14;
    }

    public int getMax_borrow() {
        return 4;
    }

    public int getFine() {
        return 200;
    }
}
