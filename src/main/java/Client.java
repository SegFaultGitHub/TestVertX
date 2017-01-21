import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;

/**
 * Created by SegFault on 21/01/2017.
 */
public class Client extends AbstractVerticle {
    private int port;
    private String host;
    private HttpClient client;

    public Client(String host, int port) {
        this.port = port;
        this.host = host;
    }

    @Override
    public void start() throws Exception {
        super.start();
        HttpClientOptions options = new HttpClientOptions();
        options.setDefaultPort(1337);
        options.setDefaultHost("localhost");
        client = vertx.createHttpClient(options);
    }
}
