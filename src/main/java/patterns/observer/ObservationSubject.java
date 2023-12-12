package patterns.observer;

import patterns.observer.subscribers.Observer;

public interface ObservationSubject {
    void addObserver(String subscriberName, Observer observer);
    void removeObserver(String subscriberName);
    void notifyObservers();
    String getActualData();
}
