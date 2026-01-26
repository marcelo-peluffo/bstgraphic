package com.marcelo.backend.bst;

import com.marcelo.backend.generic.Node;

public class BinarySearchTreeNode<T extends Comparable<T>> implements Node<T> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    public BinarySearchTreeNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public Node<T> getLeft() {
        return left;
    }

    @Override
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    @Override
    public Node<T> getRight() {
        return right;
    }

    @Override
    public void setRight(Node<T> right) {
        this.right = right;
    }
}