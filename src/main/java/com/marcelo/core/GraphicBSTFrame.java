package com.marcelo.core;

import javax.swing.*;

public class GraphicBSTFrame extends JFrame {

    public GraphicBSTFrame() {
        super("Binary Search Tree Visualizer");
        init();
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1920, 1080);
        add(new GraphicBSTPanel());
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
