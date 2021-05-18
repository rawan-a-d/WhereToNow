package service.repository;

import service.model.Trip;
import service.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TripRepository {
    JDBCRepository jdbcRepository;

    public TripRepository() {
        this.jdbcRepository = new JDBCRepository();
    }

    /***
     *
     * @param id
     * @return a trip
     * @throws WhereToNowDatabaseException
     */
    public Trip getTrip(int id) throws WhereToNowDatabaseException {
        String sql = "SELECT t.id, t.location, t.destination, t.date, t.price, t.number_people, " +
                    "u.id AS user_id, u.name AS user_name, u.image AS user_image " +
                    "FROM trip AS t " +
                    "INNER JOIN user AS u ON u.id = t.user_id " +
                    "WHERE t.id = ?";

        Trip trip;
        try(Connection connection = jdbcRepository.getDatabaseConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(!resultSet.next()) {
                throw new WhereToNowDatabaseException("Trip with id " + id + " cannot be found");
            }
            else {
                int tripId = resultSet.getInt("id");
                String location = resultSet.getString("location");
                String destination = resultSet.getString("destination");
                LocalDateTime dateTime = resultSet.getTimestamp(4).toLocalDateTime();
                Double price = resultSet.getDouble("price");
                int numberPeople = resultSet.getInt("number_people");
                int userId = resultSet.getInt("user_id");
                String userName = resultSet.getString("user_name");
                String userImage = resultSet.getString("user_image");

                User user = new User(userId, userName, userImage);
                trip = new Trip(tripId, location, destination, dateTime, price, numberPeople, user);

                return trip;
            }

        }
        catch (SQLException throwable) {
            throw new WhereToNowDatabaseException("Cannot read trip from the database", throwable);
        }
    }

    /**
     *
     * @param from
     * @param to
     * @return list of trips
     * @throws WhereToNowDatabaseException
     */
    public List<Trip> getTrips(String from, String to) throws WhereToNowDatabaseException {
        List<Trip> trips = new ArrayList<>();

        String sql = "SELECT t.id, t.location, t.destination, t.date, t.price, t.number_people, " +
                "u.id AS user_id, u.name AS user_name, u.image AS user_image " +
                "FROM trip AS t " +
                "INNER JOIN user AS u ON u.id = t.user_id " +
                "WHERE t.location = ? AND t.destination = ?";

        try(Connection connection = jdbcRepository.getDatabaseConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, from);
            statement.setString(2, to);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int tripId = resultSet.getInt("id");
                String location = resultSet.getString("location");
                String destination = resultSet.getString("destination");
                LocalDateTime dateTime = resultSet.getTimestamp(4).toLocalDateTime();
                Double price = resultSet.getDouble("price");
                int numberPeople = resultSet.getInt("number_people");
                int userId = resultSet.getInt("user_id");
                String userName = resultSet.getString("user_name");
                String userImage = resultSet.getString("user_image");

                User user = new User(userId, userName, userImage);
                Trip trip = new Trip(tripId, location, destination, dateTime, price, numberPeople, user);
                trips.add(trip);
            }

            connection.commit();


        } catch (SQLException throwable) {
            throw new WhereToNowDatabaseException("Cannot read trips from the database.", throwable);
        }

        return trips;
    }
}
