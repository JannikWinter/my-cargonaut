package my_cargonaut.login;


import io.javalin.http.Context;
import io.javalin.http.Handler;
import my_cargonaut.Page;
import my_cargonaut.landing.LandingPage;
import my_cargonaut.utility.FormManUtils;

import static my_cargonaut.utility.SessionManUtils.sessionAttributeLoggedInUsername;

public class LoginController {

    // TODO: Ensure login for "Gesuche erstellen", "Deal abschließen"

    public static Handler clearSessionOnLogOut = ctx -> {

        System.out.println((String)ctx.sessionAttribute(sessionAttributeLoggedInUsername));
        //if(ctx.pathParam("status").)
    };

    public static Handler handleLogout = ctx -> {
        ctx.sessionAttribute(sessionAttributeLoggedInUsername, null);
        //TODO: Maybe use ctx.path() here? So a user would be redirected to the page they were on
        ctx.redirect(LandingPage.PATH);
    };

    public static Page checkLoginPostFromEverywhere(Page page, Context ctx) {
        String username = ctx.formParam(FormManUtils.loginFormName);
        String password = ctx.formParam(FormManUtils.loginFormPassword);

        try {
            if (!LoginService.authenticate(username, password)) {
                return page.markAuthentificationFailure("Falsches Passwort");
            } else {
                ctx.sessionAttribute(sessionAttributeLoggedInUsername, username);
                return page.markAuthentificationSuccess();
            }
        } catch(IllegalArgumentException e) {
            return page.markAuthentificationFailure(e.getMessage());
        }
    }
}
