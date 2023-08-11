package SDA.Services.Discounts;

import SDA.Models.Vehicle.Vehicle;

public class DiscountDecoratorImp extends DiscountDecorator{
    private double discountPercent=0;
    @Override
    public double getDiscount(Vehicle vehicle) {
        discount = new MembershipDiscount();
        discountPercent+= discount.getDiscount(vehicle);
        discount = new PromocodeDiscount();
        discountPercent+= discount.getDiscount(vehicle);
        return discountPercent;
    }
}
