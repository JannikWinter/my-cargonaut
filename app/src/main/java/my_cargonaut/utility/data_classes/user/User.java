package my_cargonaut.utility.data_classes.user;

import my_cargonaut.utility.data_classes.Vehicle;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

public class User implements java.io.Serializable {

    private Pronoun pronoun;
    private final String username;
    private final UserPassword password;
    private String givenName;
    private String surname;
    private LocalDate dob;
    private String city;
    private String cityPostal;
    private String cellphoneNumber;
    private Vehicle vehicle;


    public User(String name, String password) {
        this.pronoun = Pronoun.Divers;
        this.username = name;
        this.password = new UserPassword(password);
        this.givenName = "Ein neuer";
        this.surname = "Cargonaut";
        this.city = "Beispielstadt";
        this.cityPostal = "12345";
        this.cellphoneNumber = "+49 111 11111";
        this.vehicle = new Vehicle();
    }

    public String getUsername() {
        return username;
    }
    public UserPassword getPassword() {
        return password;
    }
    public Pronoun getPronoun() {
        return pronoun;
    }
    public String getGivenName() {
        return givenName;
    }
    public String getSurname() {
        return surname;
    }
    public LocalDate getDob() {
        return dob;
    }
    public String getCity() {
        return city;
    }
    public String getCityPostal() {
        return cityPostal;
    }
    public Vehicle getVehicle() { return vehicle; }
    public String getCellphoneNumber() {
        return cellphoneNumber;
    }
    public void updateProfileInformation(String pronoun, String givenName, String surname,
                                         String city, String cityPostal,
                                         String cellphoneNumber){
        this.pronoun = Pronoun.valueOf(pronoun);
        this.givenName = givenName;
        this.surname = surname;
        this.city = city;
        this.cityPostal = cityPostal;
        this.cellphoneNumber = cellphoneNumber;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getPronoun() == user.getPronoun() && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getGivenName(), user.getGivenName()) && Objects.equals(getSurname(), user.getSurname()) && Objects.equals(getDob(), user.getDob()) && Objects.equals(getCity(), user.getCity()) && Objects.equals(getCityPostal(), user.getCityPostal()) && Objects.equals(getCellphoneNumber(), user.getCellphoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPronoun(), getUsername(), getPassword(), getGivenName(), getSurname(), getDob(), getCity(), getCityPostal(), getCellphoneNumber());
    }
}
