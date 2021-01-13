package my_cargonaut.utility;

import io.javalin.http.Context;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FormManUtils {

    //Login
    public static final String loginForm = "login";
    public static final String loginFormName = "loginName";
    public static final String loginFormPassword = "loginPw";

    public static Map<String, String> createQueryParamMap(Context ctx) {
        return createParamMap(ctx.queryParamMap());
    }

    public static Map<String, String> createFormParamMap(Context ctx) {
        return createParamMap(ctx.formParamMap());
    }

    private static Map<String, String> createParamMap(Map<String, List<String>> params) {
        Map<String, String> map = new HashMap<>();
        Optional<List<String>> optList;
        for(Map.Entry<String, List<String>> entry : params.entrySet()){
            optList = Optional.ofNullable(entry.getValue());
            optList.ifPresentOrElse(list -> map.put(entry.getKey(), list.get(0)), () -> map.put(entry.getKey(), ""));
        }
        return map;
    }

    //"2021-01-10T22:33"
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

    public static Date parseDateFromFromParam(String param) throws ParseException {
        return dateFormat.parse(param);
    }

}
