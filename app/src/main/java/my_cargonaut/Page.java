package my_cargonaut;

import io.javalin.http.Context;
import my_cargonaut.utility.SessionManUtils;
import my_cargonaut.utility.data_classes.user.User;

import java.util.Collections;
import java.util.Optional;

import static my_cargonaut.utility.SessionManUtils.*;

public abstract class Page {

    public static final String ERROR_PATH = "404error";

    protected final Context ctx;
    protected boolean hideNavBarNavigation;
    protected boolean pageIsNotAccessRestricted;

    private String currentUserName;
    private User currentUser;
    private boolean wasAuthorizationAttempted;
    private boolean hasAuthorizationSucceeded;
    private String loginErrorMsg;

    //private String newlyRegisteredUser;

    public Page(Context ctx) {
        this.ctx = ctx;
        this.wasAuthorizationAttempted = false;
        this.hasAuthorizationSucceeded = false;
        this.hideNavBarNavigation = false;
        this.pageIsNotAccessRestricted = true;

        SessionManUtils.getUserInSession(ctx).ifPresentOrElse(user -> {
            this.currentUserName = user.getUsername();
            this.currentUser = user;
        }, () -> {
            this.currentUserName = null;
            this.currentUser = null;
        });
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

    public Optional<String> getCurrentUserName() {
        return Optional.ofNullable(currentUserName);
    }

    public Optional<User> getCurrentUser() { return Optional.ofNullable(currentUser); }

    public void updateLoggedInUser() {
        this.currentUserName = ctx.sessionAttribute(sessionAttributeLoggedInUsername);
    }

    /*
    public Optional<String> getNewlyRegisteredUser() {
        return Optional.ofNullable(newlyRegisteredUser);
    }
     */

    public boolean isUserLoggedIn() {
        return getCurrentUserName().isPresent();
    }

    public Page markAuthentificationSuccess(User user) {
        this.wasAuthorizationAttempted = true;
        this.hasAuthorizationSucceeded = true;
        this.currentUser = user;
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
        return this.pageIsNotAccessRestricted || isUserLoggedIn();
    }

    public void render() {
        ctx.render(getTemplate(), Collections.singletonMap("page", this));
    }
}
