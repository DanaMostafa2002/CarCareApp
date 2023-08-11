package SDA.Services.Bridgestone;

import SDA.Services.Service;
import SDA.Services.ServiceFactory;

import java.util.LinkedList;
import java.util.List;

public class BridgestoneFactory extends ServiceFactory {

    List<Service> services;

    public BridgestoneFactory() {
        services = new LinkedList<>();
        services.add(new BridgestoneTireService());
    }

    @Override
    public List<Service> provideServices() {
        return services;
    }

}
