package model;

public abstract class AbstractRoom implements Room {
    protected final double basePrice;
    protected final String description;

    public AbstractRoom(double basePrice, String description) {
        this.basePrice = basePrice;
        this.description = description;
    }

    @Override
    public double getPrice() {
        return basePrice;
    }

    @Override
    public String getDescription() {
        return description;
    }
}