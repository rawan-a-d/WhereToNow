package service.resources;

import service.controller.UserController;
import service.model.User;
import service.model.Guardian;
import service.repository.WhereToNowDatabaseException;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

@Path("users")
public class UserResources {
    UserController userController = new UserController();

    @GET //GET at http://localhost:9090/WhereToNow/users/test
    @Path("")
    public Response testing() throws URISyntaxException, WhereToNowDatabaseException, SQLException {
        List<User> users = userController.getAllUsers();
        return Response.ok(users).build();
    }

    @GET //GET at http://localhost:9090/WhereToNow/users/1/guardians
    @Path("{id}/guardians")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGuardians(@PathParam("id") int id) {
        List<Guardian> allGuardians = userController.getAllGuardians(id);

        GenericEntity<List<Guardian>> entity = new GenericEntity<List<Guardian>>(allGuardians) {  };
        return Response.ok(entity).build();
    }

    @GET //GET at http://localhost:9090/WhereToNow/users/1
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByID(@PathParam("id") int id) {
        User user = userController.getUser(id);

        return Response.ok(user).build();
    }
}
