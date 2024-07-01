package Composition;

public class ConcreteSubsidiaryAirline extends ConcreteAirline{
    public ConcreteSubsidiaryAirline(String companyName, AbstractAirline parentAirline){
        super(companyName, parentAirline);
    }
    @Override
    public void display() { // will display parent airline and flights only
        System.out.println("Parent airline is: " + getParent() + ". It has the following flights: " + getFlights());
    }
}