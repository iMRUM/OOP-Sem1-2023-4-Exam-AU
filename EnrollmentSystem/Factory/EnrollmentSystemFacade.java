package Factory;

import java.util.ArrayList;
import java.util.HashMap;

public class EnrollmentSystemFacade {
    private static EnrollmentSystem instance;
    public static void run() {
        if (instance == null) {
            instance = EnrollmentSystem.getInstance();
        }
        instance.run();
    }
}
