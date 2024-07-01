package Composition;

import Factory.IProduct;
import Observer.AbstractPublisher;
import Observer.ISubscriber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flight extends AbstractPublisher implements IComponent, IProduct {
    private double price, duration;
    private String time;
    private String destination, code;
    private AbstractAirline airline;

    public Flight(double price, double duration, String time, String dest, String code, AbstractAirline airline) {
        super("price", "duration", "time", "destination", "code", "airline");
        this.price = price;
        this.duration = duration;
        this.time = time;
        this.destination = dest;
        this.code = code;
        this.airline = airline;
    }

    @Override
    public String toString() {
        return "Flight " + code;
    }

    public String getCode() {
        return code;
    }

    public AbstractAirline getAirline() {
        return airline;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void display() {
        System.out.println("DESTINATION: " + this.getDestination() + ", AT: " + this.getTime() + ", WILL TAKE: " + this.getDuration() + ", COSTS: " + this.getPrice() + ", Flying with: " + this.airline);
    }

    @Override
    public void execute() {
        display();
    }

}
