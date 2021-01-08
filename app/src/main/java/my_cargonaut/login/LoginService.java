package my_cargonaut.login;

import my_cargonaut.user.User;
import my_cargonaut.user.UserRegister;

import java.util.Optional;

public class LoginService {

    private static final UserRegister userRegister = UserRegister.getInstance();

    public static boolean authenticate(String username, String password) throws IllegalArgumentException {
        Optional<User> maybeUser;
        User user;
        if(username == null || password == null) {
            throw new IllegalArgumentException("Both parameters need to be non-null!");
        }
        maybeUser = userRegister.getUser(username);
        if(maybeUser.isEmpty()) {
            throw new IllegalArgumentException("User does not exist");
        }
        user = maybeUser.get();
        return password.equals(user.getPassword().getPw());
    }
}
