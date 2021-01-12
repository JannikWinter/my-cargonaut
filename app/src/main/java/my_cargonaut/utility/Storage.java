package my_cargonaut.utility;

import my_cargonaut.utility.data_classes.offers.OfferPool;
import my_cargonaut.utility.data_classes.user.UserRegister;

import java.io.*;

public class Storage {

    public static final String userRegisterLoc = "data/userRegister.ser";
    public static final String offerPoolLoc = "data/offerPool.ser";

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

    public static void initializeData() throws IOException, ClassNotFoundException {
        UserRegister userRegister = UserRegister.getInstance();
        OfferPool offerPool = OfferPool.getInstance();


        UserRegister tmpUserRegister = (UserRegister) readFile(userRegisterLoc);
        OfferPool tmpOfferPool = (OfferPool) readFile(offerPoolLoc);

        tmpOfferPool.filterOffers(tmpOfferPool.getOfferFilter()).forEach(offer -> {
            userRegister.addNewUser(offer.getUser());
            offerPool.addOffer(offer);
        });

        tmpUserRegister.getUsers().forEach(userRegister::addNewUser);
    }

    private static void writeFile(String filename, Object obj) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(obj);
        out.close();
        fileOut.close();
    }

    private static Object readFile(String filename) throws IOException, ClassNotFoundException {
        Object o;
        FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        o = in.readObject();
        in.close();
        fileIn.close();
        return o;
    }
}
