package Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractPublisher implements IPublisher {
    Map<String, List<ISubscriber>> subscribesMap = new HashMap<>();

    protected AbstractPublisher(String... events) {
        for (String event : events) {
            this.subscribesMap.put(event, new ArrayList<>());
        }
    }

    @Override
    public void subscribe(String event, ISubscriber iSubscriber) {
        subscribesMap.get(event).add(iSubscriber);
    }

    @Override
    public void unsubscribe(String event, ISubscriber iSubscriber) {
        subscribesMap.get(event).remove(iSubscriber);
    }

    @Override
    public void notify(String event, Object o) {
        List<ISubscriber> subscribers = subscribesMap.get(event);
        for (ISubscriber subscriber : subscribers) {
            subscriber.update(event, o);
        }
    }

    @Override
    public void addEvent(String event) {
        this.subscribesMap.put(event, new ArrayList<>());
    }
}
