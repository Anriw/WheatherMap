package pl.piotrpyjas.wheathermap.views;

public class MainView {
    public void showWelcomeText() {
        System.out.println("Wiatj w WeatherMap!");
        System.out.println("Jesteśmy tu aby ci pomóc.. <3");
    }

    public void showCityRequestText() {
        System.out.println("Podaj miasto : ");
    }
    public void showCountryRequestText(){
        System.out.println("Podaj panstwo : ");
    }
    public void printWeather(String weatherText){
        System.out.println(weatherText);
    }
}
