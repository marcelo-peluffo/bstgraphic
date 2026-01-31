package com.marcelo.core;

import com.marcelo.backend.bst.BinarySearchTree;

/**
 * The runner file for the Graphic BST program for CSIII.
 * @author Marcelo
 */
public class GraphicBSTRunner {
    /**
     * The main entry point of the application.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = initializeBST();
        GraphicBSTFrame programFrame = new GraphicBSTFrame();
    }

    /**
     * Initializes the BinarySearchTree and its observer, the TreeVisualizer.
     * @return the initialized BinarySearchTree.
     */
    public static BinarySearchTree<Integer> initializeBST() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        return bst;
    }
}
