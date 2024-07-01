package Observer;

public abstract class AbstractSubscriber implements ISubscriber {
    @Override
    public void update(String event, Object o) {
        System.out.println(o + " is now " + event);
    }
}
