package Strategy;
import java.util.Comparator;

public class TimeComparator implements Comparator<String> {
    @Override
    public int compare(String time1, String time2) { // returns >1 if time1 is later than time2, <1 if time1 is earlier than time2
        // Split the strings into hours and minutes
        String[] time1Parts = time1.split(":");
        String[] time2Parts = time2.split(":");

        // Parse hours and minutes to integers
        int hour1 = Integer.parseInt(time1Parts[0]);
        int minute1 = Integer.parseInt(time1Parts[1]);
        int hour2 = Integer.parseInt(time2Parts[0]);
        int minute2 = Integer.parseInt(time2Parts[1]);

        // Compare hours first
        if (hour1 != hour2) {
            return hour1 - hour2;
        }

        // If hours are equal, compare minutes
        return minute1 - minute2;
    }
}
