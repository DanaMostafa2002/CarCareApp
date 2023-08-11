package SDA.Services.Discounts;

import SDA.Models.Vehicle.Vehicle;

import java.util.ArrayList;

public class MembershipDiscount implements  Discount{
    private static ArrayList<String> vehiclesWhoMemberIn;
    public final double discount = .1;

    public MembershipDiscount() {
        vehiclesWhoMemberIn = new ArrayList<>();
    }
    public void addVehicle(Vehicle vehicle){
        vehiclesWhoMemberIn.add(vehicle.getIdentificationNumber());
    }
    public boolean removeVehical(Vehicle vehicle){
            return vehiclesWhoMemberIn.remove(vehicle.getIdentificationNumber());
    }
    public double getDiscount(Vehicle vehicle){
        if (vehiclesWhoMemberIn.contains(vehicle.getIdentificationNumber())){
            return discount;
        }else return 0;
    }

}
