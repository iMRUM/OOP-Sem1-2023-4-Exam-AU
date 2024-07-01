package Composition;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractContainer implements IContainer{
    List<IComponent> iComponents;
    public AbstractContainer(){
        iComponents = new ArrayList<>();
    }

    @Override
    public void add(IComponent iComponent) {
        iComponents.add(iComponent);
    }

    @Override
    public boolean remove(IComponent iComponent) {
        return (iComponents.remove(iComponent));
    }

    public List<IComponent> getIComponents() {
        return iComponents;
    }

    @Override
    public void execute() {
        for (IComponent iComponent :iComponents){
            iComponent.execute();
        }
    }
}
