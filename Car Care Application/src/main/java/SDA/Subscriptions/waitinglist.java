package SDA.Subscriptions;

import java.util.ArrayList;
import java.util.List;

public class waitinglist {
    private List<Vehicles_observer> observers = new ArrayList<>();
    private boolean vechile_turn=false;
    public void add_observer(Vehicles_observer vech){
        observers.add(vech);
    }
    public void remove_observer(Vehicles_observer vech){
        observers.remove(vech);
    }
    public void notify_observer(){
        for(Vehicles_observer vech:observers){
            vech.update();
        }
    }
    public void set_availble(boolean turn){
        this.vechile_turn=turn;
        if(turn){
            notify_observer();
        }

    }
    public   boolean is_availble()
    {
        return vechile_turn;
    }



}
