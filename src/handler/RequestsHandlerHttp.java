package handler;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import singleton.TaskExecutor;
import singleton.TasksList;

import java.io.*;


//this file gives context to the server


public class RequestsHandlerHttp implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        //this function will handle all server requests


        //this line gets the user header
        Headers requestHeaders = httpExchange.getRequestHeaders();
        
        //this virable contains the response to the user
        String response = "";
        // this virable contains of the request method is GET or POST


        //i wonder what happen if i use non existent request method
        String requestMethod = httpExchange.getRequestMethod();
        switch (requestMethod) {
            case "GET":

                //if the method is get
                //the response is the list of tasks
                response = TasksList.INSTANCE.list();
                System.out.println("New get request");
                break;
            case "POST":
                //if it is post add the task in the post body
                InputStream input = httpExchange.getRequestBody();

                //did something with body some processing
                StringBuilder params = new StringBuilder();
                new BufferedReader(new InputStreamReader(input))
                    .lines()
                    .forEach(s -> params.append(s));

                System.out.println("New request from " + requestHeaders.get("User-agent") + " -> " + params);
                response = TaskExecutor.INSTANCE.run(params.toString());
                break;
        }

        httpExchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
