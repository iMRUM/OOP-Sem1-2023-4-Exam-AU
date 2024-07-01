package States;

import Factory.AbstractCourse;
import Factory.ConcreteProfessor;
import Factory.EnrollmentSystem;

public class ProfessorState extends AbstractState{
    public ProfessorState(EnrollmentSystem context) {
        super(context);
    }


    @Override
    public void handle() {
        login();
    }

    public void login(){
        String id = read("enter your id");
        String name = read("enter your name");
        decision(context.getConcreteProfessor(name, id));
    }

    public void redirect(ConcreteProfessor professor){
        System.out.println("REDIRECTING...\n");
        decision(professor);
    }
    public void decision(ConcreteProfessor professor){
        int decision = readType("What would you like to do?\n1 - Add new course\n2 - Modify existing course\n3 - Go back to start-up screen");
        switch (decision){
            case 1:
                addNewCourse(professor);
                break;
            case 2:
                modifyExistingCourse(professor);
                break;
            case 3:
                logout();
                break;

        }
    }
    private void addNewCourse(ConcreteProfessor professor){
        String courseId = read("enter course id to be created\n");
        if (!context.isCourse(courseId)){
            addCourse(professor, courseId);
        }else{
            System.out.println("The course ID is already taken, let's start over!");
        }
        redirect(professor);
    }
    private void addCourse(ConcreteProfessor professor, String courseId){
        String name = read("enter course name to be created\n");
        int type = readType("enter course type\n1 - Mandatory Course\n2 - Elective Course\n3 - Seminar Course");
        AbstractCourse course = context.getCourse(name, courseId, type, professor);
        System.out.println("The Course "+course+" was created.\n\n");
    }
    private void modifyExistingCourse(ConcreteProfessor professor){
        String courseId = read("enter course id to be modified\n");
        if (context.isCourse(courseId)){
            int type = readType("What would you like to do?\n1 - Add/Remove Lecturer \n2 - Change course capacity\n3 - Remove course from system\n4 - Replace existing course professor");
            switch (type){
                case 1:
                    modifyCourseLecturer(professor,courseId);
                    break;
                case 2:
                    modifyCourseCapacity(professor, courseId);
                    break;
                case 3:
                    removeCourse(professor, courseId);
                    break;
                case 4:
                    replaceProfessor(professor, courseId);
            }
        }else{
            System.out.println("The course ID wasn't found. Would you like to create one with the ID: "+ courseId +"?\nY / N?");
            if (proceed()){
                addCourse(professor,courseId);
            }
        }
        redirect(professor);
    }
    private void modifyCourseLecturer(ConcreteProfessor professor, String courseId){
        String lecturerId = read("enter lecturer ID");
        if (context.isLecturerInCourse(courseId, lecturerId)){
            System.out.println("Remove?\nY / N");
            if (proceed()){
                context.removeLecturerFromCourse(courseId, lecturerId);
            }
        }
        else {
            String lecturerName = read("enter lecturer name");
            context.addLecturerToCourse(courseId, lecturerId, lecturerName);
        }
        redirect(professor);
    }

    private void modifyCourseCapacity(ConcreteProfessor professor, String courseId){
        int capacity = readType("enter new capacity");
        context.modifyCapacity(courseId, capacity);
        redirect(professor);
    }
    private void removeCourse(ConcreteProfessor professor, String courseId){
        System.out.println("Are you sure?\nY / N");
        if (proceed()){
            context.removeCourse(courseId);
        }
        redirect(professor);
    }
    private void replaceProfessor(ConcreteProfessor professor, String courseId){
        System.out.println("Are you sure?\nY / N");
        if (proceed()){
            context.modifyProfessor(courseId, professor);
        }
        redirect(professor);
    }

}
