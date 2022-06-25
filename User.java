public class User {
    protected String name;
    protected String account;
    protected String password;
    public User(String name, String account, String password) {
        setName(name);
        setAccount(account);
        setPassword(password);  

    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public String getAccount() {
        return account;
    }
    public String getPassword() {
        return password;
    }
}
