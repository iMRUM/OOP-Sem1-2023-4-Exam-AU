package Factory;

public interface CourseInterface{
    public void addStudent();
    public void removeStudent();
    public void addLecturer(ConcreteLecturer lecturer);
    public void removeLecturer(String lecturerId);
    public void setProfessor(ConcreteProfessor professor);
    public void setCapacity(int capacity);
    public boolean isFull();
}
