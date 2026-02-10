package com.marcelo.ui.drawable;

import java.awt.Graphics;
import java.util.Stack;

import com.marcelo.backend.bst.BinarySearchTree;
import com.marcelo.backend.generic.Node;
import com.marcelo.backend.generic.Tree;

public class DrawableBinarySearchTree<T extends Comparable<T>> implements DrawableTree<T> {
        private Tree<T> backendBst;
        private Tree<T> previousBackendBst;
        private Stack<Tree<T>> history;
        private DrawableNode<T> root;
        private int rootX;
        private int rootY;
        private int horizontalSpacing;
        private int radius;

        public DrawableBinarySearchTree() {
                backendBst = new BinarySearchTree<>();
                previousBackendBst = null;
                root = null;
                rootX = 960;
                rootY = 200;
                horizontalSpacing = 450;
                radius = 20;
                history = new Stack<>();
        }

        public DrawableBinarySearchTree(Tree<T> backendBst) {
                this();
                this.backendBst = backendBst != null ? backendBst : new BinarySearchTree<>();
                rebuildRoot();
                history = new Stack<>();
        }

        public void insert(T value) {
                if (backendBst == null) {
                        backendBst = new BinarySearchTree<>();
                }
                System.out.println(previousBackendBst);
                System.out.println(backendBst);

                previousBackendBst = backendBst;
                backendBst.insert(value);
                rebuildRoot();
        }

        public void delete(T value) {
                if (backendBst == null) {
                        return;
                }
                previousBackendBst = backendBst;
                backendBst.delete(value);
                rebuildRoot();
        }

        public void undo() {
                if (backendBst == null) {
                        return;
                }
                System.out.println(previousBackendBst);
                System.out.println(backendBst);

                backendBst = previousBackendBst;
                previousBackendBst = null;
                rebuildRoot();
        }

        @Override
        public void paintNodes(Graphics g) {
                if (root == null) {
                        rebuildRoot();
                }
                if (root != null) {
                        root.paint(g);
                }
        }

        @Override
        public Tree<T> getTree() {
                return backendBst;
        }

        public DrawableNode<T> getRoot() {
                return root;
        }

        public void setRootPosition(int x, int y) {
                this.rootX = x;
                this.rootY = y;
                rebuildRoot();
        }

        public void setHorizontalSpacing(int spacing) {
                this.horizontalSpacing = spacing;
                rebuildRoot();
        }

        private void rebuildRoot() {
                Node<T> backendRoot = backendBst != null ? backendBst.getRoot() : null;
                if (backendRoot == null) {
                        root = null;
                        return;
                }
                root = new DrawableBinarySearchTreeNode<>(backendRoot, rootX, rootY, radius, horizontalSpacing);
        }
}
