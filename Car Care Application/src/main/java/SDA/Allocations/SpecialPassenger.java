package SDA.Allocations;

import SDA.Models.CenterSingleton;
import SDA.Models.Vehicle.PassengerType;
import SDA.Models.Vehicle.Vehicle;

public class SpecialPassenger implements AllocationStrategy {

    @Override
    public void allocateWorker() {
        for (Vehicle vehicle : CenterSingleton.getInstance().getWaitingList()) {
            if (vehicle.getType().equals(PassengerType.INCLUDE_ELDERLY) ||
                    (vehicle.getType().equals(PassengerType.INCLUDE_KIDS))) {
                CenterSingleton.getInstance().getWaitingList().remove(vehicle);
                return;
            }
        }
        CenterSingleton.getInstance().getWaitingList().remove(0);
    }

}
