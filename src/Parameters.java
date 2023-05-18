import domain.Drone;
import domain.Location;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Parameters {

    private final Location[] locations;
    private final List<Drone> drones;

    private Parameters(Location[] locations, List<Drone> drones) {
        this.locations = locations;
        this.drones = drones;
    }

    public static Parameters getParameters() {
        List<Drone> drones = new ArrayList<>();
        List<Location> locationsList = new ArrayList<>();

        try {
            readFile(drones, locationsList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Location[] locations = new Location[locationsList.size()];
        locationsList.toArray(locations);

        Arrays.sort(locations, Comparator.comparingInt(Location::getPackageWeight).reversed());
        drones.sort(Comparator.comparingInt(Drone::getCapacity).reversed());

        return new Parameters(locations, drones);
    }

    private static void readFile(List<Drone> drones, List<Location> locations) throws IOException {
        File file = new File("src/input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line = reader.readLine();
        if (line != null) {
            String[] droneParts = line
                    .replace("[", "")
                    .replace("]", "")
                    .split(", ");

            for (int i = 0; i < droneParts.length; i += 2) {
                String name = droneParts[i];
                int value = Integer.parseInt(droneParts[i + 1]);
                drones.add(new Drone(name, value));
            }
        }

        while ((line = reader.readLine()) != null) {
            String[] parts = line
                    .replace("[", "")
                    .replace("]", "")
                    .split(", ");
            String name = parts[0];
            int value = Integer.parseInt(parts[1]);
            locations.add(new Location(name, value));
        }
        reader.close();
    }

    public Location[] getLocations() {
        return locations;
    }

    public List<Drone> getDrones() {
        return drones;
    }

}
