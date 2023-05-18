package domain;

public class Location {

    private final String name;
    private final int packageWeight;

    public Location(String name, int packageWeight) {
        this.name = name;
        this.packageWeight = packageWeight;
    }

    public String getName() {
        return name;
    }

    public int getPackageWeight() {
        return packageWeight;
    }

}
