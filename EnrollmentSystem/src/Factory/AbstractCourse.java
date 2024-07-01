package Factory;

import Observer.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractCourse extends AbstractPublisher implements CourseInterface, IProduct {
    private String name;
    private String id;
    private int capacity;
    Map<String, ConcreteLecturer> lecturerMap;
    private ConcreteProfessor professor;

    protected AbstractCourse(String name, String id, int capacity, ConcreteProfessor concreteProfessor) {
        super("open");
        this.name = name;
        this.id = id;
        this.capacity = capacity;
        this.professor = concreteProfessor;
        this.lecturerMap = new HashMap<String, ConcreteLecturer>();
    }

    @Override
    public void addStudent() {
        capacity--;
        if (isFull()) {
            notifyAll("full", this);
        }
    }

    @Override
    public void removeStudent() {
        capacity++;
        if (!isFull()) {
            notifyAll("open", this);
        }
    }

    @Override
    public void addLecturer(ConcreteLecturer lecturer) {
        lecturerMap.put(lecturer.getId(), lecturer);
    }

    @Override
    public void removeLecturer(String lecturerId) {
        lecturerMap.remove(lecturerId);
    }

    @Override
    public void setProfessor(ConcreteProfessor professor) {
        this.professor = professor;
    }

    @Override
    public boolean isFull() {
        return (capacity == 0);
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
        if (isFull()) {
            notifyAll("full", this);
        }
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return (getName() + ", " + getId());
    }

    @Override
    public void display() {
        System.out.println(getName() + ", " + getId());
    }

    public boolean isLecturer(String lecturerId) {
        return lecturerMap.containsKey(lecturerId);
    }
}
