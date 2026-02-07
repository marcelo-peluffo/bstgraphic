package com.marcelo.ui.input.button;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

import com.marcelo.core.GraphicBSTPanel;
import com.marcelo.ui.input.VisualComponent;
import com.marcelo.ui.input.textbox.Textbox;

public class DeleteButton implements VisualComponent {
        private final JButton deleteButton;
        private final Textbox valueTextbox;

        public DeleteButton(Textbox valueTextbox) {
                this.valueTextbox = valueTextbox;
                deleteButton = new JButton("Delete");
                styleButton();
        }

        private void styleButton() {
                deleteButton.setBackground(new Color(50, 100, 150));
                deleteButton.setForeground(Color.WHITE);
                deleteButton.setFont(new Font("Arial", Font.BOLD, 14));
                deleteButton.setFocusPainted(false);
                deleteButton.setOpaque(true);
                deleteButton.setBorderPainted(true);
        }

        @Override
        public JComponent getComponent() {
                return deleteButton;
        }

        @Override
        public void initializeListeners(GraphicBSTPanel panel) {
                deleteButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String rawValue = valueTextbox.getText();
                                if (rawValue == null || rawValue.trim().isEmpty()) {
                                        return;
                                }

                                try {
                                        int value = Integer.parseInt(rawValue.trim());
                                        panel.deleteValue(value);
                                        valueTextbox.clear();
                                } catch (NumberFormatException ex) {
                                        JOptionPane.showMessageDialog(panel,
                                                        "Please enter a valid integer.",
                                                        "Invalid Input",
                                                        JOptionPane.ERROR_MESSAGE);
                                }
                        }
                });
        }
}
