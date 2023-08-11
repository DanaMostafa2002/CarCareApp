package SDA.Models.Vehicle;

import SDA.enums.Promocodes;

import java.time.LocalTime;

public class Vehicle {

    String modelName;
    String identificationNumber;
    Dimensions vehicleDimensions;
    int modelYear;
    PassengerType type;
    LocalTime timeArrived;
    LocalTime timeDeparted;
    Promocodes promocode ;

    public Vehicle() {
        modelName = "N/A";
        identificationNumber = "N/A";
        vehicleDimensions = new Dimensions();
        modelYear = 0;
        type = null;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setVehicleDimensions(double width, double length) {
        this.vehicleDimensions.setWidth(width);
        this.vehicleDimensions.setLength(length);
    }

    public Dimensions getVehicleDimensions() {
        return vehicleDimensions;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public PassengerType getType() {
        return type;
    }

    public Promocodes getPromocode() {
        return promocode;
    }

    public void setPromocode(Promocodes promocode) {
        this.promocode = promocode;
    }

    public void setType(int type) {
        switch (type) {
            case 1 -> this.type = PassengerType.REGULAR_ONLY;
            case 2 -> this.type = PassengerType.INCLUDE_KIDS;
            case 3 -> this.type = PassengerType.INCLUDE_ELDERLY;
        }
    }

    public void setTimeArrived(LocalTime timeArrived) {
        this.timeArrived = timeArrived;
    }

    public void setTimeDeparted(LocalTime timeDeparted) {
        this.timeDeparted = timeDeparted;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "modelName='" + modelName + '\'' +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", vehicleDimensions=" + vehicleDimensions +
                ", modelYear=" + modelYear +
                ", type=" + type +
                ", timeArrived=" + timeArrived +
                ", timeDeparted=" + timeDeparted +
                ", promocode=" + promocode +
                '}';
    }
}
