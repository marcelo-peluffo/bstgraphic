package com.marcelo;

import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawableBinaryNode extends JPanel {
    private BinaryNode node;

    protected DrawableBinaryNode() {
        setNode(null);
    }

    protected DrawableBinaryNode(BinaryNode n) {
        setNode(n);
    }

    @Override
    protected void paintComponent(Graphics g) {

    }

    public void setNode(BinaryNode n) { node = n; }
    public BinaryNode getNode() { return node; }
}
