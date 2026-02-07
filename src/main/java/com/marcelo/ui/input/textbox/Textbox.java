package com.marcelo.ui.input.textbox;

import javax.swing.JComponent;
import javax.swing.JTextField;

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
                // Text fields can register listeners here if needed.
        }
}
