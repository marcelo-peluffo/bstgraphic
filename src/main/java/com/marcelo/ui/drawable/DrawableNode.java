package com.marcelo.ui.drawable;

import com.marcelo.backend.generic.Node;
import java.awt.Graphics;

/**
 * An interface for drawable nodes that can be painted on a Swing component
 * and hold a reference to the backend node.
 * 
 * @param <T> the type of data stored in the node, which must be comparable.
 */
public interface DrawableNode<T extends Comparable<T>> {
        /**
         * Paints the node on the given graphics context.
         * 
         * @param g the graphics context to paint on.
         */
        void paint(Graphics g);

        /**
         * Returns the backend node that this drawable node wraps.
         * 
         * @return the backend node.
         */
        Node<T> getNode();
}
