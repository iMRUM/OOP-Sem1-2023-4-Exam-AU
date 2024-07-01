package States;

import Factory.EnrollmentSystem;

import java.util.Scanner;

public abstract class AbstractState implements IState {
    protected EnrollmentSystem context;

    public AbstractState(EnrollmentSystem context) {
        this.context = context;
    }

    @Override
    public void setState(IState iState) {
        iState.handle();
    }

    public void logout() {
            setState(new StartupState(context));
    }

    protected boolean proceed() {
        Scanner input = new Scanner(System.in);
        String answer = input.next();
        return answer.equals("Y");
    }

    protected String read(String context) {
        System.out.println(context.toUpperCase() + ":\n");
        Scanner input = new Scanner(System.in);
        String answer = input.next();
        return answer;
    }

    protected int readType(String context) {
        System.out.println(context.toUpperCase() + ":\n");
        Scanner input = new Scanner(System.in);
        int answer = input.nextInt();
        return answer;
    }
}

