package patterns.observer.subscribers;

import patterns.observer.ObservationSubject;

public interface Observer {
    void update(ObservationSubject observationSubject);
}
