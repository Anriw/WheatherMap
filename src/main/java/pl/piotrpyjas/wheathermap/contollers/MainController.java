package pl.piotrpyjas.wheathermap.contollers;

import pl.piotrpyjas.wheathermap.models.DownloadWeatherService;
import pl.piotrpyjas.wheathermap.views.MainView;

import java.util.Scanner;

public class MainController {
    private MainView mainView;
    private Scanner scanner;
    private DownloadWeatherService downloadWeatherService = DownloadWeatherService.getInstance();

    public MainController() {
        mainView = new MainView();
        scanner = new Scanner(System.in);
    }

    public void start() {
        mainView.showWelcomeText();
        createMainLoop();
    }

    private void createMainLoop() {
        String userAnswerCity;
        String userAnswerCountry;

        int maxCityLenght = 20;
        int maxCountryLenght = 2;

        do {
            mainView.showCityRequestText();
            userAnswerCity = scanner.nextLine();

            if (userAnswerCity.length() > maxCityLenght){
                System.out.println("Za długa nazwa");
                break;
            }

            mainView.showCountryRequestText();
            userAnswerCountry = scanner.nextLine();

            if (userAnswerCountry.length() > maxCountryLenght){
                System.out.println("Za długi skrot panstwa");
                break;
            }


            mainView.printWeather(downloadWeatherService.getWeather(userAnswerCity,userAnswerCountry));

        } while (!userAnswerCity.equals("exit"));
    }
}

