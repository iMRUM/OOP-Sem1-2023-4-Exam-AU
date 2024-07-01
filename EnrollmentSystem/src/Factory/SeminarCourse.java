package Factory;

public class SeminarCourse extends AbstractCourse{
    protected SeminarCourse(String name, String id, ConcreteProfessor concreteProfessor) {
        super(name, id, 12, concreteProfessor);
    }
}
