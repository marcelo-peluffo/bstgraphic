package com.marcelo.core;

import com.marcelo.backend.bst.BinarySearchTree;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The panel where the binary search tree is drawn.
 */
public class GraphicBSTPanel extends JPanel {
        private JTextField textbox;
        private JButton addValueButton;
        private BinarySearchTree<Integer> bst;

        public GraphicBSTPanel() {
                bst = new BinarySearchTree<>();
                initializeComponents();
                setupListeners();
        }

        private void initializeComponents() {
                textbox = new JTextField(10);
                addValueButton = new JButton("Add");

                add(textbox);
                add(addValueButton);
        }

        private void setupListeners() {
                addValueButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String input = textbox.getText().trim();
                                if (!input.isEmpty()) {
                                        try {
                                                int value = Integer.parseInt(input);
                                                bst.insert(value);
                                                textbox.setText(""); // Clear the text field
                                        } catch (NumberFormatException ex) {
                                                JOptionPane.showMessageDialog(GraphicBSTPanel.this,
                                                                "Please enter a valid integer.",
                                                                "Invalid Input",
                                                                JOptionPane.ERROR_MESSAGE);
                                        }
                                }
                        }
                });
        }

        public BinarySearchTree<Integer> getBST() {
                return bst;
        }
}
