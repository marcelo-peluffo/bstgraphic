package com.marcelo.ui.input.textbox;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.marcelo.core.GraphicBSTPanel;
import com.marcelo.ui.input.VisualComponent;

public class Textbox implements VisualComponent {
        private final JTextField textField;

        public Textbox(int columns) {
                textField = new JTextField(columns);
        }

        public String getText() {
                return textField.getText();
        }

        public void clear() {
                textField.setText("");
        }

        @Override
        public JComponent getComponent() {
                return textField;
        }

        @Override
        public void initializeListeners(GraphicBSTPanel panel) {
                // When Enter is pressed, insert the value
                textField.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String rawValue = getText();
                                if (rawValue == null || rawValue.trim().isEmpty()) {
                                        return;
                                }

                                try {
                                        int value = Integer.parseInt(rawValue.trim());
                                        panel.insertValue(value);
                                        clear();
                                } catch (NumberFormatException ex) {
                                        JOptionPane.showMessageDialog(panel,
                                                        "Please enter a valid integer.",
                                                        "Invalid Input",
                                                        JOptionPane.ERROR_MESSAGE);
                                }
                        }
                });

                // When Delete key is pressed, delete the value
                textField.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                                        e.consume(); // Prevent the system beep
                                        String rawValue = getText();
                                        if (rawValue == null || rawValue.trim().isEmpty()) {
                                                return;
                                        }

                                        try {
                                                int value = Integer.parseInt(rawValue.trim());
                                                panel.deleteValue(value);
                                                clear();
                                        } catch (NumberFormatException ex) {
                                                JOptionPane.showMessageDialog(panel,
                                                                "Please enter a valid integer.",
                                                                "Invalid Input",
                                                                JOptionPane.ERROR_MESSAGE);
                                        }
                                }
                                else if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
                                        e.consume(); // Prevent the system beep
                                        String rawValue = getText();
                                        if (rawValue == null || rawValue.trim().isEmpty()) {
                                                return;
                                        }

                                        try {
                                                int value = Integer.parseInt(rawValue.trim());
                                                panel.undoValue();
                                                clear();
                                        } catch (NumberFormatException ex) {
                                                JOptionPane.showMessageDialog(panel,
                                                        "Please enter a valid integer.",
                                                        "Invalid Input",
                                                        JOptionPane.ERROR_MESSAGE);
                                        }
                                }
                        }
                });
        }
}
