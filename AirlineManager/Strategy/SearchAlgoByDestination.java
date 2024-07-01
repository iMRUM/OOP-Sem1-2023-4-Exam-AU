package Strategy;
import Composition.Flight;

import java.util.List;
import java.util.Scanner;
public class SearchAlgoByDestination implements ISearchAlgo {
    private String destination;
    @Override
    public void collectFlightSearchInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter destination");
        this.destination = scanner.next();
    }
    @Override
    public void search(List<Flight> flightList) {
        for(Flight flight: flightList){
            if (flight.getDestination().equals(destination) ){
                System.out.println(flight + " ");
            }
        }
    }
}

