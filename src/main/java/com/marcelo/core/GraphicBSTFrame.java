package com.marcelo.core;

import javax.swing.*;

/**
 * The main frame of the application, which holds the {@link GraphicBSTPanel}.
 */
public class GraphicBSTFrame extends JFrame {

    /**
     * Constructs the main frame of the application.
     */
    public GraphicBSTFrame() {
        super("Binary Search Tree Visualizer");
        init();
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1920, 800);
        add(new GraphicBSTIntroPanel(this));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void switchToPanel(JPanel newPanel) {
        getContentPane().removeAll();
        getContentPane().add(newPanel);
        getContentPane().revalidate();
        getContentPane().repaint();
    }

}
