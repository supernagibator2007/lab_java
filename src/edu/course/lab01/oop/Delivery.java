package edu.course.lab01.oop;

public abstract class Delivery {

    private final String orderNumber;
    private final double distanceKm;

    protected Delivery(String orderNumber, double distanceKm) {
        if (orderNumber == null || orderNumber.isBlank()) {
            throw new IllegalArgumentException(
                    "Номер заказа не должен быть пустым"
            );
        }

        if (distanceKm < 0) {
            throw new IllegalArgumentException(
                    "Расстояние не может быть отрицательным"
            );
        }

        this.orderNumber = orderNumber;
        this.distanceKm = distanceKm;
    }

    public final String getOrderNumber() {
        return orderNumber;
    }

    public final double getDistanceKm() {
        return distanceKm;
    }

    public abstract double calculateCost();

    protected abstract String typeName();

    public final String summary() {
        return "%s | %s | %.1f км | %.2f у.е."
                .formatted(
                        orderNumber,
                        typeName(),
                        distanceKm,
                        calculateCost()
                );
    }
}