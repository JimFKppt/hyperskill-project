package advisor;

import com.sun.net.httpserver.HttpServer;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Authorization {

    protected void createHttpServer() {

        String uri = Config.SERVER_PATH + "/authorize" +
                "?client_id=" + Config.CLIENT_ID +
                "&redirect_uri=" + Config.REDIRECT_URI +
                "&response_type=code";

        System.out.println("use this link to request the access code:\n" + uri);

        try {
            HttpServer server = HttpServer.create();
            server.bind(new InetSocketAddress(8080), 0);
            server.start();
            server.createContext("/",
                    exchange -> {
                        String query = exchange.getRequestURI().getQuery();
//                            System.out.println(query);
                        String responseMessage;

                        if (query != null && query.contains("code")) {
                            Config.AUTH_CODE = query.substring(5);
                            System.out.println("code received");
                            responseMessage = "Got the code. Return back to your program.";
                        } else {
                            responseMessage = "Authorization code not found. Try again.";
                        }

                        exchange.sendResponseHeaders(200, responseMessage.length());
                        exchange.getResponseBody().write(responseMessage.getBytes());
                        exchange.getResponseBody().close();
                    }
            );

            System.out.println("waiting for code...");

            if(Config.AUTH_CODE.isBlank()) {
                Thread.sleep(10);
            }

            server.stop(10);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void authRequest() {

        System.out.println("making http request for access_token...");
        System.out.println("response:");

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .uri(URI.create(Config.SERVER_PATH + "/api/token"))
                .POST(HttpRequest.BodyPublishers.ofString(
                        "grant_type=authorization_code" +
                                "&code=" + Config.AUTH_CODE +
                                "&client_id=" + Config.CLIENT_ID +
                                "&client_secret=" + Config.CLIENT_SECRET +
                                "&redirect_uri=" + Config.REDIRECT_URI))
                .build();

        try {
            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response != null && response.body().contains("access_token")) {
                parseAssessToken(response.body());
            }

            assert response != null;
            System.out.println(response.body());
            System.out.println("---SUCCESS---");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void parseAssessToken(String body) {
        JsonObject jo = JsonParser.parseString(body).getAsJsonObject();
        Config.ACCESS_TOKEN = jo.get("access_token").getAsString();
    }
}
