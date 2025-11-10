package model;

public class DeluxeRoom extends AbstractRoom {
    private static final double BASE_PRICE = 180.0;

    public DeluxeRoom() {
        super(BASE_PRICE, "deluxe room with superior view.");
    }
}