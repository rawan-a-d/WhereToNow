package service;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class deploys CustomApplicationConfig on a Grizzly server
 */
class Publisher {

    private static final URI BASE_URI = URI.create("http://localhost:9090/WhereToNow/");

    public static void main(String[] args) throws IOException {

        try {
            CustomApplicationConfig customApplicationConfig = new CustomApplicationConfig();
            // create and start a grizzly server
            HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, customApplicationConfig, true);

            //books get URLs
            String[] getOperations = {
                    BASE_URI.toURL() + "user?name=Ranim", // filter users with name Ranim
                    BASE_URI.toURL() + "trip?userId=2", //show tripe with user_id = 2

            };
            for (String getOperation : getOperations) {
                System.out.println(getOperation);
            }

        } catch (IOException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
