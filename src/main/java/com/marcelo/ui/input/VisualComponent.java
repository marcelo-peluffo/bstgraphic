package com.marcelo.ui.input;

import javax.swing.JComponent;

import com.marcelo.core.GraphicBSTPanel;

public interface VisualComponent {
        JComponent getComponent();

        void initializeListeners(GraphicBSTPanel panel);
}
