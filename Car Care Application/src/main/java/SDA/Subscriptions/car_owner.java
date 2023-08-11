package SDA.Subscriptions;

public class car_owner implements Vehicles_observer {
    private String id;

    public car_owner(String id) {
        this.id = id;
    }
    @Override
    public void update() {
        System.out.println("IT IS TOUR TURN THANK YOU FOR WAITING WITH US !");

    }
}
