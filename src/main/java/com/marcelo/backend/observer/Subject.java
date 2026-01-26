package com.marcelo.backend.observer;

/**
 * An interface for objects that can be observed.
 */
public interface Subject {
    /**
     * Adds an observer to the list of observers.
     * @param observer the observer to be added.
     */
    void addObserver(Observer observer);

    /**
     * Removes an observer from the list of observers.
     * @param observer the observer to be removed.
     */
    void removeObserver(Observer observer);

    /**
     * Notifies all observers of a change.
     */
    void notifyObservers();
}
