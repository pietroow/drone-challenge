package domain;

public class Drone {

    private final String name;
    private final int capacity;
    private int remainingWeight;
    private boolean isAvailable;

    public Drone(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.remainingWeight = capacity;
        this.isAvailable = true;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean canAddItem(Integer packageWeight) {
        return remainingWeight >= packageWeight;
    }

    public void addItem(int packageWeight) {
        remainingWeight -= packageWeight;
    }

    public void reset() {
        this.remainingWeight = capacity;
        this.isAvailable = true;
    }

    public boolean isAtMaximumCapacity() {
        return remainingWeight == 0;
    }

}
