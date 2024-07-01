package Observer;

import Composition.AbstractAirline;
import Factory.IProduct;

public class Employee extends AbstractUser implements IProduct {
    private AbstractAirline employer;
    public Employee(String name, String id, AbstractAirline employer) {
        super(name, id);
        this.employer = employer;
    }

    public AbstractAirline getEmployer() {
        return employer;
    }

    @Override
    public void display() {
        System.out.println("ID: "+getId()+", NAME: "+getName()+", EMPLOYER: "+getEmployer().getName());
    }
}
