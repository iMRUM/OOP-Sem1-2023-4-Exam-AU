package Strategy;
import Composition.Flight;

import java.util.List;
import java.util.Scanner;
public class SearchAlgoByPrice implements ISearchAlgo {
    private int price;
    @Override
    public void collectFlightSearchInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter price");
        this.price = scanner.nextInt();
    }
    @Override
    public void search(List<Flight> flightList) {
        for(Flight flight: flightList){
            if (flight.getPrice() <= price){
                System.out.println(flight + " ");
            }
        }
    }
}
