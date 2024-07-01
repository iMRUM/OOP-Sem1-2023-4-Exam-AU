package Composition;

import java.util.List;

public interface IContainer {
    public void add(IComponent iComponent);
    public boolean remove(IComponent iComponent);
    public List<IComponent> getIComponents();
    public void execute();
}
