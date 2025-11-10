package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private final Hotel hotel;
    private final Room room;
    private final String customer;
    private final LocalDate checkIn;
    private final LocalDate checkOut;
    private final double totalPrice;
    private final List<String> extraServices;

    private Booking(Builder builder) {
        this.hotel = builder.hotel;
        this.room = builder.room;
        this.customer = builder.customer;
        this.checkIn = builder.checkIn;
        this.checkOut = builder.checkOut;
        this.totalPrice = builder.totalPrice;
        this.extraServices = builder.extraServices;
    }

    public Hotel getHotel() {
        return hotel;
    }
    public Room getRoom() {
        return room;
    }
    public String getCustomer() {
        return customer;
    }
    public LocalDate getCheckIn() {
        return checkIn;
    }
    public LocalDate getCheckOut() {
        return checkOut;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public List<String> getExtraServices() {
        return extraServices;
    }

    @Override
    public String toString() {
        long nights = ChronoUnit.DAYS.between(checkIn, checkOut);
        String serviceList = extraServices.isEmpty() ? "No extra services" : String.join(", ", extraServices);

        return "Booking details: " +
                "\nHotel: " + hotel.getName() +
                "\nLocated in: " + hotel.getCity() +
                "\nCustomer: " + customer +
                "\nRoom: " + room.getDescription() +
                "\nCheck-in: " + checkIn + ", Check-out: " + checkOut + " (" + nights + " nights)" +
                "\nExtra services: " + serviceList +
                "\nTotal cost: " + String.format("%.2f USD", totalPrice) +
                "\nThank you for choosing our hotel!";
    }

    public static class Builder {
        private Hotel hotel;
        private Room room;
        private String customer;
        private LocalDate checkIn;
        private LocalDate checkOut;
        private double totalPrice;
        private List<String> extraServices = new ArrayList<>();

        public Builder setHotel(Hotel hotel) {
            this.hotel = hotel;
            return this;
        }

        public Builder setRoom(Room room) {
            this.room = room;
            return this;
        }

        public Builder setCustomer(String customer) {
            this.customer = customer;
            return this;
        }

        public Builder setDates(LocalDate checkIn, LocalDate checkOut) {
            this.checkIn = checkIn;
            this.checkOut = checkOut;
            return this;
        }

        public Builder setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder addExtra(String extra) {
            this.extraServices.add(extra);
            return this;
        }
        public Booking build() {
            if (hotel == null || room == null || customer == null || checkIn == null || checkOut == null) {
                throw new IllegalStateException("Please make sure all required fields are filled out (hotel, room, client, check-in and check-out dates!!!).");
            }
            return new Booking( this);
        }
    }
}