package patterns.observer.subscribers;

import patterns.observer.ObservationSubject;

public class AlertSystem implements Observer {
    public AlertSystem() {
    }

    @Override
    public void update(ObservationSubject observationSubject) {
        System.out.println("AlertSystem has got new event. The weather data has been updated." + observationSubject.getActualData());
    }
}
