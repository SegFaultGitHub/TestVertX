import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

/**
 * Created by SegFault on 21/01/2017.
 */
public class Main {
    private static String host;
    private static int port;

    public static void main(String[] args) {
        VertxOptions vertxOptions = new VertxOptions();
        vertxOptions.setBlockedThreadCheckInterval(1000 * 60 * 60);
        vertxOptions.setClusterPublicHost(host);
        vertxOptions.setClusterPublicPort(port);
        Vertx vertx = Vertx.vertx(vertxOptions);

        Server server = new Server(1337);
        Client client = new Client("192.168.1.7", 1337);

        vertx.eventBus().consumer("/test", message -> {
            System.out.println(message.body());
        });
    }
}
