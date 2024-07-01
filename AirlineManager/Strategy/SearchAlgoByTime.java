package Strategy;

import Composition.Flight;

import java.util.*;

public class SearchAlgoByTime implements ISearchAlgo {
    private String time;
    private List<Flight> validFlights;

    @Override
    public void collectFlightSearchInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the latest time for departure, according to 24H format (HH:MM)\n");
        this.time = scanner.next();
    }

    @Override
    public void search(List<Flight> flightList) {
        validFlights = new ArrayList<>();
        Comparator comparator = new TimeComparator();
        for (Flight flight : flightList) {
            if (comparator.compare(time, flight.getTime()) >= 0) {
                validFlights.add(flight);
            }
        }
        validFlights.sort(comparator);
        System.out.println(validFlights);
    }
}