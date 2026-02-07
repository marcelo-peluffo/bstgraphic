package com.marcelo.core;

import com.marcelo.ui.drawable.DrawableBinarySearchTree;
import com.marcelo.ui.input.VisualComponent;
import com.marcelo.ui.input.button.AddButton;
import com.marcelo.ui.input.textbox.Textbox;

import javax.swing.*;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * The panel where the binary search tree is drawn.
 */
public class GraphicBSTPanel extends JPanel {
        private List<VisualComponent> visualComponents;
        private DrawableBinarySearchTree<Integer> drawableBST;

        public GraphicBSTPanel() {
                drawableBST = new DrawableBinarySearchTree<>();
                initializeComponents();
                setupListeners();
        }

        private void initializeComponents() {
                visualComponents = new ArrayList<>();
                Textbox valueTextbox = new Textbox(10);
                visualComponents.add(valueTextbox);
                visualComponents.add(new AddButton(valueTextbox));
        }

        private void setupListeners() {
                for (VisualComponent visualComponent : visualComponents) {
                        add(visualComponent.getComponent());
                        visualComponent.initializeListeners(this);
                }
        }

        public void insertValue(Integer value) {
                if (value == null) {
                        return;
                }
                drawableBST.insert(value);
                repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                drawableBST.paintNodes(g);
        }
}
