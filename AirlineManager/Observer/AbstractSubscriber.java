package Observer;

public abstract class AbstractSubscriber implements ISubscriber {
    @Override
    public void update(String event, Object o) {
        System.out.println("There was a change in " + event + " for "+o);
    }
}
