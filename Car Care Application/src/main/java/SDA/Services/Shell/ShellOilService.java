package SDA.Services.Shell;

import SDA.Services.Service;

public class ShellOilService implements Service {

    String serviceName;
    double serviceFees;

    ShellOilService(){
        serviceName = "Shell oil service";
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
