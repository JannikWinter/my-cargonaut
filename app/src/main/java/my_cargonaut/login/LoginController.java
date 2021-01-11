package my_cargonaut.login;


import io.javalin.http.Context;
import io.javalin.http.Handler;
import my_cargonaut.Page;
import my_cargonaut.landing.LandingPage;
import my_cargonaut.utility.FormManUtils;

import java.util.Map;

import static my_cargonaut.utility.SessionManUtils.sessionAttributeLoggedInUsername;

public class LoginController {

    private static final LoginService loginService = LoginService.getInstance();

    public static Handler handleLogout = ctx -> {
        ctx.sessionAttribute(sessionAttributeLoggedInUsername, null);
        //TODO: Maybe use ctx.path() here? So a user would be redirected to the page they were on
        ctx.redirect(LandingPage.PATH);
    };

    public static Page checkLoginPost(Page page, Context ctx) {
        String username;
        String password;

        Map<String, String> map = FormManUtils.createFormParamMap(ctx);

        if(map.containsKey(FormManUtils.loginFormName) && map.containsKey(FormManUtils.loginFormPassword)) {
            username = map.get(FormManUtils.loginFormName);
            password = map.get(FormManUtils.loginFormPassword);
            try {
                if (!loginService.authenticate(username, password)) {
                    return page.markAuthentificationFailure("Falsches Passwort");
                } else {
                    ctx.sessionAttribute(sessionAttributeLoggedInUsername, username);
                    return page.markAuthentificationSuccess();
                }
            } catch (IllegalArgumentException e) {
                return page.markAuthentificationFailure(e.getMessage());
            }
        }

        // if no login was attempted
        return page;
    }
}
