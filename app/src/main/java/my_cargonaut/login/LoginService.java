package my_cargonaut.login;

import my_cargonaut.utility.data_classes.user.User;
import my_cargonaut.utility.data_classes.user.UserRegister;

import java.util.Optional;

public class LoginService {

    private static LoginService instance;

    private final UserRegister userRegister;

    private LoginService() {
        userRegister = UserRegister.getInstance();
    }

    public boolean authenticate(String username, String password) throws IllegalArgumentException {
        Optional<User> maybeUser;
        User user;
        if(username == null && password == null) {
            throw new IllegalArgumentException("Nutzername und Passwort müssen ausgefüllt sein");
        } else if(username == null) {
            throw new IllegalArgumentException("Nutzername muss ausgefüllt sein");
        } else if (password == null) {
            throw new IllegalArgumentException("Passwort muss ausgefüllt sein");
        }
        maybeUser = userRegister.getUser(username);
        if(maybeUser.isEmpty()) {
            throw new IllegalArgumentException("Der Nutzer " + username + " existiert nicht");
        }
        user = maybeUser.get();
        return password.equals(user.getPassword().getPw());
    }

    public static LoginService getInstance() {
        if(LoginService.instance == null) {
            LoginService.instance = new LoginService();
        }
        return LoginService.instance;
    }
}
