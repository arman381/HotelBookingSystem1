package strategy;

public class RegularPayment implements PaymentStrategy {
    @Override
    public double calculateCost(double basePrice, long nights) {
        return basePrice * nights;
    }
}