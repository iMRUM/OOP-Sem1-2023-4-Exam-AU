package Strategy;
import Composition.Flight;

import java.util.List;
import java.util.Scanner;
public class SearchAlgoByDuration implements ISearchAlgo {
    private double duration;
    @Override
    public void collectFlightSearchInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter maximum duration");
        this.duration = scanner.nextDouble();
    }
    @Override
    public void search(List<Flight> flightList) {
        for(Flight flight: flightList){
            if (flight.getDuration() <= duration){
                System.out.println(flight + " ");
            }
        }
    }
}