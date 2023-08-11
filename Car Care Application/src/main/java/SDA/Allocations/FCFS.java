package SDA.Allocations;

import SDA.Models.CenterSingleton;

public class FCFS implements AllocationStrategy {

    @Override
    public void allocateWorker() {
        CenterSingleton.getInstance().getWaitingList().remove(0);
    }

}
