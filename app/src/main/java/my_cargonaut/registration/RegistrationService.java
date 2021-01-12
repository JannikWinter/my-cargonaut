package my_cargonaut.registration;

import my_cargonaut.utility.data_classes.user.User;
import my_cargonaut.utility.data_classes.user.UserRegister;

import java.util.Optional;

// TODO: email needs to be saved for the user!

public class RegistrationService {

    private static RegistrationService instance;

    private final UserRegister userRegister;

    private RegistrationService() {
        this.userRegister = UserRegister.getInstance();
    }

    public boolean register(String username, String password, String email) throws IllegalArgumentException {
        User user;
        if(username == null || password == null) {
            throw new IllegalArgumentException("Nutzername und Passwort müsssen ausgefüllt sein");
        }
        user = new User(username, password);
        return userRegister.addNewUser(user);
    }

    public boolean deleteUser(String username) {
        Optional<User> deletedUser = userRegister.deleteUser(username);
        return deletedUser.isPresent();
    }

    public Optional<User> getUser(String uid) {
        return userRegister.getUser(uid);
    }

    public static RegistrationService getInstance() {
        if(RegistrationService.instance == null) {
            RegistrationService.instance = new RegistrationService();
        }
        return RegistrationService.instance;
    }
}
