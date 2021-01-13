package my_cargonaut.profile.edit;

import io.javalin.http.Handler;
import my_cargonaut.landing.NotFoundPage;
import my_cargonaut.login.LoginController;
import my_cargonaut.utility.FormManUtils;
import my_cargonaut.utility.SessionManUtils;
import my_cargonaut.utility.data_classes.user.User;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

public class EditProfileController {

    public static Handler serveEditProfilePage = ctx -> {
        EditPage page = new EditPage(ctx);
        // is fine as we should only be able to access this page while logged in (as in: there's a User in the Optional)
        page.render();
    };

    public static Handler handleEditprofilePagePost = ctx -> {
        EditPage page = new EditPage(ctx);
        Map<String, String> map = FormManUtils.createFormParamMap(ctx);
        User currentUser = page.getCurrentUser().orElseThrow(IllegalStateException::new);

        currentUser.updateProfileInformation(
                map.get(EditPage.ProfileEPronoun),
                map.get(EditPage.ProfileEName),
                map.get(EditPage.ProfileESurname),
                map.get(EditPage.ProfileECity),
                map.get(EditPage.ProfileEPLZ),
                map.get(EditPage.ProfileECellPhone)
        );

        page = (EditPage) LoginController.checkLoginPost(page, ctx);
        page.render();
    };


    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // copypasted from: https://www.baeldung.com/java-date-to-localdate-and-localdatetime
    private static LocalDate convertDateToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static Date parseDateFromFromParam(String param) throws ParseException {
        return dateFormat.parse(param);
    }
}
