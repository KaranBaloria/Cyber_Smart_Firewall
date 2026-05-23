public class FirewallRuleEngine {

    IPReputationService ipService = new IPReputationService();
    RateLimiter rateLimiter = new RateLimiter();
    AttackDetector attackDetector = new AttackDetector();
    FirewallLogger logger = new FirewallLogger();

    public boolean inspect(FirewallRequest request) {

        if (ipService.isMalicious(request.ip)) {
            logger.alert("Blocked malicious IP: " + request.ip);
            return false;
        }

        if (!rateLimiter.isAllowed(request.ip)) {
            logger.alert("Rate limit exceeded for IP: " + request.ip);
            return false;
        }

        if (attackDetector.isAttack(request.payload)) {
            logger.alert("Attack detected from IP: " + request.ip);
            return false;
        }

        logger.log("Request allowed from IP: " + request.ip);
        return true;
    }
}
