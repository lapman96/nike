package patterns.observer.subscribers;

import patterns.observer.ObservationSubject;

public class UserInterface implements Observer {
    public UserInterface() {
    }

    @Override
    public void update(ObservationSubject observationSubject) {
        System.out.println("UI has got a new event. The weather data has been updated." + observationSubject.getActualData());
    }
}
