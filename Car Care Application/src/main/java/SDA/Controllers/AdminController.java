package SDA.Controllers;

import SDA.Models.CenterSingleton;
import SDA.Models.Vehicle.Vehicle;

import java.time.LocalTime;

public class AdminController {

    public double calculateTotalIncome() {
        return CenterSingleton.getInstance().getTotalIncome();
    }

    public int getVehiclesCount() {
        return CenterSingleton.getInstance().getVehiclesCount();
    }
    CenterSingleton data = CenterSingleton.getInstance();
    public void enforceServicePackage() {

    }

    public void getAllUserUsedServices() {
        for (Vehicle vehicle : data.getVehiclesList()) {
            System.out.println(vehicle);
        }
    }

}
