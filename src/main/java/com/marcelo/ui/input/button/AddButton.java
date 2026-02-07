package com.marcelo.ui.input.button;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.marcelo.core.GraphicBSTPanel;
import com.marcelo.ui.input.VisualComponent;
import com.marcelo.ui.input.textbox.Textbox;

public class AddButton implements VisualComponent {
        private final JButton addValueButton;
        private final Textbox valueTextbox;

        public AddButton(Textbox valueTextbox) {
                this.valueTextbox = valueTextbox;
                addValueButton = new JButton("Add");
        }

        @Override
        public JComponent getComponent() {
                return addValueButton;
        }

        @Override
        public void initializeListeners(GraphicBSTPanel panel) {
                addValueButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String rawValue = valueTextbox.getText();
                                if (rawValue == null || rawValue.trim().isEmpty()) {
                                        return;
                                }

                                try {
                                        int value = Integer.parseInt(rawValue.trim());
                                        panel.insertValue(value);
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
