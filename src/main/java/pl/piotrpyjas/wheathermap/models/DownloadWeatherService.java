package pl.piotrpyjas.wheathermap.models;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadWeatherService {
    private static DownloadWeatherService INSTANCE = new DownloadWeatherService();

    private DownloadWeatherService() {
    }

    public static DownloadWeatherService getInstance() {
        return INSTANCE;
    }

    public String getWeather(String cityName, String countryName) {
        String url = Config.URL_TO_API + cityName + "," + countryName + "&appid=" + Config.API_KEY;
        String cleanJson = readWebsite(url);

        JSONObject root = new JSONObject(cleanJson);
        JSONObject main = root.getJSONObject("main");
        JSONObject sys = root.getJSONObject("sys");
        //JSONObject cod = root.getJSONObject("cod");

        int cod = root.getInt("cod");

        String country = sys.getString("country");

        double temp = main.getDouble("temp");

        return "Temp: " + (temp - 273) + " " + country + " " + cod;
    }

    public String readWebsite(String url) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();

            int response = 0;
            while ((response = inputStream.read()) != -1) {
                stringBuilder.append((char) response);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

}
