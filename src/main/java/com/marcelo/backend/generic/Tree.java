package com.marcelo.backend.generic;

public interface Tree<T extends Comparable<T>> {
    Node<T> getRoot();
    void insert(T value);
    void delete(T value);
    Node<T> search(T value);
    void inOrderTraversal();
    void preOrderTraversal();
    void postOrderTraversal();
}
