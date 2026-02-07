package com.marcelo.ui.input.button;

import javax.swing.JButton;
import javax.swing.JComponent;

import com.marcelo.core.GraphicBSTPanel;
import com.marcelo.ui.input.VisualComponent;

public class UndoButton implements VisualComponent {
        private final JButton undoButton;

        public UndoButton() {
                undoButton = new JButton("Undo");
        }

        @Override
        public JComponent getComponent() {
                return undoButton;
        }

        @Override
        public void initializeListeners(GraphicBSTPanel panel) {
                // TODO: wire undo behavior.
        }
}
