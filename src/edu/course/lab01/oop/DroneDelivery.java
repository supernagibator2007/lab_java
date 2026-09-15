package edu.course.lab01.oop;

public final class DroneDelivery extends Delivery {

    private static final double BASE_PRICE = 300.0;
    private static final double PRICE_PER_KM = 50.0;
    private static final double MAX_DISTANCE_KM = 10.0;

    public DroneDelivery(String orderNumber, double distanceKm) {
        super(orderNumber, distanceKm);

        if (distanceKm > MAX_DISTANCE_KM) {
            throw new IllegalArgumentException(
                    "Расстояние доставки дроном не может превышать %.1f км"
                            .formatted(MAX_DISTANCE_KM)
            );
        }
    }

    @Override
    public double calculateCost() {
        return BASE_PRICE + PRICE_PER_KM * getDistanceKm();
    }

    @Override
    protected String typeName() {
        return "Дрон";
    }
}