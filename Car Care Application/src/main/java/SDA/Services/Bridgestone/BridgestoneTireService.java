package SDA.Services.Bridgestone;

import SDA.Services.Service;

public class BridgestoneTireService implements Service {

    String serviceName;
    double serviceFees;

    BridgestoneTireService(){
        serviceName = "Bridgestone tire service";
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
