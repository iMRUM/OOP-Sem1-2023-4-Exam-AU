import Composition.AirlineManager;
import Factory.Factory;

public class Main {
    public static void main(String[] args) {
        AirlineManager root = AirlineManager.getInstance();
        root.run();
        System.out.println("done");
    }
}