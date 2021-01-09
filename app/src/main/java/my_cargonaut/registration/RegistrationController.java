package my_cargonaut.registration;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import my_cargonaut.utility.FormManUtils;

import java.util.*;

import static my_cargonaut.utility.SessionManUtils.sessionAttributeRedirect;
import static my_cargonaut.utility.SessionManUtils.sessionAttributeRegisteredUserName;



public class RegistrationController {

    public static Handler handleRegistration = ctx -> {
        RegistrationPage page;
        Map<String, String> map = new HashMap<>();
        String newUsername, email, password, checkPassword;

        Map<String, List<String>> params = ctx.formParamMap();
        Optional<List<String>> optList;
        for(Map.Entry<String, List<String>> entry : params.entrySet()){
            optList = Optional.ofNullable(entry.getValue());
            optList.ifPresentOrElse(list -> map.put(entry.getKey(), list.get(0)), () -> map.put(entry.getKey(), ""));
        }
        newUsername = map.get(FormManUtils.regFormUsername);
        email = map.get(FormManUtils.regFormEmail);
        password = map.get(FormManUtils.regFormPassword);
        checkPassword = map.get(FormManUtils.regFormPassword2);

        if(!password.equals(checkPassword)) {
            // Render registration page with info that passwords didn't match -> SHOULD NOT HAPPEN
            page = new RegistrationPage(ctx);
            page.markRegistrationFailure(map, "Die Passwörter stimmen nicht überein");
            page.render();
            return;
        }
        try {
            if (!RegistrationService.register(newUsername, password, email)) {
                // Render registration page with info that username is already taken
                page = new RegistrationPage(ctx);
                page.markRegistrationFailure(map, "Der gewählte Nutzername ist bereits vergeben");
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
            page.markRegistrationFailure(map, "Bitte füllen Sie alle Felder aus!");
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
