package com.bridgelabz;
import java.util.ArrayList;
import java.util.List;
public class CabInvoice {
    static List<Customer> customerList = new ArrayList<>();

    static final double COST_PER_KM = 10;
    static final double COST_PER_MIN = 1;
    static final double MINIMUM_FARE = 5;
    static final double COST_PER_KM_PREMIUM = 15;
    static final double COST_PER_MIN_PREMIUM = 2;


    public double calculateFare(double distance, double time) {
        double fare = distance * COST_PER_KM + time * COST_PER_MIN;
        if (fare < 5)
            fare = MINIMUM_FARE;

        return fare;
    }
    public static double calculateFarePremium(double distance, double time) {
        double totalFare = COST_PER_KM_PREMIUM * distance + COST_PER_MIN_PREMIUM * time;
        if(totalFare < 20)
            totalFare = 20;
        return totalFare;
    }
    public double calculateFare(Ride[] rideArray) {
        double totalFare = 0;
        for (Ride ride : rideArray) {
            totalFare += calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }

    public Invoice generateInvoice(Ride[] rideArray) {
        double totalFare = calculateFare(rideArray);
        int totalRides = rideArray.length;
        double avgFare = totalFare / totalRides;
        return new Invoice(totalFare, totalRides, avgFare);
    }

}
