package Observer;

import Factory.IProduct;

public class Passenger extends AbstractUser implements IProduct {
    private String name;
    private String id;

    public Passenger(String name, String id) {
        super(name, id);
    }

    @Override
    public void display() {
        System.out.println("ID: "+getId()+", NAME: "+getName()+".");
    }
}
