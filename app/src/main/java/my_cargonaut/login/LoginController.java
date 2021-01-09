package my_cargonaut.login;


import io.javalin.http.Context;
import io.javalin.http.Handler;
import my_cargonaut.Page;
import my_cargonaut.landing.LandingPage;

public class LoginController {

    // TODO: Ensure login for "Gesuche erstellen", "Deal abschließen"

    public static Handler clearSessionOnLogOut = ctx -> {

        System.out.println((String)ctx.sessionAttribute("username"));
        //if(ctx.pathParam("status").)
    };

    public static Handler handleLogout = ctx -> {
        ctx.sessionAttribute("username", null);
        ctx.redirect(LandingPage.PATH);
    };

    public static Page checkLoginPostFromEverywhere(Page page, Context ctx) {
        String username = ctx.formParam("email");
        String password = ctx.formParam("password");

        try {
            if (!LoginService.authenticate(username, password)) {
                return page.markAuthentificationFailure();
            } else {
                page.setLoggedInUser(username);
            }
        } catch(IllegalArgumentException e) {
            return page.markAuthentificationFailure().setErrorMsg(e.getMessage());
        }
        return page;
    }
}
