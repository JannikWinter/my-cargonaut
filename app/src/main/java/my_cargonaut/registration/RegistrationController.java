package my_cargonaut.registration;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import my_cargonaut.utility.FormManUtils;

import java.util.*;

import static my_cargonaut.utility.SessionManUtils.sessionAttributeRedirect;
import static my_cargonaut.utility.SessionManUtils.sessionAttributeRegisteredUserName;



public class RegistrationController {

    private static final RegistrationService registrationService = RegistrationService.getInstance();

    public static Handler handleRegistration = ctx -> {
        RegistrationPage page;
        Map<String, String> map = FormManUtils.createFormParamMap(ctx);
        String newUsername, email, password, checkPassword;

        newUsername = map.get(RegistrationPage.regFormUsername);
        email = map.get(RegistrationPage.regFormEmail);
        password = map.get(RegistrationPage.regFormPassword);
        checkPassword = map.get(RegistrationPage.regFormPassword2);

        if(!password.equals(checkPassword)) {
            // Render registration page with info that passwords didn't match -> SHOULD NOT HAPPEN
            page = new RegistrationPage(ctx);
            page.markRegistrationFailure(map, "Die Passwoerter stimmen nicht ueberein");
            page.render();
            return;
        }
        try {
            if (!registrationService.register(newUsername, password, email)) {
                // Render registration page with info that username is already taken
                page = new RegistrationPage(ctx);
                page.markRegistrationFailure(map, "Der gewaehlte Nutzername ist bereits vergeben");
                page.render();
            } else {
                // Render registration page with success information
                page = new RegistrationPage(ctx);
                page.markRegistrationSuccess(map);
                page.render();
                /*
                ctx.sessionAttribute(sessionAttributeRegisteredUserName, newUsername);
                String path = ctx.sessionAttribute(sessionAttributeRedirect);
                ctx.redirect(path == null ? LandingPage.PATH : path);
                 */
            }
        } catch(IllegalArgumentException e) {
            // Render registration page with info that all fields need to be filled -> SHOULD NOT HAPPEN
            page = new RegistrationPage(ctx);
            page.markRegistrationFailure(map, "Bitte fuellen Sie alle Felder aus!");
            page.render();
        }

    };

    public static Handler serveRegistrationPage = ctx -> {
        String path = ctx.path();
        ctx.sessionAttribute(sessionAttributeRedirect, ctx.path());
        RegistrationPage page = new RegistrationPage(ctx);
        page.render();
    };

    public static void cleanSessionFromRegistrationClutter(Context ctx) {
        ctx.sessionAttributeMap().remove(sessionAttributeRegisteredUserName);
        ctx.sessionAttributeMap().remove(sessionAttributeRedirect);
    }
}
