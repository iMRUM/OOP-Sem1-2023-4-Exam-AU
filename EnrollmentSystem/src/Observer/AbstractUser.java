package Observer;

import Factory.IProduct;

public abstract class AbstractUser extends AbstractSubscriber implements IProduct {
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
