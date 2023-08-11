package SDA.Models;

import SDA.Models.Vehicle.Vehicle;
import SDA.Services.Bridgestone.BridgestoneFactory;
import SDA.Services.Hyundai.HyundaiFactory;
import SDA.Services.Service;
import SDA.Services.ServiceFactory;
import SDA.Services.Shell.ShellFactory;

import java.util.LinkedList;
import java.util.List;

public class CenterSingleton {

    static CenterSingleton instance;
    final static int WORKERS = 2;

    int availableWorkers;
    double totalIncome;
    int vehiclesCount;
    String allocation;
    List<Vehicle> vehiclesList;
    List<Vehicle> waitingList;
    List<Service> serviceList;

    private CenterSingleton() {
        availableWorkers = WORKERS;
        totalIncome = 0;
        vehiclesCount = 0;
        allocation = "SPECIAL";
        vehiclesList = new LinkedList<>();
        waitingList = new LinkedList<>();
        serviceList = new LinkedList<>();
        ServiceFactory bridgestoneFactory = new BridgestoneFactory();
        serviceList.addAll(bridgestoneFactory.provideServices());
        ServiceFactory hyundaiFactory = new HyundaiFactory();
        serviceList.addAll(hyundaiFactory.provideServices());
        ServiceFactory shellFactory = new ShellFactory();
        serviceList.addAll(shellFactory.provideServices());
    }

    public static CenterSingleton getInstance() {
        if (instance == null) {
            instance = new CenterSingleton();
        }
        return instance;
    }

    public String getAllocation() {
        return allocation;
    }

    public int getAvailableWorkers() {
        return availableWorkers;
    }

    public void setAvailableWorkers(int availableWorkers) {
        this.availableWorkers = availableWorkers;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public int getVehiclesCount() {
        return vehiclesCount;
    }

    public void setVehiclesCount(int vehiclesCount) {
        this.vehiclesCount = vehiclesCount;
    }

    public List<Vehicle> getWaitingList() {
        return waitingList;
    }

    public List<Vehicle> getVehiclesList() {
        return vehiclesList;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

}
