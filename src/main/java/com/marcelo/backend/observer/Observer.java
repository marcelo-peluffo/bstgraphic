package com.marcelo.backend.observer;

/**
 * An interface for objects that observe changes in a subject.
 */
public interface Observer {
    /**
     * This method is called when the subject changes.
     */
    void update();
}
