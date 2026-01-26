package com.marcelo.backend.grid;

import com.marcelo.backend.generic.Node;
import java.util.ArrayList;

/**
 * A generic grid data structure to hold nodes in a 2D matrix.
 * @param <T> the type of data stored in the nodes, which must be comparable.
 */
public class Grid<T extends Comparable<T>> {
    private ArrayList<ArrayList<Node<T>>> matrix;

    /**
     * Constructs an empty grid.
     */
    public Grid() {
        this.matrix = new ArrayList<>();
    }

    /**
     * Returns the underlying 2D matrix of the grid.
     * @return the 2D matrix of nodes.
     */
    public ArrayList<ArrayList<Node<T>>> getMatrix() {
        return matrix;
    }

    /**
     * Sets the underlying 2D matrix of the grid.
     * @param matrix the new 2D matrix of nodes.
     */
    public void setMatrix(ArrayList<ArrayList<Node<T>>> matrix) {
        this.matrix = matrix;
    }

    /**
     * Clears the grid, removing all rows and nodes.
     */
    public void clear() {
        this.matrix.clear();
    }

    /**
     * Adds a new row to the grid.
     * @param row the row to be added.
     */
    public void addRow(ArrayList<Node<T>> row) {
        this.matrix.add(row);
    }

    /**
     * Returns the node at the specified position in the grid.
     * @param row the row of the node.
     * @param col the column of the node.
     * @return the node at the specified position.
     */
    public Node<T> getNode(int row, int col) {
        return this.matrix.get(row).get(col);
    }

    /**
     * Sets the node at the specified position in the grid.
     * @param row the row of the node.
     * @param col the column of the node.
     * @param node the new node to be set.
     */
    public void setNode(int row, int col, Node<T> node) {
        this.matrix.get(row).set(col, node);
    }
}
