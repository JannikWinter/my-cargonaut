package my_cargonaut.utility.data_classes.user;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;
        return pw.equals(user.pw);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + pw.hashCode();
        return result;
    }
}
