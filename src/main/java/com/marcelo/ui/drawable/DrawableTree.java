package com.marcelo.ui.drawable;

import com.marcelo.backend.generic.Tree;
import java.awt.Graphics;

/**
 * An interface for drawable trees that can be painted on a Swing component
 * and hold a reference to the backend tree.
 * 
 * @param <T> the type of data stored in the tree, which must be comparable.
 */
public interface DrawableTree<T extends Comparable<T>> {
        /**
         * Paints all drawable nodes in the tree on the given graphics context.
         * 
         * @param g the graphics context to paint on.
         */
        void paintNodes(Graphics g);

        /**
         * Returns the backend tree that this drawable tree wraps.
         * 
         * @return the backend tree.
         */
        Tree<T> getTree();

        void insert(T value);
}
