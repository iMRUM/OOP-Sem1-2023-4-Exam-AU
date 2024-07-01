package Composition;

import Factory.*;
import Observer.AbstractPublisher;
import Observer.Employee;
import Observer.ISubscriber;
import Observer.Passenger;
import Singleton.ISingleton;
import Strategy.SearchAlgoByPrice;
import Strategy.SearchAlgoByTime;
import Strategy.SearchService;

import java.util.ArrayList;
import java.util.List;

public class AirlineManager extends AbstractContainer {
    private static AirlineManager instance;
    private SearchService searchService;

    private AirlineManager() {
        super();
        searchService = new SearchService();
    }

    public static AirlineManager getInstance() {
        if (instance == null) {
            instance = new AirlineManager();
        }
        return instance;
    }

    public void run() {
        ConcreteAirline lufthansa = getConcreteAirline("lufthansa");
        ConcreteSubsidiaryAirline smartwings = getConcreteSubsidiaryAirline("smartwings", lufthansa);
        ConcreteAirline elal = getConcreteAirline("elal");
        ConcreteSubsidiaryAirline tus = getConcreteSubsidiaryAirline("tus", elal);
        Passenger yosi = getPassenger("yosi", "222333444");
        Flight f1 = getFlight(10, 10, "18:30", "Tokyo", "A1", lufthansa);
        Flight f2 = getFlight(1, 10, "18:30", "Tokyo", "A2", smartwings);
        Flight f3 = getFlight(10, 1, "18:30", "Tokyo", "A3", elal);
        Flight f4 = getFlight(10, 10, "17:30", "Tokyo", "A4", tus);
        Flight f5 = getFlight(10, 10, "18:30", "London", "A5", tus);
        subscribeToEvent(yosi, f1, "price");
        subscribeToEvent(yosi, f1, "destination");
        setFlightPrice(f1, 28);
        setFlightDestination(f1, "Paris");
        System.out.println("by price \n");
        lufthansa.execute();
        instance.execute();
        searchService.setSearchAlgo(new SearchAlgoByTime());
        searchService.execute(instance.getFlights());
    }

    private List<AbstractAirline> getAirlines() {
        List<AbstractAirline> airlines = new ArrayList<>();
        for (IComponent component : instance.getIComponents()) {
            if (component instanceof AbstractAirline) {
                airlines.add((AbstractAirline) component);
            }
        }
        return airlines;
    }

    private List<Flight> getFlights() {
        List<Flight> flightList = new ArrayList<>();
        for (AbstractAirline airline : instance.getAirlines()) {
            flightList.addAll(airline.getAllFlights());
        }
        return flightList;
    }

    private Flight getFlight(double price, double duration, String time, String dest, String code, AbstractAirline airline) {
        return Factory.getFlight(price, duration, time, dest, code, airline);
    }

    private ConcreteAirline getConcreteAirline(String name) {
        return Factory.getConcreteAirline(name, instance);
    }

    private ConcreteSubsidiaryAirline getConcreteSubsidiaryAirline(String name, AbstractAirline airline) {
        return Factory.getConcreteSubsidiaryAirline(name, airline);
    }

    private Employee getEmployee(String name, String id, AbstractAirline employer) {
        return Factory.getEmployee(name, id, employer);
    }

    private Passenger getPassenger(String name, String id) {
        return Factory.getPassenger(name, id);
    }

    private boolean removeFromSystem(String identifier, IProduct product) {
        return Factory.removeProduct(identifier, product);
    }

    private boolean removeAbstractAirline(AbstractContainer container, AbstractAirline airline) {
        return container.remove(airline);
    }

    private void setFlightPrice(Flight flight, double price) {
        flight.setPrice(price);
        flight.notify("price", flight);
    }

    private void setFlightDuration(Flight flight, double duration) {
        flight.setDuration(duration);
        flight.notify("duration", flight);
    }

    private void setFlightTime(Flight flight, String time) {
        flight.setTime(time);
        flight.notify("time", flight);
    }

    private void setFlightDestination(Flight flight, String destination) {
        flight.setDestination(destination);
        flight.notify("destination", flight);
    }

    private void subscribeToEvent(ISubscriber subscriber, AbstractPublisher publisher, String event) {
        publisher.subscribe(event, subscriber);
    }
    private void unsubscribeFromEvent(ISubscriber subscriber, AbstractPublisher publisher, String event) {
        publisher.unsubscribe(event, subscriber);
    }
}

