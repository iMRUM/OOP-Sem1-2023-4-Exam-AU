package Strategy;
import Composition.Flight;

import java.util.List;

public interface ISearchAlgo {
    public void collectFlightSearchInfo();
    public void search(List<Flight> flightList);
}
