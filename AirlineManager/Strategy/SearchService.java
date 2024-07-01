package Strategy;

import Composition.Flight;

import java.util.List;

public class SearchService implements ISearchService {
    private ISearchAlgo ISearchAlgo;

    @Override
    public void setSearchAlgo(Strategy.ISearchAlgo ISearchAlgo) {
        this.ISearchAlgo = ISearchAlgo;
    }

    @Override
    public void execute(List<Flight> flights) {
        ISearchAlgo.collectFlightSearchInfo();
        ISearchAlgo.search(flights);
    }
}