package patterns.observer;

import patterns.observer.subscribers.AlertSystem;
import patterns.observer.subscribers.Logger;
import patterns.observer.subscribers.UserInterface;

public class Client {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        UserInterface userInterface = new UserInterface();
        Logger logger = new Logger();
        AlertSystem alertSystem = new AlertSystem();

        weatherStation.addObserver("ui", userInterface);
        weatherStation.addObserver("logger", logger);
        weatherStation.addObserver("alert", alertSystem);

        weatherStation.setTemperature(22.5f);
        weatherStation.removeObserver("ui");
        weatherStation.setWindSpeed(5f);
        weatherStation.removeObserver("alert");
        weatherStation.setPressure(31.5f);
    }
}
