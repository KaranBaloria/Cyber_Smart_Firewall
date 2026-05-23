import java.util.regex.Pattern;

public class AttackDetector {

    Pattern sqlPattern = Pattern.compile(".*(DROP|DELETE|TRUNCATE|--).*", Pattern.CASE_INSENSITIVE);
    Pattern xssPattern = Pattern.compile(".*(<script>|</script>).*", Pattern.CASE_INSENSITIVE);

    public boolean isAttack(String payload) {
        return sqlPattern.matcher(payload).matches()
            || xssPattern.matcher(payload).matches();
    }
}
