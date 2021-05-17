package service.controller;

import service.model.Trip;
import service.repository.TripRepository;
import service.repository.WhereToNowDatabaseException;

import java.util.List;
import java.util.logging.Logger;

public class TripController {
    private final static Logger LOGGER = Logger.getLogger(TripController.class.getName());

    TripRepository tripRepository = new TripRepository();

    public Trip getTrip(int id) {
        Trip trip = null;
        try {
            System.out.println("getTrip Controller");
            trip = tripRepository.getTrip(id);
            System.out.println("TRIP controller "+ trip);
        }
        catch (WhereToNowDatabaseException ex) {
            LOGGER.info(ex.getMessage());
        }
        return trip;
    }

    public List<Trip> getTrips(String from, String to) {
        List<Trip> trips = null;
        try {
            trips = tripRepository.getTrips(from, to);
        }
        catch (WhereToNowDatabaseException ex) {
            LOGGER.info(ex.getMessage());
        }
        return trips;
    }
}
