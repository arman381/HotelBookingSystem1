package model;

public class StandardRoom extends AbstractRoom {
    private static final double BASE_PRICE = 100.0;

    public StandardRoom() {
        super(BASE_PRICE, "basic room with basic amenities");
    }
}