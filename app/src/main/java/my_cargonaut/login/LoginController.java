package my_cargonaut.login;


import io.javalin.http.Context;
import io.javalin.http.Handler;
import my_cargonaut.Page;

public class LoginController {

    // TODO: Ensure login for "Gesuche erstellen", "Deal abschließen"

    public static Handler clearSessionOnLogOut = ctx -> {

        //if(ctx.pathParam("status").)
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
