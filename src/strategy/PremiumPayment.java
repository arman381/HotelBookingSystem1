package strategy;

public class PremiumPayment implements PaymentStrategy {
    @Override
    public double calculateCost(double basePrice, long nights) {
        return basePrice * nights * 0.85; // 15% скидка
    }
}