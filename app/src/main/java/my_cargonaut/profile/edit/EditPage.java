package my_cargonaut.profile.edit;

import io.javalin.http.Context;
import my_cargonaut.utility.ProfileEditPage;

public class EditPage extends ProfileEditPage {
    public static final String PATH = "/";
    private final String templateFilePath;


    public EditPage(Context ctx){
        super(ctx);
        //TODO add Filepath
        templateFilePath="";
    }

    @Override
    public String getTemplate(){
        return templateFilePath;
    }
}
