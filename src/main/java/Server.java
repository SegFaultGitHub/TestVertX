import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by SegFault on 21/01/2017.
 */
public class Server extends AbstractVerticle {
    private int port;
    private Logger logger;

    public Server(int port) {
        this.port = port;
        logger = LogManager.getLogger(Server.class);
    }

    @Override
    public void start() throws Exception {
        super.start();

        HttpServer server = vertx.createHttpServer();
        Router router = Router.router(vertx);

        server.requestHandler(router::accept).listen(port);
    }
}