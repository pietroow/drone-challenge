package domain;

public class Drone {

    private final String name;
    private final int capacity;
    private int remainingWeight;

    public Drone(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.remainingWeight = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean canAddItem(Integer packageWeight) {
        return remainingWeight >= packageWeight;
    }

    public void addItem(int packageWeight) {
        remainingWeight -= packageWeight;
    }

    public void reset() {
        this.remainingWeight = capacity;
    }

    public boolean isAtMaximumCapacity() {
        return remainingWeight == 0;
    }

}
