package service.model;

import service.model.dto.UserDTO;

import java.util.Objects;

public class Guardian {

    //fields
    private int id;
    private UserDTO user_id; // user
    private UserDTO guardian_id; // guardian

    //constarcture
    public Guardian(int id, UserDTO user_id, UserDTO guardian_id) {
        this.id = id;
        this.user_id = user_id;
        this.guardian_id = guardian_id;
    }

    public Guardian(UserDTO guardian_id) {
        this.guardian_id = guardian_id;
    }

    public Guardian() {
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDTO getUser_id() {
        return user_id;
    }

    public void setUser_id(UserDTO user_id) {
        this.user_id = user_id;
    }

    public UserDTO getGuardian_id() {
        return guardian_id;
    }

    public void setGuardian_id(UserDTO guardian_id) {
        this.guardian_id = guardian_id;
    }

    //methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guardian that = (Guardian) o;
        return id == that.id &&
                Objects.equals(user_id, that.user_id) &&
                Objects.equals(guardian_id, that.guardian_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, guardian_id);
    }

    @Override
    public String toString() {
        return "GuardianDTO{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", guardian_id=" + guardian_id +
                '}';
    }
}
