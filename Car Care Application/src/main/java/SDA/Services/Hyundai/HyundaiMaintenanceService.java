package SDA.Services.Hyundai;

import SDA.Services.Service;

public class HyundaiMaintenanceService implements Service {

    String serviceName;
    double serviceFees;

    HyundaiMaintenanceService(){
        serviceName = "Hyundai maintenance service";
        serviceFees = 10;
    }

    @Override
    public String getServiceName(){
        return serviceName;
    }

    @Override
    public double getServiceFees(){
        return serviceFees;
    }

}
