package Factory;

import Observer.AbstractUser;
import States.AbstractState;
import States.StartupState;

import java.util.*;

public class EnrollmentSystem {
    private static EnrollmentSystem instance;
    private AbstractState state;
    private Map<String, IProduct> productMap;
    private List<AbstractUser> users;

    private EnrollmentSystem() {
        productMap = new HashMap<>();
        users = new ArrayList<>(100);
        Factory.setProductMap(productMap);
        Factory.setUserList(users);
    }

    public static EnrollmentSystem getInstance() {
        if (instance == null) {
            instance = new EnrollmentSystem();
        }
        return instance;
    }
    protected void run() {
        new StartupState(instance).handle();
    }

    public ConcreteStudent getConcreteStudent(String name, String id) {
        return (ConcreteStudent) Factory.getUser(name, id, 1);
    }

    public ConcreteProfessor getConcreteProfessor(String name, String id) {
        return (ConcreteProfessor) Factory.getUser(name, id, 2);
    }

    public ConcreteLecturer getConcreteLecturer(String name, String id) {
        return (ConcreteLecturer) Factory.getUser(name, id, 3);
    }

    public AbstractUser getUser(String name, String id, int type) {
        return Factory.getUser(name, id, type);
    }

    public AbstractCourse getCourse(String name, String id, int type, ConcreteProfessor concreteProfessor) {
        return Factory.getCourse(name, id, type, concreteProfessor);
    }

    public void removeCourse(String id) {
        Factory.removeProduct(id);
    }

    public void subscribeStudentToCourse(String event, ConcreteStudent student, String id) {
        ((AbstractCourse) productMap.get(id)).subscribe(event, student);
    }

    public void unsubscribeStudentFromCourse(String event, ConcreteStudent student, AbstractCourse course) {
        course.unsubscribe(event, student);
    }

    public AbstractCourse searchCourse(String id) {
        try {
            AbstractCourse course = (AbstractCourse) productMap.get(id);
            if (course == null) {
                throw new IllegalArgumentException("The course does not exist.\n");
            }
            return course;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int addCourseToCart(ConcreteStudent student, String courseId) {
        AbstractCourse course = searchCourse(courseId);
        if (course == null) {
            return 0;
        }
        return !course.isFull() ? 1 : 2;
    }

    public void enrollCart(ConcreteStudent student) {
        student.enrollCart();
    }

    public boolean isCourse(String id) {
        return isInProductMap(id);
    }

    private boolean isInProductMap(String id) {
        return productMap.containsKey(id);
    }

    public boolean isLecturerInCourse(String courseId, String lecturerId) {
        return ((AbstractCourse) productMap.get(courseId)).isLecturer(lecturerId);
    }

    public void addLecturerToCourse(String courseId, String lecturerId, String lecturerName) {
        ((AbstractCourse) productMap.get(courseId)).addLecturer(getConcreteLecturer(lecturerName, lecturerId));
    }

    public void removeLecturerFromCourse(String courseId, String lecturerId) {
        ((AbstractCourse) productMap.get(courseId)).removeLecturer(lecturerId);
    }

    public void modifyCapacity(String courseId, int capacity) {
        ((AbstractCourse) productMap.get(courseId)).setCapacity(capacity);
    }

    public void modifyProfessor(String courseId, ConcreteProfessor professor) {
        ((AbstractCourse) productMap.get(courseId)).setProfessor(professor);
    }
}
