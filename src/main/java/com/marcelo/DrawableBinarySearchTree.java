package com.marcelo;

import javax.swing.*;
import java.awt.*;

public class DrawableBinarySearchTree extends JPanel {
    private final BinarySearchTree backendTree;

    protected DrawableBinarySearchTree() {
        backendTree = Config.tree;
    }

    @Override
    protected void paintComponent(Graphics g) {

    }
}
