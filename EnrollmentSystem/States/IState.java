package States;

import Observer.AbstractUser;

public interface IState {
    public void handle();
    public void setState(IState state);
}
