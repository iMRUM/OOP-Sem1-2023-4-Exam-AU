package Factory;

import Observer.AbstractSubscriber;
import Observer.AbstractUser;

import java.util.ArrayList;

public class ConcreteStudent extends AbstractUser {
    ArrayList<AbstractCourse> enrolledCourses = new ArrayList<>();
    ArrayList<AbstractCourse> cart = new ArrayList<>();

    protected ConcreteStudent(String name, String id) {
        super(name, id);
    }

    public void addToCart(AbstractCourse course) {
            cart.add(course);
    }

    public void enrollCart() {
        for (AbstractCourse course : cart) {
            course.addStudent();
        }
        enrolledCourses.addAll(cart);
        cart.removeAll(cart);
    }

    public ArrayList<AbstractCourse> getEnrolledCourses() {
        return enrolledCourses;
    }

    public ArrayList<AbstractCourse> getCart() {
        return cart;
    }

    @Override
    public void display() {
        System.out.println("NAME: " + getName() + ", ID: " + getId() + " is enrolled for the following: " + getEnrolledCourses());
    }
}
