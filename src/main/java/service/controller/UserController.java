package service.controller;

import service.model.User;
import service.model.dto.GuardianDTO;
import service.model.dto.UserDTO;
import service.repository.UserRepository;
import service.repository.WhereToNowDatabaseException;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public class UserController {

    UserRepository userRepository = new UserRepository();

    /**
     *
     * @param userId
     * @return User with the given ID
     */
    public User getUser(int userId){

        try {
            User user = userRepository.getUserById(userId);
            System.out.println("Get user by ID" + user);
            return user;
        } catch (SQLException | URISyntaxException | WhereToNowDatabaseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     *
     * @param id
     * @return List of all gardians
     */
    public List<GuardianDTO> getAllGuardians(int id) {
        List<GuardianDTO> allGuardians;
        try {
            allGuardians = userRepository.getAllGuardianDTO(id);
            System.out.println("Get user's guardian'" + allGuardians);
            return allGuardians;
        }
        catch (URISyntaxException | WhereToNowDatabaseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<User> getAllUsers() {
        try {
            List<User> users = userRepository.getUsers();
            System.out.println("Get users" + users);
            return users;
        }
        catch (URISyntaxException | WhereToNowDatabaseException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
