import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class FirewallServer {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(
                new InetSocketAddress(8080), 0
        );

        // Frontend serve karega
        server.createContext("/", new StaticFileHandler());

        // API endpoints
        server.createContext("/check", new FirewallHandler());
        server.createContext("/logs", new LogsHandler());

        server.start();

        System.out.println("🔥 Smart Firewall running at http://localhost:8080");
    }
}
