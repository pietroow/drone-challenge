package domain;

import java.util.ArrayList;
import java.util.List;

public class Trip {

    public Drone drone;
    public List<Location> locations;

    public Trip(Drone drone) {
        this.drone = drone;
        this.locations = new ArrayList<>();
    }

    public void addLocation(Location location) {
        this.locations.add(location);
    }

}
