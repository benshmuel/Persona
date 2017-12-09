package ServerPackage;

import HandlerPackage.Welcome;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;


/**
 * Created by benshmuel on 22/11/2017.
 */
public class Main {

    private final static String PERSONA_ADMIN_SDK ="persona-tech-firebase-adminsdk-6bqub-4ed83752b0.json";

    public static void main(String[] args) throws FileNotFoundException {


        //working on DB is below //


        System.out.println("Server is Started");
//        FileInputStream serviceAccount = new FileInputStream(PERSONA_ADMIN_SDK);
//
//        FirebaseOptions options = null;
//        try {
//            options = new FirebaseOptions.Builder()
//                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                    .setDatabaseUrl("https://persona-tech.firebaseio.com/")
//                    .build();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        FirebaseApp.initializeApp(options);
//
//        // getting FireB3ase Database reference
//        FirebaseDatabase myRef = FirebaseDatabase.getInstance();






        // starting to listen to clients //

        try(ServerSocket serverSocket = new ServerSocket(8080)) {
            while(true) {
                new Welcome(serverSocket.accept()).start();
            }


        } catch(IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }


}
