# domain.Drone Project

This project is a drone and location simulator. It allows you to create drones and locations from an input file and execute a "round" using all the drones.

## Input

The input file should be a text file named input.txt located in the root directory. The format of the input file is as follows:

On the first line, list all the drones you wish to create. Each drone is represented by a pair of values: the drone's name and its associated value. These pairs should be separated by commas. For example:

```
[DroneA], [200], [DroneB], [250], [DroneC], [100]
```

On all subsequent lines, list the locations you wish to create. Each location is represented by a pair of values: the location's name and its associated value. Each location should be on its own line. For example:

```
[LocationA], [200]
[LocationB], [150]
[LocationC], [50]
...
```

## Round

The program executes a "round", in which all drones must be utilized. 
During my research to implement the logic of allocating the drones to the locations, I studied and understood the concepts of allocation algorithms like (Next Fit), (First Fit), and (Best Fit). 
Although these algorithms could provide an extremely performant solution, they require significant time to implement correctly.
Therefore, at this moment, the implementation of the drones' allocation logic to the locations is an open task for future improvement.
If can research for Bin Packing Problem and have a deep dive.

## Execution

To run the program, run the Main class in your IDE or command line environment.

## Output

The program will print out a representation of all the drones and locations that were created from the input file.

## Notes

Please ensure that the input file is formatted correctly and that all drone names and locations are unique. Otherwise, the program may not function as expected.

## Original Problem description

A squad of drones is tasked with delivering packages for a major online reseller in a world
where time and distance do not matter. Each drone can carry a specific weight and can make
multiple deliveries before returning to home base to pick up additional loads; however, the goal
is to make the fewest number of trips as each time the drone returns to home base, it is
extremely costly to refuel and reload the drone.
The purpose of the written software is to accept input which will include the name of each
drone and the maximum weight it can carry, along with a series of locations and the total weight
needed to be delivered to that specific location. The software should highlight the most efficient
deliveries for each drone to make on each trip.
Assume that time and distance to each drop off location do not matter, and that the size of
each package is also irrelevant. It is also assumed that the cost to refuel and restock each
drone is a constant and does not vary between drones. The maximum number of drones in a
squad is 100, and there is no maximum number of deliveries which are required. 