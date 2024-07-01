package States;

import Factory.EnrollmentSystem;
import Observer.AbstractUser;

public class StartupState extends AbstractState {
    public StartupState(EnrollmentSystem context) {
        super(context);
    }
    @Override
    public void handle() {
        int action = readType("Who are you\n1 - STUDENT\n2 - PROFESSOR\n3 - LECTURER");
        switch (action) {
            case 1:
                setState(new StudentState(context));
            case 2:
                setState(new ProfessorState(context));
            case 3:
                setState(new LecturerState(context));
        }
    }



}
