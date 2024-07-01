package Observer;

public interface IPublisher {
    public void subscribe(String event, ISubscriber iSubscriber);
    public void unsubscribe(String event, ISubscriber iSubscriber);
    public void notifyAll(String event, Object o);
    public void addEvent(String event);
}
