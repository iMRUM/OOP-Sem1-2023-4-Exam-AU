package States;

import Factory.ConcreteLecturer;
import Factory.EnrollmentSystem;

public class LecturerState extends AbstractState {
    public LecturerState(EnrollmentSystem context) {
        super(context);
    }

    @Override
    public void handle() {
        login();
    }

    public void login() {
        String id = read("enter your id");
        String name = read("enter your name");
        decision(context.getConcreteLecturer(name, id));
    }

    public void redirect(ConcreteLecturer lecturer) {
        System.out.println("REDIRECTING...\n");
        decision(lecturer);
    }

    public void decision(ConcreteLecturer lecturer) {
        int decision = readType("What would you like to do?\n1 - Modify existing course\n2 - Go back to start-up screen");
        switch (decision) {
            case 1:
                modifyExistingCourse(lecturer);
                break;
            case 2:
                logout();
                break;

        }
    }


    private void modifyExistingCourse(ConcreteLecturer lecturer) {
        String courseId = read("enter course id to be modified\n");
        if (context.isCourse(courseId)) {
            int type = readType("What would you like to do?\n1 - Remove yourself from course \n2 - Change course capacity\n3 - Remove course from system");
            switch (type) {
                case 1:
                    modifyCourseLecturer(lecturer, courseId);
                    break;
                case 2:
                    modifyCourseCapacity(lecturer, courseId);
                    break;
                case 3:
                    removeCourse(lecturer, courseId);
                    break;
            }
        } else {
            System.out.println("The course ID wasn't found.");
            redirect(lecturer);

        }
    }

    private void modifyCourseLecturer(ConcreteLecturer lecturer, String courseId) {
        String lecturerId = read("enter lecturer ID for authentication");
        if (context.isLecturerInCourse(courseId, lecturerId)) {
            System.out.println("Remove?\nY / N");
            if (proceed()) {
                context.removeLecturerFromCourse(courseId, lecturerId);
            }
        } else {
            String lecturerName = read("lecturer was not found");
        }
        redirect(lecturer);
    }

    private void modifyCourseCapacity(ConcreteLecturer lecturer, String courseId) {
        int capacity = readType("enter new capacity");
        context.modifyCapacity(courseId, capacity);
        redirect(lecturer);
    }

    private void removeCourse(ConcreteLecturer lecturer, String courseId) {
        System.out.println("Are you sure?\nY / N");
        if (proceed()) {
            context.removeCourse(courseId);
        }
        redirect(lecturer);
    }

}
