package Strategy;

import Composition.Flight;

import java.util.List;
import java.util.Scanner;
public class SearchAlgoByAirline implements ISearchAlgo {
    private String airline;
    @Override
    public void collectFlightSearchInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter airline");
        this.airline = scanner.next();
    }

    @Override
    public void search(List<Flight> flightList) {
        for(Flight flight: flightList){
            if (flight.getAirline().getName().equals(airline) ){
                System.out.println(flight + "\n");
            }
        }
    }
}

