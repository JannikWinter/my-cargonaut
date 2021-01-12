package my_cargonaut.utility.data_classes.user;
//TODO Delete?
public class UserPassword implements java.io.Serializable {
    private String pw;

    public UserPassword(String pw) {
        this.pw = pw;
    }

    public String getPw() {
        return pw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPassword that = (UserPassword) o;

        return pw.equals(that.pw);
    }

    @Override
    public int hashCode() {
        return pw.hashCode();
    }
}
