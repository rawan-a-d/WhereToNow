package service.resources;

import service.controller.TripController;
import service.model.Trip;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/trips")
public class TripResources {

    @Context
    private UriInfo uriInfo;

    private final TripController tripController = new TripController();

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrip(@PathParam("id") int id) {
        Trip trip = tripController.getTrip(id);

        if(trip != null) {
            return Response.ok(trip).build();
        }
        else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Please provide a valid trip id").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrips(@QueryParam("from") String from, @QueryParam("to") String to) {
        List<Trip> trips = tripController.getTrips(from, to);

        GenericEntity<List<Trip>> entity = new GenericEntity<List<Trip>>(trips){ };
        return Response.ok(entity).build();
    }
}
