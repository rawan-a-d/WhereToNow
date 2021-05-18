package service.model.dto;

import java.util.Objects;

public class UserDTO {

    //fields
    private int id; //user's id
    private String name; //user's name
    private String image; //user's image

    //constracture
    public UserDTO(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public UserDTO(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public UserDTO() {
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    //methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return id == userDTO.id &&
                Objects.equals(name, userDTO.name) &&
                Objects.equals(image, userDTO.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
