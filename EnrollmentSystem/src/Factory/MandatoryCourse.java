package Factory;

public class MandatoryCourse extends AbstractCourse {
    protected MandatoryCourse(String name, String id, ConcreteProfessor concreteProfessor) {
        super(name, id, 48, concreteProfessor);
    }
}
