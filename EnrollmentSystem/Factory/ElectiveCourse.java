package Factory;

public class ElectiveCourse extends AbstractCourse {
    protected ElectiveCourse(String name, String id, ConcreteProfessor concreteProfessor) {
        super(name, id, 24, concreteProfessor);
    }
}
