package SDA.Services.Discounts;

import SDA.Models.Vehicle.Vehicle;

public class PromocodeDiscount implements Discount {
    private final double discount = 0.05;
    public double getDiscount(Vehicle vehicle){
        if (vehicle.getPromocode().name().equals("NONE")){
            return discount;
        }else return 0;
    }

}
