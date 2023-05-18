public class Main {

    public static void main(String[] args) {
        Parameters parameters = Parameters.getParameters();
        Resolver.performDelivery(parameters.getDrones(), parameters.getLocations());
    }

}
