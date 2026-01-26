package com.marcelo.backend.observer;

import com.marcelo.backend.generic.Node;
import com.marcelo.backend.generic.Tree;
import com.marcelo.backend.grid.Grid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * A class that observes a tree and creates a grid representation of it.
 * @param <T> the type of data stored in the tree, which must be comparable.
 */
public class TreeVisualizer<T extends Comparable<T>> implements Observer {
    private Grid<T> grid;
    private Tree<T> tree;

    /**
     * Constructs a new TreeVisualizer for the given tree.
     * @param tree the tree to be visualized.
     */
    public TreeVisualizer(Tree<T> tree) {
        this.tree = tree;
        this.grid = new Grid<>();
    }

    /**
     * {@inheritDoc}
     * This method is called when the subject (the tree) changes. It clears the grid and
     * repopulates it with a level-order traversal of the tree.
     */
    @Override
    public void update() {
        grid.clear();
        Node<T> root = tree.getRoot();
        if (root == null) {
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Node<T>> levelNodes = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node<T> currentNode = queue.poll();
                levelNodes.add(currentNode);

                if (currentNode != null) {
                    if (currentNode.getLeft() != null) {
                        queue.add(currentNode.getLeft());
                    }
                    if (currentNode.getRight() != null) {
                        queue.add(currentNode.getRight());
                    }
                }
            }
            grid.addRow(levelNodes);
        }
    }
}
