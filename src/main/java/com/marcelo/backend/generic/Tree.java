package com.marcelo.backend.generic;

/**
 * An interface representing a generic tree data structure.
 * @param <T> the type of data stored in the tree, which must be comparable.
 */
public interface Tree<T extends Comparable<T>> {
    /**
     * Returns the root node of the tree.
     * @return the root node of the tree.
     */
    Node<T> getRoot();

    /**
     * Inserts a new value into the tree.
     * @param value the value to be inserted.
     */
    void insert(T value);

    /**
     * Deletes a value from the tree.
     * @param value the value to be deleted.
     */
    void delete(T value);

    /**
     * Searches for a value in the tree.
     * @param value the value to be searched for.
     * @return the node containing the value, or null if not found.
     */
    Node<T> search(T value);

    /**
     * Performs an in-order traversal of the tree.
     */
    void inOrderTraversal();

    /**
     * Performs a pre-order traversal of the tree.
     */
    void preOrderTraversal();

    /**
     * Performs a post-order traversal of the tree.
     */
    void postOrderTraversal();
}
