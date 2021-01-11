package my_cargonaut.registration;

import io.javalin.http.Context;
import my_cargonaut.Page;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RegistrationPage extends Page {

    public static final String PATH = "/register";

    // Registration Form
    public static final String regForm = "registration";
    public static final String regFormUsername = "registerName";
    public static final String regFormEmail = "registerMail";
    public static final String regFormPassword = "registerPw";
    public static final String regFormPassword2 = "registerPw2";

    private boolean hasRegistrationSucceeded;
    private boolean registrationAttempted;
    private String registrationErrorMsg;
    private String enteredUserName, enteredMail, enteredPassword, enteredPassword2;

    public RegistrationPage(Context ctx) {
        super(ctx);
        Map<String, List<String>> params = ctx.formParamMap();

        this.hideNavBarNavigation = true;
        this.registrationAttempted = false;
        this.hasRegistrationSucceeded = false;
    }

    public RegistrationPage markRegistrationFailure(Map<String, String> params, String errorMsg) {
        this.registrationAttempted = true;
        this.hasRegistrationSucceeded = false;
        this.registrationErrorMsg = errorMsg;
        addFormParamValues(params);
        return this;
    }

    public RegistrationPage markRegistrationSuccess(Map<String, String> params) {
        this.registrationAttempted = true;
        this.hasRegistrationSucceeded = true;
        this.registrationErrorMsg = null;
        addFormParamValues(params);
        return this;
    }

    private void addFormParamValues(Map<String, String> params) {
        enteredUserName = params.get(regFormUsername);
        enteredMail = params.get(regFormEmail);
        enteredPassword = params.get(regFormPassword);
        enteredPassword2 = params.get(regFormPassword2);
    }

    public boolean wasRegistrationAttempted() {
        return registrationAttempted;
    }

    public boolean hasRegistrationSucceeded() {
        return hasRegistrationSucceeded;
    }

    public String getEnteredUsername() { return Optional.ofNullable(enteredUserName).orElse(""); }

    public String getEnteredMail() { return Optional.ofNullable(enteredMail).orElse(""); }

    public String getEnteredPw() { return Optional.ofNullable(enteredPassword).orElse(""); }

    public String getEnteredPw2() { return Optional.ofNullable(enteredPassword2).orElse(""); }

    public String getRegistrationErrorMsg() { return Optional.ofNullable(registrationErrorMsg).orElse("Unbekannter Registrierungsfehler"); }

    @Override
    public String getTemplate() {
        return "registration/registration.jte";
    }
}
