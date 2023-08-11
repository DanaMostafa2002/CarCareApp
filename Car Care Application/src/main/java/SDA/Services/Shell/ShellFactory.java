package SDA.Services.Shell;

import SDA.Services.Service;
import SDA.Services.ServiceFactory;

import java.util.LinkedList;
import java.util.List;

public class ShellFactory extends ServiceFactory {

    List<Service> services;

    public ShellFactory() {
        services = new LinkedList<>();
        services.add(new ShellOilService());
    }

    @Override
    public List<Service> provideServices() {
        return services;
    }
}
