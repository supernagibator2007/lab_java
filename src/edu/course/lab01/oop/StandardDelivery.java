package edu.course.lab01.oop;

public final class StandardDelivery extends Delivery {

    private static final double BASE_PRICE = 120.0;
    private static final double PRICE_PER_KM = 20.0;

    public StandardDelivery(String orderNumber, double distanceKm) {
        super(orderNumber, distanceKm);
    }

    @Override
    public double calculateCost() {
        return BASE_PRICE + PRICE_PER_KM * getDistanceKm();
    }

    @Override
    protected String typeName() {
        return "Стандартная";
    }
}