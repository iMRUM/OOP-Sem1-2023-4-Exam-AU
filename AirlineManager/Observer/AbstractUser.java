package Observer;

public abstract class AbstractUser extends AbstractSubscriber {
    private String name;
    private String id;

    public AbstractUser(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
