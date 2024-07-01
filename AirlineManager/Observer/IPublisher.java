package Observer;

import java.util.Map;

public interface IPublisher {
    public void subscribe(String event, ISubscriber iSubscriber);

    public void unsubscribe(String event, ISubscriber iSubscriber);

    public void notify(String event, Object o);

    public void addEvent(String event);
}
