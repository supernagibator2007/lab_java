package edu.course.lab01.oop;

public final class ExpressDelivery extends Delivery {

    private static final double BASE_PRICE = 250.0;
    private static final double PRICE_PER_KM = 35.0;

    public ExpressDelivery(String orderNumber, double distanceKm) {
        super(orderNumber, distanceKm);
    }

    @Override
    public double calculateCost() {
        return BASE_PRICE + PRICE_PER_KM * getDistanceKm();
    }

    @Override
    protected String typeName() {
        return "Экспресс";
    }
}