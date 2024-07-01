package Strategy;

import Composition.Flight;

import java.util.List;

public interface ISearchService {
    public void setSearchAlgo(ISearchAlgo ISearchAlgo);
    public void execute(List<Flight> flights);
}
