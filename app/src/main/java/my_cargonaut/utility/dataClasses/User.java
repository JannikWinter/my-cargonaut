package my_cargonaut.utility.dataClasses;

public class User {

    private final String username;
    private UserPassword pw;

    public User(String name, String pw) {
        this.username = name;
        this.pw = new UserPassword(pw);
    }

    public String getUsername() {
        return username;
    }

    public UserPassword getPassword() {
        return pw;
    }
}
