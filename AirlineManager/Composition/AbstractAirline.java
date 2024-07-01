package Composition;

import Factory.IProduct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractAirline extends AbstractContainer implements IComponent, IProduct {
    private String name;
    private IContainer parent;

    public AbstractAirline(String name, IContainer parent) {
        super();
        this.name = name;
        this.parent = parent;
        parent.add(this);
    }

    public String getName() {
        return name;
    }

    public IContainer getParent() {
        return parent;
    }

    public List<Flight> getFlights() {
        List<Flight> flightList = new ArrayList<>();
        Iterator<IComponent> iterator = iComponents.iterator();
        while (iterator.hasNext()) {
            IComponent component = iterator.next();
            if (component instanceof Flight) {
                flightList.add((Flight) component);
            }
        }
        return flightList;
    }

    public List<AbstractAirline> getSubAirlines() {
        List<AbstractAirline> abstractAirlineListList = new ArrayList<>();
        Iterator<IComponent> iterator = iComponents.iterator();
        while (iterator.hasNext()) {
            IComponent component = iterator.next();
            if (component instanceof AbstractAirline) {
                abstractAirlineListList.add((AbstractAirline) component);
            }
        }
        return abstractAirlineListList;
    }

    public List<Flight> getAllFlights() {
        List<Flight> flightList = new ArrayList<>();
        flightList.addAll(getFlights());
        for (AbstractAirline airline : getSubAirlines()) {
            flightList.addAll(airline.getFlights());
        }
        return flightList;
    }

    @Override
    public String toString() {
        return name;
    }
}
