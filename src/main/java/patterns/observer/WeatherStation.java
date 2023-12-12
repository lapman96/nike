package patterns.observer;

import patterns.observer.subscribers.Observer;

import java.util.HashMap;
import java.util.Map;

public class WeatherStation implements ObservationSubject{
    private float temperature;
    private float windSpeed;
    private float pressure;
    private Map<String, Observer> subscribers = new HashMap<>();

    public WeatherStation() {}

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        this.notifyObservers();
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
        this.notifyObservers();
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
        this.notifyObservers();
    }

    @Override
    public void addObserver(String subscriberName, Observer observer) {
        subscribers.put(subscriberName, observer);
    }

    @Override
    public void removeObserver(String subscriberName) {
        subscribers.remove(subscriberName);
    }

    @Override
    public void notifyObservers() {
        subscribers.forEach((key, value) -> value.update(this));
    }

    public String getActualData() {
        return "WeatherStation{" +
                "temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", pressure=" + pressure +
                '}';
    }
}
