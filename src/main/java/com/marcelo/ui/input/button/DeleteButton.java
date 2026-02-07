package com.marcelo.ui.input.button;

import javax.swing.JButton;
import javax.swing.JComponent;

import com.marcelo.core.GraphicBSTPanel;
import com.marcelo.ui.input.VisualComponent;

public class DeleteButton implements VisualComponent {
        private final JButton deleteButton;

        public DeleteButton() {
                deleteButton = new JButton("Delete");
        }

        @Override
        public JComponent getComponent() {
                return deleteButton;
        }

        @Override
        public void initializeListeners(GraphicBSTPanel panel) {
                // TODO: wire delete behavior.
        }
}
