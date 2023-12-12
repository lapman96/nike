package patterns.observer.subscribers;

import patterns.observer.ObservationSubject;

public class Logger implements Observer {
    public Logger() {
    }

    @Override
    public void update(ObservationSubject observationSubject) {
        System.out.println("Logger has got a new event. The weather data has been updated." + observationSubject.getActualData());
    }
}
