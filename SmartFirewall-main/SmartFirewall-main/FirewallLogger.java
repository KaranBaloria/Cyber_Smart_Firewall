import java.util.ArrayList;
import java.util.List;

public class FirewallLogger {

    private static List<String> logs = new ArrayList<>();

    public void log(String msg) {
        String entry = "[LOG] " + msg;
        logs.add(entry);
        System.out.println(entry);
    }

    public void alert(String msg) {
        String entry = "[ALERT] " + msg;
        logs.add(entry);
        System.out.println(entry);
    }

    public static List<String> getLogs() {
        return logs;
    }
}
