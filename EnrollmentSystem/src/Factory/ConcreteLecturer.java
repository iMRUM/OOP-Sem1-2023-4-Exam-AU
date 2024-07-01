package Factory;

import Observer.AbstractUser;

public class ConcreteLecturer extends AbstractUser {
    protected ConcreteLecturer(String name, String id) {
        super(name, id);
    }

    @Override
    public void display() {
        System.out.println("Lecturer: " + getName() + ", ID: "+ getId());
    }
}
