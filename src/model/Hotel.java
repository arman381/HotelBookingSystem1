package model;

import java.util.Map;

public class Hotel {
    private final String id;
    private final String name;
    private final String city;
    private final Map<String, Double> roomPrices;

    public Hotel(String id, String name, String city, Map<String, Double> roomPrices) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.roomPrices = roomPrices;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCity() {
        return city;
    }
    public Map<String, Double> getRoomPrices() {
        return roomPrices;
    }

    @Override
    public String toString() {
        return "Hotel: " + name + " in " + city + " (ID: " + id + ")";
    }

}