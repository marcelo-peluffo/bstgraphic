package com.marcelo.ui.input.button;

import javax.swing.*;

import com.marcelo.core.GraphicBSTPanel;
import com.marcelo.ui.input.VisualComponent;
import com.marcelo.ui.input.textbox.Textbox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class UndoButton implements VisualComponent {
        private final JButton undoValueButton;
        private final Textbox valueTextbox;

        public UndoButton(Textbox valueTextbox) {
                this.valueTextbox = valueTextbox;
                undoValueButton = new JButton("Undo");
                styleButton();
        }

        private void styleButton() {
                undoValueButton.setBackground(new Color(50, 100, 150));
                undoValueButton.setForeground(Color.WHITE);
                undoValueButton.setFont(new Font("Arial", Font.BOLD, 14));
                undoValueButton.setFocusPainted(false);
                undoValueButton.setOpaque(true);
                undoValueButton.setBorderPainted(true);
        }

        @Override
        public JComponent getComponent() {
                return undoValueButton;
        }

        @Override
        public void initializeListeners(GraphicBSTPanel panel) {
                undoValueButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                System.out.println("Clicked Undo Button.");
                                panel.undoValue();
                                valueTextbox.clear();
                        }
                });
        }
}
