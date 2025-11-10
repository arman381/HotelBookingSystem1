package strategy;

public class DiscountPayment implements PaymentStrategy {
    @Override
    public double calculateCost(double basePrice, long nights) {
        return basePrice * nights * 0.9; // 10% скидка
    }
}