package my_cargonaut.utility;

import my_cargonaut.utility.data_classes.offers.OfferPool;
import my_cargonaut.utility.data_classes.user.UserRegister;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Storage {

    private static final String userRegisterLoc = "data/userRegister.ser";
    private static final String offerPoolLoc = "data/offerPool.ser";

    public static void saveData() throws IOException {
        try {
            UserRegister userRegister = UserRegister.getInstance();
            OfferPool offerPool = OfferPool.getInstance();
            writeFile(userRegisterLoc, userRegister);
            writeFile(offerPoolLoc, offerPool);

        } catch ( FileNotFoundException i) {
            i.printStackTrace();
        }
    }

    public static void initializeData() {
        UserRegister userRegister = UserRegister.getInstance();
        OfferPool offerPool = OfferPool.getInstance();

        UserRegister tmpUserRegister;
        OfferPool tmpOfferPool;


    }

    private static void writeFile(String filename, Object obj) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(obj);
        out.close();
        fileOut.close();
    }
}
