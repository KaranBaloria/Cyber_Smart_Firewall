import java.util.HashSet;

public class IPReputationService {

    HashSet<String> blacklistedIPs = new HashSet<>();

    public IPReputationService() {
        blacklistedIPs.add("192.168.1.10");
        blacklistedIPs.add("10.0.0.5");
    }

    public boolean isMalicious(String ip) {
        return blacklistedIPs.contains(ip);
    }
}
