package my_cargonaut.utility.data_classes.user;



import java.util.HashMap;
import java.util.Optional;

public class UserRegister implements java.io.Serializable {

    private static UserRegister instance;

    private final HashMap<String, User> registeredUsers;

    private UserRegister() {
        this.registeredUsers = new HashMap<>();
    }

    public static UserRegister getInstance() {
        if(UserRegister.instance == null) {
            UserRegister.instance = new UserRegister();
        }
        return instance;
    }

    public Optional<User> getUser(String username) {
        return Optional.ofNullable(registeredUsers.get(username));
    }

    public boolean addNewUser(User user) {
        String username = user.getUsername();
        if(registeredUsers.containsKey(username)) {
            return false;
        }
        registeredUsers.put(user.getUsername(), user);
        return true;
    }

    public Optional<User> deleteUser(String username) {
        return Optional.ofNullable(registeredUsers.remove(username));
    }
}
