package strategy;

public interface PaymentStrategy {
    double calculateCost(double basePrice, long nights);
}
