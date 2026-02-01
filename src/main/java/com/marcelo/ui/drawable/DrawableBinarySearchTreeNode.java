package com.marcelo.ui.drawable;

import com.marcelo.backend.generic.Node;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * A drawable implementation of a Binary Search Tree node.
 * Wraps a backend node and provides visual representation.
 * 
 * @param <T> the type of data stored in the node, which must be comparable.
 */
public class DrawableBinarySearchTreeNode<T extends Comparable<T>> implements DrawableNode<T> {
        private Node<T> node;
        private int x;
        private int y;
        private int radius;
        private int horizontalSpacing;

        /**
         * Constructs a drawable BST node with the given backend node and position.
         * 
         * @param node              the backend node to wrap.
         * @param x                 the x-coordinate of the node's center.
         * @param y                 the y-coordinate of the node's center.
         * @param radius            the radius of the circle representing the node.
         * @param horizontalSpacing the horizontal distance to place children from this
         *                          node.
         */
        public DrawableBinarySearchTreeNode(Node<T> node, int x, int y, int radius, int horizontalSpacing) {
                this.node = node;
                this.x = x;
                this.y = y;
                this.radius = radius;
                this.horizontalSpacing = horizontalSpacing;
        }

        /**
         * Constructs a drawable BST node with the given backend node and position.
         * 
         * @param node   the backend node to wrap.
         * @param x      the x-coordinate of the node's center.
         * @param y      the y-coordinate of the node's center.
         * @param radius the radius of the circle representing the node.
         */
        public DrawableBinarySearchTreeNode(Node<T> node, int x, int y, int radius) {
                this(node, x, y, radius, 100);
        }

        /**
         * Constructs a drawable BST node with default radius of 20.
         * 
         * @param node the backend node to wrap.
         * @param x    the x-coordinate of the node's center.
         * @param y    the y-coordinate of the node's center.
         */
        public DrawableBinarySearchTreeNode(Node<T> node, int x, int y) {
                this(node, x, y, 20);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void paint(Graphics g) {
                if (node == null)
                        return;

                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int verticalSpacing = 60;

                // Draw lines to children first (so they appear behind the nodes)
                if (node.getLeft() != null) {
                        int leftX = x - horizontalSpacing;
                        int leftY = y + verticalSpacing;
                        g2d.setColor(Color.BLACK);
                        g2d.drawLine(x, y, leftX, leftY);
                }

                if (node.getRight() != null) {
                        int rightX = x + horizontalSpacing;
                        int rightY = y + verticalSpacing;
                        g2d.setColor(Color.BLACK);
                        g2d.drawLine(x, y, rightX, rightY);
                }

                // Draw the circle
                g2d.setColor(Color.WHITE);
                g2d.fillOval(x - radius, y - radius, radius * 2, radius * 2);

                g2d.setColor(Color.BLACK);
                g2d.drawOval(x - radius, y - radius, radius * 2, radius * 2);

                // Draw the value
                String value = node.getValue().toString();
                int stringWidth = g2d.getFontMetrics().stringWidth(value);
                int stringHeight = g2d.getFontMetrics().getAscent();
                g2d.drawString(value, x - stringWidth / 2, y + stringHeight / 3);

                // Recursively paint children with half the horizontal spacing
                if (node.getLeft() != null) {
                        int leftX = x - horizontalSpacing;
                        int leftY = y + verticalSpacing;
                        DrawableBinarySearchTreeNode<T> leftDrawable = new DrawableBinarySearchTreeNode<>(
                                        node.getLeft(), leftX, leftY, radius, horizontalSpacing / 2);
                        leftDrawable.paint(g);
                }

                if (node.getRight() != null) {
                        int rightX = x + horizontalSpacing;
                        int rightY = y + verticalSpacing;
                        DrawableBinarySearchTreeNode<T> rightDrawable = new DrawableBinarySearchTreeNode<>(
                                        node.getRight(), rightX, rightY, radius, horizontalSpacing / 2);
                        rightDrawable.paint(g);
                }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Node<T> getNode() { // the idea is getNode().[node methods as needed] (same for drawable tree)
                return node;
        }

        /**
         * Gets the x-coordinate of this node's center.
         * 
         * @return the x-coordinate.
         */
        public int getX() {
                return x;
        }

        /**
         * Gets the y-coordinate of this node's center.
         * 
         * @return the y-coordinate.
         */
        public int getY() {
                return y;
        }

        /**
         * Gets the radius of this node's circle.
         * 
         * @return the radius.
         */
        public int getRadius() {
                return radius;
        }

        /**
         * Sets the position of this node.
         * 
         * @param x the new x-coordinate.
         * @param y the new y-coordinate.
         */
        public void setPosition(int x, int y) {
                this.x = x;
                this.y = y;
        }
}
