package Factory;

import Composition.*;
import Observer.Employee;
import Observer.Passenger;

import java.util.HashMap;
import java.util.Map;

public class Factory {
    private static Map<String, IProduct> productMap = new HashMap<>();

    public static Flight getFlight(double price, double duration, String time, String dest, String code, AbstractAirline airline) {
        if (!productMap.containsKey(code)) {
            productMap.put(code, new Flight(price, duration, time, dest, code, airline));
        }
        airline.add((Flight) productMap.get(code));
        return (Flight) productMap.get(code);
    }

    public static ConcreteAirline getConcreteAirline(String name, IContainer parent) {
        if (!productMap.containsKey(name)) {
            productMap.put(name, new ConcreteAirline(name, parent));
        }
        return (ConcreteAirline) productMap.get(name);
    }

    public static ConcreteSubsidiaryAirline getConcreteSubsidiaryAirline(String name, AbstractAirline airline) {
        if (!productMap.containsKey(name)) {
            productMap.put(name, new ConcreteSubsidiaryAirline(name, airline));
        }
        return (ConcreteSubsidiaryAirline) productMap.get(name);
    }

    public static Employee getEmployee(String name, String id, AbstractAirline employer) {
        if (productMap.containsKey(id)) {
            return (Employee) productMap.get(id);
        }
        return new Employee(name, id, employer);
    }

    public static Passenger getPassenger(String name, String id) {
        if (productMap.containsKey(id)) {
            return (Passenger) productMap.get(id);
        }
        return new Passenger(name, id);
    }
    public static boolean removeProduct(String name, IProduct product){
        return productMap.remove(name, product);
    }
}
