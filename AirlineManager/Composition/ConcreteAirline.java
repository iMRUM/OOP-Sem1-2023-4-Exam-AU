package Composition;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAirline extends AbstractAirline {
    public ConcreteAirline(String name, IContainer parent) {
        super(name, parent);
    }

    @Override
    public void display() { // will display sub airlines and flights only
        System.out.println("subairlines are: " + getSubAirlines() + ". It has the following flights: " + getFlights());
    }
}
