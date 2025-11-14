import com.sun.net.httpserver.HttpServer;
import handler.RequestsHandlerHttp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class WebServerHttp {
    //port 8000
    private static final int PORT = 8000;



    //main function (thread) running the server
    public static void main(String[] args) throws IOException {
        // creating server on a socket connection on port 8000
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        //this line add context to the server   
        //probably most important line we will see as we reverse engineer this shit
        server.createContext("/", new RequestsHandlerHttp());

        //server.setExecutor(Executors.newFixedThreadPool(1));

        //every request is handled by new thread
        //cached thread pool is unbound thread pool (not fixed)
        server.setExecutor(Executors.newCachedThreadPool());

        server.start();
        System.out.println("WebServerHttp is listening on port " + PORT);
    }
}








