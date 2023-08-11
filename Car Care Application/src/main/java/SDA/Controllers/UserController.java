package SDA.Controllers;

import SDA.Allocations.AllocationStrategy;
import SDA.Allocations.FCFS;
import SDA.Allocations.SpecialPassenger;
import SDA.Models.CenterSingleton;
import SDA.Models.Vehicle.Vehicle;
import SDA.Services.Discounts.Discount;
import SDA.Services.Discounts.DiscountDecorator;
import SDA.Services.Discounts.DiscountDecoratorImp;
import SDA.Services.Discounts.MembershipDiscount;
import SDA.Services.Service;
import SDA.Subscriptions.car_owner;
import SDA.Models.Vehicle.Vehicle;

import java.time.LocalTime;
import java.util.List;



public class UserController {

    CenterSingleton center;
    MembershipDiscount membershipDiscount =new MembershipDiscount();

    public UserController() {
        center = CenterSingleton.getInstance();
    }

    public int cleanInVehicle(String modelName, String identificationNumber, int modelYear, double width, double length, int type) {
        if (center.getAvailableWorkers() > 0) {
            Vehicle vehicle = _registerVehicle(modelName, identificationNumber, modelYear, width, length, type);
            _allocateWorker(vehicle);
            center.setVehiclesCount(CenterSingleton.getInstance().getVehiclesCount() + 1);
            return 1;
        }
        return -1;
    }

    public double cleanOutVehicle(String identificationNumber) {
        for (Vehicle vehicle : center.getVehiclesList()) {
            if (vehicle.getIdentificationNumber().equals(identificationNumber)) {
                vehicle.setTimeDeparted(LocalTime.now());
                return _calculateFees(vehicle);
            }
        }
        return -1;
    }

    public void subscribeToWaitingList( String identificationNumber) {




    }

    public List<Service> askForService() {
        return center.getServiceList();
    }

    public void SubscribeToMembership(Vehicle vehicle) {
        membershipDiscount.addVehicle(vehicle);
    }

    public Vehicle _registerVehicle(String modelName, String identificationNumber, int modelYear, double width, double length, int type) {
        Vehicle vehicle = new Vehicle();
        vehicle.setModelName(modelName);
        vehicle.setIdentificationNumber(identificationNumber);
        vehicle.setModelYear(modelYear);
        vehicle.setVehicleDimensions(width, length);
        vehicle.setType(type);
        vehicle.setTimeArrived(LocalTime.now());
        center.getWaitingList().add(vehicle);
        return vehicle;
    }

    public void _allocateWorker(Vehicle vehicle) {
        AllocationStrategy allocation;
        switch (center.getAllocation()) {
            case "SPECIAL" -> {
                allocation = new SpecialPassenger();
                allocation.allocateWorker();
            }
            case "FCFS" -> {
                allocation = new FCFS();
                allocation.allocateWorker();
            }
        }
        center.getVehiclesList().add(vehicle);
        center.setAvailableWorkers(CenterSingleton.getInstance().getAvailableWorkers() - 1);
    }

    public double _calculateFees(Vehicle vehicle) {
        Discount discountType = new DiscountDecoratorImp();

        double fees = (vehicle.getVehicleDimensions().getLength() * vehicle.getVehicleDimensions().getWidth() * 20);
        center.setTotalIncome(center.getTotalIncome() + fees);
        return fees;
    }

}
