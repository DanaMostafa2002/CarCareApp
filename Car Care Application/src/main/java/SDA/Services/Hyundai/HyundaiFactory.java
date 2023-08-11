package SDA.Services.Hyundai;

import SDA.Services.Service;
import SDA.Services.ServiceFactory;

import java.util.LinkedList;
import java.util.List;

public class HyundaiFactory extends ServiceFactory {
    List<Service> services;

    public HyundaiFactory() {
        services = new LinkedList<>();
        services.add(new HyundaiMaintenanceService());
    }

    @Override
    public List<Service> provideServices() {
        return services;
    }
}
