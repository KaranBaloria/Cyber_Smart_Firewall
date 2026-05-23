import java.util.HashMap;

public class RateLimiter {

    HashMap<String, Integer> requestCount = new HashMap<>();
    int LIMIT = 15;

    public boolean isAllowed(String ip) {
        requestCount.put(ip, requestCount.getOrDefault(ip, 0) + 1);
        return requestCount.get(ip) <= LIMIT;
    }
}
