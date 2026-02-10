package com.marcelo.core;

import javax.swing.SwingUtilities;

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
        SwingUtilities.invokeLater(() -> {
            new GraphicBSTFrame();
        });
    }
}
