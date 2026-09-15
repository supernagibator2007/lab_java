package edu.course.lab01.oop;

public class DeliveryApp {

    public static void main(String[] args) {
        Delivery[] deliveries = {
                new StandardDelivery("A-101", 3.5),
                new ExpressDelivery("B-205", 7.0),
                new DroneDelivery("C-330", 2.0)
        };

        double totalCost = 0.0;

        for (Delivery delivery : deliveries) {
            System.out.println(delivery.summary());
            totalCost += delivery.calculateCost();
        }

        System.out.printf("Итого: %.2f у.е.%n", totalCost);
    }
}