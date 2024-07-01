package Factory;

import Observer.AbstractUser;

public class ConcreteProfessor extends AbstractUser {
    protected ConcreteProfessor(String name, String id) {
        super(name, id);
    }

    @Override
    public void display() {
        System.out.println("Proffesor: " + getName() + ", ID: "+ getId());
    }
}
