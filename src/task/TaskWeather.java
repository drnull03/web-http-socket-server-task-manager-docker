package task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * TaskWeather fetches the current weather in Damascus using Open-Meteo API.
 * Returns all response data as a string (no parsing needed).
 */
public class TaskWeather extends TaskImpl {

    @Override
    public void execute() {
        try {
            result = getWeatherData();
        } catch (Exception e) {
            result = "Exception: " + e.getMessage();
        }
    }

    private String getWeatherData() throws IOException {
        // Open-Meteo API for Damascus: latitude=33.5, longitude=36.3
        String url = "http://api.open-meteo.com/v1/forecast?latitude=33.5&longitude=36.3&current_weather=true";

        return getRequest(url);
    }

    private String getRequest(String urlStr) throws IOException {
        StringBuilder response = new StringBuilder();

        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setInstanceFollowRedirects(true); // safe for redirects, if any

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line).append("\n");
            }
        }

        return response.toString();
    }
}
