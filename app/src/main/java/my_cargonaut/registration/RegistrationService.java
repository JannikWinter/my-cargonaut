package my_cargonaut.registration;

import my_cargonaut.user.User;
import my_cargonaut.user.UserRegister;

import java.util.Date;
import java.util.Optional;

// TODO: email needs to be saved for the user!

public class RegistrationService {

    private static final UserRegister userRegister = UserRegister.getInstance();

    public static boolean register(String username, String password, String email) throws IllegalArgumentException {
        User user;
        if(username == null || password == null) {
            throw new IllegalArgumentException("Nutzername und Passwort müsssen ausgefüllt sein");
        }
        user = new User(username, password);
        return userRegister.addNewUser(user);
    }

    public static boolean deleteUser(String username) {
        Optional<User> deletedUser = userRegister.deleteUser(username);
        return deletedUser.isPresent();
    }
}
