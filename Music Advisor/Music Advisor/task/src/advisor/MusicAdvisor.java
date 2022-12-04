package advisor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MusicAdvisor {

    private static String[] obtainUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split(" ");
    }

    protected static void run() {
        boolean isAuth = false;

        while (true) {
            String message = matchPattern(isAuth);

            if ("Stop Program".equals(message)) {
                System.out.println("---GOODBYE!---");
                break;
            } else if ("access_token acquired".equals(message)) {
                isAuth = true;
            }
        }
    }

    protected static String matchPattern(boolean isAuth) {
        String[] groupOfKeyword = obtainUserInput();
        String keyword = groupOfKeyword[0];
        String playWhichList = "";
        if (groupOfKeyword.length > 1) playWhichList = groupOfKeyword[1];

        switch (keyword) {
            case "auth":
                auth();
                if (!Config.ACCESS_TOKEN.isEmpty()) {
                    return "access_token acquired";
                }
                break;
            case "exit":
                return "Stop Program";
            default:
                if (isAuth) sentRequest(keyword, playWhichList);
                else System.out.println("Please, provide access for application.");
                break;
        }

        return "Some message";
    }

    protected static void auth() {
        Authorization auth = new Authorization();
        auth.createHttpServer();
        auth.authRequest();
    }

    protected static void sentRequest(String keyword, String playWhichList) {
        switch (keyword) {
            case "new":
                getNewList();
                break;
            case "featured":
                getFeaturedList();
                break;
            case "categories":
                getCategoriesList();
                break;
            case "playlists":
                // TODO Special handle ... play list from categories
                System.out.println("Play this list --> " + playWhichList);
                break;
            default:
                break;
        }
    }

    protected static void getNewList() {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create("https://api.spotify.com/v1/browse/new-releases");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.statusCode());
            System.out.println(response.body());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected static void getFeaturedList() {
        System.out.println("---FEATURED---\n" +
                "Mellow Morning\n" +
                "Wake Up and Smell the Coffee\n" +
                "Monday Motivation\n" +
                "Songs to Sing in the Shower"
        );
    }

    protected static void getCategoriesList() {
        System.out.println("Top Lists\n" +
                "Pop\n" +
                "Mood\n" +
                "Latin"
        );
    }

    protected static void getMoodPlayList() {
        System.out.println("Walk Like A Badass\n" +
                "Rage Beats\n" +
                "Arab Mood Booster\n" +
                "Sunday Stroll"
        );
    }
}
