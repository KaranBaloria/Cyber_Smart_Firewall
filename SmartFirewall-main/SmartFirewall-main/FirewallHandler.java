import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;

public class FirewallHandler implements HttpHandler {

    Firewall firewall = new Firewall();

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(exchange.getRequestBody())
        );

        String payload = br.readLine();
        if (payload == null) payload = "";

        String ip = exchange.getRemoteAddress()
                            .getAddress()
                            .getHostAddress();

        FirewallRequest request = new FirewallRequest(ip, payload);
        boolean allowed = firewall.engine.inspect(request);

        String response = allowed ? "ALLOWED" : "BLOCKED";

        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
