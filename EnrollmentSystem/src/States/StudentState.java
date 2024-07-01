package States;

import Factory.ConcreteStudent;
import Factory.EnrollmentSystem;

public class StudentState extends AbstractState {
    public StudentState(EnrollmentSystem context) {
        super(context);
    }


    @Override
    public void handle() {
        login();
    }
    public void login(){
        String id = read("enter your id");
        String name = read("enter your name");
        searchCourse(context.getConcreteStudent(name, id));
    }
    public void redirect(ConcreteStudent student) {
        System.out.println("REDIRECTING...\n");
        decision(student);
    }
    public void decision(ConcreteStudent student){
        int type = readType("What would you like to do?\n1 - Search another course\n2 - Logout");
        switch (type){
            case 1:
                searchCourse(student);
                break;
            case 2:
                logout();
                break;
        }
    }
    private void searchCourse(ConcreteStudent student) {
        String courseId = read("enter course id to add to your cart");
        switch (context.addCourseToCart(student, courseId)) {
            case 0:
                System.out.println("ERROR: COURSE WAS NOT FOUND.");
                redirect(student);
                break;
            case 1:
                System.out.println("SUCCESS: The course was added to cart.");
                enrollCart(student);
                break;
            case 2:
                System.out.println("FAILED: The course is full and wasn't added to cart.");
                subscribeToCourse(student, courseId);
                break;
        }
    }

    private void subscribeToCourse(ConcreteStudent student, String courseId) {
        System.out.println("Would you like to subscribe to the course?\n Y - I do! \n N - search another course");
        if (proceed()) {
            context.subscribeStudentToCourse("open", student, courseId);
        }
        redirect(student);
    }

    private void enrollCart(ConcreteStudent student) {
        System.out.println("Would you like to enroll your cart?\n Y - I do! \n N - search another course");
        if (proceed()) {
            context.enrollCart(student);
        }
        redirect(student);
    }
}
