package com.marcelo.backend.bst;

import com.marcelo.backend.generic.Node;

/**
 * A generic implementation of a Node in a Binary Search Tree.
 * @param <T> the type of data stored in the node, which must be comparable.
 */
public class BinarySearchTreeNode<T extends Comparable<T>> implements Node<T> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    /**
     * Constructs a new BinarySearchTreeNode with the given value.
     * @param value the value to be stored in the node.
     */
    public BinarySearchTreeNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getValue() {
        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node<T> getLeft() {
        return left;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLeft(Node<T> left) {
        this.left = left;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node<T> getRight() {
        return right;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setRight(Node<T> right) {
        this.right = right;
    }
}