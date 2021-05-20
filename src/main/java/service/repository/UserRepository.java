package service.repository;

import service.model.User;
import service.model.Guardian;
import service.model.dto.UserDTO;

import java.net.URISyntaxException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository extends JDBCRepository{

    //get all users from data base
    public List<User> getUsers() throws WhereToNowDatabaseException, SQLException, URISyntaxException {

        List<User> users = new ArrayList<>();

        Connection connection = this.getDatabaseConnection();

        String sql = "SELECT * FROM user WHERE 1";

        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String image =  resultSet.getString("image");
                String id_image = resultSet.getString("id_image");
                String number = resultSet.getString("number");
                String safe_word = resultSet.getString("safe_word");

                User user = new User(id,name,email, password, image,id_image, number, safe_word);
                users.add(user);
            }
        } catch (SQLException throwable) {
            throw new WhereToNowDatabaseException("Cannot read users from the database.",throwable);
        }

        return users;
    }

    // get user by his id
    public User getUserById(int id) throws WhereToNowDatabaseException, SQLException, URISyntaxException {
        String sql = "SELECT * FROM user WHERE id = ?";

        try (Connection connection = this.getDatabaseConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id); // set id parameter
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()){
                connection.close();
                throw new WhereToNowDatabaseException("User with id " + id + " cannot be found");
            } else {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String image =  resultSet.getString("image");
                String id_image = resultSet.getString("id_image");
                String number = resultSet.getString("number");
                String safe_word = resultSet.getString("safe_word");

                return new User(id,name,email, password, image,id_image, number, safe_word);
            }
        } catch (SQLException throwable) {
            throw new WhereToNowDatabaseException("Cannot read user from the database.",throwable);
        }
    }

    // get user's guardians
    public List<Guardian> getAllGuardianDTO(int id) throws WhereToNowDatabaseException, URISyntaxException {

        List<Guardian> allGuardiansDTO = new ArrayList<>();

        String sql = "SELECT guardian.name AS GuardianName, guardian.image " +
                "AS GuardianImage FROM user_guardian " +
                "LEFT JOIN user AS userr " +
                "ON (user_guardian.user_id = userr.id) " +
                "LEFT JOIN user AS guardian ON (user_guardian.guardian_id = guardian.id) " +
                "WHERE (userr.id = ?)";

        try(Connection connection = this.getDatabaseConnection();
            PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                String guardianName = resultSet.getString("GuardianName");
                String guardianImage = resultSet.getString("GuardianImage");

                UserDTO guardian = new UserDTO( guardianName, guardianImage);

                Guardian myGuardian = new Guardian(guardian);

                allGuardiansDTO.add(myGuardian);
            }
        }
        catch (SQLException throwable) {
            throw new WhereToNowDatabaseException("Cannot read guardians from the database.", throwable);
        }

        return allGuardiansDTO;
    }

}
