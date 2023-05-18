import domain.Drone;
import domain.Location;
import domain.Trip;

import java.util.*;
import java.util.stream.Collectors;

public class Resolver {


    // This problem is pretty similar to (Multiple Knapsack problem) / (Bin Packing Problem)
    // The solution implemented has time complexity of O(n*m)
    // Where n drones * m locations
    // Space complexity in the worst case is log(n*m).
    public static void performDelivery(List<Drone> drones, Location[] locations) {
        List<Trip> trips = new ArrayList<>();
        Set<Integer> usedLocations = new HashSet<>();
        List<Drone> availableDrones = new ArrayList<>(drones);

        // Iterate over all locations until visit every single on.
        while (usedLocations.size() != locations.length) {

            if (availableDrones.isEmpty()) {

                // After all drones complete the trip, we will open the next round.
                // This step avoid to have the BEST FIT and it is intended.
                resetDrones(drones);
                availableDrones.addAll(drones);

            } else {
                Drone drone = availableDrones.get(0);

                Trip trip = new Trip(drone);

                for (int i = 0; i < locations.length; i++) {

                    // Check if location was already considered
                    if (!usedLocations.contains(i)) {
                        Location location = locations[i];

                        if (drone.canAddItem(location.getPackageWeight())) {

                            drone.addItem(location.getPackageWeight());
                            trip.addLocation(location);

                            // Add location index so we can avoid it on next iterations
                            usedLocations.add(i);

                            // If reach maximumCapacity we're done with current drone
                            if (drone.isAtMaximumCapacity()) {
                                break;
                            }

                        }
                    }
                }

                // Drone full for the round, remove from available list.
                availableDrones.remove(drone);
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
