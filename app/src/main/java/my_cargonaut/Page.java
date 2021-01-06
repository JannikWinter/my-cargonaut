package my_cargonaut;

import io.javalin.http.Context;

import java.util.Collections;
import java.util.Optional;

public abstract class Page {

    protected final Context ctx;

    private String currentUser;

    public Page(Context ctx) {
        this.ctx = ctx;
    }

    public abstract String getTemplate();

    public Optional<String> getCurrentUser() {
        if(currentUser == null) {
            currentUser = ctx.sessionAttribute("currentUser");
        }
        return Optional.ofNullable(currentUser);
    }

    public boolean isUserLoggedIn() {
        return getCurrentUser().isPresent();
    }

    public void render() {
        ctx.render(getTemplate(), Collections.singletonMap("page", this));
    }
}
