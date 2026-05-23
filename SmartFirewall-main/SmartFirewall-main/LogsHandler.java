import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import java.util.List;

public class LogsHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        List<String> logs = FirewallLogger.getLogs();

        StringBuilder response = new StringBuilder();
        for (String log : logs) {
            response.append(log).append("\n");
        }

        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.toString().getBytes());
        os.close();
    }
}
