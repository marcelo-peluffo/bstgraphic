package com.marcelo.backend.bst;

import com.marcelo.backend.generic.Node;
import com.marcelo.backend.generic.Tree;

/**
 * A generic implementation of a Binary Search Tree.
 *
 * @param <T> the type of data stored in the tree, which must be comparable.
 */
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;
    private int maxDepth; // Maximum depth allowed (0-indexed, so 4 = 5 levels)

    /**
     * Constructs an empty BinarySearchTree with no depth limit.
     */
    public BinarySearchTree() {
        this.root = null;
        this.maxDepth = 5; // No limit by default
    }

    /**
     * Constructs an empty BinarySearchTree with a maximum depth limit.
     *
     * @param maxDepth the maximum depth allowed (0-indexed, so 4 = 5 levels)
     */
    public BinarySearchTree(int maxDepth) {
        this.root = null;
        this.maxDepth = maxDepth;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node<T> getRoot() {
        return root;
    }

    /**
     * Sets the maximum depth allowed in the tree.
     *
     * @param maxDepth the maximum depth (0-indexed, so 4 = 5 levels)
     */
    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void insert(T value) {
        root = insert(root, value, 0);
    }

    private Node<T> insert(Node<T> node, T value, int depth) {
        if (node == null) {
            // Check if we've exceeded max depth before creating a new node
            if (depth > maxDepth) {
                return null; // Reject insertion beyond max depth
            }
            return new BinarySearchTreeNode<>(value);
        }

        if (value.compareTo(node.getValue()) < 0) {
            node.setLeft(insert(node.getLeft(), value, depth + 1));
        } else if (value.compareTo(node.getValue()) > 0) {
            node.setRight(insert(node.getRight(), value, depth + 1));
        }

        return node;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(T value) {
        root = delete(root, value);
    }

    private Node<T> delete(Node<T> node, T value) {
        if (node == null) {
            return null;
        }

        if (value.compareTo(node.getValue()) < 0) {
            node.setLeft(delete(node.getLeft(), value));
        } else if (value.compareTo(node.getValue()) > 0) {
            node.setRight(delete(node.getRight(), value));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            node.setValue(minValue(node.getRight()));
            node.setRight(delete(node.getRight(), node.getValue()));
        }

        return node;
    }

    private T minValue(Node<T> node) {
        T minValue = node.getValue();
        while (node.getLeft() != null) {
            minValue = node.getLeft().getValue();
            node = node.getLeft();
        }
        return minValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node<T> search(T value) {
        return search(root, value);
    }

    private Node<T> search(Node<T> node, T value) {
        if (node == null || node.getValue().equals(value)) {
            return node;
        }

        if (value.compareTo(node.getValue()) < 0) {
            return search(node.getLeft(), value);
        } else {
            return search(node.getRight(), value);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void inOrderTraversal() {
        inOrder(root);
    }

    private void inOrder(Node<T> node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getValue() + " ");
            inOrder(node.getRight());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void preOrderTraversal() {
        preOrder(root);
    }

    private void preOrder(Node<T> node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void postOrderTraversal() {
        postOrder(root);
    }

    private void postOrder(Node<T> node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }
}