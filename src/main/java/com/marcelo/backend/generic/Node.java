package com.marcelo.backend.generic;

/**
 * An interface representing a node in a binary tree.
 * @param <T> the type of data stored in the node, which must be comparable.
 */
public interface Node<T extends Comparable<T>> {
    /**
     * Returns the value stored in the node.
     * @return the value stored in the node.
     */
    T getValue();

    /**
     * Sets the value stored in the node.
     * @param value the new value to be stored in the node.
     */
    void setValue(T value);

    /**
     * Returns the left child of the node.
     * @return the left child of the node.
     */
    Node<T> getLeft();

    /**
     * Sets the left child of the node.
     * @param left the new left child of the node.
     */
    void setLeft(Node<T> left);

    /**
     * Returns the right child of the node.
     * @return the right child of the node.
     */
    Node<T> getRight();

    /**
     * Sets the right child of the node.
     * @param right the new right child of the node.
     */
    void setRight(Node<T> right);
}
