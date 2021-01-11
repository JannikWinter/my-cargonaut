package my_cargonaut;

import io.javalin.http.Context;

import java.util.Collections;
import java.util.Optional;

import static my_cargonaut.utility.SessionManUtils.*;

public abstract class Page {

    protected final Context ctx;
    protected boolean hideNavBarNavigation;
    protected boolean isNotAccessRestricted;

    private String currentUser;
    private boolean wasAuthorizationAttempted;
    private boolean hasAuthorizationSucceeded;
    private String loginErrorMsg;

    //private String newlyRegisteredUser;

    public Page(Context ctx) {
        this.ctx = ctx;
        this.wasAuthorizationAttempted = false;
        this.hasAuthorizationSucceeded = false;
        this.currentUser = ctx.sessionAttribute(sessionAttributeLoggedInUsername);
        this.hideNavBarNavigation = false;
        this.isNotAccessRestricted = true;
        /*
        // TODO: Delete if registration works as intended
        Optional<String> tmp = Optional.ofNullable(ctx.sessionAttribute(sessionAttributeRegisteredUserName));
        if(tmp.isPresent()) {
            this.newlyRegisteredUser = tmp.get();
            RegistrationController.cleanSessionFromRegistrationClutter(ctx);
        } else {
            this.newlyRegisteredUser = null;
        }
         */

    }

    public abstract String getTemplate();

    public Optional<String> getCurrentUser() {
        return Optional.ofNullable(currentUser);
    }

    public void updateLoggedInUser() {
        this.currentUser = ctx.sessionAttribute(sessionAttributeLoggedInUsername);
    }

    /*
    public Optional<String> getNewlyRegisteredUser() {
        return Optional.ofNullable(newlyRegisteredUser);
    }
     */

    public boolean isUserLoggedIn() {
        return getCurrentUser().isPresent();
    }

    public Page markAuthentificationSuccess() {
        this.wasAuthorizationAttempted = true;
        this.hasAuthorizationSucceeded = true;
        updateLoggedInUser();
        return this;
    }

    public Page markAuthentificationFailure(String errorMsg) {
        this.wasAuthorizationAttempted = true;
        this.hasAuthorizationSucceeded = false;
        this.loginErrorMsg = errorMsg;
        return this;
    }

    public boolean wasAuthorizationAttempted() {
        return wasAuthorizationAttempted;
    }

    public boolean hasAuthorizationSucceeded() {
        return wasAuthorizationAttempted && hasAuthorizationSucceeded;
    }

    public Optional<String> getLoginErrorMsg() {
        return Optional.ofNullable(loginErrorMsg);
    }

    public boolean hideNavBarNavigation() {
        return this.hideNavBarNavigation;
    }

    public boolean hasAccess() {
        return this.isNotAccessRestricted || isUserLoggedIn();
    }

    public void render() {
        ctx.render(getTemplate(), Collections.singletonMap("page", this));
    }
}
