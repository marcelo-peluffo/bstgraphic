package com.marcelo.util;

/**
 * A generic class representing an ordered pair of two objects.
 * @param <X> the type of the first object.
 * @param <Y> the type of the second object.
 */
public class OrderedPair<X, Y> {
    private X x;
    private Y y;

    /**
     * Constructs a new OrderedPair with the given values.
     * @param x the first value.
     * @param y the second value.
     */
    public OrderedPair(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the first value of the pair.
     * @return the first value.
     */
    public X getX() {
        return x;
    }

    /**
     * Sets the first value of the pair.
     * @param x the new first value.
     */
    public void setX(X x) {
        this.x = x;
    }

    /**
     * Returns the second value of the pair.
     * @return the second value.
     */
    public Y getY() {
        return y;
    }

    /**
     * Sets the second value of the pair.
     * @param y the new second value.
     */
    public void setY(Y y) {
        this.y = y;
    }
}
