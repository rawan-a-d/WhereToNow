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

    //private static final URI BASE_URI = URI.create("http://localhost:9090/WhereToNow/");
    //private static final URI BASE_URI = URI.create("http://0.0.0.0:9090/WhereToNow/");
    //private static final URI BASE_URI = URI.create("https://where-to-now.herokuapp.com/");

    // https://stackoverflow.com/questions/57825797/how-to-deploy-a-jersey-rest-server-to-heroku

    static String defaultPort = "9091";

    final static String port = System.getenv("PORT") != null ? System.getenv("PORT"): defaultPort;

    final static URI BASE_URI = URI.create("http://0.0.0.0:" + port);

    public static void main(String[] args) throws IOException {

        try {
            System.out.println("PORT ********* " + BASE_URI);
            service.CustomApplicationConfig customApplicationConfig = new service.CustomApplicationConfig();
            // create and start a grizzly server
            HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, customApplicationConfig, true);
        } catch (Exception ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
