import domain.Drone;
import domain.Location;
import domain.Trip;

import java.util.*;
import java.util.stream.Collectors;

public class Resolver {

    public static void performDelivery(List<Drone> drones, Location[] locations) {
        List<Trip> trips = new ArrayList<>();
        Set<Integer> usedLocations = new HashSet<>();

        // we iterate until we allocate all items
        while (usedLocations.size() != locations.length) {
            List<Drone> availableDrones = drones.stream()
                    .filter(Drone::isAvailable)
                    .toList();

            if (availableDrones.isEmpty()) {

                // After all drones complete the first trip, we will open the second round.
                resetDrones(drones);

            } else {
                Drone drone = availableDrones.get(0);
                Trip trip = new Trip(drone);

                for (int i = 0; i < locations.length; i++) {
                    if (!usedLocations.contains(i)) {
                        Location location = locations[i];

                        if (drone.canAddItem(location.getPackageWeight())) {

                            drone.addItem(location.getPackageWeight());
                            trip.addLocation(location);
                            usedLocations.add(i);

                            if (drone.isAtMaximumCapacity()) {
                                break;
                            }

                        }
                    }
                }

                // After iterating over all possibilites we disable the drone
                // to pickup more load until next round
                drone.setAvailable(false);
                trips.add(trip);
            }
        }
        print(trips);
    }

    private static void resetDrones(List<Drone> drones) {
        drones.forEach(Drone::reset);
    }

    private static void print(List<Trip> trips) {
        Map<Drone, List<Trip>> map = trips.stream()
                .collect(Collectors.groupingBy(o -> o.drone));

        map.forEach((drone, tripes) -> {
            System.out.printf("[%s]\n", drone.getName());
            for (int i = 0; i < tripes.size(); i++) {
                System.out.printf("Trip #%d\n", i + 1);
                String loca = tripes.get(i).locations.stream()
                        .map(Location::getName)
                        .collect(Collectors.joining(", ", "[", "]"));
                System.out.println(loca);
            }
            System.out.println();
        });
    }

}
