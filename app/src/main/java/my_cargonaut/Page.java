package my_cargonaut;

import io.javalin.http.Context;

import java.util.Collections;
import java.util.Optional;

public abstract class Page {

    protected final Context ctx;

    private String currentUser;
    private boolean hasAuthorizationFailed;
    private String errorMsg;

    public Page(Context ctx) {
        this.ctx = ctx;
        this.hasAuthorizationFailed = false;
        this.currentUser = ctx.sessionAttribute("username");
    }

    public abstract String getTemplate();

    public Optional<String> getCurrentUser() {
        if(currentUser == null) {
            currentUser = ctx.sessionAttribute("currentUser");
        }
        return Optional.ofNullable(currentUser);
    }

    public void setLoggedInUser(String username) {
        ctx.sessionAttribute("username", username);
        this.currentUser = ctx.sessionAttribute("username");
    }

    public String removeLoggedInUser() {
        String curUser = this.currentUser;
        currentUser = null;
        ctx.sessionAttribute("currentUser", null);
        return curUser;
    }

    public boolean isUserLoggedIn() {
        return getCurrentUser().isPresent();
    }

    public Page markAuthentificationFailure() {
        this.hasAuthorizationFailed = true;
        return this;
    }

    public boolean hasAuthorizationFailed() {
        return this.hasAuthorizationFailed;
    }

    public Optional<String> getErrorMsg() {
        return Optional.ofNullable(errorMsg);
    }

    public Page setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public void render() {
        ctx.render(getTemplate(), Collections.singletonMap("page", this));
    }
}
