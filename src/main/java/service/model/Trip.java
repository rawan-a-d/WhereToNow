package service.model;

import service.model.dto.UserDTO;

import java.time.LocalDateTime;

public class Trip {
    private int id;
    private String location;
    private String destination;
    private LocalDateTime dateTime;
    private Double price;
    private int numberPeople;
    private UserDTO user;

    public Trip(int id, String location, String destination, LocalDateTime dateTime, Double price, int number_people, UserDTO user) {
        this.id = id;
        this.location = location;
        this.destination = destination;
        this.dateTime = dateTime;
        this.price = price;
        this.numberPeople = numberPeople;
        this.user = user;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getNumberPeople() {
        return numberPeople;
    }

    public void setNumberPeople(int numberPeople) {
        this.numberPeople = numberPeople;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
