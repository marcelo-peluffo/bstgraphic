package com.marcelo.backend.generic;

public interface Node<T extends Comparable<T>> {
    T getValue();
    void setValue(T value);
    Node<T> getLeft();
    void setLeft(Node<T> left);
    Node<T> getRight();
    void setRight(Node<T> right);
}
