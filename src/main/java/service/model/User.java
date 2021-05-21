package service.model;

import java.util.Objects;

public class User {

    // fields
    private int id;
    private String name; // user's name
    private String email; // user's email
    private String password; // user's password
    private String image; // user's personal image
    private String id_image; // user's Id image
    private String number;
    private String safe_word;

    // constructors
    public User(int id, String name, String email, String password, String image, String id_image, String number, String safe_word) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.image = image;
        this.id_image = id_image;
        this.number = number;
        this.safe_word = safe_word;
    }

    public User(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getId_image() {
        return id_image;
    }

    public void setId_image(String id_image) {
        this.id_image = id_image;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSafe_word() {
        return safe_word;
    }

    public void setSafe_word(String safe_word) {
        this.safe_word = safe_word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(image, user.image) &&
                Objects.equals(id_image, user.id_image) &&
                Objects.equals(number, user.number) &&
                Objects.equals(safe_word, user.safe_word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, image, id_image, number, safe_word);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", id_image='" + id_image + '\'' +
                ", number='" + number + '\'' +
                ", safe_word='" + safe_word + '\'' +
                '}';
    }
}
